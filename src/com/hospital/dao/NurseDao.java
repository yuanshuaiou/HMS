package com.hospital.dao;

import com.hospital.bean.Doctor;
import com.hospital.bean.Nurse;
import com.hospital.bean.Nurse;
import com.hospital.utils.DBMysql;

import java.sql.ResultSet;
import java.util.List;

public class NurseDao {
    /**
     * 判断是否登录
     */
    public static Nurse isLogin(String username, String password) {
        String sql = "select * from h_nurse where nid=? and npassword=?";
        ResultSet res = DBMysql.query(sql, username, password);//获取到一个结果集合
        try{
            if(res.next()){
                Nurse nurse = new Nurse(res.getString("nid"),
                        res.getString("nname"),
                        res.getString("nage"),
                        res.getString("nsex"),
                        res.getString("nphone"),
                        res.getString("ntitle"),
                        res.getString("ndeptid"),
                        res.getString("ndeptname"),
                        res.getString("npassword"));//读取数据
                return nurse;

            }
        }catch(Exception e){

        }
        return null;
    }



    /**
     * 实现注册账号功能
     */

    public static int registerNurse(String nid, String nname, String nage, String nsex, String nphone, String ntitle, String ndeptid, String ndeptname, String npassword) {
        String sql = "insert into h_nurse values(?,?,?,?,?,?,?,?,?)";
        int result = DBMysql.update(sql, nid, nname, nage, nsex, nphone, ntitle, ndeptid, ndeptname, npassword);
        return result;
    }

    /**
     * 实现护士删除（根据编号删除）
     * @param did
     * @return
     */

    public static int deleteNurse(String did) {
        String sql = "delete from h_nurse where did=?";
        int res= DBMysql.update(sql, did);
        return res;
    }


    public static int editNurse(String nid, String nname, String nage, String nsex, String nphone, String ntitle, String ndeptid, String ndeptname, String npassword) {
        String sql = "update h_nurse set nid=?,nname=?,nage=?,nsex=?,nphone=?,ntitle=?,ndeptid=?,ndeptname=?,npassword=? where nid=?";
        int re = DBMysql.update(sql,nid,nname,nage,nsex,nphone,ntitle, ndeptid, ndeptname, npassword);
        return re;
    }


    /**
     * 根据编号查询护士信息
     * @param nid
     * @return
     */
    public Nurse getnurse(String nid) {
        String sql = "select * from h_nurse where nid=?";
        Nurse nur =(Nurse)DBMysql.queryOne(sql, Nurse.class,nid);
        return nur;
    }

    /**
     * 查询全部护士
     * @return
     */
    public List<Nurse> getnurseAll() {
        String sql = "select * from h_nurse";
        List<Nurse> nur =DBMysql.queryAll(sql, Nurse.class);
        return nur;
    }

}
