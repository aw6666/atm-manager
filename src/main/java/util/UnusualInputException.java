package util;

import javax.swing.*;

public class UnusualInputException extends Exception{
    public UnusualInputException(){
        super();
    }
    @Override
    public void printStackTrace() {
        JOptionPane.showConfirmDialog(null,"不正常输入");
    }
}
