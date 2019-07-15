package cn.Design_Pattern;


import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class ProtoTypeShape {
    public static void main(String[] args){
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape sp = (Circle)pm.getShape("Circle");
        sp.countArea();
        Shape sp0 = (Square)pm.getShape("Square");
        sp0.countArea();
    }
}

interface Shape extends Cloneable{
    public Object clone();   //copy
    public void countArea(); //Calculated area
}


class Circle implements Shape{  //计算圆面积
    public Object clone(){
        Circle area = null;
        try {
            area = (Circle) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("error");
        }
        return area;
    }
    public void countArea(){
        int r=0;
        System.out.print("Please input the radius of the circle:");
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        System.out.println("The area of the circle is:"+3.1415926*r*r+"\n");
    }
}
class Square implements Shape{  //计算正方形面积
    public Object clone(){
        Square area = null;
        try {
            area = (Square) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("error");
        }
        return area;
    }
    public void countArea(){
        int a=0;
        System.out.print("Please input the Square side length:");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        System.out.println("The area of the Square is:"+a*a+"\n");
    }
}

class ProtoTypeManager{     //中间代理
    private HashMap<String,Shape> ht=new HashMap<String,Shape>();

    public ProtoTypeManager(){  //存放不同的计算方法
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
        //..........
    }

    public void addshape(String key,Shape sp){
        ht.put(key,sp);
    }

    public Shape getShape(String key){
        Shape temp = ht.get(key);
        return (Shape)temp.clone();
    }
}
