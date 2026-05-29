package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {
    String formno;
    JTextField textpan, textadhar;
    JComboBox comboBox1, comboBox2, comboBox3, comboBox4, comboBox5;
    JRadioButton r1, r2, r3, r4;
    JButton next;

    SignUp2(String formno) {
        super("APPLICATION DETAILS ");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jfif"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);
        this.formno = formno;
        JLabel label1 = new JLabel("Page: 2");
        label1.setFont(new Font("AvantGard", Font.BOLD, 22));
        label1.setBounds(300, 20, 600, 40);
        add(label1);
        JLabel label2 = new JLabel("Account Details:");
        label2.setFont(new Font("AvantGard", Font.BOLD, 22));
        label2.setBounds(300, 60, 200, 40);
        add(label2);
        JLabel label12 = new JLabel("Religion :");
        label12.setFont(new Font("AvantGard", Font.BOLD, 20));
        label12.setBounds(100, 120, 200, 40);
        add(label12);

        String Religion[] = {"Hindu", "Muslim", "Shikh", "Christian", "Other"};
        comboBox1 = new JComboBox(Religion);
        comboBox1.setFont(new Font("AvantGard", Font.BOLD, 14));
        comboBox1.setBounds(300, 120, 320, 30);
        add(comboBox1);
        JLabel label3 = new JLabel("Category:");
        label3.setFont(new Font("AvantGard", Font.BOLD, 18));
        label3.setBounds(100, 170, 200, 40);
        add(label3);
        String Category[] = {"General", "OBC", "SC", "ST", "Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setFont(new Font("AvantGard", Font.BOLD, 14));
        comboBox2.setBounds(300, 170, 320, 30);
        add(comboBox2);
        JLabel label4 = new JLabel("Income :");
        label4.setFont(new Font("AvantGard", Font.BOLD, 18));
        label4.setBounds(100, 220, 200, 40);
        add(label4);
        String Income[] = {"<10,000", "10,000-25,000", "25,001-50,000", "50,001-75,000", "75,001-100,000", ">100,000"};
        comboBox3 = new JComboBox(Income);
        comboBox3.setFont(new Font("AvantGard", Font.BOLD, 14));
        comboBox3.setBounds(300, 220, 320, 30);
        add(comboBox3);
        JLabel label5 = new JLabel("Education:");
        label5.setFont(new Font("AvantGard", Font.BOLD, 18));
        label5.setBounds(100, 270, 200, 40);
        add(label5);
        String Education[] = {"High School", "Intermediate", "Diploma", "Bachelor", "Master", "PhD", "Other"};
        comboBox4 = new JComboBox(Education);
        comboBox4.setFont(new Font("AvantGard", Font.BOLD, 14));
        comboBox4.setBounds(300, 270, 320, 30);
        add(comboBox4);
        JLabel label6 = new JLabel("Occuption:");
        label6.setFont(new Font("AvantGard", Font.BOLD, 18));
        label6.setBounds(100, 320, 200, 40);
        add(label6);
        String Occuption[] = {"Student", "Business", "Government Employee", "Private Employee", "Self-employed", "Housewife", "Retired", "Other"};
        comboBox5 = new JComboBox(Category);
        comboBox5.setFont(new Font("AvantGard", Font.BOLD, 14));
        comboBox5.setBounds(300, 320, 320, 30);
        add(comboBox5);
        JLabel label7 = new JLabel("PAN Number :");
        label7.setFont(new Font("AvantGard", Font.BOLD, 18));
        label7.setBounds(100, 380, 200, 40);
        add(label7);
        textpan = new JTextField();
        textpan.setFont(new Font("Raleway", Font.BOLD, 14));
        textpan.setBounds(300, 380, 320, 30);
        add(textpan);
        JLabel label8 = new JLabel("Adhar Number:");
        label8.setFont(new Font("AvantGard", Font.BOLD, 18));
        label8.setBounds(100, 430, 200, 40);
        add(label8);
        textadhar = new JTextField();
        textadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        textadhar.setBounds(300, 430, 320, 30);
        add(textadhar);
        JLabel label9 = new JLabel("Senior Citizen :");
        label9.setFont(new Font("AvantGard", Font.BOLD, 18));
        label9.setBounds(100, 480, 200, 40);
        add(label9);
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("AvantGard", Font.BOLD, 18));
        r1.setBackground(new Color(252, 208, 76));
        r1.setBounds(300, 480, 100, 30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("AvantGard", Font.BOLD, 18));
        r2.setBackground(new Color(252, 208, 76));
        r2.setBounds(440, 480, 100, 30);
        add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        JLabel label10 = new JLabel("Existing Account :");
        label10.setFont(new Font("AvantGard", Font.BOLD, 18));
        label10.setBounds(100, 530, 200, 40);
        add(label10);
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("AvantGard", Font.BOLD, 18));
        r3.setBackground(new Color(252, 208, 76));
        r3.setBounds(300, 530, 100, 30);
        add(r3);
        r4 = new JRadioButton("No");
        r4.setFont(new Font("AvantGard", Font.BOLD, 18));
        r4.setBackground(new Color(252, 208, 76));
        r4.setBounds(440, 530, 100, 30);
        add(r4);
        ButtonGroup bgg = new ButtonGroup();
        bgg.add(r3);
        bgg.add(r4);

        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);

        next.setBounds(490, 590, 100, 30);
        next.addActionListener(this);
        add(next);
        JLabel label15 = new JLabel("Form No:");
        label15.setFont(new Font("AvantGard", Font.BOLD, 14));
        label15.setBounds(700, 10, 100, 30);
        add(label15);
        JLabel label13 = new JLabel(formno);
        label13.setFont(new Font("AvantGard", Font.BOLD, 14));
        label13.setBounds(760, 10, 100, 30);
        add(label13);
        setLayout(null);
        setSize(850, 670);
        setLocation(360, 10);
        getContentPane().setBackground(new Color(252, 208, 78));
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox1.getSelectedItem();
        String cast = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = textpan.getText().trim().toUpperCase(); // ensure uppercase
        String adhar = textadhar.getText().trim();
        String scitizen = r1.isSelected() ? "Yes" : r2.isSelected() ? "No" : "";
        String eAccount = r3.isSelected() ? "Yes" : r4.isSelected() ? "No" : "";

        try {
            // Check empty fields
            if (pan.equals("") || adhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields");
                return;
            }

            // PAN validation: 5 letters, 4 digits, 1 letter
            if (!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
                JOptionPane.showMessageDialog(null, "Invalid PAN number.\nFormat must be 5 letters, 4 digits, 1 letter (e.g., ABCDE1234F)");
                return;
            }

            // Optional: Aadhaar validation (12 digits)
            if (!adhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhaar number. Must be exactly 12 digits.");
                return;
            }

            // Insert into database
            ConnectionOfDatabase c1 = new ConnectionOfDatabase();
            String q = "insert into signuptwo values('" + formno + "','" + rel + "','" + cast + "','" + inc + "','" + edu + "','" + occ + "','" + pan + "','" + adhar + "','" + scitizen + "','" + eAccount + "')";
            c1.statement.executeUpdate(q);

            // Move to next signup page
            new SignUp3(formno);
            setVisible(false);

        } catch (Exception E) {
            E.printStackTrace();
        }
    }



    public static void main(String []arg){
        new SignUp2(" ");
    }
}
