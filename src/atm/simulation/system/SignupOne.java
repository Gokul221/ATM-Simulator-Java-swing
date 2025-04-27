package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;

public class SignupOne extends JFrame implements ActionListener {

    long randomFormNumber;
    JButton next;
    JTextField nameTextField, fatherNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JRadioButton male, female, otherGender, married, unmarried, other;
    JDateChooser dateChooser;

    public SignupOne() {

        setLayout(null);

        Random random = new Random();
        randomFormNumber = Math.abs((random.nextLong() % 9000L) + 1000L);

        JLabel formNumber = new JLabel("APPLICATION FORM NO. " + randomFormNumber);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formNumber.setBounds(140, 20, 600, 40);
        add(formNumber);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        // Name
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        // Father's name
        JLabel fatherName = new JLabel("Father's name: ");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fatherNameTextField.setBounds(300, 190, 400, 30);
        add(fatherNameTextField);

        // DoB
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);

        // Email
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 290, 250, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 290, 400, 30);
        add(emailTextField);

        // Gender
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 340, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.PLAIN, 16));
        male.setBounds(300, 340, 100, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 16));
        female.setBounds(450, 340, 100, 30);
        add(female);

        otherGender = new JRadioButton("Other");
        otherGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        otherGender.setBounds(600, 340, 100, 30);
        add(otherGender);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGender);

        // Marital Status
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.PLAIN, 16));
        married.setBounds(300, 390, 150, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.PLAIN, 16));
        unmarried.setBounds(450, 390, 150, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.PLAIN, 16));
        other.setBounds(600, 390, 150, 30);
        add(other);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        maritalStatusGroup.add(other);

        // Address
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        // City
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        // State
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        // Pin Code
        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCodeTextField.setBounds(300, 590, 150, 30);
        add(pinCodeTextField);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(620, 660, 100, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(173, 216, 230));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    // Precompiled regex patterns for faster performance
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\S+@\\S+\\.\\S+$");
    private static final Pattern PIN_PATTERN = Pattern.compile("\\d{6}");

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNumber = "" + randomFormNumber;      // convert long into string to store in DB
        String name = nameTextField.getText();
        String fatherName = fatherNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (otherGender.isSelected()) {
            gender = "Other";
        }

        String email = emailTextField.getText();
        String maritalStatus = null;
        if (married.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (other.isSelected()) {
            maritalStatus = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinCodeTextField.getText();

        // Use precompiled regex patterns
        boolean isEmailValid = EMAIL_PATTERN.matcher(email).matches();
        boolean isPinValid = PIN_PATTERN.matcher(pin).matches();

        if (name.isBlank()) {
            JOptionPane.showMessageDialog(null, "Name is required");
        } else if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Date of Birth is required");
        } else if (email.isBlank()) {
            JOptionPane.showMessageDialog(null, "Email is required");
        } else if (!isEmailValid) {
            JOptionPane.showMessageDialog(null, "Enter valid Email address");
        } else if (gender == null) {
            JOptionPane.showMessageDialog(null, "Gender is required");
        } else if (address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Address is required");
        } else if (city.isBlank()) {
            JOptionPane.showMessageDialog(null, "City is required");
        } else if (state.isBlank()) {
            JOptionPane.showMessageDialog(null, "State is required");
        } else if (pin.isBlank()) {
            JOptionPane.showMessageDialog(null, "Pin Code is required");
        } else if (!isPinValid) {
            JOptionPane.showMessageDialog(null, "Enter valid 6-digit Pin Code");
        } else {
            // try-with-resources block to avoid memory leaks - DB connections and prepared statements are auto closed
            try (DBconnection conn1 = new DBconnection(); 
                    PreparedStatement pstmt = conn1.c.prepareStatement(
                    "INSERT INTO signup (form_number, user_name, father_name, dob, gender, email, marital_status, address, city, state, pin) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            )) {
                pstmt.setString(1, formNumber);
                pstmt.setString(2, name);
                pstmt.setString(3, fatherName);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, maritalStatus);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, state);
                pstmt.setString(11, pin);

                pstmt.executeUpdate();

                setVisible(false);
                new SignupTwo(formNumber).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
