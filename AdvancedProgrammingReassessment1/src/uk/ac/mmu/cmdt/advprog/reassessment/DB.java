package uk.ac.mmu.cmdt.advprog.reassessment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Handles all of the application's database interaction
 * 
 * @author You, mainly!
 */
public class DB {
	
	private String connectionString = "jdbc:sqlite:data/vaccination_centres.db";

	/**
	 * Queries the database to find out how many vaccination sites it contains
	 * @return The number of sites in the vaccination_centres.db database
	 */
	public int getNumberOfSites() {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT COUNT(*) FROM vaccination_sites;";
			PreparedStatement s = c.prepareStatement(sql);			
			s.execute();
			ResultSet results = s.getResultSet();

			//no need to loop through the result set, our query returns just one result
			return results.getInt(1);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Queries the database to find  filter the row  to a specific criterion (city)
	 * @param cty String The city to used as the filtering criterion
	 * @return a 2d String array that can be fed to JTable
	 */
	public String[][] randomTrials(String cty) {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT * FROM vaccination_sites WHERE City=?;";
			String sql2 = "SELECT count(*) FROM vaccination_sites WHERE City=?;"; //Obtain the length of the records

			
			PreparedStatement s = c.prepareStatement(sql);	
			PreparedStatement s1 = c.prepareStatement(sql2);	

			
			s.setString(1, cty); //Fill in the parameterized queries
			s1.setString(1, cty);

			s1.execute();
			s.execute();
			
			ResultSet totRows=s1.getResultSet();
			ResultSet results = s.getResultSet();
			
			int numRows=totRows.getInt(1); //Get the number of rows

	
			String data[][]= new String[numRows][8]; //Declare a 2D array to hold the data with 8 columns
			int count=0;
			while (results.next()) {                      
			    int i = 2;
			    while(i <= 8) {
			        data[count][i-2]=results.getString(i++); //Insert every item into a specific position within the data.
			    }
			    data[count][i-2]=this.locationCenterType(results.getString(i)); //Maps to an inner function to returns  the name of the center given its ID
			    count++;
			
			}
			return data;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Queries the database to return the rows that match a given post code
	 * @param pst the Post code
	 * @return: a 2D String array
	 */
	public String[][] searchByPostCode(String pst) {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT * FROM vaccination_sites WHERE Postcode=?;"; //Obtain  all the records matching the specific post code
			String sql2 = "SELECT count(*) FROM vaccination_sites WHERE Postcode=?;"; //Obtain the length of the rows returned

			
			PreparedStatement s = c.prepareStatement(sql);	
			PreparedStatement s1 = c.prepareStatement(sql2);	

			
			s.setString(1, pst);
			s1.setString(1, pst);

			s1.execute();
			s.execute();
			
			ResultSet totRows=s1.getResultSet();
			ResultSet results = s.getResultSet();
			
			int numRows=totRows.getInt(1); //The total number of rows Returned

			//no need to loop through the result set, our query returns just one result
//			return results.getInt(1);
			String data[][]= new String[numRows][8];
			int count=0;
			while (results.next()) {                      
			    int i = 2;
			    while(i <= 8) {
			        data[count][i-2]=results.getString(i++);
			    }
			    data[count][i-2]=this.locationCenterType(results.getString(i)); //Obtain the name of the Center type passing it's id as the parameter
			    count++; //increment the row account
			
			}
			return data;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Queries to obtain the rows that match a certain region
	 * param loc The location String
	 * Returns a 2D Array of the required Data
	 */
	public String[][] searchByLocation(String loc) {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT * FROM vaccination_sites WHERE Region=?;";
			String sql2 = "SELECT count(*) FROM vaccination_sites WHERE Region=?;";

			
			PreparedStatement s = c.prepareStatement(sql);	
			PreparedStatement s1 = c.prepareStatement(sql2);	

			
			s.setString(1, loc);
			s1.setString(1, loc);

			s1.execute();
			s.execute();
			
			ResultSet totRows=s1.getResultSet();
			ResultSet results = s.getResultSet();
			
			int numRows=totRows.getInt(1);
			System.out.println("The total number of outputted Rows is "+numRows);

			String data[][]= new String[numRows][8];
			int count=0;
			while (results.next()) {                      
			    int i = 2;
			    while(i <= 8) {
			        data[count][i-2]=results.getString(i++);
			    }
			    data[count][i-2]=this.locationCenterType(results.getString(i));
			    count++;
			
			}
			return data;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Query that returns all the rows in the database
	 * @return a 2D string
	 */
	
	public String[][] defaultData() {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT * FROM vaccination_sites;";
			String sql2 = "SELECT count(*) FROM vaccination_sites;";

			
			PreparedStatement s = c.prepareStatement(sql);	
			PreparedStatement s1 = c.prepareStatement(sql2);	
			s1.execute();
			s.execute();
			
			ResultSet totRows=s1.getResultSet();
			ResultSet results = s.getResultSet();
			
			int numRows=totRows.getInt(1);
			System.out.println("The total number of outputted Rows is "+numRows);

			//no need to loop through the result set, our query returns just one result
//			return results.getInt(1);
			String data[][]= new String[numRows][8];
			int count=0;
			while (results.next()) {                      
			    int i = 2;
			    while(i <= 8) {
			        data[count][i-2]=results.getString(i++);
			    }
		        data[count][i-2]=this.locationCenterType(results.getString(i));

			    count++;
			
			}
			return data;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	public int getRows(ResultSet res){
	    int totalRows = 0;
	    try {
	        res.last();
	        totalRows = res.getRow();
	        res.beforeFirst();
	    } 
	    catch(Exception ex)  {
	        return 0;
	    }
	    return totalRows ;    
	}
	
	public ArrayList<List<String>> totalNumberOfSites() {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			String sql = "SELECT * FROM vaccination_sites;";
			PreparedStatement s = c.prepareStatement(sql);			
			s.execute();
			ResultSet results = s.getResultSet();

			//no need to loop through the result set, our query returns just one result
			ArrayList<List<String>> arrayList = new ArrayList<List<String>>(); 
			while (results.next()) {                      
			    int i = 2;
			    List<String> temp=new ArrayList<String>();
			    while(i <= 9) {
//			        arrayList.add(results.getString(i++));
			    	temp.add(results.getString(i++));
			    }
			    arrayList.add(temp);
			 
			}
			return arrayList;   
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		return new ArrayList<List<String>>();
	}
	
	/**
	 *  Helper function to obtain the title 
	 * @param key the ID of the center type
	 * @return the name of the center type
	 */
	public String locationCenterType(String key)
	{
		
		try (Connection c = DriverManager.getConnection(connectionString); ) {
				
				//run the query
				String sql = "SELECT Name from centre_types WHERE ID=?;";
				PreparedStatement s = c.prepareStatement(sql);	
				s.setInt(1, Integer.parseInt(key));
				s.execute();
				ResultSet results = s.getResultSet();
	
				//no need to loop through the result set, our query returns just one result
				return results.getString(1);
			} 
			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	
	
}
