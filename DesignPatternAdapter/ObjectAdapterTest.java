package cn.DesignPatternAdapter;

public class ObjectAdapterTest {
    public static void main(String[] args){
        System.out.println("Object adapter mode test");
        Adapter adapter = new Adapter();
        Target target = new ObjectAdapter(adapter);
        target.request();
    }
}

class ObjectAdapter implements Target {
    private Adapter adapter;
    public ObjectAdapter(Adapter adapter){
        this.adapter=adapter;
    }
    public void request(){
        adapter.specificRequest();
    }
}