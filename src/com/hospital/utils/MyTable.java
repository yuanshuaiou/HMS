package com.hospital.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * 实现表格显示
 */
public class MyTable {
    JTable table=null;//定义一个表
    DefaultTableModel model=null;//设置默认模式，出现滚动条的方式
    //初始化一个表格
    public MyTable(Object columns[]) {
        //column 存入行的数据
        //  model = (DefaultButtonModel)table.getModel();
        if (table == null) {
            //如果表格没有Table 则创建
            table = new JTable();//初始化一个表格
            model = new DefaultTableModel() {
                //限制用户修改表格内容
                public boolean isCellEditable(int row, int column)
                {
                    return false;//重写 防止用户修改表格内容
                }
            };
            model.setColumnIdentifiers(columns);//设置表头
            table.setModel(model);
            table.getTableHeader().setReorderingAllowed(false);//禁止表头排序
            table.getTableHeader().setResizingAllowed(false);//禁止拖拉表格

        }

    }


    /**
     * 返回控制器
     * @return
     */
    public DefaultTableModel getModel() {
        return model;
    }
}
