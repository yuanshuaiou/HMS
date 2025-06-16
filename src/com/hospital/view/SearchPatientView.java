package com.hospital.view;

import com.hospital.bean.Patient;
import com.hospital.dao.AdminDao;
import com.hospital.dao.PatientDao;
import com.hospital.utils.MyTable;
import com.hospital.utils.Tools;
import com.mysql.cj.xdevapi.Table;
import com.sun.jdi.ObjectCollectedException;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchPatientView {

    public static JFrame frame;
    private JTextField textField;
    private DefaultTableModel model;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchPatientView window = new SearchPatientView();
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
    public SearchPatientView() {
        initialize();
    }

    private final int WIDTH=800;
    private final int HEIGHT=600;
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("搜索界面");
        Tools.setPos(frame, WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image\\image1.jpg"));
        lblNewLabel.setBounds(0,0,800,600);

        JLabel lblNewLabel_1 = new JLabel("搜索病人");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 60));
        lblNewLabel_1.setBounds(200,-100,396,400);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("请输入要搜索的病人ID：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(-110, -80, 500, 400);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(25, 180, 220, 26);
        panel.add(textField);
        textField.setColumns(10);


        JButton btnNewButton = new JButton("搜索");
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        btnNewButton.setBounds(60, 280, 147, 39);
        panel.add(btnNewButton);
//以下创建表格的位置待移动到显示表格的位置
        Object col[]={"编号","姓名","年龄","性别","电话","病房号","医生编号","病历"};
        MyTable table=new MyTable(col);
        model=table.getModel();
//
        //表格显示 初步
        JScrollPane scrollPane = new JScrollPane(new JTable(model));
        scrollPane.setBounds(300, 100, 400, 300); // 根据实际情况调整位置和大小
        panel.add(scrollPane);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //注册点击时间
                String id = textField.getText();
                if (id.equals("")) {
                    Tools.showMessage("请输入ID！");
                } else {
                    Patient pat = new PatientDao().getPatient(id);

                  try {
                      Tools.addTableDate(model, pat);
                  } catch (IllegalAccessException ex) {
                      throw new RuntimeException(ex);
                  }




                }
            }
        });

        JButton rtNewButton = new JButton("返回");
        rtNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        rtNewButton.setBounds(60, 350, 147, 39);
        panel.add(rtNewButton);

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
