package com.hospital.dao;

import com.hospital.bean.Admin;
import com.hospital.bean.Doctor;
import com.hospital.utils.DBMysql;

import java.sql.ResultSet;

public class AdminDao {
    /**
     * 判断是否登录
     * @param username
     * @param password
     * @return
     */
    public static Admin isLogin(String username, String password) {
        String sql = "select * from h_admin where account=? and password=?";
        ResultSet res = DBMysql.query(sql, username, password);//获取到一个结果集合
        try{
            if(res.next()){
                Admin admin = new Admin(res.getString("account"),
                        res.getString("password"),
                        res.getString("name"));//读取数据
                return admin;

            }
        }catch(Exception e){

        }
        return null;
    }



    /**
     * 实现注册账号功能
     * @param account
     * @param password
     * @param name
     * @return
     */
    public static int register(String account, String password, String name) {
        String sql = "insert into h_admin values(?,?,?)";
        int result = DBMysql.update(sql, account, password, name);
        return result;
    }

}
