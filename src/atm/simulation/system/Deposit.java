package atm.simulation.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinNumber;

    public Deposit(String pin) {
        this.pinNumber = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Deposit:");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        text.setBounds(175, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 20));
        amount.setBounds(170, 350, 320, 30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 18));
        deposit.setBounds(355, 483, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(355, 516, 150, 35);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String amtNumber = amount.getText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            if (amtNumber.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount number");
            } else {
                String query = "INSERT INTO bank (pin, depositDateTime, transactionType, amount) VALUES (?, ?, '   Deposit  ', ?)";

                // try-with-resources block to avoid memory leaks - DB connections and prepared statements are auto closed
                try (DBconnection conn = new DBconnection(); 
                        PreparedStatement pstmt = conn.c.prepareStatement(query)) {

                    pstmt.setString(1, pinNumber);
                    pstmt.setTimestamp(2, timestamp);
                    pstmt.setString(3, amtNumber);

                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Rs. " + amtNumber + " Deposited Successfully!");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error occurred while processing your transaction.");
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
