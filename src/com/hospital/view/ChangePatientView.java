package com.hospital.view;

import com.hospital.dao.AdminDao;
import com.hospital.dao.MedicineDao;
import com.hospital.dao.MedicineDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePatientView {

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
                    ChangePatientView window = new ChangePatientView();
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
    public ChangePatientView() {
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

        JLabel lblNewLabel_1 = new JLabel("病人转科室");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,0,396,49);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("编号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 34, 69, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(81, 33, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("名 称：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(350, 34, 69, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(426, 33, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("数 量：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 100, 69, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JPasswordField();
        textField_2.setBounds(81, 99, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("价 格：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(350, 100, 88, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JPasswordField();
        textField_3.setBounds(426, 99, 213, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("类 别：");
        lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 170, 88, 15);
        panel.add(lblNewLabel_6);

        textField_4 = new JPasswordField();
        textField_4.setBounds(81, 169, 213, 26);
        panel.add(textField_4);
        textField_4.setColumns(10);


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
                String mid=textField.getText();
                String mname=textField_1.getText();
                String mnum=textField_2.getText();
                String mprice=textField_3.getText();
                String mcategory=textField_4.getText();

                if(mid.equals("")){
                    Tools.showMessage("请输入账号！");
                }
                else if(mname.equals("")){
                    Tools.showMessage("请输入姓名！");
                }
                else if(mnum.equals("")){
                    Tools.showMessage("请输入年龄！");
                }
                else if(mprice.equals("")){
                    Tools.showMessage("请输入性别！");
                }
                else if(mcategory.equals("")){
                    Tools.showMessage("请输入电话！");
                }
                else{
                    int a= MedicineDao.editMedicine(mid,mname,mnum,mprice);
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

