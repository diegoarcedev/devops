package com.diego.arce.devops.vo;

public class RequestVO {
    private String message;
    private String to;
    private String from;
    private Integer timeToLifeSec;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getTimeToLifeSec() {
        return timeToLifeSec;
    }

    public void setTimeToLifeSec(Integer timeToLifeSec) {
        this.timeToLifeSec = timeToLifeSec;
    }
}