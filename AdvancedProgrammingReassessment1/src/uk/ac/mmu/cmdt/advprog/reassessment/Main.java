package uk.ac.mmu.cmdt.advprog.reassessment;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class MainInterface {
	
	MainInterface()
	{

		JFrame frame=new JFrame();
		DB db = new DB();

		//Configure the labels
		JLabel searchMode=new JLabel("Search Mode");
		searchMode.setBounds(50,70,80,50);
		JLabel searchFor=new JLabel("Search For");
		searchFor.setBounds(320,70,100,50);
		JLabel results=new JLabel("Results: ");
		results.setBounds(10,300,150,50);

		//Create a JTextField
		JTextField searchText=new JTextField();
		searchText.setBounds(450,70, 300,30);

		//create the search button
		JButton searchButton=new JButton("Search");
		searchButton.setBounds(850,70,100,30);


		//Configure the Radio Buttons for the search Criteria
		JRadioButton searchByCity=new JRadioButton("Search By City");
		searchByCity.setBounds(50,150,200,10);
		JRadioButton searchByPostCode=new JRadioButton("Search By PostCode");
		searchByPostCode.setBounds(50,200,200,10);
		JRadioButton searchByLocation=new JRadioButton("Search By Location");
		searchByLocation.setBounds(50,250,200,10);



		ButtonGroup searchesGroup=new ButtonGroup();
		searchesGroup.add(searchByCity);searchesGroup.add(searchByPostCode);
		searchesGroup.add(searchByLocation);

		//Configure the  Result table

	

		Object[] resultCols = {"Site Name", "Address Line 1","Address Line 2","Address Line 3","City","Postcode","Region","Type"};
		Object[][] info= {};
		
		
		
		

		//Setup a JTable
		DefaultTableModel tableModel = new DefaultTableModel(info,resultCols); //Initialise a  preconfigured model
		JTable result=new JTable();
		result.setBackground(Color.lightGray);
		result.setForeground(Color.blue);
		result.setModel(tableModel);
		result.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); //Allow the width of the columns to appear dynamically
		result.setBounds(50,350,1000,500);
		JScrollPane js=new JScrollPane(result); //Allow the table to be scrollable
		js.setBounds(result.getBounds());
		result.setAutoCreateRowSorter(true); // Allow the rows to be sorted
	


		//add the children to the JFrame
		frame.add(searchMode);frame.add(searchFor);frame.add(searchText);frame.add(searchButton);frame.add(searchByCity);frame.add(searchByPostCode);frame.add(searchByLocation);
		frame.add(results);frame.getContentPane().add(js);


		frame.setSize(2500,1000);
		frame.setTitle("Vaccination Site Finder");
		frame.setLayout(null);
		frame.setResizable(true);

		frame.setVisible(true);


		//Create an event listener when the search button is pressed
		searchButton.addActionListener(e -> {
			//Checks if the Search By City Radio Button is selected
			if(searchByCity.isSelected())
			{
			
				String[][] info1 =db.randomTrials(searchText.getText());//OBtain the data from the database
				int numRows=info1.length; //Obtain the length of the returned rows
				int numCols=tableModel.getColumnCount();
				tableModel.setRowCount(0); //Delete every row on the JTable
				
				for(int row=0;row<numRows;row++)
				{
					Object[] reqRow=(Object[])info1[row];
					tableModel.addRow(reqRow); 
							
				}
				
				
				



			}
			//Checks if the search By PostCode is selected
			else if(searchByPostCode.isSelected())
			{
				String[][] info1 =db.searchByPostCode(searchText.getText());
				int numRows=info1.length;
				int numCols=tableModel.getColumnCount();
				tableModel.setRowCount(0); //Delete the rows in the JTable
				for(int row=0;row<numRows;row++)
				{
					Object[] reqRow=(Object[])info1[row];
					tableModel.addRow(reqRow); //Add the row to the JTable
							
				}
				
				
				
			}
			else if(searchByLocation.isSelected())
			{
				String[][] info1 =db.searchByLocation(searchText.getText());
				int numRows=info1.length;
				int numCols=tableModel.getColumnCount();
				tableModel.setRowCount(0);
				for(int row=0;row<numRows;row++)
				{
					Object[] reqRow=(Object[])info1[row];
					tableModel.addRow(reqRow);
							
				}
				
				
			}
			else
			{
				//Automatically retrieves all the records in the database and displays them
				String[][] info1=db.defaultData();
				int numRows=info1.length;
				int numCols=tableModel.getColumnCount();
				tableModel.setRowCount(0);
				for(int row=0;row<numRows;row++)
				{
					Object[] reqRow=(Object[])info1[row];
					tableModel.addRow(reqRow);
							
				}
				
			}
		});





	}
	
	public static void main(String[] args)
	{

		new MainInterface(); //Runs the main function
	}
	
	

}


public class Main {
	
	/**
	 * Main entry point for the program
	 * @param args Not used
	 */
	public static void main(String[] args) {
		MainInterface mn=new MainInterface();
		mn.main(args);

	}

}
