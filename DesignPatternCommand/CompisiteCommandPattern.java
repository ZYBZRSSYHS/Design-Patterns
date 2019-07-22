package cn.DesignPatternCommand;

import java.util.ArrayList;

public class CompisiteCommandPattern {
    public static void main(String[] args){
        AbstractCommand cmd1 = new ConcreteCommand1();
        AbstractCommand cmd2 = new ConcreteCommand2();
        CompositeInvoker ir = new CompositeInvoker();
        ir.add(cmd1);
        ir.add(cmd2);
        System.out.println("execute Called...");
        ir.execute();
    }
}

class CompositeReceiver{ //接受者
    public void action1(){
        System.out.println("Action1 Called");
    }
    public void action2(){
        System.out.println("Action2 Called");
    }
}

interface AbstractCommand{      //抽象的命令
    public abstract void execute();
}

class ConcreteCommand1 implements AbstractCommand{      //具体的命令1
    private CompositeReceiver receiver;
    ConcreteCommand1(){
        receiver = new CompositeReceiver();
    }
    public void execute(){
        receiver.action1();
    }
}
class ConcreteCommand2 implements AbstractCommand{      //具体的命令2
    private CompositeReceiver receiver;
    ConcreteCommand2(){
        receiver = new CompositeReceiver();
    }
    public void execute(){
        receiver.action2();
    }
}
class CompositeInvoker implements AbstractCommand{      //调用命令
    private ArrayList<AbstractCommand> children = new ArrayList<AbstractCommand>();
    public void add(AbstractCommand c){
        children.add(c);
    }
    public void remove(AbstractCommand c){
        children.remove(c);
    }
    public AbstractCommand getChild(int i){
        return children.get(i);
    }
    public void execute(){
        for(Object obj:children){
            ((AbstractCommand)obj).execute();
        }
    }
}