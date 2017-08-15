package com.appspro.mobile.bean;

public class EmployeeCertificate {
    public EmployeeCertificate() {
        super();
    }
    
    private int certificationId;
    private String certificationName;
    private String whomName;
    private String endorsementRequired;
    private String justification; 
    private int noOfCopies; 
    private String status;


    public void setCertificationId(int certificationId) {
        this.certificationId = certificationId;
    }

    public int getCertificationId() {
        return certificationId;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    public String getCertificationName() {
        return certificationName;
    }

    public void setWhomName(String whomName) {
        this.whomName = whomName;
    }

    public String getWhomName() {
        return whomName;
    }

    public void setEndorsementRequired(String endorsementRequired) {
        this.endorsementRequired = endorsementRequired;
    }

    public String getEndorsementRequired() {
        return endorsementRequired;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getJustification() {
        return justification;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
