package pizza;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
// main gui screen for customers
public class gui extends JFrame {
	static int tableNum;
	static String ipX;
	static int lastOrderId_1=1;

	private JPanel contentPane;
	private JTextField txtAddOns;
	private JTextField txtBaseType;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	
	private ImageIcon olive = new ImageIcon(pizza.gui.class.getResource("images/blackolive.png"));
	private ImageIcon olives = new ImageIcon(pizza.gui.class.getResource("images/olives.png"));
	private ImageIcon onion = new ImageIcon(pizza.gui.class.getResource("images/onion.png"));
	private ImageIcon onions = new ImageIcon(pizza.gui.class.getResource("images/onions.png"));
	private ImageIcon mushroom = new ImageIcon(pizza.gui.class.getResource("images/mushroom1.gif"));
	private ImageIcon mushrooms = new ImageIcon(pizza.gui.class.getResource("images/mushrooms.png"));
	private ImageIcon salami = new ImageIcon(pizza.gui.class.getResource("images/salami.png"));
	private ImageIcon salamis = new ImageIcon(pizza.gui.class.getResource("images/salamis.png"));
	private ImageIcon bacon = new ImageIcon(pizza.gui.class.getResource("images/bacon.png"));
	private ImageIcon bacons = new ImageIcon(pizza.gui.class.getResource("images/bacons.png"));
	private ImageIcon pepper = new ImageIcon(pizza.gui.class.getResource("images/pepper.png"));
	private ImageIcon peppers = new ImageIcon(pizza.gui.class.getResource("images/peppers.png"));
	private static ImageIcon sauce1 = new ImageIcon(pizza.gui.class.getResource("images/sauce1.png"));
	private static ImageIcon sauce = new ImageIcon(pizza.gui.class.getResource("images/sauce.png"));
	private static ImageIcon base1 = new ImageIcon(pizza.gui.class.getResource("images/base2.png"));
	
	// olive needt to be added here
	/*
	private ImageIcon olive = new ImageIcon("images/blackolive.png");
	private ImageIcon olives = new ImageIcon("images/olives.png");
	private ImageIcon onion = new ImageIcon("images/onion.png");
	private ImageIcon onions = new ImageIcon("images/onions.png");
	private ImageIcon mushroom = new ImageIcon("images/mushroom1.gif");
	private ImageIcon mushrooms = new ImageIcon("images/mushrooms.png");
	private ImageIcon salami = new ImageIcon("images/salami.png");
	private ImageIcon salamis = new ImageIcon("images/salamis.png");
	private ImageIcon bacon = new ImageIcon("images/bacon.png");
	private ImageIcon bacons = new ImageIcon("images/bacons.png");
	private ImageIcon pepper = new ImageIcon("images/pepper.png");
	private ImageIcon peppers = new ImageIcon("images/peppers.png");
	private static ImageIcon sauce1 = new ImageIcon("images/sauce1.png");
	private static ImageIcon sauce = new ImageIcon("images/sauce.png");
	private static ImageIcon base1 = new ImageIcon("images/base2.png");
	*/
	
	
	// declaring layered panes which will display ingreediens on a pizza  base
	private static JLayeredPane layeredPane, layeredPane_1, layeredPane_2, layeredPane_3, layeredPane_4, layeredPane_5, layeredPane_6,layeredPane_sauce, layeredPane_base;

	private JLabel lblTablenumber;
	
	private static int olivesBoolean;
	private static int onionBoolean;
	private static int muschroomBoolean;
	private static int salamiBoolean;
	private static int baconBoolean;
	private static int pepperBoolean;
	private static int sauceBoolean;
	
	private static JLabel base1Label, oliveLabel1, onionLabel2, mushroomLabel, salamiLabel, baconLabel, pepperLabel, sauceLabel;


	/**
	 * Launch the application.
	 */

	public static void buildGui(String tableNumber){
		tableNum=Integer.parseInt(tableNumber);
		gui frame = new gui(tableNumber);
		frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public gui(String tableNumber) {
		//ipX=ipInput;
		//System.out.println(ipX);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 412, 266);
		setSize(950,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		txtAddOns = new JTextField();
		txtAddOns.setText("add ons");
		panel.add(txtAddOns);
		txtAddOns.setColumns(10);
		///////////////////////////////////////////////////// adding buttons + functionality to them

		btnNewButton = new JButton();
		btnNewButton.setIcon(olive);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if((ListProducts.listProducts(1))>0){
				oliveLabel1 = new JLabel(olives);
				oliveLabel1.setBounds(15, 15,
		                olives.getIconWidth(),
		                olives.getIconHeight());
				layeredPane_1.add(oliveLabel1, new Integer(2), 0);
				olivesBoolean=1;
				//}

			}
		});
		panel.add(btnNewButton);
		btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(onion);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onionLabel2 = new JLabel(onions);
				onionLabel2.setBounds(15, 15,
		                onions.getIconWidth(),
		                onions.getIconHeight());
				layeredPane_2.add(onionLabel2, new Integer(2), 0);
				onionBoolean=1;

			}
		});
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(mushroom);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mushroomLabel = new JLabel(mushrooms);
				mushroomLabel.setBounds(15, 15,
		                mushrooms.getIconWidth(),
		                mushrooms.getIconHeight());
				layeredPane_3.add(mushroomLabel, new Integer(2), 0);
				muschroomBoolean=1;

			}
		});
		panel.add(btnNewButton_2);

		btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(salami);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salamiLabel = new JLabel(salamis);
				salamiLabel.setBounds(15, 15,
		                salamis.getIconWidth(),
		                salamis.getIconHeight());
				layeredPane_4.add(salamiLabel, new Integer(2), 0);
				salamiBoolean=1;

			}
		});
		panel.add(btnNewButton_3);

		btnNewButton_4 = new JButton();
		btnNewButton_4.setIcon(bacon);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baconLabel = new JLabel(bacons);
				baconLabel.setBounds(15, 15,
		                bacons.getIconWidth(),
		                bacons.getIconHeight());
				layeredPane_5.add(baconLabel, new Integer(2), 0);
				baconBoolean=1;

			}
		});
		panel.add(btnNewButton_4);

		btnNewButton_5 = new JButton();
		btnNewButton_5.setIcon(pepper);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pepperLabel = new JLabel(peppers);
				pepperLabel.setBounds(15, 15,
		                peppers.getIconWidth(),
		                peppers.getIconHeight());
				layeredPane_6.add(pepperLabel, new Integer(2), 0);
				pepperBoolean=1;

			}
		});
		panel.add(btnNewButton_5);


		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		txtBaseType = new JTextField();
		txtBaseType.setText("base type");
		panel_2.add(txtBaseType);
		txtBaseType.setColumns(10);

		btnNewButton_6 = new JButton();
		btnNewButton_6.setIcon(sauce1);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sauceLabel = new JLabel(sauce);
				sauceLabel.setBounds(15, 15,
		                sauce.getIconWidth(),
		                sauce.getIconHeight());
				layeredPane_sauce.add(sauceLabel, new Integer(2), 0);
				sauceBoolean=1;

			}
		});
		panel_2.add(btnNewButton_6);

		btnNewButton_7 = new JButton("Reset");
		btnNewButton_7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				resetIngreedients();
			}
		});
		panel_2.add(btnNewButton_7);

		btnNewButton_8 = new JButton("Send Order");
		btnNewButton_8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				SendTable.sendTable(tableNum);
				lastOrderId_1 = pizza.GetLastOrderNumber.getLastOrderNumber();
				System.out.println(lastOrderId_1);
				JFrame frame=new JFrame("input credit card details");
				String cardNumber = JOptionPane.showInputDialog(frame, "Input Credit Card Details To Make order, or cancel");
				
                if(cardNumber.length()>0){
                	System.out.println("cardnumber works   "+cardNumber);
                	SendOrder.sendOrder(olivesBoolean, onionBoolean, muschroomBoolean, salamiBoolean, baconBoolean, pepperBoolean, sauceBoolean, lastOrderId_1);
                }

			}
		});
		panel_2.add(btnNewButton_8);
		
		
		
		
		////////////////////////////////////////////////////////////////////////
		// adding layered panes
		layeredPane = new JLayeredPane();

		layeredPane_1 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_1, 0);
		layeredPane_1.setBounds(10, 11, 600, 700);
		layeredPane_1.setLocation(10, 11);

		layeredPane.add(layeredPane_1);

		layeredPane_2 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_2, 0);
		layeredPane_2.setBounds(10, 11, 600, 700);
		layeredPane.add(layeredPane_2);

		layeredPane_3 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_3, 0);
		layeredPane_3.setBounds(10, 11, 600, 700);
		layeredPane.add(layeredPane_3);

		layeredPane_4 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_4, 0);
		layeredPane_4.setBounds(10, 11, 600, 700);
		layeredPane.add(layeredPane_4);

		layeredPane_5 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_5, 0);
		layeredPane_5.setBounds(10, 11, 600, 700);
		layeredPane.add(layeredPane_5);

		layeredPane_6 = new JLayeredPane();
		layeredPane.setLayer(layeredPane_6, 0);
		layeredPane_6.setBounds(10, 11, 600, 700);
		layeredPane.add(layeredPane_6);
		///////////////////////////////////////////////////adding sauce layer
		layeredPane_sauce = new JLayeredPane();
		layeredPane.setLayer(layeredPane_sauce, 0);
		layeredPane_sauce.setBounds(10,11,600,700);
		layeredPane.add(layeredPane_sauce);
		////////////////////////////////////////////////////
		
		// adding image to last layered pane
		layeredPane_base = new JLayeredPane();
		layeredPane.setLayer(layeredPane_base, 0);
		layeredPane_base.setBounds(10, 11, 600, 700);
		base1Label = new JLabel(base1);
		base1Label.setBounds(15, 15,
                base1.getIconWidth(),
                base1.getIconHeight());
		layeredPane_base.add(base1Label, new Integer(2), -1);
		layeredPane.add(layeredPane_base);

		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		lblTablenumber = new JLabel("Table" + tableNumber);
		lblTablenumber.setBounds(620, 35, 69, 40);
		layeredPane.add(lblTablenumber);


	}
	
	public static void resetIngreedients(){
		olivesBoolean =0;
		onionBoolean =0;
		muschroomBoolean =0;
		salamiBoolean =0;
		baconBoolean =0;
		pepperBoolean =0;
		sauceBoolean=0;
		
		layeredPane_1.removeAll();
		layeredPane_2.removeAll();
		layeredPane_3.removeAll();
		layeredPane_4.removeAll();
		layeredPane_5.removeAll();
		layeredPane_6.removeAll();
		layeredPane_sauce.removeAll();
		
		
		base1Label = new JLabel(base1);
		base1Label.setBounds(15, 15,
                base1.getIconWidth(),
                base1.getIconHeight());
		layeredPane_base.add(base1Label, new Integer(2), -1);
		
	
	}
}

