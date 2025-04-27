package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JButton next;
    JTextField aadharTextField, panTextField;
    JComboBox religionDropDown, categoryDropDown, incomeDropDown, educationDropDown, occupationDropDown;
    JRadioButton srCitizenYes, srCitizenNo, existingAccYes, existingAccNo;
    String formNumber;
    
    public SignupTwo(String formNumber) {
        this.formNumber = formNumber;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel religionLabel = new JLabel("Religion: ");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);
        
        String religionArr[] = {"-- Select Religion --", "Hindu", "Jain", "Sikh", "Parsi", "Christian", "Muslim", "Other"};
        religionDropDown = new JComboBox(religionArr);
        religionDropDown.setBounds(300, 140, 400, 30);
        add(religionDropDown);

        // Category
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 120, 30);
        add(categoryLabel);
        
        String categoryArr[] = {"-- Select Category --", "General", "OBC", "SC", "ST", "Other"};
        categoryDropDown = new JComboBox(categoryArr);
        categoryDropDown.setBounds(300, 190, 400, 30);
        add(categoryDropDown);

        // Income
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String incomeArr[] = {"-- Select Income --", "Null", "less than 1,50,000", "less than 2,50,000", "less than 5,00,000", "Upto 10,00,000"};
        incomeDropDown = new JComboBox(incomeArr);
        incomeDropDown.setBounds(300, 240, 400, 30);
        add(incomeDropDown);

        // Education
        JLabel educationLabel = new JLabel("Education: ");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 250, 30);
        add(educationLabel);
        
        String educationArr[] = {"-- Select Education Level --", "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationDropDown = new JComboBox(educationArr);
        educationDropDown.setBounds(300, 290, 400, 30);
        add(educationDropDown);

        // Occupation
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);
        
        String occupationArr[] = {"-- Select Occupation --", "Student", "Salaried", "Self-Employed", "Business", "Retired", "Other"};
        occupationDropDown = new JComboBox(occupationArr);
        occupationDropDown.setBounds(300, 340, 400, 30);
        add(occupationDropDown);

        // PAN Number
        JLabel panNumber = new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100, 390, 200, 30);
        add(panNumber);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        // Aadhaar Number
        JLabel aadhaarNumber = new JLabel("Aadhaar Number: ");
        aadhaarNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaarNumber.setBounds(100, 440, 200, 30);
        add(aadhaarNumber);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        // Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 490, 200, 30);
        add(seniorCitizen);
        
        srCitizenYes = new JRadioButton("Yes");
        srCitizenYes.setFont(new Font("Raleway", Font.BOLD, 14));
        srCitizenYes.setBounds(300, 490, 100, 30);
        add(srCitizenYes);
        
        srCitizenNo = new JRadioButton("No");
        srCitizenNo.setFont(new Font("Raleway", Font.BOLD, 14));
        srCitizenNo.setBounds(450, 490, 100, 30);
        add(srCitizenNo);
        
        ButtonGroup srCitizenGroup = new ButtonGroup();
        srCitizenGroup.add(srCitizenYes);
        srCitizenGroup.add(srCitizenNo);

        // Existing Account
        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 540, 200, 30);
        add(existingAccount);
        
        existingAccYes = new JRadioButton("Yes");
        existingAccYes.setFont(new Font("Raleway", Font.BOLD, 14));
        existingAccYes.setBounds(300, 540, 100, 30);
        add(existingAccYes);
        
        existingAccNo = new JRadioButton("No");
        existingAccNo.setFont(new Font("Raleway", Font.BOLD, 14));
        existingAccNo.setBounds(450, 540, 100, 30);
        add(existingAccNo);
        
        ButtonGroup existingAccGroup = new ButtonGroup();
        existingAccGroup.add(existingAccYes);
        existingAccGroup.add(existingAccNo);
        
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
    private static final Pattern PAN_NUMBER_PATTERN = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
    private static final Pattern AADHAAR_NUMBER_PATTERN = Pattern.compile("^\\d{4}\\d{4}\\d{4}$");
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionDropDown.getSelectedItem();
        String category = (String) categoryDropDown.getSelectedItem();
        String income = (String) incomeDropDown.getSelectedItem();
        String education = (String) educationDropDown.getSelectedItem();
        String occupation = (String) occupationDropDown.getSelectedItem();
        
        String seniorCitizen = null;
        if (srCitizenYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (srCitizenNo.isSelected()) {
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if (existingAccYes.isSelected()) {
            existingAccount = "Yes";
        } else if (existingAccNo.isSelected()) {
            existingAccount = "No";
        }
        
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        // Use precompiled regex patterns
        boolean isPanValid = PAN_NUMBER_PATTERN.matcher(pan).matches();
        boolean isAadharValid = AADHAAR_NUMBER_PATTERN.matcher(aadhar).matches();
        
        try {
            if (religion == null || religion.equals("-- Select Religion --")) {
                JOptionPane.showMessageDialog(null, "Please select Religion");
                
            } else if (category == null || category.equals("-- Select Category --")) {
                JOptionPane.showMessageDialog(null, "Please select Category");
                
            } else if (income == null || income.equals("-- Select Income --")) {
                JOptionPane.showMessageDialog(null, "Please select Income");
                
            } else if (occupation == null || occupation.equals("-- Select Occupation --")) {
                JOptionPane.showMessageDialog(null, "Please select Occupation");
                
            } else if (!isPanValid) {
                JOptionPane.showMessageDialog(null, "Please enter valid 10-digit PAN number");
                
            } else if (!isAadharValid) {
                JOptionPane.showMessageDialog(null, "Please enter valid 12-digit Aadhaar number");
                
            } else if (seniorCitizen == null) {
                JOptionPane.showMessageDialog(null, "Please select whether you are a senior citizen");
                
            } else if (existingAccount == null) {
                JOptionPane.showMessageDialog(null, "Please select whether you have an existing account");
                
            } else {
                DBconnection conn = new DBconnection();
                String query = "INSERT INTO signuptwo VALUES('" + formNumber + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + seniorCitizen + "', '" + existingAccount + "', '" + pan + "', '" + aadhar + "' )";
                conn.s.executeUpdate(query);

                // signupThree object
                setVisible(false);
                new SignupThree(formNumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
