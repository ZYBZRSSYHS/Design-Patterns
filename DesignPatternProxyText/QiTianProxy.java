package cn.DesignPatternProxyText;

import javax.swing.*;
import java.awt.*;

public class QiTianProxy {
    public static void main(String[] args){
        SgProxy sgProxy = new SgProxy();
        sgProxy.display();
    }
}

interface Specialty{  //抽象
    void display();
}

class QiTian extends JFrame implements Specialty{//实现
    private static final long serialVersionUID = 1L;

    public QiTian(){
        super("QiTian");
        this.setLayout(new GridLayout(1,1));
        JLabel QT = new JLabel(new ImageIcon("src/images/QiTian.jpg"));
        this.add(QT);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void display(){
        this.setVisible(true);
    }
}

class SgProxy implements Specialty{
    private QiTian realSubject = new QiTian();

    public void display(){
        preRequest();
        realSubject.display();
        postRequest();
    }

    public void preRequest(){
        System.out.println("START");
    }

    public void postRequest(){
        System.out.println("END");
    }
}
