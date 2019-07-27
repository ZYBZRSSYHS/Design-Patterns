package cn.DesignPatternIterator;

import java.util.*;

public class IteratorPattern {
    public static void main(String[] args){
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.print("聚合内容为：___");
        Iterator it = ag.getIterator();
        while(it.hasNext()){
            Object ob = it.next();
            System.out.print(ob.toString()+"\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst:_"+ob.toString());
    }
}

interface Aggregate{
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}

class ConcreteAggregate implements Aggregate{
    private List<Object> list = new ArrayList<>();
    public void add(Object obj){
        list.add(obj);
    }
    public void remove(Object obj){
        list.remove(obj);
    }
    public Iterator getIterator(){
        return(new ConcreteIterator(list));
    }
}

interface Iterator{
    Object first();
    Object next();
    boolean hasNext();
}

class ConcreteIterator implements Iterator{
    private List<Object> list = null;
    private int index=-1;
    public ConcreteIterator(List<Object> list){
        this.list=list;
    }
    public boolean hasNext(){
        if(index<list.size()-1){
            return true;
        }else{
            return false;
        }
    }
    public Object first(){
        index =0;
        Object obj = list.get(index);
        return obj;
    }
    public Object next(){
        Object obj = null;
        if(this.hasNext()){
            obj=list.get(++index);
        }
        return obj;
    }
}
