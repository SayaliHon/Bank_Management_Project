package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    Button b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Main_Class(String pin) {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);
        JLabel l1=new JLabel("Please Select Your Transacion");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(460,180,400,35);
        l3.add(l1);

        b1=new Button("DEPOSITE");
        b1.setBounds(410,270,150,35);
        b1.setBackground(new Color(65,125,120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        b2=new Button("FAST CASH");
        b2.setBounds(410,315,150,35);
        b2.setBackground(new Color(65,125,120));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);
        b3=new Button("PIN CHANGE");
        b3.setBounds(410,360,150,35);
        b3.setBackground(new Color(65,125,120));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);
        b4=new Button("CASH WITHDRAWAL");
        b4.setBounds(700,270,150,35);
        b4.setBackground(new Color(65,125,120));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l3.add(b4);
        b5=new Button("MINI STATEMENT");
        b5.setBounds(700,315,150,35);
        b5.setBackground(new Color(65,125,120));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        l3.add(b5);
        b6=new Button("BALANCE INQUIRY");
        b6.setBounds(700,360,150,35);
        b6.setBackground(new Color(65,125,120));
        b3.setForeground(Color.WHITE);
        b6.addActionListener(this);
        l3.add(b6);
        b7=new Button("EXIT");
        b7.setBounds(700,410,150,35);
        b7.setBackground(new Color(65,125,120));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        l3.add(b7);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    try{
       if(e.getSource()==b1){
           new Deposit(pin);
           setVisible(false);
       }else if(e.getSource()==b4){
           new Withdrawal(pin);
           setVisible(false);
       }else if(e.getSource()==b7){
           System.exit(0);
       }else if(e.getSource()==b6){
           new Enquiry(pin);
           setVisible(false);
       } else if (e.getSource()==b2) {
           new FastCash(pin);
           setVisible(false);
       }else if(e.getSource()==b3){
           new Pin(pin);
           setVisible(false);
       }else if(e.getSource()==b5){
           new Mini(pin);
       }

    }catch(Exception E){
        E.printStackTrace();
    }
    }
    public static void main(String arg[]){
        new Main_Class("");

    }


}
