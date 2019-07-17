package cn.DesignPatternBuilder;

import javax.swing.*;
import java.awt.*;

public class ParlourDecorator {
    public static void main(String[] args){
        try{
            Decorator d;
            d = (Decorator)ReadXML.getObject();
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Parlour{ //客厅
    private String wall;
    private String TV;
    private String sofa;

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show(){
        JFrame jf = new JFrame("Builder mode test");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = wall+TV+sofa;

        JLabel l = new JLabel(new ImageIcon("src/images"+parlour+".jpg"));

        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l);
        contentPane.add(sp,BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

abstract class Decorator{     //抽象Builder
    protected Parlour product = new Parlour();
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();

    public Parlour getResult(){
        return product;
    }
}

class ConcreteDecorator1 extends Decorator{//实现抽象接口
    @Override
    public void buildSofa() {
        product.setSofa("sf1");
    }

    @Override
    public void buildTV() {
        product.setTV("TV1");
    }

    @Override
    public void buildWall() {
        product.setWall("w1");
    }
}

class ConcreteDecorator2 extends Decorator{//实现抽象接口
    @Override
    public void buildSofa() {
        product.setSofa("sf2");
    }

    @Override
    public void buildTV() {
        product.setTV("TV2");
    }

    @Override
    public void buildWall() {
        product.setWall("w2");
    }
}

class ProjectManager{
    private Decorator builder;
    public ProjectManager(Decorator builder){
        this.builder = builder;
    }
    public Parlour decorate(){
        builder.buildSofa();
        builder.buildTV();
        builder.buildWall();
        return builder.getResult();
    }
}