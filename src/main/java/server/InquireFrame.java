package server;

import DAO.BankCardDAO;
import DAO.UserDAO;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import javax.swing.*;
import java.awt.*;

public class InquireFrame extends JFrame {
    private int account;
    private JButton Return;
    public InquireFrame(int account){
        this.account = account;
        Font font = new Font("宋体",Font.BOLD,50);
        JPanel jPanel = new JPanel();
        try(SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()){
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            BankCardDAO bankCardDAO =sqlSession.getMapper(BankCardDAO.class);
            User user = userDAO.getUserByUnum(account);
            int cardNum = bankCardDAO.getNum(account);

            JLabel jLabelName = new JLabel("姓名");
            jLabelName.setFont(font);
            jLabelName.setBounds(50,30,150,60);
            JLabel jLabelGetName = new JLabel(user.getUname());
            jLabelGetName.setFont(font);
            jLabelGetName.setBounds(280,30,220,60);

            JLabel jLabelCID = new JLabel("账号");
            jLabelCID.setFont(font);
            jLabelCID.setBounds(50,120,180,60);
            JLabel jLabelGetCID = new JLabel(String.valueOf(account));
            jLabelGetCID.setBounds(280,120,500,60);
            jLabelGetCID.setFont(font);

            JLabel jLabelTel = new JLabel("电话号码");
            jLabelTel.setFont(font);
            jLabelTel.setBounds(50,210,220,60);
            JLabel jLabelGetTel = new JLabel(user.getTel());
            jLabelGetTel.setBounds(280,210,500,60);
            jLabelGetTel.setFont(font);

            JLabel jLabelAddr = new JLabel("地址");
            jLabelAddr.setFont(font);
            jLabelAddr.setBounds(50,300,150,60);
            JLabel Addr = new JLabel("<html><body><p align=\"center\">"+user.getAddr()+"</p></body></html>");
            Addr.setFont(font);
            Addr.setBounds(280,300,500,120);



            JLabel jLabelPW = new JLabel("拥有卡数目");
            jLabelPW.setFont(font);
            jLabelPW.setBounds(50,420,350,60);
            JLabel PW = new JLabel(String.valueOf(cardNum));
            PW.setFont(font);
            PW.setBounds(450,420,500,60);


            Return = new JButton("返回");
            Return.setFont(font);
            Return.setBounds(550,530,200,150);
            Return.setFocusPainted(false);

            jPanel.setLayout(null);
            jPanel.add(jLabelName);
            jPanel.add(jLabelCID);
            jPanel.add(jLabelTel);
            jPanel.add(jLabelAddr);
            jPanel.add(jLabelPW);

            jPanel.add(jLabelGetName);
            jPanel.add(jLabelGetCID);
            jPanel.add(jLabelAddr);
            jPanel.add(jLabelGetTel);
            jPanel.add(Addr);
            jPanel.add(PW);

            jPanel.add(Return);
            this.setResizable(false);
            this.setBounds(600,150,850,800);
            this.add(jPanel);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        this.setResizable(false);
        this.setBounds(600,150,850,800);
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setReturn();
    }
    public void setReturn(){
        Return.addActionListener((event)->{
            new UserFrame(account);
            this.dispose();
        });
    }


}
