package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStatement, fastCash, pinChange, balanceEnquiry, exit;
    String pinNumber;

    public Transactions(String pin) {
        this.pinNumber = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160, 415, 170, 35);
        deposit.setFont(new Font("System", Font.BOLD, 12));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(345, 415, 170, 35);
        withdrawal.setFont(new Font("System", Font.BOLD, 12));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(160, 449, 170, 35);
        miniStatement.setFont(new Font("System", Font.BOLD, 12));
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(345, 449, 170, 35);
        fastCash.setFont(new Font("System", Font.BOLD, 12));
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(160, 483, 170, 35);
        pinChange.setFont(new Font("System", Font.BOLD, 12));
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(345, 483, 170, 35);
        balanceEnquiry.setFont(new Font("System", Font.BOLD, 12));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("-- EXIT --");
        exit.setBounds(345, 517, 170, 35);
        exit.setFont(new Font("System", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
