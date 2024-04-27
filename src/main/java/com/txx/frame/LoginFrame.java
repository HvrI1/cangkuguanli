package com.txx.frame;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// 管理员登录模块
public class LoginFrame extends JFrame{
    JLabel label,name,pass;
    JButton login;
    JTextField adminName;
    JPasswordField password;
    JPanel panel,jp1,jp2;

    public LoginFrame(){
        this.setBounds(400, 200, 300, 200);
        this.setTitle("图书馆管理系统登录");
        this.setLayout(new BorderLayout());

        label = new JLabel("登录",SwingConstants.CENTER);
        label.setFont(new Font("楷体",Font.BOLD,30));

        name = new JLabel("账 号");
        pass = new JLabel("密 码");

        adminName = new JTextField(12);
        adminName.setText("admin");
        adminName.setHorizontalAlignment(SwingConstants.CENTER);
        password = new JPasswordField(12);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setEchoChar('*');		//设置回显字符

        panel = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        panel.setLayout(new BorderLayout());

        jp1.add(adminName);
        jp1.add(name);
        jp1.add(password);
        jp1.add(pass);

        panel.add(jp1);

        login = new JButton("登录");
        jp2.add(login);
        panel.add(jp2,BorderLayout.SOUTH);

        this.add(label,BorderLayout.NORTH);
        this.add(panel);

        MyEvent();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void MyEvent(){
        login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String word = "123456";	// 正确密码
                String str = new String(password.getPassword());

                if(str.equals(word))
                    new LendAdminFrame().show();
//					new TableFrame().show();
//					new RuKuFrame();
                else{
                    String str1 = "你输入的密码不正确，原因可能是：\n" +  "1、忘记密码；\n" + "2、未开启小键盘；\n" + "3、大小写未区分。";
                    JOptionPane.showMessageDialog(null, str1);
//					new LoginErrorFrame().show();

                }
                LoginFrame.this.dispose();
            }

        });
    }

    public static void main(String[] args){
        new LoginFrame();
    }
}