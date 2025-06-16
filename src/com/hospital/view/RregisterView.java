package com.hospital.view;

import com.hospital.dao.AdminDao;
import com.hospital.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RregisterView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JPasswordField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RregisterView window = new RregisterView();
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
	public RregisterView() {
		initialize();
	}

	private final int WIDTH=410;
	private final int HEIGHT=345;
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
		lblNewLabel.setBounds(0,0,396,308);
		
		JLabel lblNewLabel_1 = new JLabel("管理员注册");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
		lblNewLabel_1.setBounds(0,0,396,49);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 59, 327, 229);
		frame.getContentPane().add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("姓 名：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(10, 24, 69, 21);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(81, 23, 223, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("账 号：");
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 64, 69, 21);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 63, 223, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("密 码：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 104, 69, 21);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(81, 103, 223, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("确认密码：");
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 150, 88, 15);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(91, 143, 213, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton.setBounds(50, 190, 100, 25);
		panel.add(btnNewButton);

		JButton rtNewButton = new JButton("返回");
		rtNewButton.setFont(new Font("楷体", Font.BOLD, 20));
		rtNewButton.setBounds(170, 190, 100, 25);
		panel.add(rtNewButton);

		frame.getContentPane().add(lblNewLabel);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//注册点击时间
				String name=textField.getText();
				String account=textField_1.getText();
				String password=new String(textField_2.getPassword());
				String password1=new String(textField_3.getPassword());

				if(name.equals("")){
					Tools.showMessage("请输入姓名！");
				}
				else if(account.equals("")){
					Tools.showMessage("请输入账号！");
				}
				else if(password.equals("")){
					Tools.showMessage("请输入密码！");
				}
				else if(password1.equals("")){
					Tools.showMessage("请输入确认密码！");
				}
				else if(!password.equals(password1)){
					Tools.showMessage("两次密码不一致！");
				}
				else{
					int a=AdminDao.register(account,password,name);
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
				ManageView manageView = new ManageView();
				manageView.frame.setVisible(true);
			}
		});
	}
}
