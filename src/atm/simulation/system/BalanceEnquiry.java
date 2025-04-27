package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    public BalanceEnquiry(String pinNo) {
        this.pinNumber = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(355, 516, 150, 35);
        back.addActionListener(this);
        image.add(back);

        DBconnection conn = new DBconnection();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "' ");
            while (rs.next()) {
                if (rs.getString("transactionType").trim().equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel text = new JLabel("Your account balance is Rs. " + balance);
        text.setForeground(Color.white);
        text.setFont(new Font("Tahoma", Font.BOLD, 16));
        text.setBounds(180, 350, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
