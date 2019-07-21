package cn.DesignPatternStrategy;

public class StrategyPattern {
    public static void main(String[] args){
        Context context = new Context();
        Strategy Concretestrategy = new ConcreteStrategyA();
        context.setStrategy(Concretestrategy);
        context.strategyyMethod();
        System.out.println("=========================");
        Concretestrategy =new ConcreteStrategyB();
        context.setStrategy(Concretestrategy);
        context.strategyyMethod();
    }
}

interface Strategy{
    public void strategyMethod();
}

class ConcreteStrategyA implements Strategy{
    public void strategyMethod(){
        System.out.println("strategyMethodA Called!");
    }
}

class ConcreteStrategyB implements Strategy{
    public void strategyMethod(){
        System.out.println("strategyMethodB Called!");
    }
}

class Context{
    private Strategy strategy;
    public Strategy getStrategy(){
        return strategy;
    }
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public void strategyyMethod(){
        strategy.strategyMethod();
    }
}