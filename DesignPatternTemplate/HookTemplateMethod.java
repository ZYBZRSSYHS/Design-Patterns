package cn.DesignPatternTemplate;

public class HookTemplateMethod {
    public static void main(String[] args){
        HookAbstractClass tm = new HookConcreteClass();
        tm.TemplateMethod();
    }
}

abstract class HookAbstractClass{
    public void TemplateMethod(){
        abstractMethod1();
        HookMethod1();
        abstractMethod2();
        if(HookMethod2()){
            SpecificMethod();
        }
        abstractMethod2();
        abstractMethod();
    }

    public void SpecificMethod(){
        System.out.println("abstractMethod Called...");
    }
    public void HookMethod1(){}
    public boolean HookMethod2(){
        return true;
    }
    public void abstractMethod(){
        System.out.println("abstractMethod achiever Called");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}

class  HookConcreteClass extends HookAbstractClass{
    public void abstractMethod1(){
        System.out.println("abstractMethod1 achiever Called");
    }
    public void abstractMethod2(){
        System.out.println("abstractMethod2 achiever Called");
    }
    public void HookMethod1(){
        System.out.println("HookMethod1 rewrite");
    }
    @Override
    public boolean HookMethod2(){
        return false;
    }
}