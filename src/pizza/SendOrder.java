package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 
/**
 * 
 * @author Genet
 *
 */
public class SendOrder {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
	static int lastOrderID;
   public static void sendOrder(int olive, int onion, int mushroom, int salami, int bacon, int pepper, int sauce ,int lastOrderId){
	   ip=GetIpAddress.IPX;
	   System.out.println(ip + "  ip addressat Send Order");
	   System.out.println(" olive selected:" + olive );
	   System.out.println(" onion selected:" + onion );
	   System.out.println(" mushroom selected:" + mushroom );
	   System.out.println(" salami selected:" + salami );
	   System.out.println(" bacon selected:" + bacon );
	   System.out.println(" pepper selected:" + pepper );
	   System.out.println(" sauce selected:" + sauce );
	   System.out.println(" orderId:" + lastOrderId );
	   
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
    	  
    	  if(olive==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'olives');";
    		  int countInserted = stmt.executeUpdate(insert);
    		  // removing olive from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'olives';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    		  
    		  
    	  }
    	  if(onion==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'onions');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing onions from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'onions';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    		  
    	  }
    	  if(mushroom==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'mushrooms');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing mushrooms from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'mushrooms';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    	  }
    	  if(bacon==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'bacon');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing bacon from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'bacon';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    	  }
    	  if(pepper==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'pepper');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing pepper from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'pepper';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    		  
    	  }
    	  if(salami==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'salami');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing salami from number of available olives if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'salami';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    	  }
    	  
    	  if(sauce==1){
    		  String insert="INSERT INTO orders_products (orders_orderID, products_item) VALUES ('"+lastOrderId+"', 'sauce');";
    		  int countInserted = stmt.executeUpdate(insert);
    		// removing sauce from number of available sauces if chosen
    		  String insert2="UPDATE products SET quantity = quantity - 1 WHERE item = 'sauce';";
    		  int countInserted2=stmt.executeUpdate(insert2);
    	  }
     

      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources

	
   }
}