package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Enquiry extends JFrame implements ActionListener {
    Button b1;
    JLabel l1;
    String pin;
    Enquiry(String pin){
this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);
        JLabel l2=new JLabel("Your Current Balance Is Rs");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        l2.setBounds(460,180,700,35);
        l3.add(l2);
        l1=new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(460,220,400,35);
        l3.add(l1);


        b1=new Button("BACK");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(65,125,120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        int balance=0;
        try{
         ConnectionOfDatabase c=new ConnectionOfDatabase();
            ResultSet res=c.statement.executeQuery("Select * from bank where pin='"+pin+"'");
            while (res.next()) {
                if (res.getString("type").equals("deposit")) {
                    balance +=  Double.parseDouble(res.getString("amount"));
                } else {
                    balance -=  Double.parseDouble(res.getString("amount"));
                }
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        l1.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Main_Class(pin);
    }
    public static void main(String a[]){
        new Enquiry("");
    }
}
