package com.hospital.dao;

import com.hospital.bean.Room;
import com.hospital.utils.DBMysql;

import java.util.List;

public class RoomDao
{
    /**
     * 添加
     */

    public static int registerRoom(String rid, String rdeptid, String rdeptname, String rbednum) {
        String sql = "insert into h_Room values(?,?,?,?)";
        int result = DBMysql.update(sql, rid, rdeptid, rdeptname, rbednum);
        return result;
    }

    /**
     * 删除
     * @param
     * @return
     */

    public static int deleteRoom(String rid) {
        String sql = "delete from h_Room where rid=?";
        int res= DBMysql.update(sql, rid);
        return res;
    }

    //修改
    public static int editRoom(String rid, String rdeptid, String rdeptname, String rbednum) {
        String sql = "update h_Room set rid=?,rdeptid=?,rdeptname=?,rbednum=? where id=?";
        int re = DBMysql.update(sql, rid, rdeptid, rdeptname, rbednum, rid);
        return re;
    }


    /**
     * 查询
     * @param
     * @return
     */
    public Room getRoom(String rid) {
        String sql = "select * from h_Room where rid=?";
        Room roo =(Room)DBMysql.queryOne(sql, Room.class,rid);
        return roo;
    }

    /**
     * 查询全部
     * @return
     */
    public List<Room> getRoomAll() {
        String sql = "select * from h_Room";
        List<Room> roo=DBMysql.queryAll(sql, Room.class);
        return roo;
    }

}
