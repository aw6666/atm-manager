package DAO;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    /**
     * 查找
     */
    public List getAll(); //输出整张表
    public User getUserByUnum(int Unum); //按照用户编号查找
    public User getUserByCID(String CID); //按照用户身份证查找
    public List<User> getUserByAddr(String Addr); //按照地址得到用户集合
    public int getAllCount();//得到所有顾客数目
    /**
     * 增加
     */
    public void addUser(User user); //新增顾客

    /**
     * 修改
     * @param newUser
     */
    public void updateUser(User newUser);//修改顾客信息
    public void updatePw(@Param("Unum") int Unum,@Param("Upassword") String Upassword);//修改密码

    /**
     * 登录
     * @param Unum
     * @param Upassword
     * @return
     */
    public Integer login(@Param("Unum") int Unum,@Param("Upassword")String Upassword);//通过用户号和密码登录
}
