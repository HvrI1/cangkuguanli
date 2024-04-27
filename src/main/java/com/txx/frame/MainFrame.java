package com.txx.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{
    JLabel label1,label2,info;
    JPanel jpanel,jp1,jp2,jp3;
    JTextField text;
    JButton button,admin,stu;

    JButton lend;
    DefaultTableModel tableModel;

    public MainFrame(){
        this.setLayout(new BorderLayout());
        this.setBounds(400, 200, 600, 450);
        this.setTitle("图书查询");

        //窗体最上面的部分
        label1 = new JLabel("图书查询",SwingConstants.CENTER);
        label1.setFont(new Font("楷体",Font.BOLD,40));		//设置字体和大小

        //窗体中间的部分
        label2 = new JLabel("书名:");

        text = new JTextField(15);
        button = new JButton("查询");

        jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        jp1 = new JPanel();
        jp2 = new JPanel();		//窗体最下面的部分（及显示查询内容的地方）
//		jp2.setBackground(Color.BLUE);

        stu = new JButton("用户登录");
        admin = new JButton("管理员");

//		//测试
//		lend = new JButton("确认借阅");


        jp1.add(label2);
        jp1.add(text);
        jp1.add(button);
//		jp1.add(lend);

        jp3 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp3.add(stu);
        jp3.add(admin);
        jp2.add(jp3,BorderLayout.SOUTH);



//		jp2.add(info,BorderLayout.SOUTH);

        jpanel.add(jp1,BorderLayout.NORTH);
        jpanel.add(jp2);



        this.add(label1,BorderLayout.NORTH);
        this.add(jpanel);

        MyEvent();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void MyEvent(){
        // 查询按钮事件
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new FindBook().findInfo(jp2,text);
            }

        });

        // 管理员按钮事件
        admin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new LoginFrame().show();
            }

        });

        //用户按钮事件
        stu.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new UserLoginFrame().show();
            }

        });
    }

    public static void main(String[] args){
        new MainFrame();
    }
}