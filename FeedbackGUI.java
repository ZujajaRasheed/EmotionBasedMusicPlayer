package defaultt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeedbackGUI extends JFrame implements ActionListener {

    JFrame frame;
    String email;
    int songId;
    ImageIcon logo;
    ImageIcon background, buttonimg1, buttonimg2, buttonimg3;
    JLabel Backgroundlabel, l;
    JButton button1, button2, button3,h,back,logout;
    FeedbackLogic feedbackLogic;
private User user1;
private String emotion;

    public FeedbackGUI(User user, int songId,String emotion) {
       user1=user;
    	email=user1.getEmail();
        this.songId = songId;
        this.emotion=emotion;
        feedbackLogic = new FeedbackLogic(email, songId);

        frame = new JFrame("Feedback-EmotionBasedMusicPlayer");
        frame.setSize(1950, 1100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        logo = new ImageIcon("logo.jpeg");
        frame.setIconImage(logo.getImage());

        background = new ImageIcon("background14.jfif");
        Image scaledBgImage = background.getImage().getScaledInstance(1950, 1100, Image.SCALE_SMOOTH);
        Backgroundlabel = new JLabel(new ImageIcon(scaledBgImage));
        Backgroundlabel.setLayout(null);
        Backgroundlabel.setBounds(0, 0, 1950, 1100);

        buttonimg1 = new ImageIcon("buttonimg1.jfif");
        Image but1 = buttonimg1.getImage().getScaledInstance(350, 310, Image.SCALE_SMOOTH);
        ImageIcon imgbut1 = new ImageIcon(but1);

        buttonimg2 = new ImageIcon("buttonimg2.jfif");
        Image but2 = buttonimg2.getImage().getScaledInstance(350, 340, Image.SCALE_SMOOTH);
        ImageIcon imgbut2 = new ImageIcon(but2);

        buttonimg3 = new ImageIcon("buttonimg3.jfif");
        Image but3 = buttonimg3.getImage().getScaledInstance(350, 340, Image.SCALE_SMOOTH);
        ImageIcon imgbut3 = new ImageIcon(but3);

        button1 = new JButton();
        button1.setBounds(530, 250, 350, 330);
        button1.setIcon(imgbut1);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.addActionListener(this);

        button2 = new JButton();
        button2.setBounds(930, 250, 350, 330);
        button2.setIcon(imgbut2);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.addActionListener(this);

        button3 = new JButton();
        button3.setBounds(730, 580, 350, 330);
        button3.setIcon(imgbut3);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.addActionListener(this);

        l = new JLabel("EXPRESSING FEELINGS THROUGH MUSIC");
        l.setBounds(500, 30, 800, 40);
        l.setBorder(null);
        l.setBackground(Color.white);
        l.setForeground(new Color(0, 107, 99));
        l.setFont(new Font("Aerial", Font.BOLD, 36));
        l.setOpaque(true);


        
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
   	 logout=new JButton() ;
   	 logout.setText("Logout");
   	 logout.setBounds(55,78,60,20);
   	 logout.setFont(new Font("Arial",Font.BOLD,14));
   	 logout.setBorder(null);
   	 logout.setForeground(new Color(0,107,99));
   	 logout.setBackground(new Color(255,255,255,100));
   	 logout.setFocusable(false);
   	 JLabel Lg=new JLabel();
   	 ImageIcon img12 =new ImageIcon(new ImageIcon("logout1.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
   	 Lg.setIcon(img12);
   	 Lg.setBounds(20,75,35,30);
   	 logout.addActionListener(new ActionListener() {
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
   		new SongsGUI(user1,emotion);
   			 frame.dispose();
   		 }
   	 });
        
        
        
        
        
        
        Backgroundlabel.add(logout);
        Backgroundlabel.add(back);
        Backgroundlabel.add(h);
        Backgroundlabel.add(Lg);
        Backgroundlabel.add(home);

        Backgroundlabel.add(l);
        Backgroundlabel.add(button1);
        Backgroundlabel.add(button2);
        Backgroundlabel.add(button3);
        frame.add(Backgroundlabel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(frame, "Enter your feedback:");
        if (input != null && !input.trim().isEmpty()) {
            String columnName = "";

            if (e.getSource() == button1) 
            {
                columnName = "feedback1";
                
            } 
            else if (e.getSource() == button2)
            {
                columnName = "feedback2";
            }
            else if (e.getSource() == button3) 
            {
                columnName = "feedback3";
            }

            String resultMessage = feedbackLogic.saveFeedback(columnName, input);
            JOptionPane.showMessageDialog(frame, resultMessage);
          }
        else 
        {
          JOptionPane.showMessageDialog(frame, "Feedback cannot be empty.");
        }
    
    }

    
}
