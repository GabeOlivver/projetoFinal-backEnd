package com.fatec.agenda.resources.exceptions;

import java.time.Instant;

public class StandardError {
    private Instant timeStemp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    
    public Instant getTimeStemp() {
        return timeStemp;
    }
    public void setTimeStemp(Instant timeStemp) {
        this.timeStemp = timeStemp;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    
}
