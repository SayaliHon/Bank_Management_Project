package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
       Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);
        JLabel l1=new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(470,180,400,35);
        l3.add(l1);

        b1=new JButton("Rs. 100");
        b1.setBounds(410,270,150,35);
        b1.setBackground(new Color(65,125,120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        b2=new JButton("Rs. 1000");
        b2.setBounds(410,315,150,35);
        b2.setBackground(new Color(65,125,120));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);
        b3=new JButton("Rs. 5000");
        b3.setBounds(410,360,150,35);
        b3.setBackground(new Color(65,125,120));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);
        b4=new JButton("Rs. 500");
        b4.setBounds(700,270,150,35);
        b4.setBackground(new Color(65,125,120));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l3.add(b4);
        b5=new JButton("Rs. 2000");
        b5.setBounds(700,315,150,35);
        b5.setBackground(new Color(65,125,120));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        l3.add(b5);
        b6=new JButton("Rs. 10000");
        b6.setBounds(700,360,150,35);
        b6.setBackground(new Color(65,125,120));
        b3.setForeground(Color.WHITE);
        b6.addActionListener(this);
        l3.add(b6);
        b7=new JButton("BACK");
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
        if(e.getSource() == b7){
            setVisible(false);
            new Main_Class(pin);
        } else {
            try {
                String amountText = ((JButton)e.getSource()).getText().substring(4).trim();
                double withdrawAmount = Double.parseDouble(amountText);

                ConnectionOfDatabase c = new ConnectionOfDatabase();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");

                double balance = 0;
                while(resultSet.next()) {
                    double amt = Double.parseDouble(resultSet.getString("amount"));
                    if(resultSet.getString("type").equalsIgnoreCase("deposit")) {
                        balance += amt;
                    } else {
                        balance -= amt;
                    }
                }

                if(balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

                c.statement.executeUpdate(
                        "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pin + "','" + formattedDate + "','withdrawal','" + withdrawAmount + "')"
                );

                JOptionPane.showMessageDialog(null,"Rs " + withdrawAmount + " Debited Successfully");

            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
            }
        }

    }
    public static void main(String arg[]){
        new FastCash(" ");
    }
}
