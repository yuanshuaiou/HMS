package com.hospital.bean;

public class Room {
    private String rid;
    private String rdeptid;
    private String rdeptname;
    private String rbednum;

    public Room() {
    }

    public Room(String rid, String rdeptid, String rdeptname, String rbednum) {
        this.rid = rid;
        this.rdeptid = rdeptid;
        this.rdeptname = rdeptname;
        this.rbednum = rbednum;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRdeptid() {
        return rdeptid;
    }

    public void setRdeptid(String rdeptid) {
        this.rdeptid = rdeptid;
    }

    public String getRdeptname() {
        return rdeptname;
    }

    public void setRdeptname(String rdeptname) {
        this.rdeptname = rdeptname;
    }

    public String getRbednum() {
        return rbednum;
    }

    public void setRbednum(String rbednum) {
        this.rbednum = rbednum;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid='" + rid + '\'' +
                ", rdeptid='" + rdeptid + '\'' +
                ", rdeptname='" + rdeptname + '\'' +
                ", rbednum='" + rbednum + '\'' +
                '}';
    }
}
