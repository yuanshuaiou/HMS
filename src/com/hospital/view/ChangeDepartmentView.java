package com.hospital.view;

import com.hospital.dao.AdminDao;
import com.hospital.dao.DepartmentDao;
import com.hospital.dao.DepartmentDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeDepartmentView {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeDepartmentView window = new ChangeDepartmentView();
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
    public ChangeDepartmentView() {
        initialize();
    }

    private final int WIDTH=800;
    private final int HEIGHT=600;
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("修改信息界面");
        Tools.setPos(frame, WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image\\image1.jpg"));
        lblNewLabel.setBounds(0,0,800,600);

        JLabel lblNewLabel_1 = new JLabel("修改科室信息");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,0,396,49);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("科室编号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 24, 69, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(81, 23, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("科室名：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 64, 69, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(81, 63, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("联系电话：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 104, 69, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(81, 103, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("房间号：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(10, 150, 88, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setBounds(81, 143, 213, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);


        JButton btnNewButton = new JButton("修改");
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
                String depid=textField.getText();
                String depname=textField_1.getText();
                String depphone=textField_2.getText();
                String deproomid=textField_3.getText();

                if(depid.equals("")){
                    Tools.showMessage("请输入科室编号！");
                }
                else if(depname.equals("")){
                    Tools.showMessage("请输入科室名！");
                }
                else if(depphone.equals("")){
                    Tools.showMessage("请输入联系电话！");
                }
                else if(deproomid.equals("")){
                    Tools.showMessage("请输入房间号！");
                }
                else{
                    int a= DepartmentDao.editDepartment(depid,depname,depphone,deproomid);
                    if(a==1){
                        Tools.showMessage("修改成功！");
                    }
                    else{
                        Tools.showMessage("修改失败！");
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
