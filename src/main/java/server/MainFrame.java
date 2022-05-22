package server;

import DAO.UserDAO;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JButton jButtonLogin;
    private final JButton jButtonRegister;
    private final JTextField jTextFieldAccount;
    private final JPasswordField jTextFieldPassword;


    public MainFrame(){
        Font font = new Font("仿宋", Font.BOLD + Font.ITALIC, 30);
        JPanel jPanel = new JPanel();


        jButtonLogin = new JButton("登录");
        jButtonLogin.setBounds(110,250,100,50);
        jButtonLogin.setFont(font);
        jButtonLogin.setFocusPainted(false);

        jButtonRegister = new JButton("注册");
        jButtonRegister.setBounds(260,250,100,50);
        jButtonRegister.setFont(font);
        jButtonRegister.setFocusPainted(false);

        JLabel jLabelAccount = new JLabel("账号");
        jLabelAccount.setBounds(50,70,100,50);
        jLabelAccount.setFont(font);

        JLabel jLabelPassword = new JLabel("密码");
        jLabelPassword.setBounds(50,150,100,50);
        jLabelPassword.setFont(font);

        jTextFieldAccount = new JTextField();
        jTextFieldAccount.setBounds(150,70,250,50);
        jTextFieldAccount.setFont(new Font("宋体",Font.BOLD,30));

        jTextFieldPassword = new JPasswordField();
        jTextFieldPassword.setBounds(150,150,250,50);
        jTextFieldPassword.setFont(new Font("宋体",Font.BOLD,30));

        jPanel.setLayout(null);
        jPanel.add(jTextFieldPassword);
        jPanel.add(jTextFieldAccount);
        jPanel.add(jLabelPassword);
        jPanel.add(jLabelAccount);
        jPanel.add(jButtonLogin);
        jPanel.add(jButtonRegister);
        this.setResizable(false);
        this.setBounds(800,350,500,400);
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verify();
        register();
    }

    /**
     * 给登录按钮增加监听事件
     */
    public void verify(){
        jButtonLogin.addActionListener((event) -> {
            try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
                UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
                String password;
                int accountInt;
                if(jTextFieldAccount.getText().length()!=0&&jTextFieldPassword.getPassword().length!=0) {
                    String account = jTextFieldAccount.getText();
                    password = new String(jTextFieldPassword.getPassword());
                    accountInt = Integer.parseInt(account);
                    if (userDAO.login(accountInt, password)==null||userDAO.login(accountInt,password)==0) {
                        JOptionPane.showMessageDialog(null, "输入有误");
                    } else {
                        this.dispose();
                        new UserFrame(accountInt);
                    }
                }
            }
        });
    }

    /**
     * 给注册按钮增加监听事件
     */
    public void register(){
        jButtonRegister.addActionListener((event)->{
            new RegisterFrame();
            this.dispose();
        });
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
