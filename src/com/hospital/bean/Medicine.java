package com.hospital.bean;

public class Medicine {
    private String mid;
    private String mname;
    private String mnum;
    private String mprice;
    //private String mcategory;
    public Medicine() {}

    public Medicine(String mid, String mname, String mnum, String mprice) {
        this.mid = mid;
        this.mname = mname;
        this.mnum = mnum;
        this.mprice = mprice;
        //this.mcategory = mcategory;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMnum() {
        return mnum;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }

//    public String getMcategory() {
//        return mcategory;
//    }
//
//    public void setMcategory(String mcategory) {
//        this.mcategory = mcategory;
//    }

    @Override
    public String toString() {
        return "Medicine{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", mnum='" + mnum + '\'' +
                ", mprice='" + mprice + '\'' +
                '}';
    }


}




