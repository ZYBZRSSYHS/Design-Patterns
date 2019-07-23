package cn.DesignPatternCOR;

public class LeaveApprovalTest {
    public static void main(String[] args){
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        Leader teacher4 = new DeanOfStudies();

        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        teacher3.setNext(teacher4);


        teacher1.handleRequest(8);
        teacher1.handleRequest(19);
    }
}

abstract class Leader{
    private Leader next;
    protected void setNext(Leader next){
        this.next = next;
    }
    public Leader getNext(){
        return next;
    }

    public abstract void handleRequest(int LeaveDays);
}

class ClassAdviser extends Leader{
    public void handleRequest(int LeaveDays){
        if (LeaveDays <= 2 ) {
            System.out.println("班主任可以批准"+LeaveDays+"天");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else{
                System.out.println("请假天数过多，没有人可以批准该假条！");
            }
        }
    }
}

class DepartmentHead extends Leader{
    public void handleRequest(int LeaveDays){
        if (LeaveDays <= 7 ) {
            System.out.println("系主任可以批准"+LeaveDays+"天");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else{
                System.out.println("请假天数过多，没有人可以批准该假条！");
            }
        }
    }
}

class Dean extends Leader{
    public void handleRequest(int LeaveDays){
        if (LeaveDays <= 10 ) {
            System.out.println("院长可以批准"+LeaveDays+"天");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else{
                System.out.println("请假天数过多，没有人可以批准该假条！");
            }
        }
    }
}

class DeanOfStudies extends Leader{
    public void handleRequest(int LeaveDays){
        if (LeaveDays <= 20 ) {
            System.out.println("教务处长可以批准"+LeaveDays+"天");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else{
                System.out.println("请假天数过多，没有人可以批准该假条！");
            }
        }
    }
}