/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.quickstarts.camel;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Header;
import javax.mail.internet.ContentDisposition;
import javax.mail.internet.MimeBodyPart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.http.common.HttpMessage;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.impl.DefaultAttachment;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.spi.Registry;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.camel.util.jsse.KeyManagersParameters;
import org.apache.camel.util.jsse.KeyStoreParameters;
import org.apache.camel.util.jsse.SSLContextParameters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.twilio.Twilio;

import io.fabric8.quickstarts.camel.instructor.Params;
import io.fabric8.quickstarts.camel.pojo.Root;
import io.fabric8.quickstarts.camel.voice.Result;
import io.fabric8.quickstarts.camel.voice.VoiceSession;

import org.apache.camel.util.jsse.SSLContextParameters;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@SpringBootApplication
@ImportResource({ "classpath:spring/camel-context.xml" })
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(),
                "/camel-rest-sql/*");
        servlet.setName("CamelServlet");
        return servlet;
    }

   

    @Component
    class RestApi extends RouteBuilder {

        @Override
        public void configure() {

            // onException(HttpOperationFailedException.class).handled(true).process(new
            // Processor() {
            // @Override
            // public void process(Exchange exchange) throws Exception {
            // // exchange.getIn().setBody("{Exception occured :"+ex.getMessage()+"}");
            // UnAuthorize test = new UnAuthorize();
            // test.setResult("You are UnAuthrized to access such API");
            // exchange.getIn().setBody(test);
            // }
            // });

            restConfiguration()

                    .contextPath("/camel-rest-sql").apiContextPath("/api-doc")
                    .apiProperty("api.title", "Camel REST API").apiProperty("api.version", "1.0")
                    // .apiProperty("cors", "true").apiContextRouteId("doc-api").enableCORS(true)
                    // .corsHeaderProperty("Access-Control-Allow-Headers",
                    // "Origin, Accept, X-Requested-With, Content-Type,
                    // Access-Control-Request-Method, Access-Control-Request-Headers,CustomHeader1,
                    // CustomHeader2")
                    .component("servlet").bindingMode(RestBindingMode.json);

            rest("/").description("Exhange Rate REST service").post("whatsapp/")
                    .description("The drools for specified currency").route().routeId("drools-rate-api")
                    .log("${header.Body}").to("log:DEBUG?showBody=true&showHeaders=true")
                    .removeHeaders("Camel*")
                    .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http.HttpMethods.POST))
                    .setHeader(Exchange.HTTP_URI, constant("https://dc.segmatek.com/gateway/auth/oauth/token"))
                    .setHeader("CamelHttpUrl",constant("https://dc.segmatek.com/gateway/auth/oauth/token"))
                    .streamCaching()

                    .setHeader("Authorization",constant("Basic bWF0dGVsLWFwcDpwYXNzd29yZA=="))
                    // .setHeader("username",constant("01028002222"))
                    // .setHeader("password",constant("password"))
                    .setHeader("Accept", constant("application/json"))
                    .setHeader(Exchange.CONTENT_TYPE,constant("application/x-www-form-urlencoded"))
                    .setBody(constant("username=01028002222&password=password&grant_type=password"))
                    .to("log:DEBUG?showBody=true&showHeaders=true")
                    .to("https://dc.segmatek.com/gateway/auth/oauth/token")
                    .log("${body}")
                  //  .convertBodyTo(String.class)

                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {

                        String output =   exchange.getIn().getBody(String.class);
                            log.info("test "+exchange.getIn().getBody(String.class));


                            JSONObject json=new JSONObject(output);
                              String token = json.getString("access_token");
                              exchange.getIn().setHeader("Authorization", token);
                            log.info("My Auth Header "+exchange.getIn().getHeader("Authorization"));

                        }
                    })
                    .removeHeaders("Camel*")
                    .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http.HttpMethods.GET))
                    .setHeader(Exchange.HTTP_URI, constant("https://dc.segmatek.com/gateway/ecare/balance/query-balance"))
                    .setHeader("CamelHttpUrl",constant("https://dc.segmatek.com/gateway/ecare/balance/query-balance"))
                   // .setHeader("Authorization",constant("Basic bWF0dGVsLWFwcDpwYXNzd29yZA=="))
                    // .setHeader("username",constant("01028002222"))
                    // .setHeader("password",constant("password"))
                    .setHeader("Accept", constant("application/json"))
                    .setHeader(Exchange.CONTENT_TYPE,constant("application/json"))
                    .to("log:DEBUG?showBody=true&showHeaders=true")
                    .setHeader(Exchange.HTTP_QUERY,simple("access_token="+"${header.Authorization}"))
                    .to("https://dc.segmatek.com/gateway/ecare/balance/query-balance")
                    .log("${body}")
                    .convertBodyTo(String.class)
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {
     

                            String output =   exchange.getIn().getBody(String.class);
                            log.info("well "+exchange.getIn().getBody(String.class));


                            JSONObject json=new JSONObject(output);
                            JSONObject data = json.getJSONObject("data");
                            
                            
                            
                           JSONArray accounts= data.getJSONArray("accounts");

                           for (int i=0 ; i <accounts.length();i++)

                           {

                            log.info("services"+accounts.getJSONObject(i).getString("name"));

                           }



                            
                           
                            
                             // JSONObject out=new JSONObject(data);
                          //    log.info("out "+exchange.getIn().getBody(String.class));


                            //   exchange.getIn().setHeader("Authorization", token);
                            // log.info("My Auth Header "+exchange.getIn().getHeader("Authorization"));

                            /*Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
                                    .creator(new com.twilio.type.PhoneNumber(exchange.getIn().getHeader("From").toString()),
                                            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                                            "Hello, I'm echoing the message:: "+exchange.getIn().getHeader("Body").toString())
                                    .create();

                            System.out.println(message.getSid());*/

                            // p test = new p();

                            // test.setName("Omar");
                            // test.setAge(80);
                            // test.setPrevious(false);

                            // test.setBilledAmount(170);
                            // test.setCreditHistory("Poor");
                            // test.setMemberType("Silver");

                            // System.out.println("Arrived from Space jBPM");

                            // exchange.getIn().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"
                            // standalone=\"yes\"?>" +
                            // "<person><id>1</id><lastName>Atieh</lastName><firstName>Omar</firstName></person>");

                            // exchange.getIn().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"
                            // standalone=\"yes\"?>" +
                            // "<person><age>25</age><name>Post johon</name></person>");
                exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML);
                
                String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> <Response><Message>Your Remaining Quota for the Data Bundle :\n"+(int)(Math.random()*100)+"GB for Subscriber " +exchange.getIn().getHeader("From")
                + "</Message></Response>";

                String error = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> <Response><Message>Please Send QBundle to Query Bundles, Enjoy Our Service\n"+"</Message></Response>";

                if (exchange.getIn().getHeader("Body").toString().equals("QBundle"))
                            exchange.getIn().setBody(result);
                            else 
                            exchange.getIn().setBody(error);

                            // Person : {
                            // "id": 10,
                            // "firstName": "Omar",
                            // "lastName": "Atieh"
                            // }

                        }
                    }).endRest();

        }

    }

    private static String convertInputStreamToStringCommonIO(InputStream inputStream)
	throws IOException {

        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
        return writer.toString();

    }
}
