package model;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class WelcomeGUI {
	private JFrame welcomeFrame = new JFrame("Welcome");
	private JLabel welcomeText = new JLabel("Welcome to Our Healthy Eating App!");
	private JTextField userNameBox = new JTextField("Enter Name");
	private JButton loginButton = new JButton("Sign in");

	public WelcomeGUI() {

		// Creates welcomeText Object
		welcomeText.setBounds(150, 40, 600, 100);
		welcomeText.setFont(new Font("Serif", Font.PLAIN, 30));

		// Creates Textbox to enter User's Name
		userNameBox.setBounds(275, 150, 200, 30);
		;
		userNameBox.addFocusListener(new FocusListener() {

			// This removes placeholder text when you click on textbox
			@Override
			public void focusGained(FocusEvent e) {
				if (userNameBox.getText().equals("Enter Name")) {
					userNameBox.setText("");
				}

			}

			// When you click out of the textbox the placeholder text returns
			@Override
			public void focusLost(FocusEvent e) {
				if (userNameBox.getText().equals("")) {
					userNameBox.setText("Enter Name");

				}

			}

		});

		// Creates Button to login
		loginButton.setBounds(325, 225, 100, 40);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userNameBox.getText().equals("") ||
						userNameBox.getText().equals("Enter Name") ||
						userNameBox.getText().equals("ENTER YOUR NAME!")) {
					userNameBox.setText("ENTER YOUR NAME!");
				} else {
					String userName = userNameBox.getText();
					welcomeFrame.dispose();
					new MainGUI(userName);
				}

			}

		});

		// Adding components to the JFrame
		welcomeFrame.add(welcomeText);
		welcomeFrame.add(userNameBox);
		welcomeFrame.add(loginButton);

		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setTitle("Healthy Eating App");
		welcomeFrame.setSize(800, 450);
		welcomeFrame.setLayout(null);
		welcomeFrame.setLocationRelativeTo(null);
		welcomeFrame.setResizable(false);
		welcomeFrame.setVisible(true);

	}

	public static void main(String[] args) {
		new WelcomeGUI();
	}
}
