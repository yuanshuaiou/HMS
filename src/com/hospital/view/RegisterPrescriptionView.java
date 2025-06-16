package com.hospital.view;

import com.hospital.bean.Doctor;
import com.hospital.bean.Medicine;
import com.hospital.bean.Prescription;
import com.hospital.dao.DoctorDao;
import com.hospital.dao.MedicineDao;
import com.hospital.dao.PrescriptionDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPrescriptionView {

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
                    RegisterPrescriptionView window = new RegisterPrescriptionView();
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
    public RegisterPrescriptionView() {
        initialize();
    }

    private final int WIDTH=800;
    private final int HEIGHT=600;
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("开具处方");
        Tools.setPos(frame, WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image\\img3.jpg"));
        lblNewLabel.setBounds(0,0,800,600);

        JLabel lblNewLabel_1 = new JLabel("开具处方");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
        lblNewLabel_1.setBounds(0,0,396,49);
        frame.getContentPane().add(lblNewLabel_1);


        JPanel panel = new JPanel();
        panel.setBounds(35, 59, 800, 600);
        frame.getContentPane().add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("处方编号：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 24, 100, 21);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(200, 23, 223, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("病人编号：");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 64, 100, 21);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 63, 223, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("开具医生编号：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 104, 150, 21);
        panel.add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(200, 103, 223, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("价 格：");
        lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(10, 150, 100, 15);
        panel.add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 143, 213, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("药品编号：");
        lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 200, 100, 15);
        panel.add(lblNewLabel_6);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 183, 213, 26);
        panel.add(textField_4);
        textField_4.setColumns(10);

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
                String preid=textField.getText();
                String prepatientid=textField_1.getText();
                String predoctorid=textField_2.getText();
                String preprice =textField_3.getText();
                String premedicine=textField_4.getText();

                if(preid.equals("")){
                    Tools.showMessage("请输入药品编号！");
                }
                else if(prepatientid.equals("")){
                    Tools.showMessage("请输入名称！");
                }
                else if(predoctorid.equals("")){
                    Tools.showMessage("请输入数量！");
                }
                else if(preprice.equals("")){
                    Tools.showMessage("请输入价格！");
                }
                else if(premedicine.equals("")){
                    Tools.showMessage("请输入药品编号！");
                }
                else{
                    int a= PrescriptionDao.registerPrescription(preid,prepatientid,predoctorid,preprice,premedicine);
                    if(a==0){
                        Tools.showMessage("处方冲突，开具失败！");
                    }
                    else{
                        if(a==1){
                            //判断药品>0，然后药品-1
//                            Doctor doc=new DoctorDao().getdoctor(id);
                            Prescription pre=new PrescriptionDao().getPrescription(preid);
                            String id=pre.getPremedicine();
                            Medicine medicine=new MedicineDao().getMedicine(id);
                            Medicine m =new MedicineDao().getMedicine(id);
                            String num=medicine.getMnum();
                            if(!num.equals("0")){
                                Tools.showMessage("开具成功！");
                                int n = Integer.parseInt(num);
                                n = n - 1;  // 执行减一操作
                                // 将结果再转换回字符串
                                String resultStr = String.valueOf(n);
                                int abo=MedicineDao.editPrescription(resultStr,id);
                            }

                            else if(num.equals("0")){
                                Tools.showMessage("该药品剩余量为0，开具失败！");
                            }

                        }
                        else{
                            Tools.showMessage("开具失败！");
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
