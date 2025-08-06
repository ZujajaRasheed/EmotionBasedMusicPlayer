package defaultt;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Login implements ActionListener {

	
	JFrame frame;
	JButton login,signup,back;
	JPanel mainpanel,loginpanel,coverpanel;
	JTextField email,password;
	ImageIcon logo,background1,background2;
	JLabel welcome,text, l1,l2;
	public Login()
	{
		frame =new JFrame("Login - EmotionBasedMusicPlayer");
		frame.setSize(1950,1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		logo=new ImageIcon("logo.jpeg");
		frame.setIconImage(logo.getImage());
		//mainpanel
		 
		 
		 
		 
		 
		 
		 
		 ImageIcon background1 = new ImageIcon("imgg1.jpeg");
		 l1 = new JLabel();
		 l1.setIcon(background1);
		 ImageIcon background2 = new ImageIcon("imgg2.jpeg");
		
         l2=new JLabel();
		 l2.setIcon(background2);
		 l1.setPreferredSize(new Dimension(700, 1100));
		 l2.setPreferredSize(new Dimension(700, 1100));

		 
		 
		 
		
		mainpanel=new JPanel();
		mainpanel.setLayout(new BorderLayout());

		
		coverpanel=new JPanel();
		coverpanel.setLayout(new BorderLayout());
		coverpanel.setBackground(new Color(0xF5F5F5));
		
		//loginpanel
		
		loginpanel=new JPanel();
		loginpanel.setBorder(BorderFactory.createEmptyBorder(40,0,40,0));
		
		loginpanel.setSize(400,400);
		loginpanel.setBackground(new Color(0,107,99));
		loginpanel.setLayout(null);
		
		welcome=new JLabel();
		welcome.setText("Welcome!");
		welcome.setBounds(160,50,200,30);
		welcome.setFont(new Font("Aerial",Font.BOLD,32));
		welcome.setForeground(Color.white);
		welcome.setBackground(new Color(0,107,99));
		welcome.setHorizontalAlignment(welcome.CENTER);
		
		email=new JTextField();
		email.setText("E-mail Address");
		email.setBounds(190,190,200,30);
	
		email.setFont(new Font("Aerial ",Font.PLAIN,20));
		email.setForeground(Color.white);
		email.setBackground(new Color(0,107,99));
		email.setBorder(null);
		
		
		
//		 email.addFocusListener(new FocusAdapter() {
//	            public void focusGained(FocusEvent e) {
//	                if (email.getText().equals("E-mail Address")) {
//	                    email.setText("");
//	                    email.setForeground(Color.BLACK);
//	                }
//	            }
//
//	            public void focusLost(FocusEvent e) {
//	                if (email.getText().isEmpty()) {
//	                    email.setForeground(Color.GRAY);
//	                    email.setText("E-mail address");
//	                }
//	            }
//	        });
		
		//line 
		
		JSeparator line1 = new JSeparator();
		line1.setBounds(50, 240, 410, 1); // adjust as needed
		line1.setForeground(Color.WHITE);
		
		//password
		
		password =new JTextField();
		password.setText("Password");
		password.setBounds(210,300,150,30);
		password.setFont(new Font("Aerial ",Font.PLAIN,20));
		password.setForeground(Color.WHITE);
		password.setBackground(new Color(0,107,99));
		password.setBorder(null);
		
		//line2
	    JSeparator line2 = new JSeparator();
    	line2.setBounds(50, 350, 410, 1); // adjust as needed
		line2.setForeground(Color.WHITE);
		
		
		// login button
		login=new JButton("Login");
		login.setFont(new Font("Aerial ",Font.BOLD,20));
		login.setBounds(160,440,200,40);
		login.setForeground(new Color(0,107,99));
		login.setBorder(null);
		login.setBackground(Color.white);
		login.addActionListener(this);
		//
		text=new JLabel();
		text.setText("Don't have an account ?");
		text.setBounds(150,500,200,30);
		text.setFont(new Font("Aerial ",Font.PLAIN,16));
		text.setForeground(Color.white);
		text.setBackground(new Color(0,107,99));
		text.setBorder(null);
		
		
		
		
		
		
		
		//signup
		signup=new JButton("Signup");
		signup.setFont(new Font("Aerial ",Font.PLAIN,18));
		signup.setBounds(270,500,150,30);
		signup.setBackground(new Color(0,107,99));
		signup.setBorder(null);
		signup.setForeground(Color.white);
		signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signup.addActionListener(this);
		
		
		 back=new JButton() ;
		 back.setText("Back");
		 back.setBounds(10,10,60,18);
		 back.setFont(new Font("Arial",Font.BOLD,20));
		 back.setBorder(null);
		 back.setForeground(new Color(0,107,99));
		 back.setBackground(new Color(0xF5F5F5));
		back.addActionListener(this);
		
		
	loginpanel.add(welcome);
	loginpanel.add(email);
	loginpanel.add(line1);
	loginpanel.add(password);
	loginpanel.add(line2);
	loginpanel.add(login);
	loginpanel.add(text);
	loginpanel.add(signup);
	
	
	
	coverpanel.add(Box.createRigidArea(new Dimension(0,150)), BorderLayout.NORTH); // top space
	coverpanel.add(Box.createRigidArea(new Dimension(0, 150)), BorderLayout.SOUTH); // bottom space
	coverpanel.add(loginpanel, BorderLayout.CENTER); // main panel in center

	
	
	
	
	
	
	mainpanel.add(back);
	mainpanel.add(coverpanel,BorderLayout.CENTER);
	mainpanel.add(l1,BorderLayout.EAST);
	mainpanel.add(l2, BorderLayout.WEST);
	frame.add(mainpanel);
	
	frame.setVisible(true);	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		   String email1=email.getText();
	   	String password1=password.getText();
			
	   	
			
		         
		         
		      if(e.getSource()==login){
		         
		         
		            Admin admin=new Admin(email1,password1);
		            
			    if(admin.adminLogin())
			    {
			    	System.out.println("admin logged in ");
			    	new AdminDashboard();
			    	 frame.dispose();
			    }
			      
			    else
			    {
			    	User user =new User(email1,password1);
			        if(user.userLogin())
			        {
			        	new UserDashboard(user);
			        	 frame.dispose();
			        	
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "Ivalid email or password plz signup first ");
			        	
			        	email.setText("E-mail Address");
			        	password.setText("password");
			        	return;
			        	
			        }
			    }
		      }
			    
		                   
			         
		     
	else if(e.getSource()==signup)
		     {
		        new SignUp();
		        frame.dispose();
			 }
		   	
	
	else if(e.getSource()==back)
    	new Main();
		      frame.dispose();
		
	}
}
	
	
	
	
	

