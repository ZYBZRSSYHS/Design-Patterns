package cn.DesignPatternCommand;


public class CommandPattern {
    public static void main(String[] args){
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法");
        ir.call();
    }
}

class Invoker{ //调用者
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void call(){
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

interface Command{
    public abstract void execute();
}
class ConcreteCommand implements Command{
    private Receiver receiver;
    ConcreteCommand(){
        receiver = new Receiver();
    }
    public void execute(){
        receiver.action();
    }
}

class Receiver{
    public void action(){
        System.out.println("接受者Action()方法被调用...");
    }
}