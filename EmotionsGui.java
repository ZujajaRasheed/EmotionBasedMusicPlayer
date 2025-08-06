package defaultt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmotionsGui implements ActionListener {

	JFrame frame;
	JButton DetectEmotion, ViewFav, Back, LogOut;

	ImageIcon logo, background, img;
	JLabel mainlabel, label, titlelabel;
	JTextArea text;
	
private User user;
	public EmotionsGui(User user) {

		this.user=user;

		frame = new JFrame("Detect Emotion - EmotionBasedMusicPlayer");
		frame.setSize(1950, 1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		frame.getContentPane().setBackground(new Color(0xF5F5F5));
		

		logo = new ImageIcon("logo.jpeg");
		frame.setIconImage(logo.getImage());

		String[] emotions = { "happy", "happy", "happy", "happy", "happy", "angry", "angry", "angry", "sad", "sad",
				"romantic", "romantic", "romantic", "angry", "angry", "sad" };

		int[][] bounds = { { 1010, 30, 213, 214 }, { 900, 280, 234, 233 }, { 1180, 210, 320, 319 },
				{ 830, 740, 320, 319 }, { 780, 510, 229, 221 }, { 1730, 880, 168, 165 }, { 1550, 370, 343, 344 },
				{ 1740, 170, 165, 167 }, { 1740, 720, 151, 154 }, { 1400, 720, 335, 326 }, { 1500, 130, 220, 220 },
				{ 1350, 530, 171, 158 }, { 1240, 680, 165, 168 }, { 1020, 510, 224, 224 }, { 1200, 860, 166, 164 },
				{ 1270, -20, 215, 225 } };
		for (int i = 0; i <= 15; i++) {
			ImageIcon icon = new ImageIcon(new ImageIcon("em" + i + ".jfif").getImage().getScaledInstance(bounds[i][2],
					bounds[i][3], Image.SCALE_SMOOTH));
			JButton b = new JButton();
			b.setActionCommand(emotions[i]);
			b.setBorder(null);
			b.setIcon(icon);
			b.setBounds(bounds[i][0], bounds[i][1], bounds[i][2], bounds[i][3]);
			b.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b.addActionListener(this);
			frame.add(b);
		}

		

		mainlabel = new JLabel();
		mainlabel.setBounds(70, 70, 500, 900);
		mainlabel.setBackground(new Color(168, 203, 176));
		mainlabel.setOpaque(true);
		mainlabel.setBorder(BorderFactory.createLineBorder(Color.pink, 3));

		

		ImageIcon icon = new ImageIcon(
				new ImageIcon("feeling.jpeg").getImage().getScaledInstance(450, 170, Image.SCALE_SMOOTH));
		titlelabel = new JLabel(icon);
		titlelabel.setBounds(10, 10, 400, 140);
		titlelabel.setBackground(new Color(0xF5F5F5));
		mainlabel.add(titlelabel);
		
		
		label = new JLabel("Share Your Feelings.....");
		label.setBounds(40, 150, 300, 40);
		label.setBackground(new Color(168, 203, 176));
		label.setForeground(new Color(0xF5F5F5));
		label.setFont(new Font("Aerial", Font.BOLD | Font.ITALIC, 26));
		label.setOpaque(true);
		mainlabel.add(label);
		
		
		text = new JTextArea();
		text.setBackground(new Color(225, 230, 236));
		text.setFont(new Font("Aerial", Font.BOLD, 16));
		text.setForeground(new Color(168, 203, 176));
		
		text.setBorder(BorderFactory.createLineBorder(Color.pink, 3));//text.setBorder(null);

		JScrollPane scrollpane = new JScrollPane(text);
		scrollpane.setBounds(40, 220, 400, 400);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(null);
		mainlabel.add(scrollpane);
		
		
		
		
		
		
		
		
		

		int buttonsBounds[][] = { { 140, 650, 200, 40 }, { 160, 710, 150, 40 }, { 160, 770, 150, 40 },
				{ 160, 830, 150, 40 } };
		String title[] = { "DetectEmotion", "Back", "Logout", "Favourities" };

		for (int i = 0; i <= 3; i++) {
			JButton btn = new JButton(title[i]);
			btn.setBackground(new Color(0xF5F5F5));
			btn.setBorder(BorderFactory.createLineBorder(Color.pink, 2));
			btn.setForeground(new Color(168, 203, 176));
			btn.setBounds(buttonsBounds[i][0], buttonsBounds[i][1], buttonsBounds[i][2], buttonsBounds[i][3]);
			btn.setFont(new Font("Aerial", Font.BOLD | Font.ITALIC, 20));
			btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btn.setActionCommand(title[i]);
			btn.addActionListener(this);
			//btn.setBorder(null);
			mainlabel.add(btn);
		}

		frame.add(mainlabel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
;

			String command = e.getActionCommand();
			// TODO Auto-generated method stub
			Emotion obj = new Emotion();
			if (command.equals("happy") || command.equals("angry") || command.equals("sad")
					|| command.equals("romantic"))
			{  obj.insertUserEmotion(user.getEmail(),command);
		 new SongsGUI(user,command); // Pass emotion to SongGui
		 frame.dispose();
		 System.out.println(command);
			}

			else if (command.equals("DetectEmotion"))

			{
				String userEmotion = text.getText();
              if(userEmotion!=null||!userEmotion.trim().isEmpty())
              {
				String emotion = obj.detectUserEmotion(userEmotion);
				if (emotion != null) 
				{
					JOptionPane.showMessageDialog(null, "Your emotion is detected and your are feeling  "+emotion);
					obj.insertUserEmotion(user.getEmail(), emotion);
					System.out.println(emotion);
					 new SongsGUI(user,emotion);
					 frame.dispose();
				}
              }
				else
				{
					JOptionPane.showMessageDialog(null, "No matching emotion detected");
				}

			}
			else if (command.equals("LogOut"))
			{
				
				new Main();
				 frame.dispose();
			} 
			else if (command.equals("Favourities")) 
			{
				System.out.println("fav");
				 new Favourites(user);
				 frame.dispose();
			} 
			else if (command.equals("Back"))
			{
				
				new UserDashboard(user);
				 frame.dispose();
			}

		}
		

		
	}
