package pizza;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * @author Genet
 *
 */

public class AdminGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Olive;
	private JTextField textField_Onion;
	public static int olives, onion, muschrooms, salami, bacon, paprica, sauce;
	private JTextField textField_Mushrooms;
	private JTextField textField_Salami;
	private JTextField textField_Bacon;
	private JTextField textField_Pepper;
	public static String ipX;
	private JTextField textField;
	static int lastOrderId; //////////////
	static String[] orderItems = new String[7];
	private JTextField textField_Sauce;
	
	

	public static void buildGui(){
		AdminGui frame = new AdminGui();
		frame.setVisible(true);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AdminGui() {
		//ipX=ipInput;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(950,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOlives = new JLabel("Olives");
		lblOlives.setBounds(32, 16, 69, 20);
		panel.add(lblOlives);
		
		JLabel lblNewLabel = new JLabel("Onion");
		lblNewLabel.setBounds(104, 16, 69, 20);
		panel.add(lblNewLabel);
		
		textField_Olive = new JTextField();
		textField_Olive.setBounds(32, 52, 46, 26);
		textField_Olive.setText(String.valueOf(ListProducts.listProducts(3)));
		panel.add(textField_Olive);
		textField_Olive.setColumns(10);
		
		textField_Onion = new JTextField();
		textField_Onion.setBounds(104, 52, 46, 26);
		textField_Onion.setText(String.valueOf(ListProducts.listProducts(4)));
		panel.add(textField_Onion);
		textField_Onion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Muschrooms");
		lblNewLabel_1.setBounds(173, 16, 98, 20);
		panel.add(lblNewLabel_1);
		
		textField_Mushrooms = new JTextField();
		textField_Mushrooms.setBounds(183, 52, 58, 26);
		textField_Mushrooms.setText(String.valueOf(ListProducts.listProducts(2)));
		panel.add(textField_Mushrooms);
		textField_Mushrooms.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Salami");
		lblNewLabel_2.setBounds(296, 16, 69, 20);
		panel.add(lblNewLabel_2);
		
		textField_Salami = new JTextField();
		textField_Salami.setBounds(296, 52, 51, 26);
		textField_Salami.setText(String.valueOf(ListProducts.listProducts(6)));
		panel.add(textField_Salami);
		textField_Salami.setColumns(10);
		
		JLabel lblBacon = new JLabel("Bacon");
		lblBacon.setBounds(380, 16, 69, 20);
		panel.add(lblBacon);
		
		textField_Bacon = new JTextField();
		textField_Bacon.setBounds(380, 52, 58, 26);
		textField_Bacon.setText(String.valueOf(ListProducts.listProducts(1)));
		panel.add(textField_Bacon);
		textField_Bacon.setColumns(10);
		
		JLabel lblPaprika = new JLabel("Pepper");
		lblPaprika.setBounds(464, 16, 69, 20);
		panel.add(lblPaprika);
		
		textField_Pepper = new JTextField();
		textField_Pepper.setBounds(462, 52, 58, 26);
		textField_Pepper.setText(String.valueOf(ListProducts.listProducts(5)));
		panel.add(textField_Pepper);
		textField_Pepper.setColumns(10);
		
		textField_Sauce = new JTextField();
		textField_Sauce.setBounds(535, 52, 59, 26);
		textField_Sauce.setText(String.valueOf(ListProducts.listProducts(7)));
		panel.add(textField_Sauce);
		textField_Sauce.setColumns(10);
		
		JButton btn_UpdateIngreedients = new JButton("Update Ingreedients");
		btn_UpdateIngreedients.setBounds(636, 51, 189, 29);
		btn_UpdateIngreedients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UpdateProducts.updatePruducts("olives", Integer.parseInt(textField_Olive.getText()));
				UpdateProducts.updatePruducts("onions", Integer.parseInt(textField_Onion.getText()));
				UpdateProducts.updatePruducts("mushrooms", Integer.parseInt(textField_Mushrooms.getText()));
				UpdateProducts.updatePruducts("salami", Integer.parseInt(textField_Salami.getText()));
				UpdateProducts.updatePruducts("bacon", Integer.parseInt(textField_Bacon.getText()));
				UpdateProducts.updatePruducts("pepper", Integer.parseInt(textField_Pepper.getText()));
				UpdateProducts.updatePruducts("sauce", Integer.parseInt(textField_Sauce.getText()));
				
			}
		});
		panel.add(btn_UpdateIngreedients);
		
		textField = new JTextField();
		textField.setBounds(32, 120, 146, 26);
		lastOrderId = pizza.GetLastOrderNumber.getLastOrderNumber();
		textField.setText(String.valueOf(lastOrderId));
		panel.add(textField);
		textField.setColumns(10);
		
		JButton updateId = new JButton("check orders");
		updateId.setBounds(200,120,246,26);
		updateId.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				new OrderCheckThread("checkThread").start();
			
				/*if(lastOrderId<CheckNewOrder.getOrder(lastOrderId)){
					System.out.println("new order added");
					lastOrderId+=1;
					JFrame popFrame= new JFrame();
					orderItems=GetOrder.getLastOrder();
					String orderedItems= orderItems[0]+ " "+orderItems[1] +" "+orderItems[2] + " " + orderItems[3] + " " + orderItems[4]+ " "+ orderItems[5];
					JOptionPane.showMessageDialog(popFrame, orderedItems, "new Order: " +lastOrderId +" table:  "+ CheckNewOrder.tableNumber, JOptionPane.PLAIN_MESSAGE);
					
				}else System.out.println("no new oeders added");
				*/
			}
		});
		panel.add(updateId);
		
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setBounds(539, 16, 69, 20);
		panel.add(lblSauce);
		
		
		
	}
}
