package cn.DesignPatternBridge;

import javax.swing.*;
import java.awt.*;

public class BagManage {
    public static void main(String[] args){
        Color color;
        Bag bag;
        color =(Color) ReadXML.getObject("color") ;
        bag = (Bag)ReadXML.getObject("bag");
        bag.setColor(color);
        String name = bag.getName();
        show(name);
    }
    public static void show(String name){
        JFrame jf = new JFrame("Bridge");
        Container contentPane = jf.getContentPane();
        JPanel jp = new JPanel();
        JLabel jl = new JLabel(new ImageIcon("src/images/"+name+".jpg"));
        jp.setLayout(new GridLayout(1,1));
        jp.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        jp.add(jl);
        contentPane.add(jp,BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


interface Color{
    String getColor();
}

class Yellow implements Color{
    public String getColor(){
        return "yellow";
    }
}

class Red implements Color{
    public String getColor(){
        return "red";
    }
}

abstract class Bag{

    protected Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public abstract String getName();
}

class HandBag extends Bag{
    public String getName(){
        return color.getColor()+"HandBag";
    }
}

class Wallet extends Bag{
    public String getName(){
        return color.getColor()+"Wallet";
    }
}