
package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import system.*;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JTextPane;


import gui.Menu;
import initialClasses.Address;
import initialClasses.JobTypeEnum;
import people.Recipient;
import system.ChesSystem;

import javax.swing.JTextField;
import java.util.ArrayList;
public class InfoWindow extends JFrame{
	
	
	
	//panels on content pane
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JTextPane formTitle;
	
	//components on north
	private JPanel nameP;
	private JTextField name;
	private JLabel nameL;
	
	private JPanel numberP;
	private JTextField number;
	private JLabel numberL;
	
	private JPanel streetP;
	private JTextField street;
	private JLabel streetL;
	
	private JPanel cityP;
	private JTextField city;
	private JLabel cityL;
	
	private JPanel stateP;
	private JTextField state;
	private JLabel stateL;
	
	private JPanel zipP;
	private JTextField zip;
	private JLabel zipL;
	
	private JPanel emailP;
	private JTextField email;
	private JLabel emailL;
	
	private JPanel passwordP;
	private JTextField password;
	private JLabel passwordL;
	
	//components on south
	private JButton submitButton;
	private JTextPane txtpnVolunteerForm;
	
	//actual chesed system
	private ChesSystem ches;
	private JTextField vrField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox jobTypeBox;
	
	public InfoWindow( ChesSystem ches  ) {
		this.ches=ches;
		setVisible(true);

		setSize(1200, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//border layout for main pane
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//add panel to to south part of pane
		southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Recipient or Volunteer?");
		southPanel.add(lblNewLabel);
		
		vrField = new JTextField();
		southPanel.add(vrField);
		vrField.setColumns(10);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 27));
		southPanel.add(submitButton);
		
		lblNewLabel_1 = new JLabel("Job Type");
		southPanel.add(lblNewLabel_1);
		
		String[] types = {"Driving", "Cleaning", "Cooking", "VisitingTheSick", "Tutoring", "Babysitting", "Other"};
		jobTypeBox = new JComboBox(types);
		southPanel.add(jobTypeBox);
		
		submitButton.addActionListener(new SubmitButtonListener());
		//add panel with grid layout to center of pane
		centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(4, 2));
		createComponents();
		fillPanel();
		
		//add panel to north part of pane
		northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		//add text to north panel
		formTitle = new JTextPane();
		formTitle.setText("Form");
		northPanel.add(formTitle);
		
		setVisible(true);
	}
	
	private void createComponents() {
		nameP=new JPanel();
		nameP.setLayout(new GridLayout(2,1));
		name=new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 48));
		nameL= new JLabel("Name");
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		nameP.add(nameL);
		nameP.add(name);
		
		
		numberP=new JPanel();
		numberP.setLayout(new GridLayout(2,1));
		number=new JTextField();
		number.setFont(new Font("Tahoma", Font.PLAIN, 48));
		numberL=new JLabel("Phone Number");
		numberL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		numberP.add(numberL);
		numberP.add(number);
		
		
		streetP=new JPanel();
		streetP.setLayout(new GridLayout(2,1));
		street=new JTextField();
		street.setFont(new Font("Tahoma", Font.PLAIN, 48));
		streetL= new JLabel("Address");
		streetL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		streetP.add(streetL);
		streetP.add(street);
		
		
		cityP=new JPanel();
		cityP.setLayout(new GridLayout(2,1));
		city=new JTextField();
		city.setFont(new Font("Tahoma", Font.PLAIN, 48));
		cityL= new JLabel("City");
		cityL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		cityP.add(cityL);
		cityP.add(city);
		
		
		zipP=new JPanel();
		zipP.setLayout(new GridLayout(2,1));
		zip=new JTextField();
		zip.setFont(new Font("Tahoma", Font.PLAIN, 48));
		zipL= new JLabel("Zip Code");
		zipL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		zipP.add(zipL);
		zipP.add(zip);
		
		
		stateP=new JPanel();
		stateP.setLayout(new GridLayout(2,1));
		state=new JTextField();
		state.setFont(new Font("Tahoma", Font.PLAIN, 48));
		stateL= new JLabel("State");
		stateL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		stateP.add(stateL);
		stateP.add(state);
		
		emailP=new JPanel();
		emailP.setLayout(new GridLayout(2,1));
		email=new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 48));
		emailL= new JLabel("Email");
		emailL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		emailP.add(emailL);
		emailP.add(email);
		
		passwordP=new JPanel();
		passwordP.setLayout(new GridLayout(2,1));
		password=new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 48));
		passwordL= new JLabel("Password");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 48));
		passwordP.add(passwordL);
		passwordP.add(password);
		
		
		
		
		
	}
	
	private void fillPanel() {
		centerPanel.add(nameP);
		centerPanel.add(numberP);
		centerPanel.add(streetP);
		centerPanel.add(cityP);
		centerPanel.add(stateP);
		centerPanel.add(zipP);
		centerPanel.add(passwordP);
		centerPanel.add(emailP);
		
	}
	//submit button listener is a listener class for submit button
		private class SubmitButtonListener implements ActionListener{
			
			//when action occurs-buttons is clicked
			//this method catches it
			@Override
			public void actionPerformed(ActionEvent e) {
				String n =name.getText();
				
				String streetA=street.getText();
				String cityA=city.getText();
				String stateA=state.getText();
				String zipA=zip.getText();
				String num=number.getText();
				String em=email.getText();
				String pword = password.getText();
				//String dayS=day.getText();
				//int hr=Integer.valueOf(hour.getSelectedItem().toString());
				if(vrField.getText().equalsIgnoreCase("Volunteer")) {
				

					ches.addVolunteer(n, new Address(streetA, cityA, stateA, zipA),num,JobTypeEnum.valueOf((jobTypeBox.getSelectedItem()).toString()),  em, pword );
			
				JOptionPane.showMessageDialog(null,  "Volunteer Successfully Added");
				
				
				new LoginWindow(ches);
				dispose();
				
				
				}
				else {
					
					ches.addRecipient(n, new Address(streetA, cityA, stateA, zipA),num, JobTypeEnum.valueOf((jobTypeBox.getSelectedItem()).toString()), em, pword );
					
					JOptionPane.showMessageDialog(null,  "Recipient Successfully Added");
					
					//ches.setCurrentPerson(rep);
					new LoginWindow(ches);
					dispose();
				}
				
			}
			
		}

}
