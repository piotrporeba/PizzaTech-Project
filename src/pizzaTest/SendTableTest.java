package pizzaTest;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import pizza.GetIpAddress;

public class SendTableTest {
	
	
	static int qty;
	static String ip="192.168.1.15";
	static int lastOrderID;
   public static void sendTable(){
	 
   }

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSendTable() {
		  System.out.println(ip + "at sendTable"); 
	      try (
	         Connection conn = DriverManager.getConnection(
	               "jdbc:mysql://"+ip+":3306/mydb?useSSL=false", "test", "test");
	         Statement stmt = conn.createStatement();
	      ) {
	    	  String insert="insert into ____orders______ values "+ "(NULL, 15)"; // wrong statement
	    	 int countInserted = stmt.executeUpdate(insert);
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	         fail("");
	      }	
	   }
	}


