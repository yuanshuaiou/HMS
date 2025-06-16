package com.hospital.bean;

public class Patient {

    private String Pid;
    private String Pname;
    private String Page;
    private String Psex;
    private String Pphone;
    private String Proomid;
    private String Pdocterid;
    private String Pdisease;

    public Patient() {
    }

    public Patient(String pid, String pname, String page, String psex, String pphone, String proomid, String pdocterid, String pdisease) {
        Pid = pid;
        Pname = pname;
        Page = page;
        Psex = psex;
        Pphone = pphone;
        Proomid = proomid;
        Pdocterid = pdocterid;
        Pdisease = pdisease;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Pid='" + Pid + '\'' +
                ", Pname='" + Pname + '\'' +
                ", Page='" + Page + '\'' +
                ", Psex='" + Psex + '\'' +
                ", Pphone='" + Pphone + '\'' +
                ", Proomid='" + Proomid + '\'' +
                ", Pdocterid='" + Pdocterid + '\'' +
                ", Pdisease='" + Pdisease + '\'' +
                '}';
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    public String getPsex() {
        return Psex;
    }

    public void setPsex(String psex) {
        Psex = psex;
    }

    public String getPphone() {
        return Pphone;
    }

    public void setPphone(String pphone) {
        Pphone = pphone;
    }

    public String getProomid() {
        return Proomid;
    }

    public void setProomid(String proomid) {
        Proomid = proomid;
    }

    public String getPdocterid() {
        return Pdocterid;
    }

    public void setPdocterid(String pdocterid) {
        Pdocterid = pdocterid;
    }

    public String getPdisease() {
        return Pdisease;
    }

    public void setPdisease(String pdisease) {
        Pdisease = pdisease;
    }
}

