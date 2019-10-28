package gui;
import system.*;

import system.ChesSystem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ErrorLoginWindow extends LoginWindow {
	
	public ErrorLoginWindow(ChesSystem ches) {
		
		
		super(ches);
		setVisible(true);

		JLabel errorMessageLabel = new JLabel("Email/Password combination do not match our systems records");
		errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessageLabel.setForeground(Color.RED);
		errorMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorMessageLabel.setBounds(0, 54, 430, 33);
		getContentPane().add(errorMessageLabel);
		
		JLabel tryAgainLabel = new JLabel("Try again. Verify that you have an account and all info is correct ");
		tryAgainLabel.setForeground(Color.RED);
		tryAgainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tryAgainLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tryAgainLabel.setBounds(0, 73, 430, 33);
		getContentPane().add(tryAgainLabel);
	}
}
