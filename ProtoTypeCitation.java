package cn.Design_Pattern;


public class ProtoTypeCitation {
    public static void main(String[] args)throws CloneNotSupportedException{
        citation ct1 = new citation("ZZ","Student was rated as a good student","szpt");
        ct1.display();
        citation ct2 = (citation)ct1.clone();
        ct2.setName("QQ");
        ct2.display();
    }
}


class citation implements Cloneable{ //创建奖状类
    String name;
    String info;
    String college;
    citation(String name,String info,String college){
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功！");
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
    void display(){
        System.out.println(name+info+college);
    }
    public Object clone() throws CloneNotSupportedException{
        System.out.println("奖状Copy成功！");
        return (citation)super.clone();
    }
}