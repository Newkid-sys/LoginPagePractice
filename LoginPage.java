package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();//Frame for the GUI
    JButton loginButton = new JButton("Login");//Buttons for login
    JButton resetButton = new JButton("Reset");//Buttons for reset
    JTextField userIDField = new JTextField();//For username
    JPasswordField userPasswordField = new JPasswordField();//Password field
    JLabel userIDLabel = new JLabel("User ID: ");//Label for username or id
    JLabel userPasswordLabel = new JLabel("Password: ");//Label for password
    JLabel messageLabel = new JLabel();//Provides message on whether it would fail or not
    HashMap<String, String> loginPageInfo = new HashMap<String, String>();

    public LoginPage(HashMap<String, String> originalLoginPageInfo){

        loginPageInfo = originalLoginPageInfo;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,125,75,75);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);


        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton){

            String userID = userIDField.getText();//Get the text of username from the user and assign it to String User ID
            String passWord = String.valueOf(userPasswordField.getPassword());//Converts password you enter and assign it to a String password.

            if (loginPageInfo.containsKey(userID)){
                if (loginPageInfo.get(userID).equals(passWord)){
                    messageLabel.setForeground(Color.CYAN);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Login info doesn't exist");
            }
        }

    }
}
