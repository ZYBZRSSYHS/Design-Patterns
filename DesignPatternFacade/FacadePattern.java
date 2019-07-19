package cn.DesignPatternFacade;

public class FacadePattern {
    public static void main(String[] args){
        Facede fc = new Facede();
        fc.method();
    }
}

class Facede{
    private SubSystem1 obj1 = new SubSystem1();
    private SubSystem2 obj2 = new SubSystem2();
    private SubSystem3 obj3 = new SubSystem3();
    public void method(){
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}

class SubSystem1{
    public static void method1(){
        System.out.println("method1 running!");
    }
}
class SubSystem2{
    public static void method2(){
        System.out.println("method2 running!");
    }
}
class SubSystem3{
    public static void method3(){
        System.out.println("method3 running!");
    }
}
