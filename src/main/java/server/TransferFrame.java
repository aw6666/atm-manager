package server;

import DAO.BankCardDAO;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import javax.swing.*;
import java.awt.*;

public class TransferFrame extends JFrame {
    private final int account;
    private final JButton register;
    private final JButton Return;
    private final JTextField money;
    private final JTextField PW;
    private final JTextField BankID;
    private final JPasswordField BankIDT;
    public TransferFrame(int account){
        this.account = account;
        JPanel jPanel = new JPanel();
        Font font = new Font("宋体",Font.BOLD,50);

        register = new JButton("取钱");
        register.setFont(font);
        register.setBounds(50,450,200,150);
        register.setFocusPainted(false);

        Return = new JButton("返回");
        Return.setFont(font);
        Return.setBounds(430,450,200,150);
        Return.setFocusPainted(false);

        JLabel jLabelMoney = new JLabel("取款卡号");
        jLabelMoney.setFont(font);
        jLabelMoney.setBounds(50,50,250,50);

        money = new JTextField();
        money.setFont(font);
        money.setBounds(320,50,600,50);

        JLabel jLabelPW = new JLabel("存款卡号");
        jLabelPW.setFont(font);
        jLabelPW.setBounds(50,150,250,50);

        PW = new JTextField();
        PW.setFont(font);
        PW.setBounds(320,150,600,50);

        JLabel Bank = new JLabel("转账金额");
        Bank.setFont(font);
        Bank.setBounds(50,250,250,50);
        BankID = new JTextField();
        BankID.setFont(font);
        BankID.setBounds(320,250,300,50);

        JLabel jLabel = new JLabel("密码");
        jLabel.setFont(font);
        jLabel.setBounds(50,350,250,50);
        BankIDT = new JPasswordField();
        BankIDT.setFont(font);
        BankIDT.setBounds(320,350,300,50);

        jPanel.setLayout(null);
        jPanel.add(register);
        jPanel.add(Return);
        jPanel.add(jLabelMoney);
        jPanel.add(jLabelPW);
        jPanel.add(Bank);
        jPanel.add(money);
        jPanel.add(PW);
        jPanel.add(BankID);
        jPanel.add(jLabel);
        jPanel.add(BankIDT);

        this.setResizable(false);
        this.setBounds(600,300,1000,700);
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
                if(money.getText().length()==23) {
                    if (bankCardDAO.showInfo(money.getText()).getPw().equals(String.valueOf(BankIDT.getPassword()))) {
                        if(bankCardDAO.transfer(money.getText(),PW.getText(),Integer.parseInt(BankID.getText()))==1){
                            sqlSession.commit();
                            JOptionPane.showMessageDialog(null, "转账成功");
                            this.dispose();
                            new UserFrame(account);
                        }else{
                            JOptionPane.showMessageDialog(null, "金额不足");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "密码错误");
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

    public static void main(String[] args) {
        new TransferFrame(132);
    }
}
