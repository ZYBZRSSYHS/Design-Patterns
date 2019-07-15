package cn.Design_Pattern;

import javax.swing.*;
import java.awt.*;

public class ProtoTypeWukong {

    public static void main(String[] args){

        JFrame jf = new JFrame("Test");
        jf.setLayout(new GridLayout(1,2));
        Container container = jf.getContentPane();

        QiTian QT1 = new QiTian();
        container.add(QT1);

        QiTian QT2 = (QiTian)QT1.clone();
        container.add(QT2);

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}

class QiTian extends JPanel implements Cloneable{
    private static final long serialVersionUID = 5543049531872119329L;

    public QiTian(){
        JLabel l1 = new JLabel(new ImageIcon("src/images/QiTian.jpg"));
        this.add(l1);
    }
    public Object clone(){
        QiTian q  = null;
        try{
            q = (QiTian)super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("error");
        }
        return q;
    }
}
