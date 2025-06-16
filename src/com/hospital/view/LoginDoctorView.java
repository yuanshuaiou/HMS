package com.hospital.view;


import com.hospital.bean.Doctor;
import com.hospital.dao.DoctorDao;
import com.hospital.utils.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JTextField.*;

public class LoginDoctorView {
    public JFrame frame;
    //final是常量，设置顶层框架的宽度和高度
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    /**
     * 构造方法
     */
    public LoginDoctorView() {
        frame=new JFrame();//创建登录窗口
        initView();
        frame.setTitle("住院管理系统");
        frame.setLayout(null);//设置布局，空布局
        frame.setVisible(true);//设置是否可视化，可视
        frame.setResizable(false);//设置是否可改变，不可改变
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Tools.setPos(frame,WIDTH,HEIGHT);//设置位置
        frame.validate();//让组件生效
    }

    /**
     * 初始化窗口
     */
    private void initView(){
        //创建一个盘子
        JPanel panel=new JPanel();//panel盘子存储所有的
        panel.setBounds(0,0,WIDTH,HEIGHT);
        frame.add(panel);
        panel.setLayout(null);//设置布局

        ImageIcon icon=new ImageIcon("image/img4.jpg");
        JLabel label=new JLabel(icon);//创建标签，使用标签来存储图片，实现背景
        label.setBounds(0,0,WIDTH,HEIGHT);//设置标签位置

        JLabel title=new JLabel("住院管理系统");//创建标签，存储标题
        title.setBounds(220,100,WIDTH,100);
        //title.setHorizontalAlignment(SwingConstants.CENTER);//设置为居中
        title.setFont(new Font("楷体",Font.BOLD,60));//设置字体//BOLD是加粗，PLAIN是不加粗
        title.setForeground(Color.BLACK);//设置文字颜色
        panel.add(title);//添加到盘子里

        //创建盘子，存储账号
        JPanel jPanel2=new JPanel();
        jPanel2.setBounds(250,230,300,50);
        panel.add(jPanel2);
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));//一行满了自动换行
        panel.add(jPanel2);
        jPanel2.setOpaque(true);//设置背景色为透明色
        jPanel2.setBackground(new Color(255, 255, 255, 128));

        JLabel account=new JLabel("账号：");//标签存储账号
        jPanel2.add(account);
        account.setForeground(Color.BLACK);
        account.setFont(new Font("宋体",Font.BOLD,35));

        JTextField acc=new JTextField(12);//账号输入框
        jPanel2.add(acc);

        //创建盘子，存储密码
        JPanel jPanel3=new JPanel();
        jPanel3.setBounds(250,280,300,50);
        panel.add(jPanel3);
        jPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));//一行满了自动换行
        panel.add(jPanel3);
        jPanel3.setOpaque(true);//设置背景色为透明色
        jPanel3.setBackground(new Color(255, 255, 255, 128));

        JLabel password=new JLabel("密码：");//标签存储密码
        jPanel3.add(password);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("宋体",Font.BOLD,35));

        JPasswordField pas=new JPasswordField(12);//密码输入框
        jPanel3.add(pas);

        //创建盘子，存储按钮
        JPanel jPanel4=new JPanel();
        jPanel4.setBounds(0,370,WIDTH,70);
        panel.add(jPanel4);
        jPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));//一行满了自动换行
        panel.add(jPanel4);
        jPanel4.setOpaque(false);//设置背景色为透明色

        JButton button=new JButton("登录");//创建按钮
        jPanel4.add(button);
        button.setBounds(0,370,WIDTH,70);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("楷体",Font.PLAIN,25));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //判断账号框和密码框是否有内容
                String account=acc.getText();//账号
                String password=new String(pas.getPassword());//密码
                if(account.equals("")){//若账号输入为空
                    Tools.showMessage("请输入账号！");
                }
                else if(password.equals("")){//若密码输入为空
                    Tools.showMessage("请输入密码！");
                }
                else{//若都输入内容了
                    //查询数据库当前账号是否存在
                    Doctor doctor=DoctorDao.isLogin(account,password);
                    if(doctor==null){//没有这个
                        Tools.showMessage("账号或密码错误！请重试");

                    }
                    else{
                        Tools.showMessage("登录成功！");
                        frame.dispose();
                        DoctorView window = new DoctorView();
                        window.frame.setVisible(true);
                    }
                }
            }
        });

        JPanel jPanel5=new JPanel();
        jPanel5.setBounds(0,450,WIDTH,HEIGHT);
        panel.add(jPanel5);
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));//一行满了自动换行
        panel.add(jPanel5);
        jPanel5.setOpaque(false);//设置背景色为透明色

        JButton button_1=new JButton("返回");//创建按钮
        jPanel5.add(button_1);
        button_1.setBounds(0,500,WIDTH,HEIGHT);
        button_1.setForeground(Color.BLACK);
        button_1.setFont(new Font("楷体",Font.PLAIN,25));

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChooseView chooseView=new ChooseView();
                chooseView.frame.setVisible(true);
            }
        });


        panel.add(label);//将存储图片的标签放到最后再添加到盘子里
    }
}