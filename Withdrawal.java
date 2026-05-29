package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2;

    Withdrawal(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l2 = new JLabel("MAXIMUM WITHDRAWAL IS Rs.10,000");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway", Font.BOLD, 16));
        l2.setBounds(460, 180, 700, 35);
        l3.add(l2);

        JLabel l1 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway", Font.BOLD, 18));
        l1.setBounds(460, 220, 400, 35);
        l3.add(l1);

        textField = new JTextField();
        textField.setBackground(new Color(65, 125, 120));
        textField.setBounds(460, 270, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 120));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String amountText = textField.getText().trim();

                if (amountText.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your amount to withdraw");
                    return;
                }

                // Validate numeric amount
                double withdrawAmount;
                try {
                    withdrawAmount = Double.parseDouble(amountText);
                    if (withdrawAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be greater than 0");
                        return;
                    }
                    if (withdrawAmount > 10000) {
                        JOptionPane.showMessageDialog(null, "Maximum withdrawal is Rs.10,000");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
                    return;
                }

                ConnectionOfDatabase con = new ConnectionOfDatabase();
                ResultSet res = con.statement.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");

                double balance = 0;
                while (res.next()) {
                    double amt = Double.parseDouble(res.getString("amount"));
                    if (res.getString("type").equalsIgnoreCase("deposit")) {
                        balance += amt;
                    } else {
                        balance -= amt;
                    }
                }

                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Format date for MySQL
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

                // Insert withdrawal into database
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('"
                        + pin + "','" + formattedDate + "','withdrawal','" + withdrawAmount + "')";
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " debited successfully");
                setVisible(false);
                new Main_Class(pin);

            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}