package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton hundredRs, fiveHundredRs, oneThousandRs, twoThousandRs, fiveThousandRs, tenThousandRs, back;
    String pinNumber;

    public FastCash(String pin) {
        this.pinNumber = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        add(image);

        JLabel text = new JLabel("Select Withdrawal amount");
        text.setBounds(230, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        hundredRs = new JButton("Rs. 100");
        hundredRs.setBounds(160, 415, 170, 35);
        hundredRs.setFont(new Font("System", Font.BOLD, 12));
        hundredRs.addActionListener(this);
        image.add(hundredRs);

        fiveHundredRs = new JButton("Rs. 500");
        fiveHundredRs.setBounds(345, 415, 170, 35);
        fiveHundredRs.setFont(new Font("System", Font.BOLD, 12));
        fiveHundredRs.addActionListener(this);
        image.add(fiveHundredRs);

        oneThousandRs = new JButton("Rs. 1000");
        oneThousandRs.setBounds(160, 449, 170, 35);
        oneThousandRs.setFont(new Font("System", Font.BOLD, 12));
        oneThousandRs.addActionListener(this);
        image.add(oneThousandRs);

        twoThousandRs = new JButton("Rs. 2000");
        twoThousandRs.setBounds(345, 449, 170, 35);
        twoThousandRs.setFont(new Font("System", Font.BOLD, 12));
        twoThousandRs.addActionListener(this);
        image.add(twoThousandRs);

        fiveThousandRs = new JButton("Rs. 5000");
        fiveThousandRs.setBounds(160, 483, 170, 35);
        fiveThousandRs.setFont(new Font("System", Font.BOLD, 12));
        fiveThousandRs.addActionListener(this);
        image.add(fiveThousandRs);

        tenThousandRs = new JButton("Rs. 10000");
        tenThousandRs.setBounds(345, 483, 170, 35);
        tenThousandRs.setFont(new Font("System", Font.BOLD, 12));
        tenThousandRs.addActionListener(this);
        image.add(tenThousandRs);

        back = new JButton("Back");
        back.setBounds(345, 517, 170, 35);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);

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
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4);
            DBconnection conn = new DBconnection();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "' ");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("transactionType").trim().equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String query = "insert into bank values('" + pinNumber + "', '" + timestamp + "', 'Withdrawal', '" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully!");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
