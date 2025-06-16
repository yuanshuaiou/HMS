package com.hospital.dao;

import com.hospital.bean.Doctor;
import com.hospital.bean.Doctor;
import com.hospital.utils.DBMysql;

import java.sql.ResultSet;
import java.util.List;

public class DoctorDao {
    /**
     * 判断是否登录
     */
    public static Doctor isLogin(String username, String password) {
        String sql = "select * from h_doctor where did=? and dpassword=?";
        ResultSet res = DBMysql.query(sql, username, password);//获取到一个结果集合
        try{
            if(res.next()){
                Doctor doctor = new Doctor(res.getString("did"),
                        res.getString("dname"),
                        res.getString("dage"),
                        res.getString("dsex"),
                        res.getString("dphone"),
                        res.getString("dtitle"),
                        res.getString("ddeptid"),
                        res.getString("ddeptname"),
                        res.getString("dpassword"));//读取数据
                return doctor;

            }
        }catch(Exception e){

        }
        return null;
    }



    /**
     * 实现注册账号功能
     */

    public static int registerdoctor(String did, String dname, String dage, String dsex, String dphone, String dtitle, String ddeptid, String ddeptname, String dpassword) {
        String sql = "insert into h_doctor values(?,?,?,?,?,?,?,?,?)";
        int result = DBMysql.update(sql, did, dname, dage, dsex, dphone, dtitle, ddeptid, ddeptname, dpassword);
        return result;
    }

    /**
     * 实现医生删除功能（根据医生编号）
     * @param did
     * @return
     */
    public static int deletedoctor(String did) {
        String sql = "delete from h_doctor where did=?";
        int res= DBMysql.update(sql, did);
        return res;
    }

    /**
     * 根据did更新医生信息
     * @param did
     * @param dname
     * @param dage
     * @param dsex
     * @param dphone
     * @param dtitle
     * @param ddeptid
     * @param ddeptname
     * @param dpassword
     * @return
     */
    public static int editdoctor(String did, String dname, String dage, String dsex, String dphone, String dtitle, String ddeptid, String ddeptname, String dpassword) {
        String sql = "update h_doctor set did=?,dname=?,dage=?,dsex=?,dphone=?,dtitle=?,ddeptid=?,ddeptname=?,dpassword=? where did=?";
        int re = DBMysql.update(sql,did,dname,dage,dsex,dphone,dtitle, ddeptid, ddeptname, dpassword);
        return re;
    }

    /**
     * 根据编号查询医生信息
     * @param did
     * @return
     */
    public Doctor getdoctor(String did) {
        String sql = "select * from h_doctor where did=?";
        Doctor doc =(Doctor)DBMysql.queryOne(sql, Doctor.class,did);
        return doc;
    }

    /**
     * 查询全部医生
     * @return
     */
    public List<Doctor> getdoctorAll() {
        String sql = "select * from h_doctor";
        List<Doctor> doc =DBMysql.queryAll(sql, Doctor.class);
        return doc;
    }


}
