package com.hospital.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.List;
public class
Tools {
    /**
     * 实现了将窗口在屏幕中居中的功能
     * @param jFrame
     * @param width
     * @param height
     */
    public static void setPos(JFrame jFrame, int width, int height){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        //求出位于屏幕正中间的矩形的左上角的顶点（get到的是屏幕的宽和高，找到中间点再减去矩形宽高的一半）
        int x = (int)screenSize.getWidth()/2 - width/2;
        int y = (int)screenSize.getHeight()/2 - height/2;
        jFrame.setBounds(x,y,width,height);
    }

    /**
     * 弹窗封装的方法
     * @param message
     */
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message, "提示消息", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * 得到表格的控制权
     * @param tableModel
     * @param list
     * @return
     * @param <T>
     */


    /**
     * 向表格模型中添加多条数据（适用于传入数据为列表的情况，比如从数据库查询多条记录返回的列表）
     *
     * @param tableModel 表格模型对象，用于存储和管理表格数据
     * @param list       包含要添加到表格中的数据对象的列表
     * @param <T>        泛型，表示列表中数据对象的类型
     * @throws IllegalAccessException 如果反射访问对象的私有字段时出现权限问题则抛出此异常
     */
    public static <T> void addTableDate(DefaultTableModel tableModel, List<T> list) throws IllegalAccessException {
        tableModel.setRowCount(0); // 清除上一次查询内容
        if (list!= null &&!list.isEmpty()) {
            for (T t : list) {
                int len = t.getClass().getDeclaredFields().length;
                String[] data = new String[len];
                Field[] fields = t.getClass().getDeclaredFields();// 得到所有字段的值
                for (int i = 0; i < len; i++) {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(t);
                    data[i] = value!= null? value.toString() : ""; // 如果字段值为null，赋值为空字符串
                }
                tableModel.addRow(data);
            }
        }
    }

    /**
     * 向表格模型中添加单条数据（适用于传入单个数据对象的情况）
     *
     * @param tableModel 表格模型对象，用于存储和管理表格数据
     * @param t          要添加到表格中的单个数据对象
     * @param <T>        泛型，表示数据对象的类型
     * @throws IllegalAccessException 如果反射访问对象的私有字段时出现权限问题则抛出此异常
     */
    public static <T> void addTableDate(DefaultTableModel tableModel, T t) throws IllegalAccessException {
        tableModel.setRowCount(0);
        if (t != null) {
            int len = t.getClass().getDeclaredFields().length;
            String[] data = new String[len];
            Field[] fields = t.getClass().getDeclaredFields();// 得到所有字段的值
            for (int i = 0; i < len; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(t);
                data[i] = value != null ? value.toString() : ""; // 如果字段值为null，赋值为空字符串
            }
            tableModel.addRow(data);
        }
    }
}