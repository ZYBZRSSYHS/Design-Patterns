package cn.DesignPatternMediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class DatingPlatform {
    public static void main(String[] args){
        Medium md = new EstateMedium();
        Customer member1,member2;
        member1 = new Seller("ZhangSan");
        member2 = new Seller("LiSi");
        md.register(member1);
        md.register(member2);
    }
}

interface Medium{
    void register(Customer member);
    void relay(String from,String ad);
}

class EstateMedium implements Medium{
    private List<Customer> members = new ArrayList<Customer>();
    public void register(Customer member){
        if(!members.contains(member)){
            members.add(member);
            member.setMedium(this);
        }
    }
    public void relay(String from,String ad){
        for(Customer ob:members){
            String name = ob.getName();
            if(!name.equals(from)){
                ((Customer)ob).receive(from,ad);
            }
        }
    }
}

abstract class Customer extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    protected Medium medium;
    protected String name;
    JTextField SentText;
    JTextArea ReceiverArea;
    public Customer(String name){
        super(name);
        this.name = name;
    }
    void ClientWindow(int x,int y){
        Container cp;
        JScrollPane sp;
        JPanel p1,p2;
        cp=this.getContentPane();
        SentText=new JTextField(18);
        ReceiverArea=new JTextArea(10,18);
        ReceiverArea.setEditable(false);
        p1=new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("接收内容："));
        p1.add(ReceiverArea);
        sp=new JScrollPane(p1);
        cp.add(sp, BorderLayout.NORTH);
        p2=new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("发送内容："));
        p2.add(SentText);
        cp.add(p2,BorderLayout.SOUTH);
        SentText.addActionListener(this);
        this.setLocation(x,y);
        this.setSize(250, 330);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String tempInfo = SentText.getText().trim();
        SentText.setText("");
        this.send(tempInfo);
    }
    public String getName(){
        return name;
    }
    public void setMedium(Medium medium){
        this.medium = medium;
    }
    public abstract void send(String ad);
    public abstract void receive(String from,String ad);
}

class Seller extends Customer{
    private static final long serialVersionUID=1L;
    public Seller(String name){
        super(name);
        ClientWindow(50,100);
    }
    public void send(String ad){
        ReceiverArea.append("Me:");
        ReceiverArea.setCaretPosition(ReceiverArea.getText().length());
        medium.relay(name,ad);
    }
    public void receive(String from,String ad){
        ReceiverArea.append(from+" : "+ad+"\n");
        ReceiverArea.setCaretPosition(ReceiverArea.getText().length());
    }
}

class Buyer extends Customer{
    private static final long serialVersionUID=1L;
    public Buyer(String name){
        super(name);
        ClientWindow(350,100);
    }
    public void send(String ad){
        ReceiverArea.append("Me:"+ad+"\n");
        ReceiverArea.setCaretPosition(ReceiverArea.getText().length());
        medium.relay(name,ad);
    }
    public void receive(String from,String ad){
        ReceiverArea.append(from+" : "+ad+"\n");
        ReceiverArea.setCaretPosition(ReceiverArea.getText().length());
    }
}