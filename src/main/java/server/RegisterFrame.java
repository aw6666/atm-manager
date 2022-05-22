package server;

import DAO.UserDAO;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private final JButton register;
    private final JButton Return;
    private final JTextField name;
    private final JTextField CID;
    private final JTextField Tel;
    private final JTextArea Addr;
    private final JTextField PW;
    public RegisterFrame(){
        JPanel jPanel = new JPanel();
        Font font = new Font("宋体",Font.BOLD,50);

        JLabel jLabelName = new JLabel("姓名");
        jLabelName.setFont(font);
        jLabelName.setBounds(50,30,150,60);
        name = new JTextField();
        name.setFont(font);
        name.setBounds(280,30,500,60);

        JLabel jLabelCID = new JLabel("身份证");
        jLabelCID.setFont(font);
        jLabelCID.setBounds(50,120,180,60);
        CID = new JTextField();
        CID.setFont(font);
        CID.setBounds(280,120,500,60);


        JLabel jLabelTel = new JLabel("电话号码");
        jLabelTel.setFont(font);
        jLabelTel.setBounds(50,210,220,60);
        Tel = new JTextField();
        Tel.setFont(font);
        Tel.setBounds(280,210,500,60);

        JLabel jLabelAddr = new JLabel("地址");
        jLabelAddr.setFont(font);
        jLabelAddr.setBounds(50,300,150,60);
        Addr = new JTextArea();
        Addr.setFont(font);
        Addr.setBounds(280,300,500,100);
        Addr.setLineWrap(true);
        Addr.setWrapStyleWord(true);


        JLabel jLabelPW = new JLabel("密码");
        jLabelPW.setFont(font);
        jLabelPW.setBounds(50,420,150,60);
        PW = new JTextField();
        PW.setFont(font);
        PW.setBounds(280,420,500,60);

        register = new JButton("注册");
        register.setFont(font);
        register.setBounds(80,530,200,150);
        register.setFocusPainted(false);

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

        jPanel.add(name);
        jPanel.add(CID);
        jPanel.add(Tel);
        jPanel.add(Addr);
        jPanel.add(PW);

        jPanel.add(register);
        jPanel.add(Return);
        this.setResizable(false);
        this.setBounds(600,150,850,800);
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setRegister();
        setReturn();
    }
    private void setRegister(){
        register.addActionListener((event)->{
            try(SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()){
                UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
               if(name.getText().length()!=0&&CID.getText().length()==18&&Tel.getText().length()==11&&PW.getText().length()!=0){
                   System.out.println(123);
                    userDAO.addUser(new User(name.getText(),CID.getText(),Tel.getText(),Addr.getText(),PW.getText()));
                    sqlSession.commit();
                    JOptionPane jOptionPane = new JOptionPane();
                    jOptionPane.setPreferredSize(null);
                    JOptionPane.showMessageDialog(null,"您的账号是"+userDAO.getUserByCID(CID.getText()).getUnum());
                    this.dispose();
                    new MainFrame();
                }
            }
        });
    }
    private void setReturn(){
        Return.addActionListener((event)->{
            new MainFrame();
            this.dispose();
        });
    }

    public static void main(String[] args) {
        new RegisterFrame();
    }
}
