package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    Button b1,b2;

    Deposit(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);
        JLabel l1=new JLabel("ENTER NUMBER  YOU WANT TO DEPOSITE");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(460,180,400,35);
        l3.add(l1);

        textField =new TextField();
        textField.setBackground(new Color(65,125,120));
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,18));
        l3.add(textField);

        b1=new Button("DEPOSITE");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        b2=new Button("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,120));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText().trim();

            if (e.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                    return;
                }

                // Validate that amount is numeric
                double amt;
                try {
                    amt = Double.parseDouble(amount);
                    if (amt <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be greater than 0");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
                    return;
                }

                // Format date for MySQL
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

                // Insert into database using formattedDate
                ConnectionOfDatabase con = new ConnectionOfDatabase();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('"
                        + pin + "','" + formattedDate + "','deposit','" + amt + "')";
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + amt + " deposited successfully");
                setVisible(false);
                new Main_Class(pin);

            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception E) {
            E.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + E.getMessage());
        }
    }
    public static void main(String a[]){
        new Deposit("");
    }


}
