package model;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MainGUI {
	private static JFrame mainFrame = new JFrame();
	private static JLabel welcomeText = new JLabel();

	public MainGUI(String userName) {

		// Creates welcomeText Object
		welcomeText.setBounds(150, 40, 450, 100);
		welcomeText.setFont(new Font("Arial", Font.PLAIN, 30));

		// Adding components to the JFrame
		welcomeText.setText("Welcome " + userName + "!");
		mainFrame.add(welcomeText);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle(userName + "'s " + "Healthy Eating Dashboard");
		mainFrame.setSize(800, 450);
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}

}