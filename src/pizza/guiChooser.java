package pizza;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * 
 * @author Genet
 *
 */
public class guiChooser extends JFrame {

	private JPanel contentPane;
	JTextField textField_Table;
	private JTextField textField_Login;
	private JTextField textField_Password;
	private JTextField textField_IP;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiChooser frame = new guiChooser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiChooser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 750, 600);
		setSize(650,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer Screen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tableNumber=textField_Table.getText();
				String ipInput=textField_IP.getText();
				gui.buildGui(tableNumber);
				GetIpAddress.setIP(ipInput);
			}
		});
		btnNewButton.setBounds(34, 65, 162, 107);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Screen");
		btnNewButton_1.setBounds(239, 65, 171, 107);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_Login.getText().equals("admin") && textField_Password.getText().equals("admin")){
				AdminGui.buildGui();
				}else{
					JOptionPane.showMessageDialog(null, "wrong username or password. please retype");
				}
			}
		});
		panel.add(btnNewButton_1);
		
		textField_Table = new JTextField();
		textField_Table.setBounds(34, 230, 105, 20);
		panel.add(textField_Table);
		textField_Table.setColumns(10);
		
		JLabel lblTableNumber = new JLabel("Table Number: ");
		lblTableNumber.setBounds(31, 200, 126, 14);
		panel.add(lblTableNumber);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(239, 197, 50, 20);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(239, 230, 69, 20);
		panel.add(lblPassword);
		
		textField_Login = new JTextField();
		textField_Login.setBounds(323, 188, 86, 26);
		panel.add(textField_Login);
		textField_Login.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(323, 227, 89, 26);
		panel.add(textField_Password);
		textField_Password.setColumns(10);
		
		JLabel lblPleaseEnterDatabase = new JLabel("Please enter database hst ip address before choosing screen");
		lblPleaseEnterDatabase.setBounds(35, 316, 437, 20);
		panel.add(lblPleaseEnterDatabase);
		
		textField_IP = new JTextField();
		textField_IP.setBounds(34, 341, 146, 26);
		panel.add(textField_IP);
		textField_IP.setColumns(10);
		
		JButton btnSetIp = new JButton("Set Ip");
		btnSetIp.setBounds(204, 340, 115, 29);
		btnSetIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ipInput=textField_IP.getText();
				GetIpAddress.setIP(ipInput);
			}
		});
		panel.add(btnSetIp);
	}
}
