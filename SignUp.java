package defaultt;

import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;



public class SignUp implements ActionListener{

	
	JFrame frame;
	JButton login,signup,back;
	JPanel mainpanel,signuppanel,coverpanel;
	JTextField namefield,emailfield,agefield;
	ImageIcon logo,background,img;
	JLabel  Backgroundlabel,l1,l2,l3,l4,l5,l6,l7,l8,l9,imagelabel;
	JRadioButton maleButton,femaleButton;
	JPasswordField passfield,confirmpassfield;
	public SignUp()
	{
		frame =new JFrame("Create Account - EmotionBasedMusicPlayer");
		frame.setSize(1950,1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	
	logo=new ImageIcon("logo.jpeg");
	
	frame.setIconImage(logo.getImage());
	
	
	background=new ImageIcon("im1.jpeg");
	Image scaledBgImage = background.getImage().getScaledInstance(1950, 1100, Image.SCALE_SMOOTH);
	Backgroundlabel=new JLabel(new ImageIcon(scaledBgImage));
	Backgroundlabel.setLayout(null);
    Backgroundlabel.setBounds(0,0,1950,1100);
    
   
    mainpanel=new JPanel();
	mainpanel.setLayout(new BorderLayout());
	//mainpanel.setBackground(Color.green);
	mainpanel.setBounds(150,100,1650,800);

	
	
	signuppanel=new JPanel();
	signuppanel.setLayout(null);
	signuppanel.setPreferredSize(new Dimension(900,1100));
	signuppanel.setBackground(new Color(0xF5F5F5));
	
	JLabel l1=new JLabel("Welcome");
	l1.setBounds(100,100,250,20);
	//l1.setBorder(null);
	l1.setBackground(new Color(0xF5F5F5));
	l1.setForeground(new Color(0,107,99));
	l1.setFont(new Font("Aerial",Font.BOLD,22));
	l1.setOpaque(true);
	
	
	 JLabel l2=new JLabel("Music Lover !");
	l2.setBounds(100,130,250,30);
	l2.setBorder(null);
	l2.setBackground(new Color(0xF5F5F5));
	l2.setForeground(new Color(0,107,99));
	l2.setFont(new Font("Aerial",Font.BOLD,28));
	l2.setOpaque(true);
	
	JLabel l3=new JLabel("Signup to enjoy music that matches your mood and lifts your emotions... ");
	l3.setBounds(100,200,650,30);
	l3.setBorder(null);
	l3.setBackground(new Color(0xF5F5F5));
	l3.setForeground(new Color(0,107,99));
	l3.setFont(new Font("Aerial",Font.PLAIN,20));
	l3.setOpaque(true);
	
	
	JLabel l4=new JLabel("Enter name");
	l4.setBounds(200,280,100,30);
	l4.setBorder(null);
	l4.setBackground(new Color(0xF5F5F5));
	l4.setForeground(new Color(0,107,99));
	l4.setFont(new Font("Aerial",Font.BOLD,16));
	l4.setOpaque(true);
	
	namefield=new JTextField();
	namefield.setBounds(360,280,220,30);
	namefield.setBorder(null);
	//t1.setBackground(new Color(0xF5F5F5));
	namefield.setForeground(new Color(0,107,99));
	namefield.setFont(new Font("Aerial",Font.PLAIN,16));
	
	JLabel l5=new JLabel("Enter email ");
	l5.setBounds(200,340,100,30);
	l5.setBorder(null);
	l5.setBackground(new Color(0xF5F5F5));
	l5.setForeground(new Color(0,107,99));
	l5.setFont(new Font("Aerial",Font.BOLD,16));
	l5.setOpaque(true);
	
	
	
	emailfield=new JTextField();
	emailfield.setBounds(360,340,220,30);
	emailfield.setBorder(null);
	//t1.setBackground(new Color(0xF5F5F5));
	emailfield.setForeground(new Color(0,107,99));
	emailfield.setFont(new Font("Aerial",Font.PLAIN,16));
	
	 JLabel l6=new JLabel("Enter Age ");
	l6.setBounds(200,400,100,30);
	l6.setBorder(null);
	l6.setBackground(new Color(0xF5F5F5));
	l6.setForeground(new Color(0,107,99));
	l6.setFont(new Font("Aerial",Font.BOLD,16));
	l6.setOpaque(true);
	
	
	agefield=new JTextField();
	agefield.setBounds(360,400,220,30);
	agefield.setBorder(null);
	agefield.setForeground(new Color(0,107,99));
	agefield.setFont(new Font("Aerial",Font.PLAIN,16));
	
	
	
	JLabel l7=new JLabel("Select gender");
	l7.setBounds(200,460,150,30);
	l7.setBorder(null);
	l7.setBackground(new Color(0xF5F5F5));
	l7.setForeground(new Color(0,107,99));
	l7.setFont(new Font("Aerial",Font.BOLD,16));
	l7.setOpaque(true);
	
	
	maleButton =new JRadioButton("male");
	maleButton.setBounds(360,460,105,30);
	maleButton.setBackground(new Color(0xF5F5F5));
	maleButton.setForeground(new Color(0,107,99));
	maleButton.setFont(new Font("Aerial",Font.BOLD,16));
	
	
	femaleButton =new JRadioButton("female");
	femaleButton.setBounds(475,460,105,30);
	
	femaleButton.setBackground(new Color(0xF5F5F5));
	femaleButton.setForeground(new Color(0,107,99));
	femaleButton.setFont(new Font("Aerial",Font.BOLD,16));
	
	
	
	ButtonGroup group=new ButtonGroup();
	group.add(maleButton);
    group.add(femaleButton);	
		
	
	JLabel l8=new JLabel("Enter password");
	l8.setBounds(200,520,150,30);
	l8.setBorder(null);
	l8.setBackground(new Color(0xF5F5F5));
	l8.setForeground(new Color(0,107,99));
	l8.setFont(new Font("Aerial",Font.BOLD,16));
	l8.setOpaque(true);
	
	passfield=new JPasswordField();
	passfield.setBounds(360,520,220,30);
	passfield.setBorder(null);
	//t1.setBackground(new Color(0xF5F5F5));
	passfield.setForeground(new Color(0,107,99));
	passfield.setFont(new Font("Aerial",Font.PLAIN,16));
	
	 JLabel l9=new JLabel("Re-enter password");
	l9.setBounds(200,580,150,30);
	l9.setBorder(null);
	l9.setBackground(new Color(0xF5F5F5));
	l9.setForeground(new Color(0,107,99));
	l9.setFont(new Font("Aerial",Font.BOLD,16));
	l9.setOpaque(true);
	
	
	confirmpassfield=new JPasswordField();
	confirmpassfield.setBounds(360,580,220,30);
	confirmpassfield.setBorder(null);
	confirmpassfield.setForeground(new Color(0,107,99));
	confirmpassfield.setFont(new Font("Aerial",Font.PLAIN,16));
	
	
	signup=new JButton("SignUp");
	signup.setBounds(410,660,100,30);
	signup.setBorder(null);
	signup.setForeground(new Color(0xF5F5F5));
	signup.setBackground(new Color(0,107,99));
	signup.setFont(new Font("Aerial",Font.BOLD,16));
	signup.addActionListener(this);
	
	login=new JButton("Already have an account ?");
	login.setBounds(270,700,380,40);
	login.setBorder(null);
	login.setBackground(new Color(0xF5F5F5));
	login.setForeground(new Color(0,107,99));
	login.setFont(new Font("Aerial",Font.PLAIN,16));
	login.setCursor(new Cursor(Cursor.HAND_CURSOR));
	login.addActionListener(this);
	
	
	JSeparator line2 = new JSeparator();
	line2.setBounds(100, 170, 180, 40); // adjust as needed
	line2.setForeground(new Color(0,107,99));
	
	
	
	signuppanel.add(l1);
	
	signuppanel.add(l2);
	signuppanel.add(l3);
	
	signuppanel.add(l4);
	signuppanel.add(namefield);
	signuppanel.add(l5);
	signuppanel.add(emailfield);
	signuppanel.add(l6);
	signuppanel.add(agefield);
	signuppanel.add(l7);
	signuppanel.add(maleButton);
	signuppanel.add(femaleButton);
	signuppanel.add(l8);
	signuppanel.add(passfield);
	signuppanel.add(l9);
	signuppanel.add(confirmpassfield);
	
	signuppanel.add(signup);
	signuppanel.add(login);
	signuppanel.add(line2);
	
	
	back=new JButton() ;
	 back.setText("Back");
	 back.setBounds(10,10,60,20);
	 back.setFont(new Font("Arial",Font.BOLD,18));
	 back.setBorder(null);
	 back.setBackground(new Color(0,107,99));
	 back.setForeground(new Color(0xF5F5F5));
	back.addActionListener(this);
	
	imagelabel=new JLabel();
	imagelabel.setLayout(null);
	imagelabel.setPreferredSize(new Dimension(1050,1100));
	

	img=new ImageIcon("im2.jpeg");	
	imagelabel.setIcon(img);
	imagelabel.setOpaque(true);
	
	mainpanel.add(signuppanel,BorderLayout.WEST);
	mainpanel.add(imagelabel,BorderLayout.EAST);
	
	Backgroundlabel.add(mainpanel);
	Backgroundlabel.add(back);
	frame.add(Backgroundlabel);
	frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signup)
		// TODO Auto-generated method stub
		{String password1=new String(passfield.getPassword());
		String password2=new String (confirmpassfield.getPassword());
		String name=namefield.getText().trim();
		String email=emailfield.getText().trim();
		String agestr=agefield.getText().trim();
		String gender="";
		if(maleButton.isSelected())
		{
			gender="male";
		}
		else if (femaleButton.isSelected())
		{
			gender="female";
		}
		
		
		
		if(name.isEmpty()||email.isEmpty()||agestr.isEmpty()||password1.isEmpty()||password2.isEmpty()||gender.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "please fill all the fields", "Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (!email.matches("^.+@.+\\..+$")) {
		    JOptionPane.showMessageDialog(null, "Enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		int age;	
		try{
			age=Integer.parseInt(agestr);
			if(age<0) 
				throw new NumberFormatException();
				
		}catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(null, "Enter a valid age","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!password1.equals(password2))
		{
			JOptionPane.showMessageDialog(null, "passwords donot match ","Error",JOptionPane.ERROR_MESSAGE);
		passfield.setText("");
		confirmpassfield.setText("");
		return;
		}
		else
		{
			User user=new User(name,email,password1,gender,age);
			if(user.userSignup())
			{
				
				new UserDashboard(user);
				 frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Registration failed");
			}
				
		}
		}
		else if(e.getSource()==login)
		{
			new Login();
			 frame.dispose();
		}
		
		else if(e.getSource()==back)
	    	new Main();
		frame.dispose();
	}
	
}
