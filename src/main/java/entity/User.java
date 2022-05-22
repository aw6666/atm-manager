package entity;

public class User{
    private int Unum;
    private String Uname;
    private String CID;
    private String Tel;
    private String Addr;

    public User(String uname, String CID, String tel, String addr, String upassword) {
        Uname = uname;
        this.CID = CID;
        Tel = tel;
        Addr = addr;
        Upassword = upassword;
    }

    private String Upassword ;

    public User(Integer unum, String uname, String CID, String tel, String addr, String upassword) {
        Unum = unum;
        Uname = uname;
        this.CID = CID;
        Tel = tel;
        Addr = addr;
        Upassword = upassword;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public int getUnum() {
        return Unum;
    }

    public void setUnum(int unum) {
        Unum = unum;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "Unum=" + Unum +
                ", Uname='" + Uname + '\'' +
                ", CID='" + CID + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Addr='" + Addr + '\'' +
                '}';
    }
}