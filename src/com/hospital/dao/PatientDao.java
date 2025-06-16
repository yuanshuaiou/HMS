package com.hospital.dao;

import com.hospital.bean.Nurse;
import com.hospital.bean.Patient;
import com.hospital.bean.Patient;
import com.hospital.utils.DBMysql;

import java.sql.ResultSet;
import java.util.List;

public class PatientDao {


    /**
     * 实现注册账号功能
     */

    public static int registerPatient(String pid, String pname, String page, String psex, String pphone, String proomid, String pdoctorid, String pdisease) {
        String sql = "insert into h_patient values(?,?,?,?,?,?,?,?)";
        int result = DBMysql.update(sql,pid,pname,page,psex,pphone,proomid,pdoctorid,pdisease);
        return result;
    }

    /**
     * 实现删除功能（根据医生编号）
     * @param pid
     * @return
     */
    public static int deletePatient(String pid) {
        String sql = "delete from h_Patient where pid=?";
        int res= DBMysql.update(sql, pid);
        return res;
    }


    public static int editPatient(String pid, String pname, String page, String psex, String pphone, String ptitle, String pdeptid, String pdeptname) {
        String sql = "update h_Patient set pid=?,pname=?,page=?,psex=?,pphone=?,ptitle=?,pdeptid=?,pdeptname=? where pid=?";
        int re = DBMysql.update(sql,pid,pname,page,psex,pphone,ptitle, pdeptid, pdeptname);
        return re;
    }

    /**
     * 根据编号查询
     * @param pid
     * @return
     */
    public Patient getPatient(String pid) {
        String sql = "select * from h_patient where pid=?";
        Patient pat = (Patient)DBMysql.queryOne(sql, Patient.class,pid);
        return pat;
    }


    public List<Patient> getpatientAll() {
        String sql = "select * from h_patient";
        List<Patient> pat =DBMysql.queryAll(sql, Patient.class);
        return pat;
    }

}
