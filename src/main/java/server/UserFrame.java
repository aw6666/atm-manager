package server;

import entity.User;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    private final int account;
    private JButton RegisterBankCard;
    private JButton Inquire;
    private JButton SaveMoney;
    private JButton GetMoney;
    private JButton transferMoney;
    private JButton Return;
    public UserFrame(int account){
        this.account = account;
        Font font = new Font("宋体",Font.BOLD,50);
        JPanel jPanel = new JPanel();

        RegisterBankCard = new JButton("注册银行卡");
        RegisterBankCard.setFont(font);
        RegisterBankCard.setBounds(30,30,300,200);
        RegisterBankCard.setFocusPainted(false);

        Inquire = new JButton("查询信息");
        Inquire.setFont(font);
        Inquire.setBounds(30,280,300,200);
        Inquire.setFocusPainted(false);

        Return = new JButton("返回");
        Return.setFont(font);
        Return.setBounds(30,530,300,200);
        Return.setFocusPainted(false);

        SaveMoney = new JButton("存钱");
        SaveMoney.setFont(font);
        SaveMoney.setBounds(630,30,300,200);
        SaveMoney.setFocusPainted(false);

        GetMoney = new JButton("取钱");
        GetMoney.setFont(font);
        GetMoney.setBounds(630,280,300,200);
        GetMoney.setFocusPainted(false);

        transferMoney = new JButton("转账");
        transferMoney.setFont(font);
        transferMoney.setBounds(630,530,300,200);
        transferMoney.setFocusPainted(false);

        jPanel.setLayout(null);
        jPanel.add(RegisterBankCard);
        jPanel.add(Inquire);
        jPanel.add(SaveMoney);
        jPanel.add(GetMoney);
        jPanel.add(transferMoney);
        jPanel.add(Return);
        this.setResizable(false);
        this.setBounds(450,150,1000,800);
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register();
        inquire();
        save();
        get();
        transfer();
        getReturn();
    }

    public void register(){
        RegisterBankCard.addActionListener((event)->{
            new RegisterBankFrame(this.account);
            this.dispose();
        });
    }

    public void inquire(){
        Inquire.addActionListener((event)-> {
            new InquireFrame(this.account);
            this.dispose();
        });
    }

    public void save(){
        SaveMoney.addActionListener((event)->{
            new SaveFrame(this.account);
            this.dispose();
        });
    }

    public void get(){
        GetMoney.addActionListener((event)->{
            new GetFrame(this.account);
            this.dispose();
        });
    }

    public void transfer(){
        transferMoney.addActionListener((event)->{
            new TransferFrame(this.account);
            this.dispose();
        });
    }

    public void getReturn(){
        Return.addActionListener((event)->{
            this.dispose();
            new MainFrame();
        });
    }
}
