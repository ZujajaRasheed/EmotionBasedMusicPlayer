package defaultt;

//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.plaf.basic.BasicScrollBarUI;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.List;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class SongsGUI extends JFrame implements ActionListener {
//    private JLabel songlabel;
//    private JLabel artistlabel;
//    private JButton h, f, log;
//    private JButton feedback;
//    private JButton prev, play_pause, next, fav;
//    private JSlider s;
//    JPanel picpanel = new JPanel();
//    private SongsLogic musicLogic;
//    private String userEmail;
//    private String detEmotion;//detected emotion
//    private JPanel mainpanel=new JPanel();
//   private User user1;
//    public SongsGUI(User user,String emotion) {
//    	user1=user;
//       userEmail= user1.getEmail();
//       this.detEmotion=emotion;
//        musicLogic = new SongsLogic(this, userEmail); // Pass GUI instance to logic
//
//        setTitle("Songs-Emotion Based Music Player");
//        setSize(1950, 1100);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ImageIcon i = new ImageIcon("logo.jpeg");
//        setIconImage(i.getImage());
//        Components();
//        setVisible(true);
//    }
//
//    private void Components() {
//        mainpanel.setLayout(new BorderLayout());
//        add(mainpanel); 
//
//      
//        JPanel panel1 = new JPanel();
//        panel1.setBackground(new Color(0, 107, 99));
//        panel1.setBorder(new LineBorder(Color.white, 2));
//        panel1.setLayout(null); 
//        panel1.setPreferredSize(new Dimension(270, 600)); 
//        JLabel l4 = new JLabel();
//        ImageIcon img = new ImageIcon(new ImageIcon("headphones.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
//        l4.setIcon(img);
//        l4.setBounds(70, 25, 100, 80); 
//
//        h = new JButton("Home");
//        h.setFont(new Font("Arial", Font.BOLD, 14));
//        h.setBounds(80, 140, 70, 20);
//        h.setBorder(null);
//        h.setBackground(new Color(0, 107, 99));
//        h.setForeground(new Color(0xffffff));
//        h.setFocusable(false);
//        h.addActionListener(e -> {
//             new UserDashboard(user1);
//            dispose();
//        });
//        JLabel home = new JLabel();
//        ImageIcon img1 = new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
//        home.setIcon(img1);
//        home.setBounds(40, 135, 35, 30);
//
//        f = new JButton("Favourites");
//        f.setBounds(80, 190, 100, 20);
//        f.setFont(new Font("Arial", Font.BOLD, 14));
//        f.setBorder(null);
//        f.setBackground(new Color(0, 107, 99));
//        f.setForeground(new Color(0xffffff));
//        f.setFocusable(false);
//        f.addActionListener(e -> {
//           new Favourites(user1);
//            dispose();
//        });
//        JLabel f1 = new JLabel();
//        ImageIcon img2 = new ImageIcon(new ImageIcon("fav.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
//        f1.setIcon(img2);
//        f1.setBounds(40, 185, 35, 30);
//
//        log = new JButton("Logout");
//        log.setBounds(75, 240, 90, 20);
//        log.setFont(new Font("Arial", Font.BOLD, 14));
//        log.setBorder(null);
//        log.setBackground(new Color(0, 107, 99));
//        log.setForeground(new Color(0xffffff));
//        log.setFocusable(false);
//        log.addActionListener(e -> {
//             new Login();
//            dispose();
//        });
//        JLabel logout = new JLabel();
//        ImageIcon img3 = new ImageIcon(new ImageIcon("logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
//        logout.setIcon(img3);
//        logout.setBounds(40, 235, 30, 30);
//
//        panel1.add(h);
//        panel1.add(log);
//        panel1.add(f);
//        panel1.add(home);
//        panel1.add(f1);
//        panel1.add(logout);
//        panel1.add(l4);
//        
//        mainpanel.add(panel1, BorderLayout.WEST);
//
//        // --- Center Container Panel ---
//        // This panel will hold the picpanel and listPanel vertically
//        JPanel emotionContainerPanel = new JPanel();
//        emotionContainerPanel.setLayout(new BoxLayout(emotionContainerPanel, BoxLayout.Y_AXIS));
//        emotionContainerPanel.setBackground(new Color(0xf5f5f5)); // Set a background for the container        
//        String[] emotions = detEmotion.split(",");
//        for (String emotion : emotions) {
//            emotion = emotion.trim().toLowerCase();
//            JPanel panelForEmotion = createEmotionPanel(emotion);
//            
//            if (panelForEmotion != null) {
//                emotionContainerPanel.add(panelForEmotion);
//                // Add some spacing between emotion panels
//                emotionContainerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
//            }
//        }
//        JScrollPane scrollPane = new JScrollPane(emotionContainerPanel);
//        scrollPane.setBorder(null);
//        scrollPane.getViewport().setBackground(Color.white);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//            @Override
//            protected void configureScrollBarColors() {
//                this.thumbColor = Color.decode("#006b63");
//            }
//
//            @Override
//            protected JButton createDecreaseButton(int orientation) {
//                JButton button = super.createDecreaseButton(orientation);
//                button.setBackground(new Color(0XF5F5F5));
//                button.setForeground(Color.black);
//                return button;
//            }
//
//            @Override
//            protected JButton createIncreaseButton(int orientation) {
//                JButton button = super.createIncreaseButton(orientation);
//                button.setBackground(new Color(0XF5F5F5));
//                button.setForeground(Color.black);
//                return button;
//            }
//        });
//        mainpanel.add(scrollPane, BorderLayout.CENTER);
//      // mainpanel.setBackground(Color.pink);
//
//        // --- Playback Control Panel (SOUTH) ---
//        JPanel panel3 = new JPanel();
//        panel3.setLayout(null); // Keep null layout for precise internal controls
//        panel3.setBackground(new Color(0, 107, 99));
//        panel3.setPreferredSize(new Dimension(1500, 100)); // Give it a preferred height
//        mainpanel.add(panel3, BorderLayout.SOUTH);
//
//        songlabel = new JLabel();
//        songlabel.setBounds(10, 15, 300, 40);
//        songlabel.setFont(new Font("Arial", Font.BOLD, 15));
//        songlabel.setForeground(Color.BLACK);
//        artistlabel = new JLabel();
//        artistlabel.setBounds(10, 45, 300, 30);
//        artistlabel.setFont(new Font("Arial", Font.PLAIN, 15));
//        artistlabel.setForeground(Color.BLACK);
//
//        prev = new JButton("<<");
//        prev.setBounds(850, 50, 50, 30);
//        prev.setFont(new Font("Arial", Font.BOLD, 20));
//        prev.setBorder(null);
//        prev.setBackground(new Color(0, 107, 99));
//        prev.setForeground(Color.white);
//        prev.setFocusable(false);
//        prev.addActionListener(this); // Make sure 'this' implements ActionListener
//
//        play_pause = new JButton("▶");
//        play_pause.setBounds(910, 50, 50, 30);
//        play_pause.setBorder(null);
//        play_pause.setBackground(new Color(0, 107, 99));
//        play_pause.setForeground(Color.white);
//        play_pause.addActionListener(this);
//        play_pause.setFocusable(false);
//
//        next = new JButton(">>");
//        next.setBounds(970, 50, 50, 30);
//        next.setFont(new Font("Arial", Font.BOLD, 20));
//        next.setBorder(null);
//        next.setBackground(new Color(0, 107, 99));
//        next.setForeground(Color.white);
//        next.setFocusable(false);
//        next.addActionListener(this);
//
//        fav = new JButton("♡");
//        fav.setBounds(1030, 50, 70, 30);
//        fav.setBorder(null);
//        fav.setBackground(new Color(0, 107, 99));
//        fav.setForeground(Color.white);
//        fav.addActionListener(e -> musicLogic.toggleFavorite());
//
//        feedback = new JButton("Feedback");
//        feedback.setBounds(1190, 45, 100, 30);
//        feedback.setBorder(null);
//        feedback.setFont(new Font("Arial", Font.BOLD, 16));
//        feedback.setBackground(new Color(0, 107, 99));
//        feedback.setForeground(Color.white);
//       feedback.addActionListener(e -> {
//    	   
//       musicLogic.feedback(user1,detEmotion);
//       dispose();
//       });
//       
//
//        s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
//        s.setMajorTickSpacing(10);
//        s.setBounds(620, 20, 900, 20); 
//        s.setBackground(new Color(0, 107, 99)); 
//        s.setForeground(Color.white); 
//
//        panel3.add(prev);
//        panel3.add(play_pause);
//        panel3.add(fav);
//        panel3.add(next);
//        panel3.add(s);
//        panel3.add(feedback);
//        panel3.add(songlabel);
//        panel3.add(artistlabel);
//    }
//
//    private JPanel createEmotionPanel(String emotion) {
//		// TODO Auto-generated method stub
//    	JPanel emotionPanel=new JPanel();
//    	emotionPanel.setLayout(new BorderLayout());
//    	emotionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 107, 99), 2),
//                emotion.substring(0, 1).toUpperCase() + emotion.substring(1) + " Songs", // Capitalize emotion for title
//                TitledBorder.LEFT, TitledBorder.TOP,
//                new Font("Arial", Font.BOLD, 18), new Color(0, 107, 99)
//        ));
//    	emotionPanel.setBackground(Color.white);
//    	emotionPanel.setPreferredSize(new Dimension(1005,800));
//    	
//        picpanel = new JPanel();
//        picpanel.setLayout(null); 
//        picpanel.setBackground(new Color(0xf5f5f5));
//        picpanel.setPreferredSize(new Dimension(2000, 400));
//        emotionPanel.add(picpanel,BorderLayout.NORTH);
//        JLabel l=new JLabel();
//        ImageIcon img=null;
//    	JPanel listPanel = new JPanel();
//         listPanel.setBackground(Color.green);
//         listPanel.setLayout(new BorderLayout()); 
//         
//         //new tableModel and table for every emotion
//         DefaultTableModel tModel = new DefaultTableModel(new Object[]{"Song", "Artist", "Genre", "FilePath"}, 0) {
//             @Override
//             public boolean isCellEditable(int rows, int column) {
//                 return false;
//             }
//         };
//
//         JTable table = new JTable(tModel);
//         table.setFont(new Font("Arial", Font.PLAIN, 15));
//         table.setRowHeight(70);
//         table.setBackground(Color.WHITE);
//         table.setForeground(Color.BLACK);
//         table.setShowGrid(false);
//         table.setGridColor(Color.white);
//         table.setBorder(null);
//         table.setSelectionBackground(new Color(0x2E8B57));
//         table.setSelectionForeground(Color.white);
//
//         table.getColumnModel().getColumn(3).setMinWidth(0);
//         table.getColumnModel().getColumn(3).setMaxWidth(0);
//         table.getColumnModel().getColumn(3).setWidth(0);
//
//         JScrollPane sp = new JScrollPane(table);
//         sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//         sp.setBorder(null);
//         sp.getVerticalScrollBar().setBorder(null);
//         sp.setBackground(Color.white);
//         sp.getVerticalScrollBar().setBackground(Color.white);
//         sp.getVerticalScrollBar().setForeground(Color.BLACK);
//
//         sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//             @Override
//             protected void configureScrollBarColors() {
//                 this.thumbColor = Color.decode("#e0e0e0");
//             }
//
//             @Override
//             protected JButton createDecreaseButton(int orientation) {
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
//                 button.setForeground(new Color(0,107,99));
//                 return button;
//             }
//         });
//
//         JTableHeader header = table.getTableHeader();
//         header.setBackground(new Color(0, 107, 99));
//         header.setForeground(Color.white);
//         header.setOpaque(false);
//         header.setFont(new Font("Arial", Font.BOLD, 15));
//         ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.LEFT);
//       listPanel.add(sp,BorderLayout.CENTER);
//       emotionPanel.add(listPanel,BorderLayout.CENTER);
//
//         table.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 int sr = table.getSelectedRow();
//                 if (sr >= 0) {
//                     String name = tModel.getValueAt(sr, 0).toString();
//                     String artist = tModel.getValueAt(sr, 1).toString();
//                     String path = tModel.getValueAt(sr, 3).toString();
//                     musicLogic.playSelectedSong(sr, name, artist, path,tModel,table);
//                 }
//             }
//         });
//         if(emotion.equals("happy")) {
//        	img = new ImageIcon(new ImageIcon("happy.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
//        	musicLogic.HappyFromDatabase(tModel);
//         }
//         else if(emotion.equals("sad")) {
//         	img = new ImageIcon(new ImageIcon("hellosad.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
//         	musicLogic.SadFromDatabase(tModel);
//          }
//         else if(emotion.equals("romantic")) {
//         	img = new ImageIcon(new ImageIcon("melodies.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
//         	musicLogic.RomanticFromDatabase(tModel);
//          }
//         else if(emotion.equals("angry")) {
//         	img = new ImageIcon(new ImageIcon("angry.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
//         	musicLogic.AngryFromDatabase(tModel);
//          }
//         else {
//         	img = new ImageIcon(new ImageIcon("").getImage().getScaledInstance(1000, 200, Image.SCALE_SMOOTH));	
//          }
//         if(img!=null) {
//         	l.setIcon(img);
//         	l.setBounds(1,5,2000, 400);
//         	picpanel.add(l);
//         }
//		return emotionPanel;
//	}
//    public void updateSongInfo(String songName, String artistName) {
//        songlabel.setText("Now Playing: " + songName);
//        artistlabel.setText(artistName);
//    }
//
//    public void setPlayPauseButtonText(String text) {
//        play_pause.setText(text);
//    }
//
//    public void setFavButtonText(String text) {
//        fav.setText(text);
//    }
//    public JButton getFav() {
//    	return fav;
//    }
//    public void showMessage(String message) {
//        JOptionPane.showMessageDialog(this, message);
//    }
//
//    public void updateSlider(int value) {
//        SwingUtilities.invokeLater(() -> s.setValue(value));
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == play_pause) {
//            musicLogic.togglePlayPause();
//        } else if (e.getSource() == next) {
//            musicLogic.playNextSong();
//        } else if (e.getSource() == prev) {
//            musicLogic.playPreviousSong();
//        }
//    }
//
//  
//}


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SongsGUI extends JFrame implements ActionListener {
    private JLabel songlabel;
    private JLabel artistlabel;
    private JButton h, f, log;
    private JButton feedback;
    private JButton prev, play_pause, next, fav;
    private JSlider s;
    JPanel picpanel = new JPanel();
    private SongsLogic musicLogic;
    private String userEmail;
    private String detEmotion;//detected emotion
    private JPanel mainpanel=new JPanel();
   private User user1;
    public SongsGUI(User user,String emotion) {
    	user1=user;
       userEmail= user1.getEmail();
       this.detEmotion=emotion;
        setTitle("Songs-Emotion Based Music Player");
        setSize(1950, 1100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i = new ImageIcon("logo.jpeg");
        setIconImage(i.getImage());
        
        musicLogic = new SongsLogic(userEmail,detEmotion); // Pass GUI instance to logic
        Components();
        musicLogic.setFav(fav);
        musicLogic.setartistLabel(artistlabel);
        musicLogic.setsongLabel(songlabel);
        musicLogic.setPlay(play_pause);
        musicLogic.setSlider(s);
        setVisible(true);
     }

    private void Components() {
        mainpanel.setLayout(new BorderLayout());
        add(mainpanel); 

      
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(0, 107, 99));
        panel1.setBorder(new LineBorder(Color.white, 2));
        panel1.setLayout(null); 
        panel1.setPreferredSize(new Dimension(270, 600)); 
        JLabel l4 = new JLabel();
        ImageIcon img = new ImageIcon(new ImageIcon("headphones.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        l4.setIcon(img);
        l4.setBounds(70, 25, 100, 80); 

        h = new JButton("Home");
        h.setFont(new Font("Arial", Font.BOLD, 14));
        h.setBounds(80, 140, 70, 20);
        h.setBorder(null);
        h.setBackground(new Color(0, 107, 99));
        h.setForeground(new Color(0xffffff));
        h.setFocusable(false);
        h.addActionListener(e -> {
             new UserDashboard(user1);
            dispose();
        });
        JLabel home = new JLabel();
        ImageIcon img1 = new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        home.setIcon(img1);
        home.setBounds(40, 135, 35, 30);

        f = new JButton("Favourites");
        f.setBounds(80, 190, 100, 20);
        f.setFont(new Font("Arial", Font.BOLD, 14));
        f.setBorder(null);
        f.setBackground(new Color(0, 107, 99));
        f.setForeground(new Color(0xffffff));
        f.setFocusable(false);
        f.addActionListener(e -> {
           new Favourites(user1);
            dispose();
        });
        JLabel f1 = new JLabel();
        ImageIcon img2 = new ImageIcon(new ImageIcon("fav.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        f1.setIcon(img2);
        f1.setBounds(40, 185, 35, 30);

        log = new JButton("Logout");
        log.setBounds(75, 240, 90, 20);
        log.setFont(new Font("Arial", Font.BOLD, 14));
        log.setBorder(null);
        log.setBackground(new Color(0, 107, 99));
        log.setForeground(new Color(0xffffff));
        log.setFocusable(false);
        log.addActionListener(e -> {
             new Main();
            dispose();
        });
        JLabel logout = new JLabel();
        ImageIcon img3 = new ImageIcon(new ImageIcon("logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        logout.setIcon(img3);
        logout.setBounds(40, 235, 30, 30);

        panel1.add(h);
        panel1.add(log);
        panel1.add(f);
        panel1.add(home);
        panel1.add(f1);
        panel1.add(logout);
        panel1.add(l4);
        
        mainpanel.add(panel1, BorderLayout.WEST);

        // --- Center Container Panel ---
        // This panel will hold the picpanel and listPanel vertically
        JPanel emotionContainerPanel = new JPanel();
        emotionContainerPanel.setLayout(new BoxLayout(emotionContainerPanel, BoxLayout.Y_AXIS));
        emotionContainerPanel.setBackground(new Color(0xf5f5f5)); // Set a background for the container        
        String[] emotions = detEmotion.split(",");
        for (String emotion : emotions) {
            emotion = emotion.trim().toLowerCase();
            JPanel panelForEmotion = createEmotionPanel(emotion);
            
            if (panelForEmotion != null) {
                emotionContainerPanel.add(panelForEmotion);
                // Add some spacing between emotion panels
                emotionContainerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            }
        }
        JScrollPane scrollPane = new JScrollPane(emotionContainerPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode("#006b63");
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
        mainpanel.add(scrollPane, BorderLayout.CENTER);
      // mainpanel.setBackground(Color.pink);

        // --- Playback Control Panel (SOUTH) ---
        JPanel panel3 = new JPanel();
        panel3.setLayout(null); // Keep null layout for precise internal controls
        panel3.setBackground(new Color(0, 107, 99));
        panel3.setPreferredSize(new Dimension(1500, 100)); // Give it a preferred height
        mainpanel.add(panel3, BorderLayout.SOUTH);

        songlabel = new JLabel();
        songlabel.setBounds(10, 15, 300, 40);
        songlabel.setFont(new Font("Arial", Font.BOLD, 15));
        songlabel.setForeground(Color.BLACK);
        artistlabel = new JLabel();
        artistlabel.setBounds(10, 45, 300, 30);
        artistlabel.setFont(new Font("Arial", Font.PLAIN, 15));
        artistlabel.setForeground(Color.BLACK);

        prev = new JButton("<<");
        prev.setBounds(850, 50, 50, 30);
        prev.setFont(new Font("Arial", Font.BOLD, 20));
        prev.setBorder(null);
        prev.setBackground(new Color(0, 107, 99));
        prev.setForeground(Color.white);
        prev.setFocusable(false);
        prev.addActionListener(this); // Make sure 'this' implements ActionListener

        play_pause = new JButton("▶");
        play_pause.setBounds(910, 50, 50, 30);
        play_pause.setBorder(null);
        play_pause.setBackground(new Color(0, 107, 99));
        play_pause.setForeground(Color.white);
        play_pause.addActionListener(this);
        play_pause.setFocusable(false);

        next = new JButton(">>");
        next.setBounds(970, 50, 50, 30);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBorder(null);
        next.setBackground(new Color(0, 107, 99));
        next.setForeground(Color.white);
        next.setFocusable(false);
        next.addActionListener(this);

        fav = new JButton("♡");
        fav.setBounds(1030, 50, 70, 30);
        fav.setBorder(null);
        fav.setBackground(new Color(0, 107, 99));
        fav.setForeground(Color.white);
        fav.addActionListener(e -> musicLogic.toggleFavorite());

        feedback = new JButton("Feedback");
        feedback.setBounds(1190, 45, 100, 30);
        feedback.setBorder(null);
        feedback.setFont(new Font("Arial", Font.BOLD, 16));
        feedback.setBackground(new Color(0, 107, 99));
        feedback.setForeground(Color.white);
       feedback.addActionListener(e -> {
    	   
      if( musicLogic.feedback(user1,detEmotion))
      {
    	  dispose();  
      }
     
       });
       

        s = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        s.setMajorTickSpacing(10);
        s.setBounds(620, 20, 900, 20); 
        s.setBackground(new Color(0, 107, 99)); 
        s.setForeground(Color.white); 

        panel3.add(prev);
        panel3.add(play_pause);
        panel3.add(fav);
        panel3.add(next);
        panel3.add(s);
        panel3.add(feedback);
        panel3.add(songlabel);
        panel3.add(artistlabel);
    }

    private JPanel createEmotionPanel(String emotion) {
		// TODO Auto-generated method stub
    	JPanel emotionPanel=new JPanel();
    	emotionPanel.setLayout(new BorderLayout());
    	emotionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 107, 99), 2),
                emotion.substring(0, 1).toUpperCase() + emotion.substring(1) + " Songs", // Capitalize emotion for title
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 18), new Color(0, 107, 99)
        ));
    	emotionPanel.setBackground(Color.white);
    	emotionPanel.setPreferredSize(new Dimension(1005,800));
    	
        picpanel = new JPanel();
        picpanel.setLayout(null); 
        picpanel.setBackground(new Color(0xf5f5f5));
        picpanel.setPreferredSize(new Dimension(2000, 400));
        emotionPanel.add(picpanel,BorderLayout.NORTH);
        JLabel l=new JLabel();
        ImageIcon img=null;
    	JPanel listPanel = new JPanel();
         listPanel.setBackground(Color.green);
         listPanel.setLayout(new BorderLayout()); 
         
         //new tableModel and table for every emotion
         DefaultTableModel tModel = new DefaultTableModel(new Object[]{"Song", "Artist", "Genre", "FilePath"}, 0) {
             @Override
             public boolean isCellEditable(int rows, int column) {
                 return false;
             }
         };

         JTable table = new JTable(tModel);
         table.setFont(new Font("Arial", Font.PLAIN, 15));
         table.setRowHeight(70);
         table.setBackground(Color.WHITE);
         table.setForeground(Color.BLACK);
         table.setShowGrid(false);
         table.setGridColor(Color.white);
         table.setBorder(null);
         table.setSelectionBackground(new Color(0x2E8B57));
         table.setSelectionForeground(Color.white);

         table.getColumnModel().getColumn(3).setMinWidth(0);
         table.getColumnModel().getColumn(3).setMaxWidth(0);
         table.getColumnModel().getColumn(3).setWidth(0);

         JScrollPane sp = new JScrollPane(table);
         sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         sp.setBorder(null);
         sp.getVerticalScrollBar().setBorder(null);
         sp.setBackground(Color.white);
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
                 button.setForeground(new Color(0,107,99));
                 return button;
             }
         });

         JTableHeader header = table.getTableHeader();
         header.setBackground(new Color(0, 107, 99));
         header.setForeground(Color.white);
         header.setOpaque(false);
         header.setFont(new Font("Arial", Font.BOLD, 15));
         ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.LEFT);
       listPanel.add(sp,BorderLayout.CENTER);
       emotionPanel.add(listPanel,BorderLayout.CENTER);

         table.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 int sr = table.getSelectedRow();
                 if (sr >= 0) {
                     String name = tModel.getValueAt(sr, 0).toString();
                     String artist = tModel.getValueAt(sr, 1).toString();
                     String path = tModel.getValueAt(sr, 3).toString();
                     musicLogic.playSelectedSong(sr, name, artist, path,tModel,table);
                 }
             }
         });
         if(emotion.equals("happy")) {
        	img = new ImageIcon(new ImageIcon("happy.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
        	musicLogic.HappyFromDatabase(tModel);
         }
         else if(emotion.equals("sad")) {
         	img = new ImageIcon(new ImageIcon("hellosad.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
         	musicLogic.SadFromDatabase(tModel);
          }
         else if(emotion.equals("romantic")) {
         	img = new ImageIcon(new ImageIcon("melodies.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
         	musicLogic.RomanticFromDatabase(tModel);
          }
         else if(emotion.equals("angry")) {
         	img = new ImageIcon(new ImageIcon("angry.png").getImage().getScaledInstance(2000, 400, Image.SCALE_SMOOTH));
         	musicLogic.AngryFromDatabase(tModel);
          }
         else {
         	img = new ImageIcon(new ImageIcon("").getImage().getScaledInstance(1000, 200, Image.SCALE_SMOOTH));	
          }
         if(img!=null) {
         	l.setIcon(img);
         	l.setBounds(1,5,2000, 400);
         	picpanel.add(l);
         }
		return emotionPanel;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play_pause) {
            musicLogic.togglePlayPause();
        } else if (e.getSource() == next) {
            musicLogic.playNextSong();
        } else if (e.getSource() == prev) {
            musicLogic.playPreviousSong();
        }
    }

  
}


















