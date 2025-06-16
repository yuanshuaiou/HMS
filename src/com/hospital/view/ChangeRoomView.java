package com.hospital.view;

import com.hospital.dao.AdminDao;
import com.hospital.dao.RoomDao;
import com.hospital.dao.RoomDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeRoomView {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeRoomView window = new ChangeRoomView();
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
    public ChangeRoomView() {
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

        JLabel lblNewLabel_1 = new JLabel("修改病房信息");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,0,396,49);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("病房号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 24, 69, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(100, 23, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("科室号：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 94, 69, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(100, 93, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("科室名：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 164, 69, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(100, 163, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("病床数量：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(10, 240, 88, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setBounds(100, 239, 213, 26);
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
                String rid=textField.getText();
                String rdeptid=textField_1.getText();
                String rdeptname=textField_2.getText();
                String rbednum=textField_3.getText();

                if(rid.equals("")){
                    Tools.showMessage("请输入病房号！");
                }
                else if(rdeptid.equals("")){
                    Tools.showMessage("请输入科室编号！");
                }
                else if(rdeptname.equals("")){
                    Tools.showMessage("请输入科室名！");
                }
                else if(rbednum.equals("")){
                    Tools.showMessage("请输入病床数量！");
                }
                else{
                    int a= RoomDao.editRoom(rid,rdeptid,rdeptname,rbednum);
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
