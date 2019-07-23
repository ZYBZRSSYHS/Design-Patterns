package cn.DesignPatternState;

public class StatePatternClient {
    public static void main(String[] args){
        Context context = new Context();
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}

abstract class State{
    public abstract void Handle(Context context);
}
class Context{
    private State state;
    public Context(){
        this.state = new ConcreteStateA();
    }
    public void setState(State state){
        this.state=state;
    }
    public State getState(){
        return(state);
    }
    public void Handle(){
        state.Handle(this);
    }
}

class ConcreteStateA extends State{
    public void Handle(Context context){
        System.out.println("当前状态为A");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State{
    public void Handle(Context context){
        System.out.println("当前状态为B");
        context.setState(new ConcreteStateA());
    }
}