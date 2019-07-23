package cn.DesignPatternState;

public class ThreadStateTest {
    public static void main(String[] args){
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}

class ThreadContext{
    private ThreadState state;
    ThreadContext(){
        state=new New();
    }
    public void setState(ThreadState state){
        this.state=state;
    }
    public ThreadState getState(){
        return state;
    }
    public void start(){
        ((New)state).start(this);
    }
    public void getCPU(){
        ((Runnable)state).getCPU(this);
    }
    public void suspend(){
        ((Running)state).suspend(this);
    }
    public void stop(){
        ((Running)state).stop(this);
    }
    public void resume(){
        ((Blocked)state).resume(this);
    }
}

abstract class ThreadState{
    protected String stateName;
}

class New extends ThreadState {
    public New() {
        stateName = "new status";
        System.out.println("Current Thread: new status");
    }

    public void start(ThreadContext TC) {
        System.out.print("start Called->");
        if (stateName.equals("new status")) {
            TC.setState(new Runnable());
        } else {
            System.out.println("Current Thread is not new status,Cannot call start()");
        }
    }
}


class Runnable extends ThreadState {
    public Runnable() {
        stateName = "new Runnable";
        System.out.println("Current Thread: new Runnable");
    }

    public void getCPU(ThreadContext TC) {
        System.out.print("get CPUTime->");
        if (stateName.equals("new Runnable")) {
            TC.setState(new Runnable());
        } else {
            System.out.println("Current Thread is not new Runnable,Cannot call getCPU()");
        }
    }
}

class Running extends ThreadState {
    public Running() {
        stateName = "new Running";
        System.out.println("Current Thread: new Runnable");
    }

    public void suspend(ThreadContext TC) {
        System.out.print("get suspend->");
        if (stateName.equals("new Running")) {
            TC.setState(new Runnable());
        } else {
            System.out.println("Current Thread is not new Runnable,Cannot call Running()");
        }
    }
    public void stop(ThreadContext TC){
        System.out.println("Call stop()");
        if(stateName.equals("new Running")){
            TC.setState(new Dead());
        }else{
            System.out.println("Current Thread is not new Runnable,Cannot call stop()");
        }
    }
}

class Blocked extends ThreadState{
    public Blocked(){
        stateName="Blocking";
        System.out.println("Current Thread is Blocking");
    }
    public void resume(ThreadContext TC){
        System.out.print("Call resume()");
        if(stateName.equals("Blocking")){
            TC.setState(new Runnable());
        }else{
            System.out.println("Current Thread is not Blocking,Cannot call resume()");
        }
    }
}

class Dead extends ThreadState{
    public Dead(){
        stateName="Dead";
        System.out.println("Current Thread :Dead");
    }
}

