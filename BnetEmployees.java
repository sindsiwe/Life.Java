package DBCon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Font;

public class BnetEmployees {

	private JFrame frame;
	private JTable tblBEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BnetEmployees window = new BnetEmployees();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BnetEmployees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tblBEmp = new JTable();
		tblBEmp.setBounds(53, 51, 328, 145);
		frame.getContentPane().add(tblBEmp);
		
		Label lblEmlHeading = new Label("Bnetworks Employee");
		lblEmlHeading.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblEmlHeading.setBounds(124, 10, 175, 22);
		frame.getContentPane().add(lblEmlHeading);
	}

	public static void showMain() {
		// TODO Auto-generated method stub
		
	}
}
