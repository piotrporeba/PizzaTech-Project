package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 
/**
 * 
 * @author Genet
 *
 */
// a class to connect to database and get last order id number from it
public class GetLastOrderNumber {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
	static int lastOrderID;
	
   public static int getLastOrderNumber(){
	   ip=GetIpAddress.getIP(); 
	   System.out.println(ip);
	   
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3: Execute a SQL SELECT query, the query result
         //  is returned in a 'ResultSet' object.
         String strSelect = "select orderID from orders";
         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
         System.out.println();
 
         ResultSet rset = stmt.executeQuery(strSelect);
 
      // Step 4: Process the ResultSet by scrolling the cursor forward via next().
         //  For each row, retrieve the contents of the cells with getXxx(columnName).
         System.out.println("The records selected are:");
         int rowCount = 0;
         int orderID=0;
         int tableNo=0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            orderID = rset.getInt("orderID");
           
            
            //table = rset.getInt("table");
       
            ++rowCount;
         }
         System.out.println("Total number of orders = " + rowCount);
         lastOrderID = orderID;
       
         System.out.println(lastOrderID);
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources
	//return qty;
	return lastOrderID;
	
   }
}