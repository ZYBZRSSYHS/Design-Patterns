package cn.DesignPatternVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args){
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------");
        visitor=new ConcreteVisitorB();
        os.accept(visitor);
    }
}


interface Visitor{
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}

class ConcreteVisitorA implements Visitor{
    public void visit(ConcreteElementA elementA){
        System.out.println("具体的访问者A->"+elementA.operationA());
    }
    public void visit(ConcreteElementB elementB){
        System.out.println("具体的访问者A->"+elementB.operationB());
    }
}

class ConcreteVisitorB implements Visitor{
    public void visit(ConcreteElementA elementA){
        System.out.println("具体的访问者B->"+elementA.operationA());
    }
    public void visit(ConcreteElementB elementB){
        System.out.println("具体的访问者->"+elementB.operationB());
    }
}

interface Element{
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String operationA(){
        return "具体的操作A";
    }
}

class ConcreteElementB implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String operationB(){
        return "具体的操作B";
    }
}

class ObjectStructure{
    private List<Element> list = new ArrayList<Element>();
    public void accept(Visitor visitor){
        Iterator<Element> i = list.iterator();
        while(i.hasNext()){
            ((Element)i.next()).accept(visitor);
        }
    }
    public void add(Element element){
        list.add(element);
    }
    public void remove(Element element){
        list.remove(element);
    }
}
