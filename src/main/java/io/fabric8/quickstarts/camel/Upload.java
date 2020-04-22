package io.fabric8.quickstarts.camel;

public class Upload {

    private String success;
    private String message;

    public void setStatus(String success) {
        this.success = success;
    }

    public String getStatus() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}