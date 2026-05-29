package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    String pin;
    JButton button;

    Mini(String pin){
        this.pin = pin;

        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20,140,400,220);
        add(l1);

        JLabel l2 = new JLabel("TechCoder A.V");
        l2.setFont(new Font("System", Font.BOLD,15));
        l2.setBounds(150,20,200,20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);

        // CARD NUMBER DISPLAY
        try{
            ConnectionOfDatabase con = new ConnectionOfDatabase();
            ResultSet rs = con.statement.executeQuery("select * from login where pin='"+pin+"'");

            while(rs.next()){
                String card = rs.getString("card_no");

                if(card.length() >= 16){
                    l3.setText("Card Number: " + card.substring(0,4) + "XXXXXXXX" + card.substring(12));
                }else{
                    l3.setText("Card Number: " + card);
                }
            }

        }catch(Exception E){
            E.printStackTrace();
        }

        // MINI STATEMENT
        try{
            ConnectionOfDatabase c = new ConnectionOfDatabase();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin='" + pin + "'");

            double balance = 0;
            String text = "<html>";

            while(resultSet.next()){

                text += resultSet.getString("date")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;"
                        + resultSet.getString("type")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;"
                        + resultSet.getString("amount")
                        + "<br><br>";

                double amount = Double.parseDouble(resultSet.getString("amount"));

                if(resultSet.getString("type").equalsIgnoreCase("deposit")){
                    balance += amount;
                }else{
                    balance -= amount;
                }
            }

            text += "</html>";

            l1.setText(text);
            l4.setText("Your Account Balance is: " + balance);

        }catch(Exception E){
            E.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }

    public static void main(String arg[]){
        new Mini("");
    }
}