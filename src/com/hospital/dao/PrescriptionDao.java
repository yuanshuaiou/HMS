package com.hospital.dao;

import com.hospital.bean.Prescription;
import com.hospital.utils.DBMysql;

import java.util.List;

public class PrescriptionDao
{
    /**
     * 添加
     */

    public static int registerPrescription(String preid, String prepatientid, String predoctorid, String preprice,String premedicine) {
        String sql = "insert into h_Prescription values(?,?,?,?,?)";
        int result = DBMysql.update(sql, preid, prepatientid, predoctorid, preprice, premedicine);
        return result;
    }

//    /**
//     * 删除
//     * @param
//     * @return
//     */
//
//    public static int deletePrescription(String rid) {
//        String sql = "delete from h_Prescription where rid=?";
//        int res= DBMysql.update(sql, rid);
//        return res;
//    }
//
//    //修改
//    public static int editPrescription(String rid, String rdeptid, String rdeptname, String rbednum) {
//        String sql = "update h_Prescription set rid=?,rdeptid=?,rdeptname=?,rbednum=? where id=?";
//        int re = DBMysql.update(sql, rid, rdeptid, rdeptname, rbednum, rid);
//        return re;
//    }
//
//
    /**
     * 查询
     * @param
     * @return
     */
    public Prescription getPrescription(String preid) {
        String sql = "select * from h_Prescription where preid=?";
        Prescription roo =(Prescription)DBMysql.queryOne(sql, Prescription.class,preid);
        return roo;
    }

    //修改
//    public static int editPrescription(String num,String premedicine) {
//        String sql = "update h_Medicine set mnum=? where mid=?";
//        int re = DBMysql.update(sql, num,premedicine);
//        return re;
//    }
//
//    /**
//     * 查询全部
//     * @return
//     */
//    public List<Prescription> getPrescriptionAll() {
//        String sql = "select * from h_Prescription";
//        List<Prescription> roo=DBMysql.queryAll(sql, Prescription.class);
//        return roo;
//    }

}
