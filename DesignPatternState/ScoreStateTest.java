package cn.DesignPatternState;

public class ScoreStateTest {
    public static void main(String[] args){
        ScoreContext account = new ScoreContext();
        System.out.println("学生成绩测试");
        account.add(30);
        account.add(40);
        account.add(-60);
        account.add(-30);
        account.add(70);
        account.add(-90);
    }
}

abstract class AbstractState{
    protected ScoreContext bj;
    protected String stateName;
    protected int score;
    public abstract void checkState();
    public void addScore(int x){
        score+=x;
        System.out.println("加上"+x+"分，\t当前分数:"+score);
        checkState();
        System.out.println("分,\t当前状态"+bj.getState().stateName);
    }
}

class LowState extends AbstractState{
    public LowState(ScoreContext SC){
       bj  =SC;
       stateName="failed";
       score=0;
    }
    public LowState(AbstractState state){
        bj=state.bj;
        stateName="failed";
        score=state.score;
    }
    public void checkState(){
        if(score>=90){
            bj.setState(new HighState(this));
        }else if(score>=60){
            bj.setState(new MiddleState(this));
        }
    }
}

class HighState extends AbstractState{
    public HighState(ScoreContext SC){
       bj  =SC;
       stateName="excellent";
       score=0;
    }
    public HighState(AbstractState state){
        bj=state.bj;
        stateName="excellent";
        score=state.score;
    }
    public void checkState(){
        if(score<=60){
            bj.setState(new LowState(this));
        }else if(score<=90){
            bj.setState(new MiddleState(this));
        }
    }
}

class MiddleState extends AbstractState{
    public MiddleState(ScoreContext SC){
       bj  =SC;
       stateName="Good";
       score=0;
    }
    public MiddleState(AbstractState state){
        bj=state.bj;
        stateName="Good";
        score=state.score;
    }
    public void checkState(){
        if(score<=60){
            bj.setState(new LowState(this));
        }else if(score>90){
            bj.setState(new HighState(this));
        }
    }
}



class ScoreContext{
    private AbstractState state;
    ScoreContext(){
        state= new LowState(this);
    }
    public void setState(AbstractState state){
        this.state = state;
    }
    public AbstractState getState(){
        return state;
    }
    public void add(int score){
        state.addScore(score);
    }
}
