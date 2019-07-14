package cn.Design_Pattern;

public class LoDtest {
    public static void main(String[] args){
        Agent agent = new Agent();
        agent.setStar(new Star("Star"));
        agent.setFans(new Fans("Fans"));
        agent.setCompany(new Company("Company"));
        agent.business();
        agent.meeting();
    }
}


class Agent{ //经纪人，中间人
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public void setStar(Star myStar){
        this.myStar = myStar;
    }
    public void setFans(Fans myFans){
        this.myFans = myFans;
    }
    public void setCompany(Company myCompany){
        this.myCompany = myCompany;
    }

    public void meeting(){
        System.out.println(myFans.getName()+" and Star "+myStar.getName()+"meet!");
    }
    public void business(){
        System.out.println(myCompany.getName()+"and Star "+myStar.getName()+"Conduct business!");
    }
}

class Star{ //明星
    private String name;
    Star(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class Fans{ //fens
    private String name;
    Fans(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }
}

class Company{
    private String name;
    Company(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}


