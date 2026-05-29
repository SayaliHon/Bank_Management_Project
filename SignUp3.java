package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JRadioButton r1,r2,r3,r4;
JButton c,s;
String formno;
    SignUp3( String formno){
        super("ACCOUNT DETAILS ");
        this.formno=formno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource( "icon/bank.jfif"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);
        JLabel label1=new JLabel("Page: 3");
        label1.setFont(new Font("AvantGard",Font.BOLD,22));
        label1.setBounds(300,20,600,40);
        add(label1);
        JLabel label2=new JLabel("Religion :");
        label2.setFont(new Font("AvantGard",Font.BOLD,22));
        label2.setBounds(300,60,600,40);
        add(label2);
        JLabel l3=new JLabel("Account Type :");
        l3.setFont(new Font("AvantGard",Font.BOLD,18));
        l3.setBounds(100,120,200,22);
        add(l3);
        r1=new JRadioButton("Saving Account ");
        r1.setFont(new Font("AvantGard",Font.BOLD,18));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(100,160,200,30);
        add(r1);
        r4=new JRadioButton("Currunt Account ");
        r4.setFont(new Font("AvantGard",Font.BOLD,18));
        r4.setBackground(new Color(252,208,76));
        r4.setBounds(100,200,200,30);
        add(r4);
        r2=new JRadioButton("Fix Deposit Account");
        r2.setFont(new Font("AvantGard",Font.BOLD,18));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(350,160,300,30);
        add(r2);
        r3=new JRadioButton("Recuring Deposit Account");
        r3.setFont(new Font("AvantGard",Font.BOLD,18));
        r3.setBackground(new Color(252,208,76));
        r3.setBounds(350,200,300,30);
        add(r3);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        JLabel label3=new JLabel("Card Number :");
        label3.setFont(new Font("AvantGard",Font.BOLD,18));
        label3.setBounds(100,260,200,30);
        add(label3);
        JLabel label4=new JLabel("(Your 16-digit Card Number)");
        label4.setFont(new Font("AvantGard",Font.BOLD,12));
        label4.setBounds(100,280,200,20);
        add(label4);
        JLabel label6=new JLabel("XXXX-XXXX-XXXX-4841");
        label6.setFont(new Font("AvantGard",Font.BOLD,18));
        label6.setBounds(330,260,250,30);
        add(label6);
        JLabel label7=new JLabel("(It would appear on atm card/cheque Book and statements)");
        label7.setFont(new Font("AvantGard",Font.BOLD,12));
        label7.setBounds(330,275,380,40);
        add(label7);
        JLabel label8=new JLabel("PIN :");
        label8.setFont(new Font("AvantGard",Font.BOLD,18));
        label8.setBounds(100,320,380,40);
        add(label8);
        JLabel label10=new JLabel("(4-digit Password)");
        label10.setFont(new Font("AvantGard",Font.BOLD,12));
        label10.setBounds(100,350,200,20);
        add(label10);
        JLabel label9=new JLabel("XXXX");
        label9.setFont(new Font("AvantGard",Font.BOLD,18));
        label9.setBounds(330,320,380,40);
        add(label9);
        JLabel label11=new JLabel("Services Required :");
        label11.setFont(new Font("AvantGard",Font.BOLD,18));
        label11.setBounds(100,390,200,20);
        add(label11);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(new Color(252,208,76));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,420,200,30);
        add(c1);
        c2=new JCheckBox("Mobile Banking");
        c2.setBackground(new Color(252,208,76));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(100,450,200,30);
        add(c2);
        c3=new JCheckBox("Cheque Book");
        c3.setBackground(new Color(252,208,76));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,480,200,30);
        add(c3);
        c4=new JCheckBox("Internet Banking");
        c4.setBackground(new Color(252,208,76));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(340,420,200,30);
        add(c4);
        c5=new JCheckBox("EMAIL Alerts");
        c5.setBackground(new Color(252,208,76));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(340,450,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(new Color(252,208,76));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(340,480,200,30);
        add(c6);
        c7=new JCheckBox("I here by decleares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(252,208,76));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,520,600,20);
        add(c7);
        JLabel label12=new JLabel("Form No:");
        label12.setFont(new Font("AvantGard",Font.BOLD,14));
        label12.setBounds(700,10,100,30);
        add(label12);
        JLabel label13=new JLabel(formno);
        label13.setFont(new Font("AvantGard",Font.BOLD,14));
        label13.setBounds(760,10,100,30);
        add(label13);
        s=new JButton("SUBMIT");
        s.setFont(new Font("Arial",Font.BOLD,14));
        s.setForeground(Color.WHITE);
        s.setBackground(Color.BLACK);
        s.addActionListener(this);
        s.setBounds(200,580,100,30);
        add(s);
        c=new JButton("CANCEL");
        c.setFont(new Font("Arial",Font.BOLD,14));
        c.setForeground(Color.WHITE);
        c.setBackground(Color.BLACK);
        c.addActionListener(this);
        c.setBounds(380,580,100,30);
        add(c);

        setLayout(null);
        setSize(850,670);
        setLocation(360,10);
        getContentPane().setBackground(new Color(252,208,78));
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String atype=" ";
        if(r1.isSelected()){
            atype="Saving Account ";
        }else if(r2.isSelected()){
            atype="Fix Deposit Account";
        }else if(r3.isSelected()){
            atype="Recuring Deposit Account";
        }else if(r4.isSelected()){
            atype="Currunt Account ";
        }
        Random ran=new Random();
        long first7=(ran.nextLong()%90000000L)+14099630000000L;
        String cardo=""+Math.abs(first7);

        long first3=(ran.nextLong()%9000L)+1000L;
        String pin=""+Math.abs(first3);

        String fac="";
        if(c1.isSelected()){
            fac+="ATM CARD";
        }else if(c2.isSelected()){
            fac+="Mobile Banking";
        }else if(c3.isSelected()){
            fac+="Cheque Book";
        }else if(c4.isSelected()){
            fac+="Internet Banking";
        }else if(c5.isSelected()){
            fac+="EMAIL Alerts";
        }else if(c6.isSelected()){
            fac+="E-Statement";
        }
        try {
            if (e.getSource() == s) {
                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");

                } else {
                    ConnectionOfDatabase c1 = new ConnectionOfDatabase();
                    String q1 = "insert into signupthree values('" + formno + "','" + atype + "','" + cardo + "','" + pin + "','" + fac + "')";
                    String q2 = "insert into login values('" + formno + "','" + cardo + "','" + pin + "')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number" + cardo + "\n Pin" + pin);
                   new Deposit(pin);
                    setVisible(false);
                }
            }else if(e.getSource()==c){
                System.exit(0);
            }

        }catch(Exception E){
           E.printStackTrace();
        }
    }
    public static void main(String[]a){
        new SignUp3(" ");
    }

}
