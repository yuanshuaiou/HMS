package com.hospital.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装、查询、更改的方式
 */
public class DBMysql {

    private static Connection con=DBUntil.con;

    /**
     * 封装一个查询的工具
     * @param sql
     * @param data
     * @return
     */
    public static ResultSet query(String sql,String ...data) {//可变参数，填几个都行
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<data.length;i++) {
                pstmt.setString(i+1,data[i]);//第i个问号值为data[i]
            }
            ResultSet resultSet=pstmt.executeQuery();//将结果集合返回去
            return resultSet;
        } catch (SQLException e) {
            return null;//有问题返回空值
        }
    }
    /**
     * -1代表报错，0代表更改失败，>1代表成功
     * @param sql
     * @param data
     * @return
     */
    public static int update(String sql,String ...data) {//可变参数，填几个都行
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<data.length;i++) {
                pstmt.setString(i+1,data[i]);//第i个问号值为data[i]
            }
            return pstmt.executeUpdate();//将结果集合返回去
        } catch (SQLException e) {
            return -1;//有问题返回-1
        }
    }
    /**
     * 实现单个查询
     * @param sql
     * @param tClass
     * @param data
     * @return
     * @param <T>
     */
    public static<T> T queryOne(String sql,Class<T>tClass,String ...data) {
        T instance = null;
        try{
            PreparedStatement pstmt=con.prepareStatement(sql);
            for(int i=0;i<data.length;i++) {
                pstmt.setString(i+1,data[i]);
            }
            ResultSet resultSet=pstmt.executeQuery();
            instance = (T)tClass.getDeclaredConstructor().newInstance();
            Field[] fields=tClass.getDeclaredFields();
            while(resultSet.next()) {
                for(Field field:fields) {
                    field.setAccessible(true);
                    String res = resultSet.getString(field.getName());
                    resultSet.getString(field.getName());
                    field.set(instance,res);
                }
            }
            return instance;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询所有
     * @param sql
     * @param tClass
     * @param data
     * @return
     * @param <T>
     */
    //T 代表任意类型
    public static <T> List<T> queryAll(String sql, Class<T> tClass, String ...data) {
//        T instance = null;
        List<T>list=new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);//初步加载SQL
            for (int i = 0; i < data.length; i++) {
                pstmt.setString(i + 1, data[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();
            //单个查询

            //创建一个类的实例


            while(resultSet.next())
            {
                T instance=tClass.getDeclaredConstructor().newInstance();
                Field fields[]=tClass.getDeclaredFields();
//
                for (Field field : fields) {
                    field.setAccessible(true);//允许访问私有字段
                    String res=resultSet.getString(field.getName());
                    resultSet.getString(field.getName());
                    field.set(instance,res);
                }
                list.add(instance);
            }

            return list;
        }catch (SQLException | NoSuchMethodException e)
        {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

}



