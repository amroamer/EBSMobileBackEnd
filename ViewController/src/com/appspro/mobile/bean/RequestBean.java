package com.appspro.mobile.bean;

public class RequestBean {
    public RequestBean() {
        super();
    }
    
    private int requestId;
    private String requestNameEn;
    private String requestNameAr ; 


    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }


    public void setRequestNameEn(String requestNameEn) {
        this.requestNameEn = requestNameEn;
    }

    public String getRequestNameEn() {
        return requestNameEn;
    }

    public void setRequestNameAr(String requestNameAr) {
        this.requestNameAr = requestNameAr;
    }

    public String getRequestNameAr() {
        return requestNameAr;
    }
}
