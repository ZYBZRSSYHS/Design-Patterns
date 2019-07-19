package cn.DesignPatternDecorator;

public class DecoratorPattern {
    public static void main(String[] args){
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("==================================");
        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}

interface Component{
    public void operation();
}

class ConcreteComponent implements Component{ //具体实现的构建角色

    public ConcreteComponent(){
        System.out.println("Create a concrete component role!");
    }

    public void operation(){
        System.out.println("Method of calling a specific component role operation()!");
    }
}

class Decorator implements Component{//抽象修饰的角色
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    public void operation(){
        component.operation();
    }
}

class ConcreteDecorator extends Decorator{  //具体实现
    public ConcreteDecorator(Component component){
        super(component);
    }
    public void operation(){
        super.operation();
        addedFunction();
    }
    public void addedFunction(){    //此为增加的装饰
        System.out.println("Add extra features to specific component roles: addedFunction()");
    }
}