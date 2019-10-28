package gui;

import javax.swing.JFrame;

import system.ChesSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import people.Person;
import people.Recipient;
import javax.swing.JComboBox;

public class AddTimeWindow extends JFrame {
	
	ChesSystem ches;
	
	JComboBox dayBox;
	
	JComboBox timeStartBox;
	
	JComboBox timeEndBox;
	
	public AddTimeWindow(ChesSystem ches) {
		
		setSize(1200,1000);
		this.ches=ches;
		getContentPane().setLayout(null);
		setVisible(true);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(265, 236, 171, 41);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ButtonListener());
		
		JLabel lblNewLabel = new JLabel("Time & Date");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 15, 716, 33);
		getContentPane().add(lblNewLabel);
		
		String[] days= {"Sunday", "Monday", "Tuesday", "Wednesday", "Thurdsday", "Friday", "Saturday"};
		dayBox = new JComboBox(days);
		dayBox.setBounds(47, 102, 224, 39);
		getContentPane().add(dayBox);
		
		String[] hours= {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		JLabel lblDat = new JLabel("Day of Week");
		lblDat.setBounds(90, 64, 150, 33);
		getContentPane().add(lblDat);
		
		timeStartBox = new JComboBox(hours);
		timeStartBox.setBounds(401, 102, 52, 39);
		getContentPane().add(timeStartBox);
		
		 timeEndBox = new JComboBox(hours);
		timeEndBox.setBounds(553, 102, 52, 39);
		getContentPane().add(timeEndBox);
		
		JLabel lblNewLabel_1 = new JLabel("Start");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(370, 139, 115, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(502, 139, 150, 33);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Time");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(448, 64, 115, 33);
		getContentPane().add(lblNewLabel_3);
	}
	
	
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent action) {
			
			System.out.println("beginning of action performed method.");
			
			ches.getCurrentPerson().addAvailability((String)dayBox.getSelectedItem(), Integer.valueOf((String)timeStartBox.getSelectedItem()), Integer.valueOf((String)timeEndBox.getSelectedItem()));
			
			System.out.println("availability added");
			new Menu(ches);
			dispose();
		}
		
	}
}
