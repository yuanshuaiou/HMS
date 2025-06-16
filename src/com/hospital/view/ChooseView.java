package com.hospital.view;

import com.hospital.bean.Admin;
import com.hospital.dao.AdminDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChooseView {

    public JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChooseView window = new ChooseView();
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
    public ChooseView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        ImageIcon icon=new ImageIcon("image/img8.jpg");
        JLabel label=new JLabel(icon);//创建标签，使用标签来存储图片，实现背景
        label.setBounds(0,0,800,700);//设置标签位置

        frame = new JFrame();
        frame.setBackground(new Color(240, 240, 240));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("住院管理系统登录");
        lblNewLabel.setBounds(148, 77, 569, 64);
        lblNewLabel.setFont(new Font("楷体", Font.BOLD, 60));
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("管理员");
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 40));
        btnNewButton.setBounds(215, 188, 368, 80);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginView loginView=new LoginView();
                loginView.frame.setVisible(true);
            }
        });

        JButton btnNewButton_1 = new JButton("医生");
        btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 40));
        btnNewButton_1.setBounds(215, 297, 368, 80);
        panel.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginDoctorView loginDoctorView=new LoginDoctorView();
                loginDoctorView.frame.setVisible(true);
            }
        });

        JButton btnNewButton_1_1 = new JButton("护士");
        btnNewButton_1_1.setFont(new Font("楷体", Font.BOLD, 40));
        btnNewButton_1_1.setBounds(215, 409, 368, 80);
        panel.add(btnNewButton_1_1);

        btnNewButton_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginNurseView loginNurseView=new LoginNurseView();
                loginNurseView.frame.setVisible(true);
            }
        });

        panel.add(label);
    }
}
