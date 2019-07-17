package cn.DesignPatternProxyText;

public class ProxyTest {
    public static void main(String[] args){
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}

interface Subject{ //抽象的主题
    void Request();
}

class RealSubject implements Subject{ //实现真正的主题
    public void Request(){
        System.out.println("Access real theme methods");
    }
}

class Proxy implements Subject{//依然代理
    private RealSubject realSubject;
    public void Request(){
        if (realSubject == null) {
            realSubject=new RealSubject();
            System.out.println("=============================================");
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest(){ //预处理
        System.out.println("Pre-processing before accessing real topics");
    }

    public void postRequest(){
        System.out.println("Subsequent processing after accessing the real topic");
    }
}