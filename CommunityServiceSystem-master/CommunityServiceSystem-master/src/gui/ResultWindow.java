package gui;



import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;



import javax.swing.ButtonGroup;

import javax.swing.JFrame;



import people.Person;

import system.ChesSystem;

import javax.swing.JRadioButton;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.SwingConstants;

import javax.swing.JTextField;

import javax.swing.JTextPane;



public class ResultWindow extends JFrame{

	ArrayList<JRadioButton> buttons;

	ArrayList<Person> matches;

	ChesSystem ches;

	private JTextField choiceField;

	public ResultWindow(ArrayList<Person> matches, ChesSystem ches) {

		setSize(1200,1000);

		getContentPane().setLayout(null);

		this.matches=matches;

		this.ches=ches;

		setVisible(true);



		JButton btnSubmit = new JButton("Accept Match");

		btnSubmit.setBounds(236, 427, 199, 41);



		btnSubmit.addActionListener(new ButtonListener());



		getContentPane().add(btnSubmit);



		JLabel lblNewLabel = new JLabel("Select the match you would like to accept.");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setForeground(Color.BLACK);

		lblNewLabel.setBounds(0, 0, 642, 33);

		getContentPane().add(lblNewLabel);



		choiceField = new JTextField();

		choiceField.setBounds(295, 379, 64, 39);

		getContentPane().add(choiceField);

		choiceField.setColumns(10);



		JLabel lblNumberCorespondingTo = new JLabel("Choice #");

		lblNumberCorespondingTo.setHorizontalAlignment(SwingConstants.CENTER);

		lblNumberCorespondingTo.setBounds(0, 340, 642, 33);

		getContentPane().add(lblNumberCorespondingTo);



		StringBuilder output=new StringBuilder();

		if (matches.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No matches currently found."
					+ " Please try again at a later time.");

			new Menu(ches);

		}
		else {

			for(int c=0; c<matches.size();c++) {

				output.append(c+1+". "+matches.get(c));

			}



			JTextPane textPane = new JTextPane();

			textPane.setBounds(0, 47, 642, 293);

			getContentPane().add(textPane);

			textPane.setText(output.toString());

		}

		ButtonGroup group = new ButtonGroup();



	}



	private class ButtonListener implements ActionListener{



		@Override

		public void actionPerformed(ActionEvent event) {


			matches.get(Integer.valueOf(choiceField.getText())-1).removeAllAvailability();

			new Menu(ches);
			dispose();

		}



	}

}