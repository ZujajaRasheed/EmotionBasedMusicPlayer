//package defaultt;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.plaf.basic.BasicScrollBarUI;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSlider;
//import javax.swing.JTable;
//import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//
//public class AdminDashboard implements ActionListener{
//
//	JFrame frame;
//	JSlider s;
//	ImageIcon logo,buttonImage,left_img;
//	JPanel leftpanel,	 tablepanel,lowerpanel;
//	JButton prev,next,play_pause;
//	JLabel piclabel, rightlabel;
//	DefaultTableModel model;
//	JTable table;
//	JScrollPane scrollpane ;
//	public AdminDashboard()
//	{
//		
//		frame=new JFrame();
//		frame.setSize(1950,1100);
//		frame.setTitle("Admin Dashboard - EmotionBasedMusicPlayer");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);
//		logo=new ImageIcon("logo.jpeg");
//		frame.setIconImage(logo.getImage());
//		
//		
//		leftpanel=new JPanel();
//		leftpanel.setBackground(new Color(0,107,99));
//		leftpanel.setBounds(0,0,300,1100);
//		leftpanel.setLayout(new BoxLayout(leftpanel,BoxLayout.Y_AXIS));
//		
//		String title[]= {"View Songs","Add Song","Delete Song","View Feedbacks","View Users","Delete User","View Favourites","Delete Feedback","Logout"};
//		
//		leftpanel.add(Box.createVerticalStrut(150));
//		for(int i=0;i<9;i++)
//		{
//			JButton btn=new JButton(title[i]);
//			buttonImage=new ImageIcon(new ImageIcon("ad"+i+".jfif").getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH));
//		    btn.setBorder(null);
//		    btn.setActionCommand(title[i]);
//		    btn.addActionListener(this);
//		    btn .setAlignmentX(JButton.CENTER_ALIGNMENT);
//		    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		    btn.setPreferredSize(new Dimension(130, 30)); 
//		    btn.setFont(new Font("Aerial",Font.BOLD,14));
//            btn.setForeground(new Color(0xF5F5F5));
//            btn.setBackground(new Color(0,107,99));
//            btn.setFocusable(false);
//		    JLabel label=new JLabel(buttonImage);
//		    
//		 
//		    
//            label.setPreferredSize(new Dimension(80, 50)); // fixed width
//        
//            
//          JPanel  horizontalpanel=new JPanel();
//          horizontalpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//          horizontalpanel.setMaximumSize(new Dimension(400, 50)); // Controls height of each row
//          horizontalpanel.setBackground(new Color(0,107,99));
//         
//          horizontalpanel.add(label);
//          horizontalpanel.add(btn);
//          leftpanel.add(horizontalpanel);
//      	leftpanel.add(Box.createVerticalStrut(10));
//
//		}
//		leftpanel.add(Box.createVerticalStrut(50));
//		leftpanel.setBorder(BorderFactory.createLineBorder(new Color(0xF5F5F5), 2));
////		left_img=new ImageIcon(new ImageIcon("im2.jpeg").getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH));
////		JLabel l1=new JLabel(left_img);
////		l1.setPreferredSize(new Dimension(400,500));
////		l1.setBackground(new Color(0,107,99));
////		l1.setAlignmentX(l1.LEFT_ALIGNMENT);
//		//leftpanel.add(l1);
//		ImageIcon image=new ImageIcon(new ImageIcon("admin.png").getImage().getScaledInstance(1650, 1150, Image.SCALE_SMOOTH));
//	    rightlabel=new JLabel(image);
//		rightlabel.setBounds(300,0,1650,1150);
//	//topimage label
//		piclabel=new JLabel();
//	    piclabel.setBounds(0,0,1650,300);
//	    piclabel.setBorder(BorderFactory.createLineBorder(new Color(0,107,99), 1));
//		piclabel.setVisible(false);
//		
//	    tablepanel=new JPanel();
//		tablepanel.setBounds(280,300,900,500);
//		//tablepanel.setBackground(Color.green);
//		tablepanel.setLayout(new BorderLayout());
//	    tablepanel.setBorder(null);
//		 table=new JTable();
//		 table.setRowHeight(40);
//		 table.setIntercellSpacing(new Dimension(10, 10));
//         table.setBackground(new Color(0xF5F5F5));
//		 //table.getColumn(3).setPreferredWidth(20);
//		 table.setForeground(new Color(0,107,99));
//		 table.setShowGrid(false);
//		 table.setSelectionBackground(new Color(0,107,99));
//		 table.setSelectionForeground(new Color(0xF5F5F5));
//		table.setBorder(null);
//		 //header styling 
//		 JTableHeader header=table.getTableHeader();
//		 header.setBackground(new Color(0,107,99));
//		 header.setForeground(new Color(0xF5F5F5));
//		 header.setFont(new Font("Segoe UI",Font.BOLD,20));
//		 header.setBorder(null);
//		 
//		 
//		 
//		scrollpane=new JScrollPane(table);
//		scrollpane.setBackground(new Color(0xF5F5F5));
//		scrollpane.getViewport().setBackground(new Color(0xF5F5F5));
//		scrollpane.setBorder(BorderFactory.createLineBorder(new Color(0,107,99), 1));
//		//scrollpane.setBorder(null);
//		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollpane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//			protected void configureScrollBarColors()
//			{
//				this.thumbColor=new Color(0,107,99);
//				this.trackColor=Color.white;
//			}
//			
//			 protected JButton createDecreaseButton(int orientation) {
//                 JButton button = super.createDecreaseButton(orientation);
//                 button.setBackground(new Color(0XF5F5F5));
//                 button.setForeground(Color.black);
//                 return button;
//             }
//
//             @Override
//             protected JButton createIncreaseButton(int orientation) {
//                 JButton button = super.createIncreaseButton(orientation);
//                 button.setBackground(new Color(0XF5F5F5));
//                 button.setForeground(Color.black);
//                 return button;
//             }
//		});
//		tablepanel.add(scrollpane,BorderLayout.CENTER);
//        
//		
//         tablepanel.setVisible(false);
//			
//         lowerpanel=new JPanel();
//         lowerpanel.setBounds(320,900,800,200);
//         lowerpanel.setBackground(new Color(0xF5F5F5));
//         lowerpanel.setBorder(null);
//         lowerpanel.setLayout(null);
//         
//         
//         prev = new JButton("<<");
//         prev.setBounds(300, 50, 50, 30);
//         prev.setFont(new Font("Arial", Font.BOLD, 20));
//         prev.setBorder(null);
//         prev.setForeground(new Color(0, 107, 99));
//         prev.setBackground(new Color(0xF5F5F5));
//         prev.setFocusable(false);
//         prev.addActionListener(this); // Make sure 'this' implements ActionListener
//
//         play_pause = new JButton("▶");
//         play_pause.setBounds(350, 50, 50, 30);
//         play_pause.setBorder(null);
//         play_pause.setForeground(new Color(0, 107, 99));
//         play_pause.setBackground(new Color(0xF5F5F5));
//         play_pause.addActionListener(this);
//         play_pause.setFocusable(false);
//
//         next = new JButton(">>");
//         next.setBounds(400, 50, 50, 30);
//         next.setFont(new Font("Arial", Font.BOLD, 20));
//         next.setBorder(null);
//         next.setForeground(new Color(0, 107, 99));
//         next.setBackground(new Color(0xF5F5F5));
//         next.setFocusable(false);
//         next.addActionListener(this);
//         
//         s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
//         s.setMajorTickSpacing(10);
//         s.setBounds(0, 0, 800, 20); 
//         s.setForeground(new Color(0, 107, 99)); 
//         s.setBackground(new Color(0xF5F5F5)); 
//         
//         lowerpanel.add(prev);
//         lowerpanel.add(play_pause);
//         lowerpanel.add(next);
//         lowerpanel.add(s);
//         
//         lowerpanel.setVisible(false);
//         
//         
//         
//         
//         
//		 rightlabel.add(piclabel);
//		rightlabel.add(tablepanel);
//		rightlabel.add(lowerpanel);
//		
//		frame.add(rightlabel);
//		frame.add(leftpanel);
//	
//		frame.setVisible(true);
//		
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//	//	Admindashbo
//		Admin admin=new Admin( new AdminDashboard());
//		String btn= e.getActionCommand();
//		if(btn.equals("View Songs"))	
//		{
//			  DefaultTableModel songsModel =admin.viewSongs();
//		        table.setModel(songsModel); // Reuse the same JTable
//			  lowerpanel.setVisible(true);
//			  table.getColumnModel().getColumn(4).setMinWidth(0);
//		    	table.getColumnModel().getColumn(4).setMaxWidth(0);
//		    	table.getColumnModel().getColumn(4).setWidth(0);
//				
//			
//			ImageIcon topImage=new ImageIcon(new ImageIcon("admins.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));
//			piclabel.setIcon(topImage);
//			piclabel.setVisible(true);
//		
//			tablepanel.setVisible(true);
//		}
//		else	if(btn.equals("Add Song"))
//		{
//		String song_title=JOptionPane.showInputDialog("Tell me title of song");
//		String artist_name=JOptionPane.showInputDialog("Tell me song's artist name");
//		String song_genre=JOptionPane.showInputDialog("Tell me song genre");	
//		String song_path=JOptionPane.showInputDialog("Tell me song's path");	
//		String[] emotions = {"Happy", "Sad", "Angry", "Romantic"};
//		String song_emotion = (String) JOptionPane.showInputDialog(null, "Select emotion:", "Emotion",
//		               JOptionPane.QUESTION_MESSAGE, null, emotions, emotions[0]);
//		if(song_title==null||song_title.trim().isEmpty()||artist_name==null||artist_name.trim().isEmpty()||song_genre==null||song_genre.trim().isEmpty()||song_path==null||song_path.trim().isEmpty()||song_emotion==null||song_emotion.trim().isEmpty())
//			return ;
//
//		
//		if(	admin.addSong(song_title,artist_name,song_genre,song_path,song_emotion))
//		{
//			JOptionPane.showMessageDialog(null, "Sond added successfully");
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(null, "Failed to add song");
//		}
//		}
//		else	if(btn.equals("Delete Song"))
//		{
//			String id=JOptionPane.showInputDialog("Tell me Song-ID to delete a song");
//		
//			try
//			{
//			int songid=Integer.parseInt(id);
//		if(songid>0)
//		{
//			if(admin.deleteSong(songid))
//			{
//				JOptionPane.showMessageDialog(null, "SongID "+songid+" has deleted");
//			}
//		else
//		{
//			JOptionPane.showMessageDialog(null, "Invalid Song ID");
//		}
//		}
//		
//		}catch(Exception e1)
//			{
//			JOptionPane.showMessageDialog(null, "Please enter a valid numeric Song ID.");
//			}
//		}
//		else	if(btn.equals("View Feedbacks"))
//		{DefaultTableModel favmodel=admin.viewFavourites();
//			table.setModel(favmodel);
//		ImageIcon topImage=new ImageIcon(new ImageIcon("adminf.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));	
//			piclabel.setIcon(topImage);
//		}
//		else	if(btn.equals("View Users"))
//		{
//			model=admin.viewUser();
//			
//		
//			table.setModel(model);
//		
//			ImageIcon topImage=new ImageIcon(new ImageIcon("adminu.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));
//			piclabel.setIcon(topImage);
//			piclabel.setVisible(true);
//			tablepanel.setVisible(true);
//			lowerpanel.setVisible(false);
//		}
//		else	if(btn.equals("View Favourites"))
//		{
//			ImageIcon topImage=new ImageIcon(new ImageIcon("adminfav.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));	
//			piclabel.setIcon(topImage);
//		}
//		else	if(btn.equals("Delete Feedback"))
//		{
//			
//		}
//		else	if(btn.equals("Delete User"))
//		{
//			String email=JOptionPane.showInputDialog("Enter user's email to delete user");
//			if(email==null||email.trim().isEmpty())
//				{JOptionPane.showMessageDialog(null,"Plz enter email to delete user");
//			return;
//				}
//			
//			if(admin.deleteUser(email))
//			{
//			JOptionPane.showMessageDialog(null, "User whose email is "+email+" has deleted successfully");	
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null, "Invalid email or user not found");
//			}
//		}
//		else	if(btn.equals("Logout"))
//		{
//			new Login();
//		}
//		
//		 //playback controls
//		else if (e.getSource() == play_pause) {
//	        admin.play();
//	    }
//		
//		else if(e.getSource()==next) {
//			admin.next();
//		}
//		else if(e.getSource()==prev) {
//			admin.prev();
//		}
//		
//		
//	}
//	
//	public JTable getTable() {
//		return table;
//	}
//
//	public JButton getplaypause() {
//		return play_pause;
//	}
//	public void updateSlider(int value) {
//        SwingUtilities.invokeLater(() -> s.setValue(value));
//    }
//	
//}


package defaultt;






import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminDashboard implements ActionListener{

	JFrame frame;
	JSlider s;
	ImageIcon logo,buttonImage,left_img;
	JPanel leftpanel,	 tablepanel,lowerpanel;
	JButton prev,next,play_pause;
	JLabel piclabel, rightlabel;
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollpane ;
	
	private Admin admin;
	public AdminDashboard()
	{
		
		frame=new JFrame();
		frame.setSize(1950,1100);
		frame.setTitle("Admin Dashboard - EmotionBasedMusicPlayer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		logo=new ImageIcon("logo.jpeg");
		frame.setIconImage(logo.getImage());
		
		
		leftpanel=new JPanel();
		leftpanel.setBackground(new Color(0,107,99));
		leftpanel.setBounds(0,0,300,1100);
		leftpanel.setLayout(new BoxLayout(leftpanel,BoxLayout.Y_AXIS));
		
		String title[]= {"View Songs","Add Song","Delete Song","View Feedbacks","View Users","Delete User","View Favourites","Delete Feedback","Logout"};
		
		leftpanel.add(Box.createVerticalStrut(150));
		for(int i=0;i<9;i++)
		{
			JButton btn=new JButton(title[i]);
			buttonImage=new ImageIcon(new ImageIcon("ad"+i+".jfif").getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH));
		    btn.setBorder(null);
		    btn.setActionCommand(title[i]);
		    btn.addActionListener(this);
		    btn .setAlignmentX(JButton.CENTER_ALIGNMENT);
		    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    btn.setPreferredSize(new Dimension(130, 30)); 
		    btn.setFont(new Font("Aerial",Font.BOLD,14));
          btn.setForeground(new Color(0xF5F5F5));
          btn.setBackground(new Color(0,107,99));
          btn.setFocusable(false);
		    JLabel label=new JLabel(buttonImage);
		    
		 
		    
          label.setPreferredSize(new Dimension(80, 50)); // fixed width
      
          
        JPanel  horizontalpanel=new JPanel();
        horizontalpanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        horizontalpanel.setMaximumSize(new Dimension(400, 50)); // Controls height of each row
        horizontalpanel.setBackground(new Color(0,107,99));
       
        horizontalpanel.add(label);
        horizontalpanel.add(btn);
        leftpanel.add(horizontalpanel);
    	leftpanel.add(Box.createVerticalStrut(10));

		}
		leftpanel.add(Box.createVerticalStrut(50));
		leftpanel.setBorder(BorderFactory.createLineBorder(new Color(0xF5F5F5), 2));
//		left_img=new ImageIcon(new ImageIcon("im2.jpeg").getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH));
//		JLabel l1=new JLabel(left_img);
//		l1.setPreferredSize(new Dimension(400,500));
//		l1.setBackground(new Color(0,107,99));
//		l1.setAlignmentX(l1.LEFT_ALIGNMENT);
		//leftpanel.add(l1);
		ImageIcon image=new ImageIcon(new ImageIcon("admin.png").getImage().getScaledInstance(1650, 1150, Image.SCALE_SMOOTH));
	    rightlabel=new JLabel(image);
		rightlabel.setBounds(300,0,1650,1150);
	//topimage label
		piclabel=new JLabel();
	    piclabel.setBounds(0,0,1650,300);
	    piclabel.setBorder(BorderFactory.createLineBorder(new Color(0,107,99), 1));
		piclabel.setVisible(false);
		
	    tablepanel=new JPanel();
		tablepanel.setBounds(280,300,900,500);
		//tablepanel.setBackground(Color.green);
		tablepanel.setLayout(new BorderLayout());
	    tablepanel.setBorder(null);
		 table=new JTable();
		 table.setRowHeight(40);
		 table.setIntercellSpacing(new Dimension(10, 10));
       table.setBackground(new Color(0xF5F5F5));
		 //table.getColumn(3).setPreferredWidth(20);
		 table.setForeground(new Color(0,107,99));
		 table.setShowGrid(false);
		 table.setSelectionBackground(new Color(0,107,99));
		 table.setSelectionForeground(new Color(0xF5F5F5));
		table.setBorder(null);
		 //header styling 
		 JTableHeader header=table.getTableHeader();
		 header.setBackground(new Color(0,107,99));
		 header.setForeground(new Color(0xF5F5F5));
		 header.setFont(new Font("Segoe UI",Font.BOLD,20));
		 header.setBorder(null);
		 
		 
		 
		scrollpane=new JScrollPane(table);
		scrollpane.setBackground(new Color(0xF5F5F5));
		scrollpane.getViewport().setBackground(new Color(0xF5F5F5));
		scrollpane.setBorder(BorderFactory.createLineBorder(new Color(0,107,99), 1));
		
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			protected void configureScrollBarColors()
			{
				this.thumbColor=new Color(0,107,99);
				this.trackColor=Color.white;
			}
			
			 protected JButton createDecreaseButton(int orientation) {
               JButton button = super.createDecreaseButton(orientation);
               button.setBackground(new Color(0XF5F5F5));
               button.setForeground(new Color(0,107,99));
               return button;
           }

           @Override
           protected JButton createIncreaseButton(int orientation) {
               JButton button = super.createIncreaseButton(orientation);
               button.setBackground(new Color(0XF5F5F5));
               button.setForeground(new Color(0,107,99));
               return button;
           }
		});
		tablepanel.add(scrollpane,BorderLayout.CENTER);
      
		
       tablepanel.setVisible(false);
			
       lowerpanel=new JPanel();
       lowerpanel.setBounds(320,900,800,200);
       lowerpanel.setBackground(new Color(0xF5F5F5));
       lowerpanel.setBorder(null);
       lowerpanel.setLayout(null);
       
       
       prev = new JButton("<<");
       prev.setBounds(300, 50, 50, 30);
       prev.setFont(new Font("Arial", Font.BOLD, 20));
       prev.setBorder(null);
       prev.setForeground(new Color(0, 107, 99));
       prev.setBackground(new Color(0xF5F5F5));
       prev.setFocusable(false);
       prev.addActionListener(this); // Make sure 'this' implements ActionListener

       play_pause = new JButton("▶");
       play_pause.setBounds(350, 50, 50, 30);
       play_pause.setBorder(null);
       play_pause.setForeground(new Color(0, 107, 99));
       play_pause.setBackground(new Color(0xF5F5F5));
       play_pause.addActionListener(this);
       play_pause.setFocusable(false);

       next = new JButton(">>");
       next.setBounds(400, 50, 50, 30);
       next.setFont(new Font("Arial", Font.BOLD, 20));
       next.setBorder(null);
       next.setForeground(new Color(0, 107, 99));
       next.setBackground(new Color(0xF5F5F5));
       next.setFocusable(false);
       next.addActionListener(this);
       
       s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
       s.setMajorTickSpacing(10);
       s.setBounds(0, 0, 800, 20); 
       s.setForeground(new Color(0, 107, 99)); 
       s.setBackground(new Color(0xF5F5F5)); 
       
       lowerpanel.add(prev);
       lowerpanel.add(play_pause);
       lowerpanel.add(next);
       lowerpanel.add(s);
       
       lowerpanel.setVisible(false);
       
       
       admin=new Admin();
	     admin.setSlider(s);
			admin.setPlay(play_pause);
			admin.setTable(table);
       
       
		 rightlabel.add(piclabel);
		rightlabel.add(tablepanel);
		rightlabel.add(lowerpanel);
		
		frame.add(rightlabel);
		frame.add(leftpanel);
	
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	String btn= e.getActionCommand();
	
	//view songs
		if(btn.equals("View Songs"))	
		{
			
			
			
			  DefaultTableModel songsModel =admin.viewSongs();
		        table.setModel(songsModel); // Reuse the same JTable
		        table.getColumnModel().getColumn(4).setMinWidth(0);
              table.getColumnModel().getColumn(4).setMaxWidth(0);
              table.getColumnModel().getColumn(4).setWidth(0);
              table.addMouseListener(new MouseAdapter() {
              	public void mouseClicked(MouseEvent e) {
              		int sr=table.getSelectedRow();
              		if(sr>0) {
              			admin.setCurrentIndex(sr);
              			String path=table.getModel().getValueAt(sr, 4).toString();
              			admin.playmusic(path);
              			play_pause.setText("||");
              		}
              	}
              });
			  lowerpanel.setVisible(true);
			
			
			ImageIcon topImage=new ImageIcon(new ImageIcon("admins.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));
			piclabel.setIcon(topImage);
			piclabel.setVisible(true);
		
			tablepanel.setVisible(true);
		}
		
		//add song
		
		else	if(btn.equals("Add Song"))
		{
		String song_title=JOptionPane.showInputDialog("Tell me title of song");
		String artist_name=JOptionPane.showInputDialog("Tell me song's artist name");
		String song_genre=JOptionPane.showInputDialog("Tell me song genre");	
		String song_path=JOptionPane.showInputDialog("Tell me song's path");	
		String[] emotions = {"Happy", "Sad", "Angry", "Romantic"};
		String song_emotion = (String) JOptionPane.showInputDialog(null, "Select emotion:", "Emotion",
		               JOptionPane.QUESTION_MESSAGE, null, emotions, emotions[0]);
		if(song_title==null||song_title.trim().isEmpty()||artist_name==null||artist_name.trim().isEmpty()||song_genre==null||song_genre.trim().isEmpty()||song_path==null||song_path.trim().isEmpty()||song_emotion==null||song_emotion.trim().isEmpty())
			return ;

		
		if(	admin.addSong(song_title,artist_name,song_genre,song_path,song_emotion))
		{
			JOptionPane.showMessageDialog(null, "Sond added successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Failed to add song");
		}
		}
		
		
	//delete song	
		else	if(btn.equals("Delete Song"))
		{
			String id=JOptionPane.showInputDialog("Tell me Song-ID to delete a song");
		
			try
			{
			int songid=Integer.parseInt(id);
		if(songid>0)
		{
			if(admin.deleteSong(songid))
			{
				JOptionPane.showMessageDialog(null, "SongID "+songid+" has deleted");
			}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Song ID");
		}
		}
		
		}catch(Exception e1)
			{
			JOptionPane.showMessageDialog(null, "Please enter a valid numeric Song ID.");
			}
		}
		
//view feedbacks		
		else	if(btn.equals("View Feedbacks"))
		{
			DefaultTableModel model=admin.viewFeedback();
			if(model==null)
			{
				JOptionPane.showMessageDialog(null, "No feedback available");
			}
			else
			{
				table.setModel(model);
			tablepanel.setVisible(true);
			ImageIcon topImage=new ImageIcon(new ImageIcon("adminf.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));	
			piclabel.setIcon(topImage);
			piclabel.setVisible(true);
		}}
		
//view users		
		else	if(btn.equals("View Users"))
		{
			model=admin.viewUser();
			
		
			table.setModel(model);
		
			ImageIcon topImage=new ImageIcon(new ImageIcon("adminu.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));
			piclabel.setIcon(topImage);
			piclabel.setVisible(true);
			tablepanel.setVisible(true);
			lowerpanel.setVisible(false);
		}
		
//	view favourite songs	
		else	if(btn.equals("View Favourites"))
		{
			DefaultTableModel favModel=admin.viewFavourites();
			table.setModel(favModel);
			ImageIcon topImage=new ImageIcon(new ImageIcon("adminfav.png").getImage().getScaledInstance(1650, 300, Image.SCALE_SMOOTH));	
			piclabel.setIcon(topImage);
			piclabel.setVisible(true);
			tablepanel.setVisible(true);
		}
		
//delete feedback
		
	else	if(btn.equals("Delete Feedback"))
		 {
			String option[]= {"Complete feedback","Specific feedback"};
		String choice =	(String)JOptionPane.showInputDialog(null,"Choose the type of deletion","Delete feedback",JOptionPane.QUESTION_MESSAGE,null,option,option[0]) ;
		
		if(choice!=null)
		{
		String song	=JOptionPane.showInputDialog("Enter Song ID");
		String emailaddr=JOptionPane.showInputDialog("Enter email address");
		 
		if (song == null || emailaddr == null || song.trim().isEmpty() || emailaddr.trim().isEmpty()) 
		   {
	            JOptionPane.showMessageDialog(null, "SongID or email address is missing.");
	            return;
	        }
		
		
		int songid;
		try {
			
			 songid=Integer.parseInt(song);
			if(songid<=0)
			throw new NumberFormatException();
				
			}catch(NumberFormatException e1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid songID kindly enter a valid songID(numeric)");
				e1.printStackTrace();
				return;
		   }
		
		if (!emailaddr.matches("^.+@.+\\..+$"))
		{
		JOptionPane.showMessageDialog(null, "Invalid email format ,plz try again");
		return;
		}
		
		//delete complete feedback
		if(choice.equals("Complete feedback"))
		{
			//admin.deleteCompFeedback(emailaddr,songid);
		}
		
		else if(choice.equals("Specific feedback"))
		{
			String feedback[]= {"feedback1","feedback2","feedback3"};
		String columnName=(String)	JOptionPane.showInputDialog(null,"Choose the type of feedback","Delete feedback",JOptionPane.QUESTION_MESSAGE,null,feedback,feedback[0]);
		if(columnName!=null)
		{
			admin.deleteSFeedback(emailaddr,songid,columnName);
		
		}
		
		}
		
		}
		

		 }
		else	if(btn.equals("Delete User"))
		{
			String email=JOptionPane.showInputDialog("Enter user's email to delete user");
			if(email==null||email.trim().isEmpty())
				{JOptionPane.showMessageDialog(null,"Plz enter email to delete user");
			return;
				}
			
			if(admin.deleteUser(email))
			{
			JOptionPane.showMessageDialog(null, "User whose email is "+email+" has deleted successfully");	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid email or user not found");
			}
		}

	//logout
		else	if(btn.equals("Logout"))
		{
			new Main();
		}
		
		// playback controls
		else if (e.getSource()==play_pause ){
	       admin.play();
	    }
		
		else if(e.getSource()==next) {
			admin.next();
		}
		else if(e.getSource()==prev) {
			admin.prev();
	       
		}	
		
	}
	
	
	}
	
       

