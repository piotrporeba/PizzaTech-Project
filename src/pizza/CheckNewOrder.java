package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 
/**
 * 
 * @author Genet
 *
 */
public class CheckNewOrder {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
	static int lastOrderID;
	static int orderID;
	static int tableNumber;
	
   public static int getOrder(int last){
	   ip=GetIpAddress.IPX;
	   int lastId=last;
	   
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
    	  
    	  ////////// getting the number of rows in orders_products table
    	  String strSelect2 = "select orders_products.orders_orderID, orders.table FROM orders_products Inner Join orders On orders_products.orders_orderID = orders.orderID;";
          ResultSet rset2 = stmt.executeQuery(strSelect2);
          int rowCount = 0;
         
           
          while(rset2.next()) {   // Move the cursor to the next row, return false if no more row
        	  orderID = rset2.getInt("orders_orderID");
        	  tableNumber=rset2.getInt("table");
        	  
            
          } 	  
        

      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources
	return orderID;

	
   }
}
