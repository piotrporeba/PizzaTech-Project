package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 
/**
 * 
 * @author Genet
 *
 */
public class ListProducts {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
   public static int listProducts(int position) {
	   ip=GetIpAddress.IPX; 
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
         String strSelect = "select item, price, quantity from products";
         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
         System.out.println();
 
         ResultSet rset = stmt.executeQuery(strSelect);
 
         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
         //  For each row, retrieve the contents of the cells with getXxx(columnName).
        
         
         rset.absolute(position);
         qty= rset.getInt("quantity");
         System.out.println("The records selected are: " +qty);
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources
	return qty;
   }
}