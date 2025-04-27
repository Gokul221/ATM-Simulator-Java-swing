package atm.simulation.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinNumber;

    public Withdrawal(String pin) {
        this.pinNumber = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw:");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        text.setBounds(175, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 20));
        amount.setBounds(170, 350, 320, 30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("System", Font.BOLD, 18));
        withdraw.setBounds(355, 483, 150, 35);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if (ae.getSource() == withdraw) {
            String amtNumber = amount.getText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            if (amtNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount number");
            } else {
                try {
                    DBconnection conn = new DBconnection();
                    ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "' ");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("transactionType").trim().equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amtNumber)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = "INSERT INTO bank VALUES ('" + pinNumber + "', '" + timestamp + "', 'Withdrawal', '" + amtNumber + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amtNumber + " Withdrawn successfully!");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
