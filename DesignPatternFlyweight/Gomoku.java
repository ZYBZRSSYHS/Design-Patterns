package cn.DesignPatternFlyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Gomoku{
    public static void main(String[] args){
        new Chessboard();
    }
}
interface ChessPieces{      //棋子
    public void DownPieces(Graphics g,Point pt);
}

class WhitePieces implements ChessPieces{   //白子
    public void DownPieces(Graphics g,Point pt){
        g.setColor(Color.WHITE);
        g.fillOval(pt.x,pt.y,30,30);
    }
}

class BlackPieces implements ChessPieces{   //黑子
    public void DownPieces(Graphics g,Point pt){
        g.setColor(Color.BLACK);
        g.fillOval(pt.x,pt.y,30,30);
    }
}

class WeiqiFactory{  //享元
    private ArrayList<ChessPieces> qz;
    public WeiqiFactory(){
        qz = new ArrayList<ChessPieces>();
        ChessPieces w = new WhitePieces();
        qz.add(w);
        ChessPieces b = new BlackPieces();
        qz.add(b);
    }
    public ChessPieces getChessPieces(String type){
        if(type.equalsIgnoreCase("w")){
            return (ChessPieces)qz.get(0);
        }else if(type.equalsIgnoreCase("b")){
            return (ChessPieces)qz.get(1);
        }else{
            return null;
        }
    }
}

class Chessboard extends MouseAdapter {  //画图

    WeiqiFactory wf;
    JFrame f;
    Graphics g;
    JRadioButton wz;
    JRadioButton bz;
    private final int x=50;
    private final int y=50;
    private final int w=40;    //小方格宽度和高度
    private final int rw=400;    //棋盘宽度和高度
    Chessboard()
    {
        wf=new WeiqiFactory();
        f=new JFrame("Flyweight application");
        f.setBounds(100,100,500,550);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel SouthJP=new JPanel();
        f.add("South",SouthJP);
        wz=new JRadioButton("白子");
        bz=new JRadioButton("黑子",true);
        ButtonGroup group=new ButtonGroup();
        group.add(wz);
        group.add(bz);
        SouthJP.add(wz);
        SouthJP.add(bz);
        JPanel CenterJP=new JPanel();
        CenterJP.setLayout(null);
        CenterJP.setSize(500, 500);
        CenterJP.addMouseListener(this);
        f.add("Center",CenterJP);
        f.setVisible(true);
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        g=CenterJP.getGraphics();
        g.setColor(Color.BLUE);
        g.drawRect(x, y, rw, rw);
        for(int i=1;i<10;i++)
        {
            g.drawLine(x+(i*w),y,x+(i*w),y+rw);//绘制第i条竖直线
            g.drawLine(x,y+(i*w),x+rw,y+(i*w));//绘制第i条水平线
        }
    }


    public void mouseClicked(MouseEvent e){ //鼠标点击响应
        Point pt = new Point(e.getX()-15,e.getY()-15);
        if(wz.isSelected()){
            ChessPieces c1 =wf.getChessPieces("w");
            c1.DownPieces(g,pt);
        }else if(bz.isSelected()){
            ChessPieces c2 = wf.getChessPieces("b");
            c2.DownPieces(g,pt);
        }
    }
}