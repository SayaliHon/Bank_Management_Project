package bank.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;

import static java.lang.ClassLoader.getSystemResources;

class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textfield2;
    JPasswordField passwordfield3;
    JButton button1,button2,button3;
    Login(){
        super("Bank Management System");
        //bank image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource( "icon/bank.jfif"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);
        //Card image
        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource( "icon/atmcardd.jfif"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel iimage=new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);
        //To set label
        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGard",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        //label for card
        label2=new JLabel("Card No:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150,190,375,30);
        add(label2);
        //TextField
        textfield2=new JTextField(15);
        textfield2.setBounds(325,190,230,30);
        textfield2.setFont(new Font("Arial",Font.BOLD,14));
        add(textfield2);
        //label for pin no
        label3=new JLabel("PIN No:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        add(label3);
        // Password field
        passwordfield3=new JPasswordField(15);
        passwordfield3.setBounds(325,250,230,30);
        passwordfield3.setFont(new Font("Arial",Font.BOLD,14));
        add( passwordfield3);
        // SIGN IN Buttons
        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);
        // Clear Button
        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        //sign up button
        button3=new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);


        //Background image
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource( "icon/bg.jfif"));
        Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        setLayout(null);
        setSize(850,480);
        setLocation(340,80);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                ConnectionOfDatabase con=new ConnectionOfDatabase();
                String cardno=textfield2.getText();
                String pin=passwordfield3.getText();
                String q="select * from login  where card_no='"+cardno+"' and pin='"+pin+"'";
                ResultSet res=con.statement.executeQuery(q);
                if(res.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid card nunber and PIN");
                }

            } else if(e.getSource()==button2) {
                textfield2.setText("");
                passwordfield3.setText("");
            }else if(e.getSource()==button3) {
                new SignUp();
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
