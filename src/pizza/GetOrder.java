package pizza;

import java.awt.List;
import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;
 
/**
 * 
 * @author Genet
 *
 */
// a class to connect to database and get last order id number from it
public class GetOrder {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
	static int lastOrderID;
	static  ResultSet rset;
	static String[]items=new String[7];
	
   public static String[] getLastOrder(){
	   ip=GetIpAddress.getIP(); 
	   
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
         String strSelect = "select products_item from orders_products WHERE orders_orderID = '"+AdminGui.lastOrderId+"';";
         rset = stmt.executeQuery(strSelect);
         items[0]="";
         items[1]="";
         items[2]="";
         items[3]="";
         items[4]="";
         items[5]="";
         items[6]="";
         while(rset.next()){
            if(rset.getString("products_item").equals("bacon")){
        	 items[0]="bacon";
             }
            if(rset.getString("products_item").equals("mushrooms")){
           	 items[1]="muschrooms";
                }
            if(rset.getString("products_item").equals("olives")){
           	 items[2]="olives";
                }
            if(rset.getString("products_item").equals("onions")){
           	 items[3]="onions";
                }
            if(rset.getString("products_item").equals("pepper")){
           	 items[4]="pepper";
                }
            if(rset.getString("products_item").equals("salami")){
           	 items[5]="salami";
                }
            if(rset.getString("products_item").equals("sauce")){
              	 items[6]=" tomato sauce";
                   }
         }
         
         
         
        
      // Step 4: Process the ResultSet by scrolling the cursor forward via next().
         //  For each row, retrieve the contents of the cells with getXxx(columnName).
       
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources
	
	return items;
   }
}