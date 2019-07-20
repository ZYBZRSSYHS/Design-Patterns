package cn.DesignPatternFlyweight;

import java.util.HashMap;

public class FlyweightPattern {
    public static void main(String[] args){
        FlyweightFactory factory=new FlyweightFactory();
        Flyweight f1 = factory.getFlyweight("a");
        Flyweight f2 = factory.getFlyweight("a");
        Flyweight f3 = factory.getFlyweight("a");
        Flyweight f4 = factory.getFlyweight("b");
        Flyweight f5 = factory.getFlyweight("b");
        f1.operation(new UnsharedConcreteFlyweight("the first time a"));
        f2.operation(new UnsharedConcreteFlyweight("the second time a"));
        f3.operation(new UnsharedConcreteFlyweight("the third time a"));
        f4.operation(new UnsharedConcreteFlyweight("the first time b"));
        f5.operation(new UnsharedConcreteFlyweight("the second time b"));
    }
}

class UnsharedConcreteFlyweight{  //UnFlyweight角色
    private String info;

    UnsharedConcreteFlyweight(String info){
        this.info = info;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }
}

interface Flyweight{            //抽象Flyweight
    public void operation(UnsharedConcreteFlyweight state);
}

class ConcreteFlyweight implements Flyweight{  //具体的Flyweight角色
    private String key;

    ConcreteFlyweight(String key){
        this.key = key;
        System.out.println("Flyweight "+key+" Built");
    }

    public void operation(UnsharedConcreteFlyweight outstate){
        System.out.println("===================================");
        System.out.println("Flyweight"+key+"Called");
        System.out.println("-----------------------------------");
        System.out.println("UnFlyweight is "+outstate.getInfo());
        System.out.println("===================================");
    }
}

class FlyweightFactory{
    private HashMap<String,Flyweight> flyweights=new HashMap<String,Flyweight>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight=(Flyweight)flyweights.get(key);
        if(flyweight !=null){
            System.out.println("Flyweight"+key+"already exists , Getting....");
        }else{
            flyweight=new ConcreteFlyweight(key);
            flyweights.put(key,flyweight);
        }
        return flyweight;
    }
}