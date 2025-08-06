package defaultt;

import java.awt.Color;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserDashboard implements ActionListener{

	
	
	JFrame frame;
	JButton DetectEmotion,ViewProfile,ViewFav,LogOut;
	JPanel mainpanel,toppanel;
	JTextArea profileTextArea;
	ImageIcon logo,background,img;
	JLabel  Backgroundlabel,profilelabel;
	private User user;
	public UserDashboard(User user)
	{
        this.user=user;
		frame =new JFrame("User Dashboard - EmotionBasedMusicPlayer");
		frame.setSize(1950,1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	    
	    logo=new ImageIcon("logo.jpeg");
		frame.setIconImage(logo.getImage());
	
		background=new ImageIcon("dashboard.jpeg");
		Image scaledBgImage = background.getImage().getScaledInstance(1950, 1100, Image.SCALE_SMOOTH);
		Backgroundlabel=new JLabel(new ImageIcon(scaledBgImage));
		Backgroundlabel.setLayout(null);
	    Backgroundlabel.setBounds(0,0,1950,1100);
	    
	    
	    toppanel=new JPanel();
	    
		toppanel.setLayout(null);
		toppanel.setBackground(new Color(0xF5F5F5));
		toppanel.setBounds(0, 0, 900, 340);
		
		
		JLabel l=new JLabel();
		 l.setBounds(400,10,400,30);
		 l.setText("Welcome to Your Music Mood Dashboard");
		 l.setBorder(null);
		 l.setBackground(new Color(0xF5F5F5));
		 l.setForeground(new Color(0,107,99));
		 l.setFont(new Font("Aerial",Font.BOLD,18));
		 l.setOpaque(true);
		
		
		
		 JLabel l1=new JLabel();
		 l1.setBounds(10,80,500,30);
		 l1.setText("\"Everything You Need, One Click Away.\"");
		 l1.setBorder(null);
		 l1.setBackground(new Color(0xF5F5F5));
		 l1.setForeground(new Color(0,107,99));
		 l1.setFont(new Font("Aerial",Font.BOLD,20));
		 l1.setOpaque(true);
		 
		 JLabel l2=new JLabel();
		 l2.setBounds(10,150,900,30);
		 l2.setText("This dashboard is built to keep you in control — feel your vibe, manage your data, and groove to your mood.");
		 l2.setBorder(null);
		 l2.setBackground(new Color(0xF5F5F5));
		 l2.setForeground(new Color(0,107,99));
		 l2.setFont(new Font("Aerial",Font.PLAIN,16));
		 l2.setOpaque(true);
		 
		 JLabel l3=new JLabel();
		 l3.setBounds(10,200,600,30);
		 l3.setText("Music that's more than sound — it's emotional intelligence in action.");
		 l3.setBorder(null);
		 l3.setBackground(new Color(0xF5F5F5));
		 l3.setForeground(new Color(0,107,99));
		 l3.setFont(new Font("Aerial",Font.BOLD,18));
		 l3.setOpaque(true);
		 
		
		 toppanel.add(l1);
		 toppanel.add(l2);
		 toppanel.add(l3);
		
	    
	    
	    
	    
	    mainpanel=new JPanel();
		mainpanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		mainpanel.setOpaque(false);
		mainpanel.setBounds(300, 300, 1400, 600);
		String titles[]= {"Detect Emotion","View Profile","View Favourites","Logout"};
		for (int i = 0; i < 4; i++) {
             
            ImageIcon icon = new ImageIcon(new ImageIcon("immg" + i + ".png").getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH));          
        
            JButton btn=new JButton();
            btn.setIcon(icon);
            btn.setPreferredSize(new Dimension(350, 350)); // Button size
            
            btn.setActionCommand(titles[i]); 
            btn.addActionListener(this);     
            btn.setBackground(new Color(0xF5F5F5));
        	btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(null);
            btn.setAlignmentX(JButton.CENTER_ALIGNMENT);

            JLabel label=new JLabel(titles[i],JLabel.CENTER);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            label.setFont(new Font("Aerial",Font.BOLD,24));
            label.setForeground(new Color(0,107,99));
            //vertical box for label+button
            JPanel verticalBox=new JPanel();
            verticalBox.setLayout(new BoxLayout(verticalBox,BoxLayout.Y_AXIS));
            verticalBox.setPreferredSize(new Dimension(300,400));
            verticalBox.setBackground(new Color(0xF5F5F5));
            verticalBox.add(btn);
            verticalBox.add(Box.createVerticalStrut(10));//spacing between button and label
            verticalBox.add(label);
            mainpanel.add(verticalBox);
          
            Backgroundlabel.add(mainpanel);
            }
		
		 profileTextArea = new JTextArea();
		
		profileTextArea.setFont(new Font("Aerial",Font.PLAIN,18));
		profileTextArea.setForeground(new Color(0xF5F5F5));
		profileTextArea.setBackground(new Color(0, 107, 99));
		profileTextArea.setEditable(false);
		profileTextArea.setOpaque(false);
		

		JScrollPane scrollpane=new JScrollPane(profileTextArea);
		scrollpane.setBounds(1600, 730, 300, 300);
		scrollpane.getViewport().setOpaque(false);
		scrollpane.setOpaque(false);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(null);
		
		// Change vertical scrollbar color
		scrollpane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor =new Color(0xF5F5F5) ; // Scrollbar handle color
		        this.trackColor = new Color(0,107,99); // Scrollbar background
		    }
		});
		// Change horizontal scrollbar color
		scrollpane.getHorizontalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(0xF5F5F5);//handler color
		        this.trackColor = new Color(0,107,99);//backgroundcolor
		    }
		});
		  Backgroundlabel.add(toppanel);
		Backgroundlabel.add(scrollpane);
		frame.add(Backgroundlabel);
	
            frame.setVisible(true);
            
        }
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command =e.getActionCommand();
		
		if (command.equals("Detect Emotion")) 
		{
	        new EmotionsGui(user);
	        frame.dispose();
	    } 
		else if (command.equals("View Profile"))
		{
			String profileInfo=user.getProfileInfo();
			profileTextArea.setText(profileInfo);
	        profileTextArea.setOpaque(true);
	    
	
		} 
		else if (command.equals("View Favourites")) 
		{
	        System.out.println("Favourites button  has clicked");
	        new Favourites(user);
	        frame.dispose();
	    } 
		else if (command.equals("Logout"))
		{
	       new Main();
	       frame.dispose();
	    }
	}
		
	}




