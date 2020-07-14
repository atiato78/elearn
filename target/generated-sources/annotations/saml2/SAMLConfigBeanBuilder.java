package saml2;

import java.util.Set;
import javax.annotation.Generated;
import net.karneim.pojobuilder.GwtIncompatible;
import org.springframework.core.io.Resource;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;

@Generated("PojoBuilder")
public class SAMLConfigBeanBuilder
    implements Cloneable {
  protected SAMLConfigBeanBuilder self;
  protected String value$idpServerName$java$lang$String;
  protected boolean isSet$idpServerName$java$lang$String;
  protected String value$spServerName$java$lang$String;
  protected boolean isSet$spServerName$java$lang$String;
  protected Integer value$spHttpsPort$java$lang$Integer;
  protected boolean isSet$spHttpsPort$java$lang$Integer;
  protected String value$spContextPath$java$lang$String;
  protected boolean isSet$spContextPath$java$lang$String;
  protected Resource value$keystoreResource$org$springframework$core$io$Resource;
  protected boolean isSet$keystoreResource$org$springframework$core$io$Resource;
  protected String value$keystoreAlias$java$lang$String;
  protected boolean isSet$keystoreAlias$java$lang$String;
  protected String value$keystorePassword$java$lang$String;
  protected boolean isSet$keystorePassword$java$lang$String;
  protected String value$keystorePrivateKeyPassword$java$lang$String;
  protected boolean isSet$keystorePrivateKeyPassword$java$lang$String;
  protected String value$successLoginDefaultUrl$java$lang$String;
  protected boolean isSet$successLoginDefaultUrl$java$lang$String;
  protected String value$successLogoutUrl$java$lang$String;
  protected boolean isSet$successLogoutUrl$java$lang$String;
  protected String value$failedLoginDefaultUrl$java$lang$String;
  protected boolean isSet$failedLoginDefaultUrl$java$lang$String;
  protected Boolean value$storeCsrfTokenInCookie$java$lang$Boolean;
  protected boolean isSet$storeCsrfTokenInCookie$java$lang$Boolean;
  protected SAMLUserDetailsService value$samlUserDetailsService$org$springframework$security$saml$userdetails$SAMLUserDetailsService;
  protected boolean isSet$samlUserDetailsService$org$springframework$security$saml$userdetails$SAMLUserDetailsService;
  protected Set<String> value$authnContexts$java$util$Set;
  protected boolean isSet$authnContexts$java$util$Set;
  protected Boolean value$useJdkCacertsForSslVerification$java$lang$Boolean;
  protected boolean isSet$useJdkCacertsForSslVerification$java$lang$Boolean;

  /**
   * Creates a new {@link SAMLConfigBeanBuilder}.
   */
  public SAMLConfigBeanBuilder() {
    self = (SAMLConfigBeanBuilder)this;
  }

  /**
   * Sets the default value for the idpServerName property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withIdpServerName(String value) {
    this.value$idpServerName$java$lang$String = value;
    this.isSet$idpServerName$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the spServerName property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSpServerName(String value) {
    this.value$spServerName$java$lang$String = value;
    this.isSet$spServerName$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the spHttpsPort property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSpHttpsPort(Integer value) {
    this.value$spHttpsPort$java$lang$Integer = value;
    this.isSet$spHttpsPort$java$lang$Integer = true;
    return self;
  }

  /**
   * Sets the default value for the spContextPath property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSpContextPath(String value) {
    this.value$spContextPath$java$lang$String = value;
    this.isSet$spContextPath$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystoreResource property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withKeystoreResource(Resource value) {
    this.value$keystoreResource$org$springframework$core$io$Resource = value;
    this.isSet$keystoreResource$org$springframework$core$io$Resource = true;
    return self;
  }

  /**
   * Sets the default value for the keystoreAlias property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withKeystoreAlias(String value) {
    this.value$keystoreAlias$java$lang$String = value;
    this.isSet$keystoreAlias$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystorePassword property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withKeystorePassword(String value) {
    this.value$keystorePassword$java$lang$String = value;
    this.isSet$keystorePassword$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystorePrivateKeyPassword property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withKeystorePrivateKeyPassword(String value) {
    this.value$keystorePrivateKeyPassword$java$lang$String = value;
    this.isSet$keystorePrivateKeyPassword$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the successLoginDefaultUrl property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSuccessLoginDefaultUrl(String value) {
    this.value$successLoginDefaultUrl$java$lang$String = value;
    this.isSet$successLoginDefaultUrl$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the successLogoutUrl property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSuccessLogoutUrl(String value) {
    this.value$successLogoutUrl$java$lang$String = value;
    this.isSet$successLogoutUrl$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the failedLoginDefaultUrl property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withFailedLoginDefaultUrl(String value) {
    this.value$failedLoginDefaultUrl$java$lang$String = value;
    this.isSet$failedLoginDefaultUrl$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the storeCsrfTokenInCookie property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withStoreCsrfTokenInCookie(Boolean value) {
    this.value$storeCsrfTokenInCookie$java$lang$Boolean = value;
    this.isSet$storeCsrfTokenInCookie$java$lang$Boolean = true;
    return self;
  }

  /**
   * Sets the default value for the samlUserDetailsService property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withSamlUserDetailsService(SAMLUserDetailsService value) {
    this.value$samlUserDetailsService$org$springframework$security$saml$userdetails$SAMLUserDetailsService = value;
    this.isSet$samlUserDetailsService$org$springframework$security$saml$userdetails$SAMLUserDetailsService = true;
    return self;
  }

  /**
   * Sets the default value for the authnContexts property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withAuthnContexts(Set<String> value) {
    this.value$authnContexts$java$util$Set = value;
    this.isSet$authnContexts$java$util$Set = true;
    return self;
  }

  /**
   * Sets the default value for the useJdkCacertsForSslVerification property.
   *
   * @param value the default value
   * @return this builder
   */
  public SAMLConfigBeanBuilder withUseJdkCacertsForSslVerification(Boolean value) {
    this.value$useJdkCacertsForSslVerification$java$lang$Boolean = value;
    this.isSet$useJdkCacertsForSslVerification$java$lang$Boolean = true;
    return self;
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @Override
  @GwtIncompatible
  public Object clone() {
    try {
      SAMLConfigBeanBuilder result = (SAMLConfigBeanBuilder)super.clone();
      result.self = result;
      return result;
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.getMessage());
    }
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @GwtIncompatible
  public SAMLConfigBeanBuilder but() {
    return (SAMLConfigBeanBuilder)clone();
  }

  /**
   * Creates a new {@link SAMLConfigBean} based on this builder's settings.
   *
   * @return the created SAMLConfigBean
   */
  public SAMLConfigBean build() {
    try {
      SAMLConfigBean result = new SAMLConfigBean(value$idpServerName$java$lang$String, value$spServerName$java$lang$String, value$spHttpsPort$java$lang$Integer, value$spContextPath$java$lang$String, value$keystoreResource$org$springframework$core$io$Resource, value$keystoreAlias$java$lang$String, value$keystorePassword$java$lang$String, value$keystorePrivateKeyPassword$java$lang$String, value$successLoginDefaultUrl$java$lang$String, value$successLogoutUrl$java$lang$String, value$failedLoginDefaultUrl$java$lang$String, value$storeCsrfTokenInCookie$java$lang$Boolean, value$samlUserDetailsService$org$springframework$security$saml$userdetails$SAMLUserDetailsService, value$authnContexts$java$util$Set, value$useJdkCacertsForSslVerification$java$lang$Boolean);
      return result;
    } catch (RuntimeException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
