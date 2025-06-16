package com.hospital.view;

import com.hospital.utils.DBUntil;

/*当前是程序入口*/
public class HospitalMain {
    public static void main(String[] args) {
        //打开主程序，连接数据库
        DBUntil dbUntil=new DBUntil("root","yso20050411","db_hospital");
        //打开登录窗口
        ChooseView chooseView=new ChooseView();
        chooseView.frame.setVisible(true);
        //LoginView loginView=new LoginView();
    }
}
