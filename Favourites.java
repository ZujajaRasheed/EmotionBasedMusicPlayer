package defaultt;



import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.*;

public class Favourites implements ActionListener {
    JFrame frame = new JFrame("FavouriteSongs-Emotion Based Music Player");
    JPanel panel1 = new JPanel();
    JPanel picpanel=new JPanel();
    JPanel sidepanel=new JPanel();
    JPanel songpanel = new JPanel();
    JPanel panel=new JPanel();
    JButton h,back,log;
    JButton prev,play_pause,next;
    JLabel songlabel=new JLabel();
    
    DefaultTableModel tableModel;
    JTable tb;
  
   private favPlayer obj;
private User user1;
    Favourites(User user) {
    	this.user1=user;

		
        obj=new favPlayer(user.getEmail());
        
        frame.setSize(1950, 1100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0xf5f5f5));
        ImageIcon logo = new ImageIcon("logo.jpeg");
		frame.setIconImage(logo.getImage());
		
		
        JLabel umbrella=new JLabel();
        umbrella.setBounds(0,0,1300,1100);
        ImageIcon img1=new ImageIcon(new ImageIcon("umbrella.png").getImage().getScaledInstance(1300, 1050, Image.SCALE_SMOOTH));
        umbrella.setIcon(img1);
        frame.add(umbrella);
        
        sidepanel.setBounds(0,0,150,200);
        sidepanel.setLayout(null);
      sidepanel.setBackground(new Color(255,255,255,100));
     umbrella.add(sidepanel);
     
	 h=new JButton() ;
	 h.setText("Home");
	 h.setFont(new Font("Arial",Font.BOLD,14));
	 h.setBounds(55,18,50,20);
	 h.setBorder(null);
	 h.setForeground(new Color(0,107,99));
	 h.setBackground(new Color(255,255,255,100));
	 h.setFocusable(false);
	 JLabel home=new JLabel();
	 ImageIcon img11 =new ImageIcon(new ImageIcon("home1.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
	 home.setIcon(img11);
	 home.setBounds(20,15,35,30);
	 h.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 new UserDashboard(user1);
			 frame.dispose();
		 }
	 });
	 log=new JButton() ;
	 log.setText("Logout");
	 log.setBounds(55,78,60,20);
	 log.setFont(new Font("Arial",Font.BOLD,14));
	 log.setBorder(null);
	 log.setForeground(new Color(0,107,99));
	 log.setBackground(new Color(255,255,255,100));
	 log.setFocusable(false);
	 JLabel Lg=new JLabel();
	 ImageIcon img12 =new ImageIcon(new ImageIcon("logout1.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
	 Lg.setIcon(img12);
	 Lg.setBounds(20,75,35,30);
	 log.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 new Main();
			 frame.dispose();
		 }
	 });
	 back=new JButton() ;
	 back.setText("Back");
	 back.setBounds(55,138,60,20);
	 back.setFont(new Font("Arial",Font.BOLD,14));
	 back.setBorder(null);
	 back.setForeground(new Color(0,107,99));
	 back.setBackground(new Color(255,255,255,100));
	 back.setFocusable(false);

	 Lg.setBounds(20,75,35,30);
	 back.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		new UserDashboard(user1);
			 frame.dispose();
		 }
	 });
sidepanel.add(log);sidepanel.add(h);
sidepanel.add(Lg);sidepanel.add(home);sidepanel.add(back);
        
        panel1.setBounds(1250, 200, 500, 600);
        panel1.setBackground(new Color(0, 107, 99));
        panel1.setLayout(null);
        frame.add(panel1);
     //   frame.add(sidepanel);
        picpanel.setBounds(0,0,500,200);
        picpanel.setLayout(null);
        picpanel.setBackground(new Color(0x006b63));
        JLabel image=new JLabel();
        image.setBounds(50,0,600,200);
        ImageIcon img=new ImageIcon("echoes.png");
        image.setIcon(img);
        picpanel.add(image);
        panel1.add(picpanel);

        songpanel.setBackground(Color.WHITE);
        songpanel.setBounds(70, 200, 370, 280);
        songpanel.setLayout(null);

        String[] columns= {"Songs","❤","FilePath"};
        tableModel=new DefaultTableModel(null,columns) {
        	public boolean isCellEditable(int row,int column) {
        		return false;
        	}
        };
        tb=new JTable(tableModel);
        tb.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{ setHorizontalAlignment(SwingConstants.CENTER); }});
        tb.setRowHeight(50);
        tb.setBackground(Color.white);
        tb.setShowGrid(false);
        tb.setBorder(null);
        tb.getColumnModel().getColumn(2).setMinWidth(0);
    	tb.getColumnModel().getColumn(2).setMaxWidth(0);
    	tb.getColumnModel().getColumn(2).setWidth(0);
    	tb.setSelectionBackground(new Color(0x2E8B57));
    	tb.setSelectionForeground(Color.white);
    	
    	JTableHeader header = tb.getTableHeader();
   	 		header.setBackground(Color.white);
   	 		header.setForeground(new Color(0x006b63));
   	 		header.setOpaque(false);
   	 		//header.setFont(new Font("Arial",Font.BOLD,10));

        JScrollPane sp = new JScrollPane(tb);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBounds(70, 200, 370, 280);
        sp.setBorder(null);
        panel1.add(sp);
        sp.setBackground(Color.white);
        sp.getViewport().setBackground(Color.white);
    	sp.getVerticalScrollBar().setBackground(Color.white);
    	sp.getVerticalScrollBar().setForeground(Color.BLACK);
    	sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    	    @Override
    	    protected void configureScrollBarColors() {
    	        this.thumbColor = Color.decode("#e0e0e0");
    	    }

    	    @Override
    	    protected JButton createDecreaseButton(int orientation) {
    	        JButton button = super.createDecreaseButton(orientation);
    	        button.setBackground(new Color(0XF5F5F5)); 
    	        button.setForeground(Color.black);
    	        return button;
    	    }

    	    @Override
    	    protected JButton createIncreaseButton(int orientation) {
    	        JButton button = super.createIncreaseButton(orientation);
    	        button.setBackground(new Color(0XF5F5F5)); 
    	        button.setForeground(Color.black);
    	        return button;
    	    }
    	});
      //playing buttons
      		prev=new JButton();  
      		prev.setText("<<");
      		prev.setFont(new Font("Arial",Font.BOLD,20));
      		prev.setBorder(null);
      		prev.setBackground(new Color(0,107,99));
      		prev.setForeground(Color.white);
      		prev.setFocusable(false);
      		prev.addActionListener(this);
      		
      		play_pause=new JButton();
      		play_pause.setText("▶");
      		play_pause.setBorder(null);
      		play_pause.setBackground(new Color(0,107,99));
      		play_pause.setForeground(Color.white);
      		play_pause.addActionListener(this);
      		play_pause.setFocusable(false);
      		
      		next=new JButton();
      		next.setText(">>");
      		next.setFont(new Font("Arial",Font.BOLD,20));
      		next.setBorder(null);
      		next.setBackground(new Color(0,107,99));
      		next.setForeground(Color.white);		
      		next.setFocusable(false);
      		next.addActionListener(this);
      		prev.setBounds(140, 520, 60, 50);
      		play_pause.setBounds(220, 520, 60, 50);
      		next.setBounds(300, 520, 60, 50);
      		
      		songlabel.setBounds(130, 480, 300, 50);
      		songlabel.setFont(new Font("Arial",Font.BOLD,17));
      	

      		panel1.add(play_pause);panel1.add(prev);panel1.add(next);
      		panel1.add(songlabel);
      		
      		obj.setPlay(play_pause);
      		obj.setsongLabel(songlabel);
      		obj.setTable(tb);
      		obj.setTableModel(tableModel);
      		
        obj.loadfav();
    }

    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == play_pause) {
	        obj.play();
	    }
		
		if(e.getSource()==next) {
			obj.next();
		}
		if(e.getSource()==prev) {
			obj.prev();
		}
			}	
}