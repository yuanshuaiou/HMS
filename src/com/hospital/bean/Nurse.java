package com.hospital.bean;

public class Nurse {
    private String nid;
    private String nname;
    private String nage;
    private String nsex;
    private String nphone;
    private String ntitle;
    private String ndeptid;
    private String ndeptname;
    private String npassword;
    //private String npatientid;
    public Nurse() {}
    @Override
    public String toString() {
        return "Nurse{" +
                "nid='" + nid + '\'' +
                ", nname='" + nname + '\'' +
                ", nage='" + nage + '\'' +
                ", nsex='" + nsex + '\'' +
                ", nphone='" + nphone + '\'' +
                ", ntitle='" + ntitle + '\'' +
                ", ndeptid='" + ndeptid + '\'' +
                ", ndeptname='" + ndeptname + '\'' +
                ", npassword='" + npassword + '\'' +
                '}';
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getNage() {
        return nage;
    }

    public void setNage(String nage) {
        this.nage = nage;
    }

    public String getNsex() {
        return nsex;
    }

    public void setNsex(String nsex) {
        this.nsex = nsex;
    }

    public String getNphone() {
        return nphone;
    }

    public void setNphone(String nphone) {
        this.nphone = nphone;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNdeptid() {
        return ndeptid;
    }

    public void setNdeptid(String ndeptid) {
        this.ndeptid = ndeptid;
    }

    public String getNdeptname() {
        return ndeptname;
    }

    public void setNdeptname(String ndeptname) {
        this.ndeptname = ndeptname;
    }

    public String getNpassword() {
        return npassword;
    }

    public void setNpassword(String npassword) {
        this.npassword = npassword;
    }

    public Nurse(String nid, String nname, String nage, String nsex, String nphone, String ntitle, String ndeptid, String ndeptname, String npassword) {
        this.nid = nid;
        this.nname = nname;
        this.nage = nage;
        this.nsex = nsex;
        this.nphone = nphone;
        this.ntitle = ntitle;
        this.ndeptid = ndeptid;
        this.ndeptname = ndeptname;
        this.npassword = npassword;
    }

}
