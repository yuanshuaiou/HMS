package com.hospital.bean;

public class Prescription {
    private String preid;
    private String prepatientid;
    private String predoctorid;
    private String preprice;
    private String premedicine;

    public Prescription(String preid, String prepatientid, String predoctorid, String preprice, String premedicine) {
        this.preid = preid;
        this.prepatientid = prepatientid;
        this.predoctorid = predoctorid;
        this.preprice = preprice;
        this.premedicine = premedicine;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "preid='" + preid + '\'' +
                ", prepatientid='" + prepatientid + '\'' +
                ", predoctorid='" + predoctorid + '\'' +
                ", preprice='" + preprice + '\'' +
                ", premedicine='" + premedicine + '\'' +
                '}';
    }

    public String getPreid() {
        return preid;
    }

    public void setPreid(String preid) {
        this.preid = preid;
    }

    public String getPrepatientid() {
        return prepatientid;
    }

    public void setPrepatientid(String prepatientid) {
        this.prepatientid = prepatientid;
    }

    public String getPredoctorid() {
        return predoctorid;
    }

    public void setPredoctorid(String predoctorid) {
        this.predoctorid = predoctorid;
    }

    public String getPreprice() {
        return preprice;
    }

    public void setPreprice(String preprice) {
        this.preprice = preprice;
    }

    public String getPremedicine() {
        return premedicine;
    }

    public void setPremedicine(String premedicine) {
        this.premedicine = premedicine;
    }

    public Prescription() {
    }
}
