
package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JTextField textName,textFName,textEmail,textA,textS,textP,textC;
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    JDateChooser dateChooser;

    Random random = new Random();
    long first4 = (random.nextLong()%9000L)+1000L;
    String first = ""+Math.abs(first4);

    SignUp(){

        super("APPLICATION FORM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.jfif"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1=new JLabel("APPLICATION FORM NO: "+first);
        label1.setFont(new Font("AvantGard",Font.BOLD,30));
        label1.setBounds(160,20,600,40);
        add(label1);

        JLabel label3=new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(350,70,600,30);
        add(label3);

        JLabel labelName=new JLabel("Name:");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,120,200,30);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(300,120,400,30);
        add(textName);

        JLabel labelFName=new JLabel("Father's Name:");
        labelFName.setFont(new Font("Raleway",Font.BOLD,20));
        labelFName.setBounds(100,160,200,30);
        add(labelFName);

        textFName=new JTextField();
        textFName.setBounds(300,160,400,30);
        add(textFName);

        JLabel labelEmail=new JLabel("Email Address:");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,200,200,30);
        add(labelEmail);

        textEmail=new JTextField();
        textEmail.setBounds(300,200,400,30);
        add(textEmail);

        JLabel labelG=new JLabel("Gender:");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,240,200,30);
        add(labelG);

        r1=new JRadioButton("Male");
        r1.setBounds(300,240,80,30);
        r1.setBackground(new Color(252,208,78));
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(400,240,100,30);
        r2.setBackground(new Color(252,208,78));
        add(r2);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel DOB=new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,280,200,30);
        add(DOB);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,280,400,30);
        add(dateChooser);

        JLabel labelMS=new JLabel("Marital Status:");
        labelMS.setFont(new Font("Raleway",Font.BOLD,20));
        labelMS.setBounds(100,320,200,30);
        add(labelMS);

        m1=new JRadioButton("Married");
        m1.setBounds(300,320,100,30);
        m1.setBackground(new Color(252,208,78));
        add(m1);

        m2=new JRadioButton("Unmarried");
        m2.setBounds(420,320,100,30);
        m2.setBackground(new Color(252,208,78));
        add(m2);

        m3=new JRadioButton("Other");
        m3.setBounds(540,320,100,30);
        m3.setBackground(new Color(252,208,78));
        add(m3);

        ButtonGroup msGroup=new ButtonGroup();
        msGroup.add(m1);
        msGroup.add(m2);
        msGroup.add(m3);

        JLabel labelCity=new JLabel("City:");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,360,200,30);
        add(labelCity);

        textC=new JTextField();
        textC.setBounds(300,360,400,30);
        add(textC);

        JLabel labelAddress=new JLabel("Address:");
        labelAddress.setFont(new Font("Raleway",Font.BOLD,20));
        labelAddress.setBounds(100,400,200,30);
        add(labelAddress);

        textA=new JTextField();
        textA.setBounds(300,400,400,30);
        add(textA);

        JLabel labelPin=new JLabel("Pin Code:");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,440,200,30);
        add(labelPin);

        textP=new JTextField();
        textP.setBounds(300,440,400,30);
        add(textP);

        JLabel labelState=new JLabel("State:");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,480,200,30);
        add(labelState);

        textS=new JTextField();
        textS.setBounds(300,480,400,30);
        add(textS);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,540,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,650);
        setLocation(350,10);
        getContentPane().setBackground(new Color(252,208,78));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String firstno = first;
        String name = textName.getText().trim();
        String fname = textFName.getText().trim();
        String email = textEmail.getText().trim();

        Date date = dateChooser.getDate();
        if(date == null){
            JOptionPane.showMessageDialog(null,"Please select Date of Birth");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dob = sdf.format(date);

        String gender = null;
        if(r1.isSelected()) gender="Male";
        else if(r2.isSelected()) gender="Female";

        String maritalState = null;
        if(m1.isSelected()) maritalState="Married";
        else if(m2.isSelected()) maritalState="Unmarried";
        else if(m3.isSelected()) maritalState="Other";

        String address=textA.getText().trim();
        String state=textS.getText().trim();
        String city=textC.getText().trim();
        String pin=textP.getText().trim();

        try{

            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your name");
                return;
            }

            // Email validation
            if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your email");
                return;
            }

            // Regex for email validation
            if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                JOptionPane.showMessageDialog(null, "Invalid email format. Example: example@gmail.com");
                return;
            }

            ConnectionOfDatabase con1=new ConnectionOfDatabase();
            String q="insert into signup values('"+firstno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+maritalState+"','"+address+"','"+city+"','"+state+"','"+pin+"','"+email+"')";
            con1.statement.executeUpdate(q);

            new SignUp2(firstno);
            setVisible(false);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new SignUp();
    }
}

