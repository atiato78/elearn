package io.fabric8.quickstarts.camel.chapters;

import java.util.ArrayList;

public class Result {
  
    private ArrayList <io.fabric8.quickstarts.camel.chapters.Params>  params;
    private String status; 
  
   // Getter Methods 
  
    public ArrayList <io.fabric8.quickstarts.camel.chapters.Params> getResult() {
      return params;
    }
  
   // Setter Methods 
  
    public  void setResult(ArrayList <io.fabric8.quickstarts.camel.chapters.Params> params) {
      this.params = params;
    }

    public String getStatus() {
      return status;
  }

  public void setStatus(String status) {
      this.status = status;
  }

    
  }