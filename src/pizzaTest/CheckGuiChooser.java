package pizzaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckGuiChooser {
	static String login="admin";
	static String password="admin";
	static int table=2;
	static String ip;
	@Test
	public  void test(){	
		if(login != "admin"){
			fail("Wrong login entered ");
		}
		if(password != "admin"){
			fail("Wrong password entered ");
		}
		if(Character.isLetter(table)){
			fail("char entered for table ");
		}
		if( table>100){
			fail("table number too high ");
		}
		if( table<1){
			fail("table nr to low ");
		}
		
		if(ip!="192.168.1.15"){
			fail("wrong ip entered ");
		}
		
	}
}

