package com.hospital.view;

import com.hospital.bean.*;
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

public class ManageView {

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
                    ManageView window = new ManageView();
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
    public ManageView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        ImageIcon icon=new ImageIcon("image/image1.jpg");
        JLabel label=new JLabel(icon);//创建标签，使用标签来存储图片，实现背景
        label.setBounds(0,0,800,600);//设置标签位置

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(240, 240, 240));
        frame.setTitle("住院管理系统");
        frame.setBounds(100, 100, 800, 725);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        //change1
        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        panel.setOpaque(false);
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 125, 750, 450);
        panel.add(scrollPane);
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        scrollPane.setViewportView(table);

        //
        JMenu mnNewMenu = new JMenu("查找");
        mnNewMenu.setIcon(null);
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("查看医生信息");
        mnNewMenu.add(mntmNewMenuItem);

        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Doctor> doc=new DoctorDao().getdoctorAll();
                try {
                    //创建表头
                    Object col[]={"编号","姓名","性别","年龄","电话","职称","科室号","科室名","密码"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,doc);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("查看护士信息");
        mnNewMenu.add(mntmNewMenuItem_1);

        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Nurse> nur=new NurseDao().getnurseAll();
                try {
                    //创建表格位置
                    Object col[]={"编号","姓名","性别","年龄","电话","职称","科室号","科室名","密码"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,nur);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("查看病人信息");
        mnNewMenu.add(mntmNewMenuItem_2);

        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Patient> nur=new PatientDao().getpatientAll();
                try {
                    //创建表格位置
                    Object col[]={"编号","姓名","年龄","性别","电话","病房号","医生编号","病历"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,nur);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("查看药品信息");
        mnNewMenu.add(mntmNewMenuItem_3);

        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Medicine> med=new MedicineDao().getmedicineAll();
                try {
                    //创建表格位置
                    Object col[]={"编号","药品名","药品数量","价格"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,med);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("查看科室信息");
        mnNewMenu.add(mntmNewMenuItem_4);

        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Department> med=new DepartmentDao().getDepartmentAll();
                try {
                    //创建表格位置
                    Object col[]={"科室编号","科室名","联系电话","房间号"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,med);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("查看病房信息");
        mnNewMenu.add(mntmNewMenuItem_5);

        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Room> med=new RoomDao().getRoomAll();
                try {
                    //创建表格位置
                    Object col[]={"病房号","科室编号","科室名","病床数量"};
                    model.setColumnIdentifiers(col);
                    Tools.addTableDate(model,med);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });
        JMenu mnNewMenu_1 = new JMenu("搜索");
        menuBar.add(mnNewMenu_1);



        JMenuItem mntmNewMenuItem_6 = new JMenuItem("搜索医生");
        mnNewMenu_1.add(mntmNewMenuItem_6);

        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
               SearchDoctorView searchDoctorView = new SearchDoctorView();
               searchDoctorView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("搜索护士");
        mnNewMenu_1.add(mntmNewMenuItem_7);

        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SearchNurseView searchNurseView = new SearchNurseView();
                searchNurseView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("搜索病人");
        mnNewMenu_1.add(mntmNewMenuItem_8);

        mntmNewMenuItem_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SearchPatientView searchPatientView = new SearchPatientView();
                searchPatientView.frame.setVisible(true);
            }
        });

        JMenu mnNewMenu_2 = new JMenu("管理");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("注册医生账号");
        mnNewMenu_2.add(mntmNewMenuItem_9);

        //实现医生账号注册
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                RegisterDoctorView registerDoctorView = new RegisterDoctorView();
                registerDoctorView.frame.setVisible(true);
            }
        });


        JMenuItem mntmNewMenuItem_10 = new JMenuItem("注册护士账号");
        mnNewMenu_2.add(mntmNewMenuItem_10);

        //实现注册
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                RegisterNurseView registerNurseView = new RegisterNurseView();
                registerNurseView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("修改医生信息");
        mnNewMenu_2.add(mntmNewMenuItem_11);

        mntmNewMenuItem_11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChangeDoctorView changeDoctorView = new ChangeDoctorView();
                changeDoctorView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_15 = new JMenuItem("修改护士信息");
        mnNewMenu_2.add(mntmNewMenuItem_15);

        mntmNewMenuItem_15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChangeNurseView changeNurseView = new ChangeNurseView();
                changeNurseView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_12 = new JMenuItem("注销医生账号");
        mnNewMenu_2.add(mntmNewMenuItem_12);

        mntmNewMenuItem_12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                DeleteDoctorView deleteDoctorView = new DeleteDoctorView();
                deleteDoctorView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_13 = new JMenuItem("注销护士账号");
        mnNewMenu_2.add(mntmNewMenuItem_13);

        mntmNewMenuItem_13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                DeleteNurseView deleteNurseView = new DeleteNurseView();
                deleteNurseView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_16 = new JMenuItem("修改科室信息");
        mnNewMenu_2.add(mntmNewMenuItem_16);

        mntmNewMenuItem_16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChangeDepartmentView changeDepartmentView = new ChangeDepartmentView();
                changeDepartmentView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_17 = new JMenuItem("修改病房信息");
        mnNewMenu_2.add(mntmNewMenuItem_17);

        mntmNewMenuItem_17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChangeRoomView changeRoomView = new ChangeRoomView();
                changeRoomView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_14 = new JMenuItem("添加药品");
        mnNewMenu_2.add(mntmNewMenuItem_14);

        mntmNewMenuItem_14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                RegisterMedicineView registerMedicineView = new RegisterMedicineView();
                registerMedicineView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_18 = new JMenuItem("修改药品");
        mnNewMenu_2.add(mntmNewMenuItem_18);

        mntmNewMenuItem_18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                ChangeMedicineView changeMedicineView = new ChangeMedicineView();
                changeMedicineView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_19 = new JMenuItem("删除药品");
        mnNewMenu_2.add(mntmNewMenuItem_19);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                DeleteMedicineView deleteMedicineView = new DeleteMedicineView();
                deleteMedicineView.frame.setVisible(true);
            }
        });

        JMenuItem mntmNewMenuItem_20 = new JMenuItem("注册管理员");
        mnNewMenu_2.add(mntmNewMenuItem_20);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                RregisterView rregisterView = new RregisterView();
                rregisterView.frame.setVisible(true);
            }
        });

        JMenu mnNewMenu_3 = new JMenu("退出登录");
        menuBar.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_21 = new JMenuItem("切换管理员账号");
        mnNewMenu_3.add(mntmNewMenuItem_21);
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
        mnNewMenu_3.add(mntmNewMenuItem_22);
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
        mnNewMenu_3.add(mntmNewMenuItem_23);
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
        mnNewMenu_3.add(mntmNewMenuItem_24);
        frame.getContentPane().setLayout(null);

        mntmNewMenuItem_24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\住院管理系统\\HMS\\image\\img2.jpg"));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setBounds(0, 0, 800, 180);
        frame.getContentPane().add(lblNewLabel);
    }

}
