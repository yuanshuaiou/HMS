package com.hospital.view;

import com.hospital.dao.AdminDao;
import com.hospital.dao.DoctorDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterDoctorView {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JPasswordField textField_8;
    private JPasswordField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterDoctorView window = new RegisterDoctorView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public RegisterDoctorView() {
        initialize();
    }

    private final int WIDTH=800;
    private final int HEIGHT=600;
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("注册界面");
        Tools.setPos(frame, WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image\\img3.jpg"));
        lblNewLabel.setBounds(0,0,800,600);

        JLabel lblNewLabel_1 = new JLabel("医生注册");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,20,396,49);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("账 号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 44, 69, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(81, 43, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("姓 名：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(350, 44, 69, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(426, 43, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("年 龄：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 104, 69, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(80, 103, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("性 别：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(350, 104, 88, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setBounds(426, 103, 213, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("电 话：");
        lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 161, 88, 15);
        panel.add(lblNewLabel_6);

        textField_4 = new JTextField();
        textField_4.setBounds(80, 160, 213, 26);
        panel.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("职 称：");
        lblNewLabel_7.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(350, 160, 88, 15);
        panel.add(lblNewLabel_7);

        textField_5 = new JTextField();
        textField_5.setBounds(426, 160, 213, 26);
        panel.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("科室编号：");
        lblNewLabel_8.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(6, 220, 88, 15);
        panel.add(lblNewLabel_8);

        textField_6 = new JTextField();
        textField_6.setBounds(81, 219, 213, 26);
        panel.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("科室名：");
        lblNewLabel_9.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBounds(350, 220, 88, 15);
        panel.add(lblNewLabel_9);

        textField_7 = new JTextField();
        textField_7.setBounds(426, 219, 213, 26);
        panel.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("密 码：");
        lblNewLabel_10.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setBounds(10, 290, 88, 15);
        panel.add(lblNewLabel_10);

        textField_8 = new JPasswordField();
        textField_8.setBounds(81, 289, 213, 26);
        panel.add(textField_8);
        textField_8.setColumns(10);

        JLabel lblNewLabel_11 = new JLabel("确认密码：");
        lblNewLabel_11.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setBounds(350, 290, 88, 15);
        panel.add(lblNewLabel_11);

        textField_9 = new JPasswordField();
        textField_9.setBounds(426, 289, 213, 26);
        panel.add(textField_9);
        textField_9.setColumns(10);


        JButton btnNewButton = new JButton("注册");
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        btnNewButton.setBounds(92, 400, 147, 39);
        panel.add(btnNewButton);

        JButton rtNewButton = new JButton("返回");
        rtNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        rtNewButton.setBounds(400, 400, 147, 39);
        panel.add(rtNewButton);

        frame.getContentPane().add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //注册点击时间
                String did=textField.getText();
                String dname=textField_1.getText();
                String dage=textField_2.getText();
                String dsex=textField_3.getText();
                String dphone=textField_4.getText();
                String dtitle=textField_5.getText();
                String ddeptid=textField_6.getText();
                String ddeptname=textField_7.getText();
                String dpassword=new String(textField_8.getPassword());
                String dpassword1=new String(textField_9.getPassword());

                if(did.equals("")){
                    Tools.showMessage("请输入账号！");
                }
                else if(dname.equals("")){
                    Tools.showMessage("请输入姓名！");
                }
                else if(dage.equals("")){
                    Tools.showMessage("请输入年龄！");
                }
                else if(dsex.equals("")){
                    Tools.showMessage("请输入性别！");
                }
                else if(dphone.equals("")){
                    Tools.showMessage("请输入电话！");
                }
                else if(dtitle.equals("")){
                    Tools.showMessage("请输入职称！");
                }
                else if(ddeptid.equals("")){
                    Tools.showMessage("请输入科室编号！");
                }
                else if(ddeptname.equals("")){
                    Tools.showMessage("请输入科室名！");
                }
                else if(!dpassword.equals(dpassword1)){
                    Tools.showMessage("两次密码不一致！");
                }
                else{
                    int a= DoctorDao.registerdoctor(did,dname,dage,dsex,dphone,dtitle,ddeptid,ddeptname,dpassword);
                    if(a==0){
                        Tools.showMessage("账号冲突，注册失败！");
                    }
                    else{
                        if(a==1){
                            Tools.showMessage("注册成功！");
                        }
                        else{
                            Tools.showMessage("注册失败！");
                        }
                    }
                }
            }
        });
        rtNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ManageView manageView = new ManageView();
                manageView.frame.setVisible(true);
            }
        });
    }
}
