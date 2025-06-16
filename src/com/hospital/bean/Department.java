package com.hospital.bean;

public class Department {
    private String deptid;
    private String deptname;
    private String deptphone;
    private String deptroomid;

    @Override
    public String toString() {
        return "Department{" +
                "deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", deptphone='" + deptphone + '\'' +
                ", deptroomid='" + deptroomid + '\'' +
                '}';
    }

    public String getdeptid() {
        return deptid;
    }

    public void setdeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getdeptname() {
        return deptname;
    }

    public void setdeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getdeptphone() {
        return deptphone;
    }

    public void setdeptphone(String deptphone) {
        this.deptphone = deptphone;
    }

    public String getdeptroomid() {
        return deptroomid;
    }

    public void setdeptroomid(String deptroomid) {
        this.deptroomid = deptroomid;
    }

    public Department(String deptid, String deptname, String deptphone, String deptroomid) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptphone = deptphone;
        this.deptroomid = deptroomid;
    }

    public Department() {
    }
}
