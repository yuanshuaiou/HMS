package com.hospital.bean;

public class Doctor {

    private String did;
    private String dname;
    private String dsex;
    private String dage;
    private String dphone;
    private String dtitle;
    private String ddeptid;
    private String ddeptname;
    private String dpassword;
public Doctor() {}
    public Doctor(String did, String dname, String dage, String dsex, String dphone, String dtitle, String ddeptid, String ddeptname, String dpassword) {
        this.did = did;
        this.dname = dname;
        this.dage = dage;
        this.dsex = dsex;
        this.dphone = dphone;
        this.dtitle = dtitle;
        this.ddeptid = ddeptid;
        this.ddeptname = ddeptname;
        this.dpassword = dpassword;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDage() {
        return dage;
    }

    public void setDage(String dage) {
        this.dage = dage;
    }

    public String getDsex() {
        return dsex;
    }

    public void setDsex(String dsex) {
        this.dsex = dsex;
    }

    public String getDphone() {
        return dphone;
    }

    public void setDphone(String dphone) {
        this.dphone = dphone;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public String getDdeptid() {
        return ddeptid;
    }

    public void setDdeptid(String ddeptid) {
        this.ddeptid = ddeptid;
    }

    public String getDdeptname() {
        return ddeptname;
    }

    public void setDdeptname(String ddeptname) {
        this.ddeptname = ddeptname;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                ", dage='" + dage + '\'' +
                ", dsex='" + dsex + '\'' +
                ", dphone='" + dphone + '\'' +
                ", dtitle='" + dtitle + '\'' +
                ", ddeptid='" + ddeptid + '\'' +
                ", ddeptname='" + ddeptname + '\'' +
                ", dpassword='" + dpassword + '\'' +
                '}';
    }
}
