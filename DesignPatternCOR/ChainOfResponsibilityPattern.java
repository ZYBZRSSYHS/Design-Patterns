package cn.DesignPatternCOR;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args){
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        handler1.handleRequest("two");
    }
}

abstract class Handler{
    private Handler next;
    public void setNext(Handler next){
        this.next = next;
    }
    public Handler getNext(){
        return next;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler{
    public void handleRequest(String request){
        if(request.equals("one")){
            System.out.println("具体处理者1负责处理该请求！");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else{
                System.out.println("该请求没有被处理！");
            }
        }
    }
}

class ConcreteHandler2 extends Handler{
    public void handleRequest(String request){
        if(request.equals("two")){
            System.out.println("具体的处理者2负责处理该请求！");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else{
                System.out.println("该请求没有被处理！");
            }
        }
    }
}