package atm.simulation.system;

import javax.swing.*;   // swing: platform-independent more powerful GUI toolkit
import java.awt.*;      // awt: platform-dependent GUI toolkit
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardNumberTextField;
    JPasswordField pinTextField;

    public Login() {

        setTitle("Automated Teller Machine");
        setLayout(null);    // disables Layout manager

        // select image from system and convert it into an icon
        ImageIcon imageObject1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));

        // extract Image object from imageObject1 and resize it
        Image imageObject2 = imageObject1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        // wrapping the scaled imageObject2 back into icon so it can be used into JLabel
        ImageIcon imageObject3 = new ImageIcon(imageObject2);

        JLabel label = new JLabel(imageObject3);
        label.setBounds(120, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM!");
        text.setFont(new Font("Tahoma", Font.BOLD, 38));
        text.setBounds(240, 40, 400, 40);
        add(text);

        JLabel cardNumber = new JLabel("Card No:");
        cardNumber.setFont(new Font("Tahoma", Font.PLAIN, 28));
        cardNumber.setBounds(120, 150, 150, 40);
        add(cardNumber);

        cardNumberTextField = new JTextField();
        cardNumberTextField.setBounds(300, 150, 230, 40);
        cardNumberTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(cardNumberTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Tahoma", Font.PLAIN, 28));
        pin.setBounds(120, 220, 150, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 40);
        pinTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setFont(new Font("Tahoma", Font.BOLD, 14));
        login.setBackground(new Color(34, 139, 34));
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setBounds(300, 300, 100, 40);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setFont(new Font("Tahoma", Font.BOLD, 14));
        clear.setBackground(new Color(220, 20, 60));
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.setBounds(430, 300, 100, 40);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setFont(new Font("Tahoma", Font.BOLD, 16));
        signup.setBackground(new Color(218, 165, 32));
        signup.setForeground(Color.WHITE);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.setBounds(300, 350, 230, 40);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardNumberTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            DBconnection conn = new DBconnection();
            String cardNumber = cardNumberTextField.getText();
            char[] pinChars = pinTextField.getPassword();
            String pin = new String(pinChars);
            String query = "SELECT * FROM login WHERE cardnumber = '" + cardNumber + "' and pinNumber = '" + pin + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
