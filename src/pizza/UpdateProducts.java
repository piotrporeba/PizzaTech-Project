package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 

public class UpdateProducts {
	static String ip;// Save as "JdbcSelectTest.java"
   public static void updatePruducts(String row, int value) {
	   ip=GetIpAddress.getIP(); 
	   System.out.println(ip);
	   
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
    		// Step 2: Allocate a 'Statement' object in the Connection
    	         Statement stmt = conn.createStatement(ResultSet.CONCUR_UPDATABLE, value);
    	      ) {
    	         // Step 3: Execute a SQL SELECT query, the query result
    	         //  is returned in a 'ResultSet' object.
    	         String strUpdate = "update products set quantity ="+value+" where item= '"+row+"'";
    	         
    	         System.out.println("The SQL query is: " + strUpdate); // Echo For debugging
    	         System.out.println();
    	 
    	         int rset = stmt.executeUpdate(strUpdate);
    	 
    	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
    	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
    	         System.out.println("The records selected are:");
    	         int rowCount = 0;
    	         
    	         
    	          //  rset.absolute(row) ;  // Move the cursor to the next row, return false if no more row
    	           // rset.updateInt(4, value);
    	            
    	                    
    	         
    	        // System.out.println("Total number of records = " + rowCount);
    	 
    	      } catch(SQLException ex) {
    	         ex.printStackTrace();
    	      }
    	      // Step 5: Close the resources - Done automatically by try-with-resources
    	   }
}