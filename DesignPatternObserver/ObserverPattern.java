package cn.DesignPatternObserver;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args){
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}

abstract class Subject{
    protected List<Observer> observers = new ArrayList<Observer>();

    public void add(Observer observer){     //增加观察者方法
        observers.add(observer);
    }
    public void remove(Observer observer){  //删除观察者方法
        observers.remove(observer);
    }
    public abstract void notifyObserver();  //通知观察者方法
}

class ConcreteSubject extends Subject{
    public void notifyObserver(){
        System.out.println("ConcreteObserver changes happened ....");
        System.out.println("=====================");
        for(Object obs:observers){
            ((Observer)obs).response();
        }
    }
}

interface Observer{
    void response();
}

class ConcreteObserver1 implements Observer{
    public void response(){
        System.out.println("ConcreteObserver1 Response");
    }
}

class ConcreteObserver2 implements Observer{
    public void response(){
        System.out.println("ConcreteObserver2 Response");
    }
}
