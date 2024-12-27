package com.txx.frame;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserLoginFrame extends JFrame{
    JLabel label,name,pass,identify;
    JButton login,register,modify;
    JTextField adminName;
    JPasswordField password;
    JPanel panel,jp1,jp2;

    JPanel[] panelLeft,panelRight;

    JComboBox personType;

    public UserLoginFrame(){
        this.setBounds(400, 200, 300, 200);
        this.setTitle("登录系统");
        this.setLayout(new BorderLayout());

        label = new JLabel("登录",SwingConstants.CENTER);
        label.setFont(new Font("楷体",Font.BOLD,30));

        name = new JLabel("账 号");
        pass = new JLabel("密 码");

        adminName = new JTextField(12);
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

        register = new JButton("注册");
        login = new JButton("登录");
        modify = new JButton("修改密码");
        jp2.add(register);
        jp2.add(login);
        jp2.add(modify);
        panel.add(jp2,BorderLayout.SOUTH);

        this.add(label,BorderLayout.NORTH);
        this.add(panel);

        MyEvent();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void MyEvent(){
        // 注册事件处理
        register.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new RegisterFrame().show();
            }

        });

        // 登录事件处理
        login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                Connection conn;
                PreparedStatement preparedStatement;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstorage?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","123456");
//					if(!conn.isClosed())
//						System.out.println("成功打开数据库");

                    String sql = "select password from password where username='" + adminName.getText() + "'";
                    preparedStatement = conn.prepareStatement(sql);

                    ResultSet result = preparedStatement.executeQuery();

//					if(result.next())
//						System.out.println(result.getString("word"));

                    String str1 = password.getText();

                    if(result.next()){
                        String str2 = result.getString("password");
                        if(str1.equals(str2))
                            new UserInfoFrame(adminName).show();
                        else{
                            String info = "你输入的密码不正确，原因可能是：\n" +  "1、忘记密码；\n" + "2、未开启小键盘；\n" + "3、大小写未区分。";
                            JOptionPane.showMessageDialog(null, info,"系统信息",JOptionPane.INFORMATION_MESSAGE);
//							new LoginErrorFrame().show();
                        }
                    }else
                        JOptionPane.showMessageDialog(null, "用户不存在，请先注册！！！","系统信息",JOptionPane.WARNING_MESSAGE);
//						new NoExist().show();


                    preparedStatement.close();
                    conn.close();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("未成功加载驱动");
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("未成功打开数据库");
                    e1.printStackTrace();
                }
                UserLoginFrame.this.dispose();
            }

        });

        // 修改密码
        modify.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

            }

        });
    }
    //
    public static void main(String[] args){
        new UserLoginFrame();
    }
}