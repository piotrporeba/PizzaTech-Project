package pizza;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
 
/**
 * 
 * @author Genet
 *
 */
public class SendTable {   // Save as "JdbcSelectTest.java"
	static int qty;
	static String ip;
	static int lastOrderID;
   public static void sendTable(int table){
	   ip=GetIpAddress.getIP(); 
	   System.out.println(ip + "at sendTable");
	   
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
 
         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
    	  String insert="insert into orders values "+ "(NULL, " +table+")";
    	 int countInserted = stmt.executeUpdate(insert);
     

      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      // Step 5: Close the resources - Done automatically by try-with-resources

	
   }
}