package com.hospital.dao;

import com.hospital.bean.Medicine;
import com.hospital.utils.DBMysql;

import java.util.List;

public class MedicineDao
{
    /**
     * 添加
     */

    public static int registerMedicine(String mid, String mname, String mnum, String mprice) {
        String sql = "insert into h_Medicine values(?,?,?,?)";
        int result = DBMysql.update(sql,mid,mname,mnum,mprice);
        return result;
    }

    /**
     * 删除
     * @param mid
     * @return
     */

    public static int deleteMedicine(String mid) {
        String sql = "delete from h_Medicine where mid=?";
        int res= DBMysql.update(sql, mid);
        return res;
    }

    //修改
    public static int editMedicine(String mid, String mname, String mnum, String mprice) {
        String sql = "update h_Medicine set mid=?,mname=?,mnum=?,mprice=?";
        int re = DBMysql.update(sql,mid,mname,mnum,mprice);
        return re;
    }


    public static int editPrescription(String num,String premedicine) {
        String sql = "update h_Medicine set mnum=? where mid=?";
        int re = DBMysql.update(sql, num,premedicine);
        return re;
    }

    /**
     * 查询
     * @param mid
     * @return
     */
    public Medicine getMedicine(String mid) {
        String sql = "select * from h_Medicine where mid=?";
        Medicine med =(Medicine)DBMysql.queryOne(sql, Medicine.class,mid);
        return med;
    }

    /**
     * 查询全部
     * @return
     */
    public List<Medicine> getmedicineAll() {
        String sql = "select * from h_Medicine";
        List<Medicine> med=DBMysql.queryAll(sql, Medicine.class);
        return med;
    }

    public String getMedicineNum(String mid) {
        String sql = "select mnum from h_Medicine where mid=?";
        Medicine med =(Medicine)DBMysql.queryOne(sql, Medicine.class,mid);
        String num=med.getMnum();
        return num;
    }


}
