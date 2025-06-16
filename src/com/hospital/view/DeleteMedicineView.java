package com.hospital.view;

import com.hospital.bean.Medicine;
import com.hospital.dao.AdminDao;
import com.hospital.dao.MedicineDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMedicineView {

    public JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteMedicineView window = new DeleteMedicineView();
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
    public DeleteMedicineView() {
        initialize();
    }

    private final int WIDTH=800;
    private final int HEIGHT=600;
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("删除界面");
        Tools.setPos(frame, WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image\\image1.jpg"));
        lblNewLabel.setBounds(0,0,800,600);

        JLabel lblNewLabel_1 = new JLabel("删除药品");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 60));
        lblNewLabel_1.setBounds(200,-100,396,400);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("请输入要删除的药品编号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 30));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(110, -50, 500, 400);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(110, 220, 500, 26);
        panel.add(textField);
        textField.setColumns(10);


        JButton btnNewButton = new JButton("确认");
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        btnNewButton.setBounds(160, 320, 147, 39);
        panel.add(btnNewButton);

        JButton rtNewButton = new JButton("返回");
        rtNewButton.setFont(new Font("楷体", Font.BOLD, 20));
        rtNewButton.setBounds(400, 320, 147, 39);
        panel.add(rtNewButton);

        frame.getContentPane().add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //注册点击时间
                String id=textField.getText();

                if(id.equals("")) {
                    Tools.showMessage("请输入ID！");

                }
                else{
                    int a= MedicineDao.deleteMedicine(id);
                    if(a==1){
                        Tools.showMessage("删除药品成功！");
                    }
                    else{
                        Tools.showMessage("找不到该药品，删除失败！");
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
