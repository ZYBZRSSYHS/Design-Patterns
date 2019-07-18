package cn.DesignPatternAdapter;

public class MotorAdapterTest {
    public static void main(String[] args){
        println p = new println();
        p.p("Adapter mode test:");
        ElectricAdapter electricAdapter = new ElectricAdapter();

       // Motor motor = (Motor)ReadXML.getObject();
        Motor motor = (Motor)new ElectricAdapter();
        motor.drive();
        Motor motor1 = (Motor)new OpticalAdapter();
        motor1.drive();
    }
}

class println{
    void p(Object obj){
        System.out.println(obj);
    }
}

interface Motor{
    public void drive();
}

class ElectricMotor{
    public void electricDrive(){
        System.out.println("Electric engine drives the car!");
    }
}

class OpticalMotor{
    public void opticalDrive(){
        System.out.println("Optical engine drives the car!");
    }
}

class ElectricAdapter  implements Motor{
    private ElectricMotor emotor;
    public ElectricAdapter(){
        emotor = new ElectricMotor();
    }
    public void drive(){
        emotor.electricDrive();
    }
}

class OpticalAdapter implements Motor{
    private OpticalMotor omotor;
    public OpticalAdapter(){
        omotor = new OpticalMotor();
    }
    public void drive(){
        omotor.opticalDrive();
    }
}