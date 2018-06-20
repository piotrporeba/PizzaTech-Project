package pizza;

/**
 * 
 * @author Genet
 *
 */

// class fo store an ip address of a database
public class GetIpAddress {
	public static String IPX;
	
	
	public static void setIP(String ipInput) {
		// TODO Auto-generated method stub
		IPX=ipInput;
		System.out.println("Ip addres sent to setIP  " + IPX);
	}
	
	public static String getIP(){
		return IPX;
	}

}
