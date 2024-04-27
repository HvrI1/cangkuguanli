package com.txx.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LendAdminFrame extends JFrame{
    JPanel panel;
    JButton storage,lendInfo;
    public LendAdminFrame(){
        this.setTitle("管理员");
        this.setBounds(400,300,200,200);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        storage = new JButton("图书入库管理");
        lendInfo = new JButton("借阅信息管理");

        this.add(storage);
        this.add(lendInfo);

        MyEvent();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void MyEvent(){
        // 图书入库管理
        storage.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new TableFrame(storage.getText()).show();
            }

        });

        // 用户借阅信息管理
        lendInfo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new TableFrame(lendInfo.getText()).show();
            }

        });
    }

    public static void main(String[] args){
        new LendAdminFrame();
    }
}
