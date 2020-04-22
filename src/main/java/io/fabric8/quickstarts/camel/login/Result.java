package io.fabric8.quickstarts.camel.login;


import io.fabric8.quickstarts.camel.login.Params;

public class Result {
  
    private Params  params;
    private String status;
  
   // Getter Methods 
  
    public Params getResult() {
      return params;
    }
  
   // Setter Methods 
  
    public  void setResult(Params params) {
      this.params = params;
    }

    public String getStatus() {
      return status;
  }

  public void setStatus(String status) {
      this.status = status;
  }
  }