package com.hospital.view;

import com.hospital.bean.Medicine;
import com.hospital.bean.Patient;
import com.hospital.dao.*;
import com.hospital.utils.MyTable;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorView {

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
    private DefaultTableModel model;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorView window = new DoctorView();
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
    public DoctorView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        ImageIcon icon=new ImageIcon("image/img3.jpg");
        JLabel label=new JLabel(icon);//创建标签，使用标签来存储图片，实现背景
        label.setBounds(0,0,800,600);//设置标签位置

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(240, 240, 240));
        frame.setTitle("住院管理系统");
        frame.setBounds(100, 100, 800, 725);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("患者管理");
        mnNewMenu.setIcon(null);
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("查看全部病人");
        mnNewMenu.add(mntmNewMenuItem);

        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Patient> nur=new PatientDao().getpatientAll();
                try {
                    //创建表格位置
                    Object col[]={"编号","姓名","年龄","性别","电话","病房号","医生编号","病历"};
                    MyTable table=new MyTable(col);
                    model=table.getModel();

                    JPanel panel = new JPanel();
                    panel.setBounds(35, 59, 800, 600);
                    frame.getContentPane().add(panel);
                    panel.setOpaque(false);
                    panel.setLayout(null);

                    JScrollPane scrollPane = new JScrollPane(new JTable(model));
                    scrollPane.setBounds(0, 125, 750, 450); // 根据实际情况调整位置和大小
                    panel.add(scrollPane);

                    Tools.addTableDate(model,nur);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("查询病人信息");
        mnNewMenu.add(mntmNewMenuItem_1);

        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DSearchPatientView dSearchPatientView = new DSearchPatientView();
                DSearchPatientView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("办理入院");
        mnNewMenu.add(mntmNewMenuItem_2);

        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                RegisterPatientView registerPatientView = new RegisterPatientView();
                registerPatientView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("办理出院");
        mnNewMenu.add(mntmNewMenuItem_3);

        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DeletePatientView deletePatientView = new DeletePatientView();
                deletePatientView.frame.setVisible(true);
            }
        });

        JMenu mnNewMenu_1 = new JMenu("治疗方案");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("开具处方");
        mnNewMenu_1.add(mntmNewMenuItem_4);

        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                RegisterPrescriptionView registerPrescriptionView = new RegisterPrescriptionView();
                registerPrescriptionView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("查询药品信息");
        mnNewMenu_1.add(mntmNewMenuItem_6);

        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Medicine> med=new MedicineDao().getmedicineAll();
                try {
                    //创建表格位置
                    Object col[]={"编号","药品名","药品数量","价格"};
                    MyTable table=new MyTable(col);
                    model=table.getModel();

                    JPanel panel = new JPanel();
                    panel.setBounds(35, 59, 800, 600);
                    frame.getContentPane().add(panel);
                    panel.setOpaque(false);
                    panel.setLayout(null);

                    JScrollPane scrollPane = new JScrollPane(new JTable(model));
                    scrollPane.setBounds(0, 125, 750, 450); // 根据实际情况调整位置和大小
                    panel.add(scrollPane);

                    Tools.addTableDate(model,med);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenu mnNewMenu_2 = new JMenu("退出登录");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_21 = new JMenuItem("切换管理员账号");
        mnNewMenu_2.add(mntmNewMenuItem_21);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginView loginView = new LoginView();
                loginView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_22 = new JMenuItem("切换医生账号");
        mnNewMenu_2.add(mntmNewMenuItem_22);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginDoctorView loginDoctorView = new LoginDoctorView();
                loginDoctorView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_23 = new JMenuItem("切换护士账号");
        mnNewMenu_2.add(mntmNewMenuItem_23);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                LoginNurseView loginNurseView = new LoginNurseView();
                loginNurseView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_24 = new JMenuItem("退出页面");
        mnNewMenu_2.add(mntmNewMenuItem_24);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });


//        JLabel lblNewLabel = new JLabel("");
//        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\住院管理系统\\HMS\\image\\img2.jpg"));
//        lblNewLabel.setBackground(new Color(240, 240, 240));
//        lblNewLabel.setBounds(0, 0, 800, 180);
//        frame.getContentPane().add(lblNewLabel);


    }

}
