package gui;

import system.*;
import people.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import system.ChesSystem;

import javax.swing.JPasswordField;

public class LoginWindow extends JFrame{
	private JTextField username;
	private JButton submitButton;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel lblPleaseLoginTo;
	private JPasswordField passwordField;
	
	private ChesSystem ches;
	
	public LoginWindow(ChesSystem ches) {
		
		setSize(1200,1000);
		
		setVisible(true);
		this.ches = ches;
		
		//details for content pane
		getContentPane().setVisible(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add components to content pane
		setTextFields();
		setLabels();
		setButton();
	}
	
	private void setTextFields() {
		username = new JTextField();

		
		//settings for the text field
		username.setBounds(95, 128, 236, 39);
		
		username.setColumns(10);

		
		//add text field to content pane
		getContentPane().add(username);
		

	}
	
	public void setButton() {
		
		submitButton = new JButton("Login");
		
		//settings for the button
		submitButton.setBounds(133, 347, 171, 41);
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		
		//add button to content pane
		getContentPane().add(submitButton);
		
		//add a listener to the button
		submitButton.addActionListener(new ButtonListener());
		
		lblPleaseLoginTo = new JLabel("Please Login to Continue");
		lblPleaseLoginTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseLoginTo.setBounds(14, 28, 390, 33);
		getContentPane().add(lblPleaseLoginTo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 241, 236, 39);
		getContentPane().add(passwordField);
		
		
		
	}
	
	public void setLabels() {
		 usernameLabel= new JLabel("Username/Email");
		 passwordLabel = new JLabel("Password");

		 //settings for labels
		usernameLabel.setBounds(95, 93, 236, 33);
		passwordLabel.setBounds(84, 206, 247, 33);
		
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		
		//add labels to content pane
		getContentPane().add(usernameLabel);
		getContentPane().add(passwordLabel);

		
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent action) {
			//check login details 
			
			StringBuilder pass = new StringBuilder();
				char[] password = passwordField.getPassword();
				for(int c =0; c<password.length;c++) {
					pass.append(password[c]);
				}
			Person curr = ches.validateLogin(username.getText(),pass.toString());
			
			//if returns an actual person then login was successful and person is set as current person for duration of session (till logout)
			if(curr!=null) {
				
				ches.setCurrentPerson(curr);//set as current person
				
				
				new Menu(ches);
				dispose();
			}
			//if login returned null then was not successful for any reason
			else {
				new ErrorLoginWindow(ches);
				dispose();
			}
		}
		
	}
	
}
