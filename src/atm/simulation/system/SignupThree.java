package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccRb, currAccRb, fixedDepositAccRb, recurringDepostAccRb;
    JCheckBox atmCardCb, internetBankingCb, mobileBankingCb, alertsCb, chequeBookCb, eStatementCb, declarationCb;
    JButton submit, cancel;
    String formNumber;

    public SignupThree(String formNumber) {
        this.formNumber = formNumber;
        setLayout(null);
        JLabel label1 = new JLabel("Page 3: Account Details");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(280, 40, 400, 40);
        add(label1);

        // Account Type
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

        savingAccRb = new JRadioButton("Savings Account");
        savingAccRb.setFont(new Font("Raleway", Font.PLAIN, 16));
        savingAccRb.setBounds(120, 190, 180, 20);
        add(savingAccRb);

        fixedDepositAccRb = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccRb.setFont(new Font("Raleway", Font.PLAIN, 16));
        fixedDepositAccRb.setBounds(400, 190, 220, 20);
        add(fixedDepositAccRb);

        currAccRb = new JRadioButton("Current Account");
        currAccRb.setFont(new Font("Raleway", Font.PLAIN, 16));
        currAccRb.setBounds(120, 240, 180, 20);
        add(currAccRb);

        recurringDepostAccRb = new JRadioButton("Recurring Deposit Account");
        recurringDepostAccRb.setFont(new Font("Raleway", Font.PLAIN, 16));
        recurringDepostAccRb.setBounds(400, 240, 260, 20);
        add(recurringDepostAccRb);

        ButtonGroup accTypeGroup = new ButtonGroup();
        accTypeGroup.add(savingAccRb);
        accTypeGroup.add(currAccRb);
        accTypeGroup.add(fixedDepositAccRb);
        accTypeGroup.add(recurringDepostAccRb);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(100, 300, 200, 30);
        add(cardNumber);

        JLabel numberLabel = new JLabel("5040-XXXX-XXXX-XXXX");
        numberLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        numberLabel.setBounds(330, 300, 300, 30);
        add(numberLabel);

        JLabel cardNumberInfo = new JLabel("(Your 16-digit card number)");
        cardNumberInfo.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardNumberInfo.setBounds(330, 330, 300, 20);
        add(cardNumberInfo);

        JLabel pinNumber = new JLabel("PIN:");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(100, 370, 200, 30);
        add(pinNumber);

        JLabel pinLabel = new JLabel("XXXX");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        pinLabel.setBounds(330, 370, 300, 30);
        add(pinLabel);

        JLabel pinInfo = new JLabel("(Your 4-digit account password)");
        pinInfo.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinInfo.setBounds(330, 400, 300, 20);
        add(pinInfo);

        JLabel servicesRequired = new JLabel("Services required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(100, 450, 300, 20);
        add(servicesRequired);

        atmCardCb = new JCheckBox("ATM Card");
        atmCardCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        atmCardCb.setBounds(120, 500, 200, 30);
        add(atmCardCb);

        internetBankingCb = new JCheckBox("Internet Banking");
        internetBankingCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        internetBankingCb.setBounds(400, 500, 200, 30);
        add(internetBankingCb);

        mobileBankingCb = new JCheckBox("Mobile Banking");
        mobileBankingCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        mobileBankingCb.setBounds(120, 550, 200, 30);
        add(mobileBankingCb);

        alertsCb = new JCheckBox("Email & SMS alerts");
        alertsCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        alertsCb.setBounds(400, 550, 200, 30);
        add(alertsCb);

        chequeBookCb = new JCheckBox("Cheque Book");
        chequeBookCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        chequeBookCb.setBounds(120, 600, 200, 30);
        add(chequeBookCb);

        eStatementCb = new JCheckBox("E-statement");
        eStatementCb.setFont(new Font("Raleway", Font.PLAIN, 16));
        eStatementCb.setBounds(400, 600, 200, 30);
        add(eStatementCb);

        declarationCb = new JCheckBox("I hereby declare that the above entered details are correct and true to the best of my knowledge.");
        declarationCb.setFont(new Font("Raleway", Font.BOLD, 12));
        declarationCb.setBounds(100, 680, 650, 30);
        add(declarationCb);

        submit = new JButton("Submit");
        submit.setBackground(new Color(34, 139, 34));
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(260, 720, 120, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(220, 20, 60));
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(460, 720, 120, 40);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(173, 216, 230));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String accountType = null;
            if (savingAccRb.isSelected()) {
                accountType = "Savings Account";
            } else if (currAccRb.isSelected()) {
                accountType = "Current Account";
            } else if (fixedDepositAccRb.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurringDepostAccRb.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Choose account type");
            } else if (!declarationCb.isSelected()) {
                JOptionPane.showMessageDialog(null, "You must agree to the declaration");
            } else {
                StringBuilder selectedServices = new StringBuilder();

                if (atmCardCb.isSelected()) {
                    selectedServices.append("ATM Card");
                }
                if (internetBankingCb.isSelected()) {
                    selectedServices.append("Internet Banking");
                }
                if (mobileBankingCb.isSelected()) {
                    selectedServices.append("Mobile Banking");
                }
                if (alertsCb.isSelected()) {
                    selectedServices.append("Email & SMS alerts");
                }
                if (chequeBookCb.isSelected()) {
                    selectedServices.append("Cheque Book");
                }
                if (eStatementCb.isSelected()) {
                    selectedServices.append("E-Statement");
                }

                // try-with-resources block to avoid memory leaks - DB connections and prepared statements are auto closed
                try (DBconnection conn3 = new DBconnection(); 
                        PreparedStatement pstmt1 = conn3.c.prepareStatement(
                        "INSERT INTO signupthree (formNumber, accountType, cardNumber, pinNumber, servicesSelected) VALUES (?, ?, ?, ?, ?)"
                );      PreparedStatement pstmt2 = conn3.c.prepareStatement(
                        "INSERT INTO login (formNumber, cardNumber, pinNumber) VALUES (?, ?, ?)"
                )) {
                    // Insert into signupthree
                    pstmt1.setString(1, formNumber);
                    pstmt1.setString(2, accountType);
                    pstmt1.setString(3, cardNumber);
                    pstmt1.setString(4, pinNumber);
                    pstmt1.setString(5, selectedServices.toString());
                    pstmt1.executeUpdate();

                    // Insert into login
                    pstmt2.setString(1, formNumber);
                    pstmt2.setString(2, cardNumber);
                    pstmt2.setString(3, pinNumber);
                    pstmt2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pinNumber);
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
                }
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignupThree("");
    }
}
