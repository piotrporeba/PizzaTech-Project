package pizza;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class OrderCheckThread extends Thread{
	public OrderCheckThread(String name){
		super(name);
	}
	
	public void run(){
		
		try{
			for(int i=1; i>0; i++){
			sleep(5000);
			if(AdminGui.lastOrderId<CheckNewOrder.getOrder(AdminGui.lastOrderId)){
				System.out.println("new order added");
				AdminGui.lastOrderId+=1;
				JFrame popFrame= new JFrame("");
				popFrame.setPreferredSize(new Dimension(500, 500));
				AdminGui.orderItems=GetOrder.getLastOrder();
				String orderedItems= AdminGui.orderItems[0]+ " "+AdminGui.orderItems[1] +" "+AdminGui.orderItems[2] + " " + AdminGui.orderItems[3] + " " + AdminGui.orderItems[4]+ " "+ AdminGui.orderItems[5]+ AdminGui.orderItems[6];
				JOptionPane.showMessageDialog(popFrame, orderedItems, "new Order: " +AdminGui.lastOrderId +" table:  "+ CheckNewOrder.tableNumber, JOptionPane.INFORMATION_MESSAGE);
				
				
			}else {
				System.out.println("no new oeders added");
			}
			}
			
			
		}catch(InterruptedException e){
			
		}
		/*
		if(AdminGui.lastOrderId<CheckNewOrder.getOrder(AdminGui.lastOrderId)){
			System.out.println("new order added");
			AdminGui.lastOrderId+=1;
			JFrame popFrame= new JFrame();
			AdminGui.orderItems=GetOrder.getLastOrder();
			String orderedItems= AdminGui.orderItems[0]+ " "+AdminGui.orderItems[1] +" "+AdminGui.orderItems[2] + " " + AdminGui.orderItems[3] + " " + AdminGui.orderItems[4]+ " "+ AdminGui.orderItems[5];
			JOptionPane.showMessageDialog(popFrame, orderedItems, "new Order: " +AdminGui.lastOrderId +" table:  "+ CheckNewOrder.tableNumber, JOptionPane.PLAIN_MESSAGE);
			
		}else {
			System.out.println("no new oeders added");
		}
		
*/}
}
