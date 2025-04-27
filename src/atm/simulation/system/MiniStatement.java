package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    public MiniStatement(String pinNo) {
        this.pinNumber = pinNo;
        setLayout(null);

        JLabel miniStatement = new JLabel();
        miniStatement.setBounds(20, 160, 450, 200);
        miniStatement.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(miniStatement);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Tahoma", Font.BOLD, 20));
        bank.setBounds(170, 30, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setFont(new Font("Tahoma", Font.PLAIN, 16));
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel label = new JLabel("------------------    Last 5 transactions    ------------------");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(20, 120, 400, 20);
        add(label);

        // Fetch and mask card number
        try (DBconnection conn = new DBconnection(); ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pinNumber = '" + pinNumber + "' ")) {

            while (rs.next()) {
                card.setText("Card number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetch account transactions
        try (DBconnection conn = new DBconnection(); PreparedStatement pstmt = conn.c.prepareStatement(
                "SELECT * FROM bank WHERE pin = ? ORDER BY depositDateTime DESC LIMIT 5"
        )) {

            pstmt.setString(1, pinNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                StringBuilder transactions = new StringBuilder("<html>");
                while (rs.next()) {
                    transactions.append(rs.getString("depositDateTime"))
                            .append("&nbsp;&nbsp;|&nbsp;&nbsp;")
                            .append(rs.getString("transactionType"))
                            .append("&nbsp;&nbsp;|&nbsp;&nbsp;")
                            .append(rs.getString("amount"))
                            .append("<br><br>");
                }
                transactions.append("</html>");
                miniStatement.setText(transactions.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.setBounds(300, 400, 150, 35);
        back.addActionListener(this);
        add(back);

        setTitle("Mini Statement");
        setSize(550, 550);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
