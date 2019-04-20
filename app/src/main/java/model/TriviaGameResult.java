package model;

import java.io.Serializable;

public class TriviaGameResult implements Serializable {

    private String result;



    public TriviaGameResult(String result, String status) {
        this.result = result;
        this.status = status;
    }

    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
