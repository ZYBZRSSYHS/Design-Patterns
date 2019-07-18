package cn.DesignPatternAdapter;

public class TwoWayAdapterTest {
    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdapter adaptee=new AdapterRealize();
       // TwoWayTarget target=new TwoWayAdaters(adaptee);
      //  target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
      //  target=new TargetRealize();
       // adaptee=new TwoWayAdaters(target);
        adaptee.specificRequest();
    }
}

interface TwoWayTarget{
    public void request();
}

interface TwoWayAdapter{
    public void specificRequest();
}

class TargetRealize implements TwoWayTarget{
    public void request(){
        System.out.println("The target code is called");
    }
}

class AdapterRealize implements TwoWayAdapter{
    public void specificRequest(){
        System.out.println("Adapter code is called");
    }
}
 class TwoWayAdaters implements TwoWayTarget,TwoWayAdapter{  //双向适配

    private TwoWayTarget target;
    private TwoWayAdapter adapter;

    public void TwoWayAdapters(TwoWayTarget target){
        this.target = target;
    }

    public void TwoWayAdapters(TwoWayAdapter adapter){
        this.adapter = adapter;
    }

    public void request(){
        adapter.specificRequest();
    }

    public void specificRequest(){
        target.request();
    }
 }