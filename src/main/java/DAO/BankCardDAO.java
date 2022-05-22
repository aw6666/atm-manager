package DAO;

import entity.BankCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BankCardDAO {
    /**
     * 显示用户卡数目，限定不能大于三张
     * @param Unum
     * @return
     */
    int getNum(@Param("Unum") int Unum);

    /**
     *
     * @param Unum
     * @return
     */
    String getCardID(@Param("Unum") int Unum);
    /**
     * 显示信息
     * @param CardID
     * @return
     */
    public BankCard showInfo(@Param("CardID") String CardID);

    /**
     * 开卡
     * @param Unum
     * @param pw
     * @param money
     * @return
     */
    public String createCard(@Param("Unum") int Unum,@Param("pw")String pw,@Param("money") int money);

    /**
     * 存钱
     * @param CardID
     * @param money
     */
    public void saveMoney(@Param("CardID")String CardID,@Param("money")int money);

    /**
     * 取钱
     * @param CardID
     * @param money
     * @return
     */
    public int getMoney(@Param("CardID")String CardID,@Param("money")int money);

    /**
     * 转账
     * @param CardIDOne
     * @param CardIDTwo
     * @param money
     * @return
     */
    public int transfer(@Param("CardIDOne")String CardIDOne,@Param("CardIDTwo") String CardIDTwo,@Param("money") int money);
}


