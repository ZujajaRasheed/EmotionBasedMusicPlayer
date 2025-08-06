package defaultt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements ActionListener{

	JFrame frame;
	JButton login,signup;

	
	ImageIcon logo,background1;
	JLabel  l1;
	
	public Main()
	{
		
	
	frame =new JFrame("EmotionBasedMusicPlayer");
	frame.setSize(1950,1100);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	logo=new ImageIcon("logo.jpeg");
	frame.setIconImage(logo.getImage());
	
	
	 ImageIcon background1 = new ImageIcon(new ImageIcon("mainimg.jpeg").getImage().getScaledInstance(1950, 1100, Image.SCALE_SMOOTH));
	 l1 = new JLabel();
	 l1.setBounds(0,0,1950,1100);
	 l1.setIcon(background1);

	
	
	
	 login=new JButton("Login");
		login.setFont(new Font("Aerial ",Font.BOLD,20));
		login.setBounds(550,620,200,30);
		login.setBackground(new Color(0,107,99));
		login.setBorder(null);
		login.setForeground(Color.white);
		login.addActionListener(this);
		
		signup=new JButton("Signup");
		signup.setFont(new Font("Aerial ",Font.PLAIN,18));
		signup.setBounds(330,620,200,30);
		signup.setBackground(new Color(0,107,99));
		signup.setBorder(null);
		signup.setForeground(Color.white);
		signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signup.addActionListener(this);
		
		l1.add(login);
		l1.add(signup);
		frame.add(l1);
		
		frame.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login)
		
		{	new Login();
		frame.dispose();
		}
		else if(e.getSource()==signup)
		{	
			new SignUp();
		frame.dispose();
		}
	}
	
}
