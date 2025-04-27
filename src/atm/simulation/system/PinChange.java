package atm.simulation.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinField, reEnterPinField;
    JButton change, back;
    String pinNumber;

    public PinChange(String pinNo) {
        this.pinNumber = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("Tahoma", Font.BOLD, 16));
        text.setBounds(270, 300, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("Set New PIN:");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pinText.setBounds(180, 362, 180, 25);
        image.add(pinText);

        pinField = new JPasswordField();
        pinField.setFont(new Font("Tahoma", Font.BOLD, 16));
        pinField.setBounds(300, 360, 180, 30);
        image.add(pinField);

        JLabel reEnterPinText = new JLabel("Re-enter PIN:");
        reEnterPinText.setForeground(Color.white);
        reEnterPinText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        reEnterPinText.setBounds(180, 392, 180, 25);
        image.add(reEnterPinText);

        reEnterPinField = new JPasswordField();
        reEnterPinField.setFont(new Font("Tahoma", Font.BOLD, 16));
        reEnterPinField.setBounds(300, 390, 180, 30);
        image.add(reEnterPinField);

        change = new JButton("Change");
        change.setFont(new Font("Tahoma", Font.BOLD, 16));
        change.setBounds(360, 485, 150, 35);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(360, 517, 150, 35);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {
            try {
                char[] newPinChars = pinField.getPassword();
                String newPin = new String(newPinChars);
                char[] rePinChars = reEnterPinField.getPassword();
                String rePin = new String(rePinChars);

                if (!newPin.equals(rePin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (newPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if (rePin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                DBconnection conn = new DBconnection();
                String query1 = "update bank set pin = '" + rePin + "' where pin = '" + pinNumber + "' ";
                String query2 = "update login set pinNumber = '" + rePin + "' where pinNumber = '" + pinNumber + "' ";
                String query3 = "update signupthree set pinNumber = '" + rePin + "' where pinNumber = '" + pinNumber + "' ";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully!!");
                setVisible(false);
                new Transactions(rePin).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
