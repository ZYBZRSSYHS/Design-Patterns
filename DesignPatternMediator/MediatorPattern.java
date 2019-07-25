package cn.DesignPatternMediator;

import java.util.*;


public class MediatorPattern {
    public static void main(String[] args){
        Mediator md = new ConcreteMediator();
        Colleague c1,c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("=========================");
        c2.send();
    }
}

abstract class Mediator{    //抽象中介类
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl);//fenxiang
}

abstract class Colleague{  //抽象同事类
    protected Mediator mediator;
    public void setMedium(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void receiver();
    public abstract void send();
}


class ConcreteMediator extends Mediator{
    private List<Colleague> colleagues = new ArrayList<Colleague>();
    public void register(Colleague colleague){
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }
    public void relay(Colleague cl){
        for(Colleague ob:colleagues){
            if(!ob.equals(cl)){
                ((Colleague)ob).receiver();
            }
        }
    }
}

class ConcreteColleague1 extends Colleague{
    @Override
    public void receiver(){
        System.out.println("ConcreteColleague1 Received a request");
    }
    @Override
    public void send(){
        System.out.println("ConcreteColleague1 Make a request");
        mediator.relay(this);
    }
}

class ConcreteColleague2 extends Colleague{
    @Override
    public void receiver(){
        System.out.println("ConcreteColleague2 Received a request");
    }
    @Override
    public void send(){
        System.out.println("ConcreteColleague2 Make a request");
        mediator.relay(this);
    }
}