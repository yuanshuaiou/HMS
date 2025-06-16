package com.hospital.dao;

import com.hospital.bean.Department;
import com.hospital.utils.DBMysql;

import java.util.List;

public class DepartmentDao
{
//    /**
//     * 添加
//     */
//
//    public static int registerDepartment(String deptid,) {
//        String sql = "insert into h_Department values(?,?,?,?,?)";
//        int result = DBMysql.update(sql,mid,mname,mnum,mprice,mcategory);
//        return result;
//    }
//
//    /**
//     * 删除
//     * @param mid
//     * @return
//     */
//
//    public static int deleteDepartment(String mid) {
//        String sql = "delete from h_Department where mid=?";
//        int res= DBMysql.update(sql, mid);
//        return res;
//    }
//
    //修改
    public static int editDepartment(String deptid,String deptname,String deptphone,String deptroomid) {
        String sql = "update h_Department set deptname=?,deptphone=?,deptroomid=? where deptid=?";
        int re = DBMysql.update(sql,deptname,deptphone,deptroomid,deptid);
        return re;
    }


    /**
     * 查询
     * @param
     * @return
     */
    public Department getDepartment(String deptid) {
        String sql = "select * from h_Department where deptid=?";
        Department dep =(Department)DBMysql.queryOne(sql, Department.class,deptid);
        return dep;
    }

    /**
     * 查询全部
     * @return
     */
    public List<Department> getDepartmentAll() {
        String sql = "select * from h_Department";
        List<Department> dep=DBMysql.queryAll(sql, Department.class);
        return dep;
    }

}
