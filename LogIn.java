package DBCon;
 /**
  * Java import class to be used 
  */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.AbstractAction;
import javax.swing.JPasswordField;

public class LogIn {

	/**
	 *Declaring instance variables 
	 */
	private JFrame frmBnetworkxOnlineSystem;
	private JTextField txtUser;
	private JButton btnLogin;
	
	//Object of the Connection class
	ConnectDB dbcon = new ConnectDB();
	String sqlCommand = "";
	private JPasswordField txtPass;
	private JButton btnExit;

	/**
	 * Main method for launching the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LogIn window = new LogIn();
					window.frmBnetworkxOnlineSystem.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
					
				}//end of try and catch
				
			}//end of run method 
		});//end of queue event
		
	}//end of Main method 

	/**
	 * Constructor to Create the application.
	 */
	public LogIn() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * setting components in place 
	 */
	private void initialize() {
		frmBnetworkxOnlineSystem = new JFrame();
		frmBnetworkxOnlineSystem.getContentPane().setBackground(Color.DARK_GRAY);
		frmBnetworkxOnlineSystem.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(139, 86, 210, 20);
		frmBnetworkxOnlineSystem.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		Label lblUser = new Label("Username  :");
		lblUser.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblUser.setBounds(10, 86, 123, 22);
		frmBnetworkxOnlineSystem.getContentPane().add(lblUser);
		
		Label lblPass = new Label("Password   :");
		lblPass.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblPass.setBounds(10, 162, 123, 22);
		frmBnetworkxOnlineSystem.getContentPane().add(lblPass);
		
		Label lblHeading = new Label("Bnetworkx LogIn ");
		lblHeading.setFont(new Font("DFKai-SB", Font.BOLD | Font.ITALIC, 20));
		lblHeading.setBounds(130, 23, 164, 22);
		frmBnetworkxOnlineSystem.getContentPane().add(lblHeading);
		
		btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent con) 
			{
				Object src = con.getSource();
				//Declaring Local variables 
				String user = txtUser.getText().trim();
				String pass = String.valueOf(txtPass.getPassword()).trim();
				
				//Function performed by the LogIn button
				if(src == btnLogin)
				{
					//Call connection class to start connection of DB
					dbcon.connectdb();
					try
					{
						//SQL command that will select the username and password from the Usersignin table 
						sqlCommand ="SELECT Username , Password FROM Usersignin WHERE Username='" + user + "'AND  Password='" + pass + "'";
						//Performing sql query command 
						ResultSet reset = dbcon.select(sqlCommand);
						
						if(reset.next())
						{
							//Opening a new window to display the employees
							BnetEmployees.showMain();
							
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Login failed, please make sure Username or Password is right","Bnetwork",JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
							txtPass.setText("");
							txtPass.grabFocus();
						}
					}
					catch(Exception val)
					{
						System.out.println("Testing " + val);
						
					}//end of try and catch
					
				}//end of outer IF
				else 
					if(src == btnExit)
					{
						System.exit(0);
					}
			}//end of action method 
			
		});//end of button performed action 
		
//########################################################################################################################################################################################################################################3		
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnLogin.setBounds(139, 236, 83, 34);
		frmBnetworkxOnlineSystem.getContentPane().add(btnLogin);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(139, 164, 210, 20);
		frmBnetworkxOnlineSystem.getContentPane().add(txtPass);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnExit.setBounds(243, 236, 89, 34);
		frmBnetworkxOnlineSystem.getContentPane().add(btnExit);
		frmBnetworkxOnlineSystem.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUser, lblUser, lblPass, lblHeading}));
		frmBnetworkxOnlineSystem.setBackground(Color.DARK_GRAY);
		frmBnetworkxOnlineSystem.setTitle("Bnetworkx Online System");
		frmBnetworkxOnlineSystem.setBounds(100, 100, 450, 350);
		frmBnetworkxOnlineSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
