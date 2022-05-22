package server;

import DAO.BankCardDAO;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import javax.swing.*;
import java.awt.*;

public class RegisterBankFrame extends JFrame {
    private final int account;
    private final JButton register;
    private final JButton Return;
    private final JTextField money;
    private final JTextField PW;
    public RegisterBankFrame(int account){
        this.account = account;
        JPanel jPanel = new JPanel();
        Font font = new Font("宋体",Font.BOLD,50);

        register = new JButton("开户");
        register.setFont(font);
        register.setBounds(50,250,200,150);
        register.setFocusPainted(false);

        Return = new JButton("返回");
        Return.setFont(font);
        Return.setBounds(430,250,200,150);
        Return.setFocusPainted(false);

        JLabel jLabelMoney = new JLabel("开户金额");
        jLabelMoney.setFont(font);
        jLabelMoney.setBounds(50,50,250,50);

        money = new JTextField();
        money.setFont(font);
        money.setBounds(320,50,300,50);

        JLabel jLabelPW = new JLabel("密码");
        jLabelPW.setFont(font);
        jLabelPW.setBounds(50,150,150,50);

        PW = new JTextField();
        PW.setFont(font);
        PW.setBounds(320,150,300,50);

        jPanel.setLayout(null);
        jPanel.add(register);
        jPanel.add(Return);
        jPanel.add(jLabelMoney);
        jPanel.add(jLabelPW);
        jPanel.add(money);
        jPanel.add(PW);

        this.setResizable(false);
        this.setBounds(600,300,700,500);
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setRegister();
        setReturn();
    }

    public void setRegister(){
        register.addActionListener((event)->{
            try(SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()){
                BankCardDAO bankCardDAO = sqlSession.getMapper(BankCardDAO.class);
                if(PW.getText().length()==6) {
                    if(bankCardDAO.getNum(account)<3) {
                        sqlSession.commit();
                        JOptionPane.showMessageDialog(null, bankCardDAO.createCard(account, PW.getText(), Integer.parseInt(money.getText())));
                        this.dispose();
                        new UserFrame(account);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "开卡已达到上限3张");
                    }
                }
            }
        });
    }

    public void setReturn(){
        Return.addActionListener((event)->{
            this.dispose();
            new UserFrame(account);
        });
    }

}
