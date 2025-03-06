package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atmgui {
    private double balance = 10000000.0; // Default balance
    private JFrame frame;
    private JTextField amountField;
    private JLabel balanceLabel;

    public atmgui() {
        frame = new JFrame("ATM Machine");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        balanceLabel = new JLabel("Balance: $" + balance, SwingConstants.CENTER);
        frame.add(balanceLabel);

        amountField = new JTextField();
        amountField.setHorizontalAlignment(JTextField.CENTER);
        frame.add(amountField);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(frame, "Deposited: $" + amount);
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Enter a number.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                balanceLabel.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(frame, "Withdrawn: $" + amount);
            } else if (amount > balance) {
                JOptionPane.showMessageDialog(frame, "Insufficient balance!");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Enter a number.");
        }
    }

    public static void main(String[] args) {
        new atmgui();
    }
}