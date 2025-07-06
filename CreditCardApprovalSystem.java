import java.awt.*;
import java.awt.event.*;

public class CreditCardApprovalSystem extends Frame implements ActionListener {

    Label heading, nameLabel, ageLabel, incomeLabel, creditScoreLabel, resultLabel;
    TextField nameField, ageField, incomeField, creditScoreField;
    Button checkButton, clearButton;

    public CreditCardApprovalSystem() {
        // Frame properties
        setTitle("Credit Card Approval System");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(Color.LIGHT_GRAY);

        // Heading
        heading = new Label("Credit Card Approval Form", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(80, 50, 300, 30);
        add(heading);

        // Labels and TextFields
        nameLabel = new Label("Name:");
        nameLabel.setBounds(80, 100, 100, 20);
        add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(200, 100, 150, 20);
        add(nameField);

        ageLabel = new Label("Age:");
        ageLabel.setBounds(80, 130, 100, 20);
        add(ageLabel);

        ageField = new TextField();
        ageField.setBounds(200, 130, 150, 20);
        add(ageField);

        incomeLabel = new Label("Monthly Income:");
        incomeLabel.setBounds(80, 160, 100, 20);
        add(incomeLabel);

        incomeField = new TextField();
        incomeField.setBounds(200, 160, 150, 20);
        add(incomeField);

        creditScoreLabel = new Label("Credit Score:");
        creditScoreLabel.setBounds(80, 190, 100, 20);
        add(creditScoreLabel);

        creditScoreField = new TextField();
        creditScoreField.setBounds(200, 190, 150, 20);
        add(creditScoreField);

        // Buttons
        checkButton = new Button("Check Approval");
        checkButton.setBounds(120, 240, 100, 30);
        checkButton.setBackground(Color.GREEN);
        checkButton.addActionListener(this);
        add(checkButton);

        clearButton = new Button("Clear");
        clearButton.setBounds(240, 240, 100, 30);
        clearButton.setBackground(Color.RED);
        clearButton.addActionListener(this);
        add(clearButton);

        // Result label
        resultLabel = new Label("", Label.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(80, 290, 300, 30);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            try {
                int age = Integer.parseInt(ageField.getText());
                double income = Double.parseDouble(incomeField.getText());
                int creditScore = Integer.parseInt(creditScoreField.getText());

                if (age >= 21 && income >= 25000 && creditScore >= 650) {
                    resultLabel.setForeground(Color.BLUE);
                    resultLabel.setText("Congratulations! Credit Card Approved.");
                } else {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Sorry, App Bhad Me jao.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Invalid input! Please enter correct values.");
            }
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            ageField.setText("");
            incomeField.setText("");
            creditScoreField.setText("");
            resultLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new CreditCardApprovalSystem();
    }
}