package gui;
import system.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//import gui.Menu.ButtonListener;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class OpeningScreen extends JFrame {
		
	
	private ChesSystem ches;
	
	public OpeningScreen(ChesSystem ches) {
		setSize(1200,1000);
		setVisible(true);
		this.ches=ches;
		
		getContentPane().setLayout(null);
		
		JLabel frontMessage = new JLabel("\tWelcome\r\n");
		frontMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frontMessage.setBounds(0, 0, 418, 43);
		getContentPane().add(frontMessage);
		
		JLabel welNextLine = new JLabel("to the");
		welNextLine.setHorizontalAlignment(SwingConstants.CENTER);
		welNextLine.setBounds(0, 42, 418, 33);
		getContentPane().add(welNextLine);
		
		JLabel lblNewLabel = new JLabel("Chesed Matching System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 75, 418, 33);
		getContentPane().add(lblNewLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(26, 136, 162, 33);
		getContentPane().add(loginButton);
		loginButton.addActionListener( new ButtonListener());
		
		JLabel newUserLabel = new JLabel("New User?");
		newUserLabel.setForeground(Color.RED);
		newUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newUserLabel.setBounds(279, 115, 73, 17);
		getContentPane().add(newUserLabel);
		
		JButton signupButton = new JButton("Signup");
		signupButton.setBounds(230, 136, 162, 33);
		getContentPane().add(signupButton);
		signupButton.addActionListener( new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent act) {
			
			if(act.getActionCommand().equals("Login")) {
				
				//open the login window
				new LoginWindow( ches);
				
				//close current window
				dispose();
			}
			
			//if signing up aka new user
			else {
				//direct to form
				new InfoWindow(ches);
				
				//close current window
				dispose();
			}
			
		}
		
	}
}
