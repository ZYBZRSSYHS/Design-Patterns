package cn.Design_Pattern;

import java.io.PrintWriter;

public class ISPtest {

    public static void main(String[] args){
        InputModule input = StuScoreList.getInputModule();
        CountModule count = StuScoreList.getCountModule();
        PrintModult print = StuScoreList.getPrintModult();

        input.insert();
        count.countTotalScore();
        print.printStuInfo();
    }
}

interface InputModule{  //输入模块接口
    void insert();
    void delete();
    void modify();
}

interface CountModule{  //统计模块接口
    void countTotalScore();
    void countAverage();
}

interface PrintModult{  //打印模块接口
    void printStuInfo();
    void queryStuInfo();
}

class StuScoreList implements InputModule,CountModule, PrintModult{

    private StuScoreList(){}

    public static InputModule getInputModule(){
        return (InputModule)new StuScoreList();
    }

    public static CountModule getCountModule(){
        return (CountModule)new StuScoreList();
    }

    public static PrintModult getPrintModult(){
        return (PrintModult)new StuScoreList();
    }

    public void insert(){
        System.out.println("transfer insert!");
    }
    public void delete(){
        System.out.println("transfer delete!");
    }
    public void modify(){
        System.out.println("transfer modify!");
    }



    public void countTotalScore(){
        System.out.println("transfer countTotalScore!");
    }
    public void countAverage(){
        System.out.println("transfer countAverage!");
    }



    public void printStuInfo(){
        System.out.println("transfer printStuInfo!");
    }

    public void queryStuInfo(){
        System.out.println("transfer queryStuInfo!");
    }

}