package entity;

import java.util.Date;

public class BankCard {
    private int Unum;
    private String CardID;
    private String Pw;
    private int BeginMoney;
    private Date BeginDate;
    private String AccountType;
    private int Money;
    private String IsLosed;
    public BankCard(int unum, String cardID, String pw, int beginMoney, Date beginDate, String accountType, int money, String isLosed) {
        Unum = unum;
        CardID = cardID;
        Pw = pw;
        BeginMoney = beginMoney;
        BeginDate = beginDate;
        AccountType = accountType;
        Money = money;
        IsLosed = isLosed;
    }

    public int getUnum() {
        return Unum;
    }

    public void setUnum(int unum) {
        Unum = unum;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public String getPw() {
        return Pw;
    }

    public void setPw(String pw) {
        Pw = pw;
    }

    public int getBeginMoney() {
        return BeginMoney;
    }

    public void setBeginMoney(int beginMoney) {
        BeginMoney = beginMoney;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date beginDate) {
        BeginDate = beginDate;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public String getIsLosed() {
        return IsLosed;
    }

    public void setIsLosed(String isLosed) {
        IsLosed = isLosed;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "Unum=" + Unum +
                ", CardID='" + CardID + '\'' +
                ", Pw='" + Pw + '\'' +
                ", BeginMoney=" + BeginMoney +
                ", BeginDate=" + BeginDate +
                ", AccountType='" + AccountType + '\'' +
                ", Money=" + Money +
                ", IsLosed='" + IsLosed + '\'' +
                '}';
    }
}
