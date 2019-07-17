package cn.DesignPatternAdapter;

public class ClassAdapterTest {
    public static void main(String[] args){
        System.out.println("Adapter test");
        Target target = new ClassAdapter();
        target.request();
    }
}

interface Target{
    public void request();
}

class Adapter{
    public void specificRequest(){
        System.out.println("Running......");
    }
}

class ClassAdapter extends Adapter implements Target{
    public void request(){
        specificRequest();
    }
}
