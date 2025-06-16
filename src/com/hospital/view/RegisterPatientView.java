package com.hospital.view;

import com.hospital.dao.PatientDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPatientView {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterPatientView window = new RegisterPatientView();
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
    public RegisterPatientView() {
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

        JLabel lblNewLabel_1 = new JLabel("病人办理入院");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,0,396,49);
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
        lblNewLabel_2.setBounds(10, 24, 69, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(81, 23, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("姓 名：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(350, 64, 69, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(426, 63, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("年 龄：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 104, 69, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(81, 103, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("性 别：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(350, 150, 88, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setBounds(426, 143, 213, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("电 话：");
        lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 190, 88, 15);
        panel.add(lblNewLabel_6);

        textField_4 = new JTextField();
        textField_4.setBounds(81, 183, 213, 26);
        panel.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("病房号：");
        lblNewLabel_7.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(10, 230, 88, 15);
        panel.add(lblNewLabel_7);

        textField_5 = new JTextField();
        textField_5.setBounds(81, 223, 213, 26);
        panel.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("医生ID：");
        lblNewLabel_8.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(10, 270, 88, 15);
        panel.add(lblNewLabel_8);

        textField_6 = new JTextField();
        textField_6.setBounds(81, 263, 213, 26);
        panel.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("病 历：");
        lblNewLabel_9.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBounds(10, 310, 88, 15);
        panel.add(lblNewLabel_9);

        textField_7 = new JTextField();
        textField_7.setBounds(81, 303, 213, 26);
        panel.add(textField_7);
        textField_7.setColumns(10);


        JButton btnNewButton = new JButton("确认");
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        btnNewButton.setBounds(92, 420, 147, 39);
        panel.add(btnNewButton);

        JButton rtNewButton = new JButton("返回");
        rtNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        rtNewButton.setBounds(400, 420, 147, 39);
        panel.add(rtNewButton);

        frame.getContentPane().add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //注册点击时间
                String pid=textField.getText();
                String pname=textField_1.getText();
                String page=textField_2.getText();
                String psex =textField_3.getText();
                String pphone=textField_4.getText();
                String proomid=textField_5.getText();
                String pdoctorid=textField_6.getText();
                String pdisease=textField_7.getText();

                if(pid.equals("")){
                    Tools.showMessage("请输入账号！");
                }
                else if(pname.equals("")){
                    Tools.showMessage("请输入姓名！");
                }
                else if(page.equals("")){
                    Tools.showMessage("请输入年龄！");
                }
                else if(psex.equals("")){
                    Tools.showMessage("请输入性别！");
                }
                else if(pphone.equals("")){
                    Tools.showMessage("请输入电话！");
                }
                else if(proomid.equals("")){
                    Tools.showMessage("请输入病房号！");
                }
                else if(pdoctorid.equals("")){
                    Tools.showMessage("请输入医生ID！");
                }
                else if(pdisease.equals("")){
                    Tools.showMessage("请输入病历！");
                }
                else{
                    int a= PatientDao.registerPatient(pid,pname,page,psex,pphone,proomid,pdoctorid,pdisease);
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
                DoctorView doctorView = new DoctorView();
                doctorView.frame.setVisible(true);
            }
        });
    }
}
