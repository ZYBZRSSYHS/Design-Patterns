package cn.DesignPatternDecorator;

import javax.swing.*;
import java.awt.*;

public class MorriganAensland {
    public static void main(String[] args){
        Morrigan m0 = new original();
        m0.display();
        Morrigan m1 = new Succubus(m0);
        m1.display();
        Morrigan m2 = new Girl(m0);
        m2.display();
    }
}

interface Morrigan{ //本体
    public void display();
}

class original extends JFrame implements Morrigan{
    private static final long serialVersionUID  =1L;
    private String t = "Morrigan0.jpg";
    public original(){
        super("Mollyka Anslan");
    }
    public void setImage(String t){
        this.t = t;
    }
    public void display(){
        this.setLayout(new FlowLayout());
        JLabel l1 = new JLabel(new ImageIcon("src/images/"+t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Changer implements Morrigan{  //装饰中间件
    Morrigan m;
    Changer(Morrigan m){
        this.m = m;
    }
    public void display(){
        m.display();
    }
}


class Succubus extends Changer{  //变身
    public Succubus(Morrigan m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((original)super.m).setImage("Morrigan1.jpg");
    }
}


class Girl extends Changer{  //变身
    public Girl(Morrigan m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((original)super.m).setImage("Morrigan2.jpg");
    }
}