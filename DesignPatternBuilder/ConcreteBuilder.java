package cn.DesignPatternBuilder;

public class ConcreteBuilder extends Builder {

    public void buildPartA(){
        product.setPartA("Builder PartA");
    }

    public void buildPartB(){
        product.setPartA("Builder PartB");
    }

    public void buildPartC(){
        product.setPartA("Builder PartC");
    }

}
