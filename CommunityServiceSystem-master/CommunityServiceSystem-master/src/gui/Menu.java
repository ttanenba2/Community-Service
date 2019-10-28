package gui;

import system.*;
import javax.swing.JFrame;

import javax.swing.JOptionPane;



import system.*;
import people.*;
import gui.*;
import initialClasses.*;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {
	
	private JButton btnAvail;
	private ChesSystem ches;


	public Menu(ChesSystem ches) {
		setSize(1200,1000);
		
		setVisible(true);
		
		this.ches=ches;
		getContentPane().setLayout(null);
		
		if(ches.getCurrentPerson() instanceof Recipient){
			btnAvail = new JButton("Add Request");
		}
		else {
			btnAvail = new JButton("Add Availability");
		}
		btnAvail.setBounds(105, 218, 211, 111);
		getContentPane().add(btnAvail);
		
		JButton btnMatch = new JButton("Match");
		btnMatch.setBounds(431, 218, 197, 111);
		getContentPane().add(btnMatch);
		
		JLabel lblMessage = new JLabel("Hello "+ches.getCurrentPerson().getName()+"!");
		lblMessage.setForeground(Color.BLUE);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(107, 50, 487, 67);
		getContentPane().add(lblMessage);
		
		JLabel lblOMessage = new JLabel("What can we help you with today?");
		lblOMessage.setForeground(Color.BLUE);
		lblOMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblOMessage.setBounds(105, 111, 523, 33);
		getContentPane().add(lblOMessage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(271, 421, 171, 41);
		getContentPane().add(btnLogout);
		
		btnAvail.addActionListener(new ButtonListener());
		btnMatch.addActionListener(new ButtonListener());
		btnLogout.addActionListener(new ButtonListener());
		
		
		
	}
	
	// submit button listener is a listener class for submit button
		private class ButtonListener implements ActionListener {

			// when action occurs-buttons is clicked
			// this method catches it
			@Override
			public void actionPerformed(ActionEvent e) {
			
				//switch for which button is clicked will bring up window based on this
				switch (e.getActionCommand().toString()) {
				case "Add Availability":
					new AddTimeWindow(ches);
					dispose();
					/*try {
					ches.write();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}*/
					break;
				case "Add Request":
					new AddTimeWindow(ches);
					dispose();
					/*try {
					ches.write();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}*/
					break;
				case "Match":
					matcher();
					break;
				case "Logout":
					System.out.println("Got into the logout case");
					ches.setCurrentPerson(null);
					System.out.println("Before new opening screen.");
					new OpeningScreen(ches);
					System.out.println("After new opening screen");
					dispose();
					break;
					
					default:
						System.out.println("default case");
				}
				

			}

		}
		
		private void matcher() {
			
				ArrayList<Person> matches = ches.findMatches(ches.getCurrentPerson());
				
				if(matches==null) {
					new JOptionPane("No matches are avaiable for you at this time. Please check back at a later date.");
				}
				
				else {
					new ResultWindow(matches, ches);
				}
			
				
				
			
		}
}
