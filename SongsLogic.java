
package defaultt;

import javazoom.jl.player.Player;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SongsLogic {
	   // private SongsGUI gui;
	    private Connection connection;
	    
	    private Player currentPlayer;
	    private List<String> paths = new ArrayList<>();
	    private List<Integer> songIds = new ArrayList<>();
	    private int currentIndex = -1;
	    private boolean isPlaying = false;
	    private Timer sliderTimer;
	    private String userEmail;
	    private DefaultTableModel activeTableModel;
	    private JTable activeTable;
	    private JSlider s;
	    private JButton fav;
		private JButton play_pause;
		private JLabel songlabel;
		private JLabel artistlabel;
		private String emotion;
		
	    public SongsLogic(String email,String emotion) {
	        this.userEmail = email;
	        this.emotion=emotion;
	    }
	    public void setSlider(JSlider slider) {
	        this.s = slider;
	    }
	    public void setPlay(JButton button) {
	        this.play_pause = button;
	    }
	    public void setFav(JButton button) {
	        this.fav = button;
	    }
	    public void setsongLabel(JLabel songlabel) {
	    	this.songlabel=songlabel;
	    }
	    public void setartistLabel(JLabel artistlabel) {
	    	this.artistlabel=artistlabel;
	    }
    public void connectionDB() {
        try {
        	 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
             connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\EmotionBasedMusicPlayer.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
        } catch (Exception e) {
            System.out.println("DB Connection error: " + e.getMessage());
JOptionPane.showMessageDialog(null, "Database error");
}
    }

  //adds the data corresponding to that emotion
    private void loadSongsByEmotion(String emotion,DefaultTableModel tableModel) {
      tableModel.setRowCount(0);
       paths.clear(); 
       songIds.clear();
    	try {
            connectionDB();
            PreparedStatement pst = connection.prepareStatement("SELECT song_id, song_title, artist_name, song_genre, file_path FROM Songs WHERE emotion_type = '"+emotion+"' ORDER BY song_id ASC");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int sid = rs.getInt("song_id");
                String name = rs.getString("song_title");
                String artist = rs.getString("artist_name");
                String genre = rs.getString("song_genre");
                String path = rs.getString("file_path");

                paths.add(path);
                songIds.add(sid);
               tableModel.addRow(new Object[]{name, artist, genre, path});
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("Error in loading songs: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database error");
        }
    }
    public void RomanticFromDatabase(DefaultTableModel tableModel) {
        loadSongsByEmotion("romantic",tableModel);
    }
    public void HappyFromDatabase(DefaultTableModel tableModel) {
        loadSongsByEmotion("happy",tableModel);
    }
    public void SadFromDatabase(DefaultTableModel tableModel) {
        loadSongsByEmotion("sad",tableModel);
    }

    public void AngryFromDatabase(DefaultTableModel tableModel) {
        loadSongsByEmotion("angry",tableModel);
    }

    public void playSelectedSong(int index, String name, String artist, String path, DefaultTableModel tableModel, JTable table) {
        stopCurrentPlayer();

        this.paths.clear();
        this.songIds.clear();

        try {
            connectionDB();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String songTitle = tableModel.getValueAt(i, 0).toString();
                String songArtist = tableModel.getValueAt(i, 1).toString();
                String songPath = tableModel.getValueAt(i, 3).toString();
                paths.add(songPath);

                // Fetch correct song_id from DB to sync with selected emotion
                PreparedStatement pst = connection.prepareStatement("select song_id FROM Songs where song_title='"+songTitle+"' AND artist_name='"+songArtist+"'");
                ResultSet rs = pst.executeQuery();
                int songId = -1;
                if (rs.next()) {
                    songId = rs.getInt("song_id");
                }
                rs.close();
                pst.close();

                songIds.add(songId);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error");
        }

        this.activeTableModel = tableModel;
        this.activeTable = table;
        this.currentIndex = index;

        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            currentPlayer = new Player(bis);
            isPlaying = true;

            
            songlabel.setText("Now Playing: " + name);
            artistlabel.setText(artist);
            play_pause.setText("||");

            if (activeTable != null) {
                activeTable.setRowSelectionInterval(currentIndex, currentIndex);
                activeTable.scrollRectToVisible(activeTable.getCellRect(currentIndex, 0, true));
            }

            new Thread(() -> {
                try {
                    currentPlayer.play();
                    isPlaying = false;
                   play_pause.setText("▶");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Playback error");
                }
            }).start();

            if (currentIndex >= 0 && currentIndex < songIds.size()) {
                updateFavIcon(songIds.get(currentIndex));
            }

            startSlider();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Could not play the song");
        }
    }

    public void stopCurrentPlayer() {
        if (currentPlayer != null) {
            currentPlayer.close();
            isPlaying = false;
        }
        if (sliderTimer != null) {
            sliderTimer.cancel();
            sliderTimer=null;
        }
    }

    public void togglePlayPause() {
        if (isPlaying) {
            stopCurrentPlayer();
            play_pause.setText("▶");
        } else if (currentIndex >= 0 && currentIndex < paths.size()) {
            String path = paths.get(currentIndex);
            String name =activeTableModel.getValueAt(currentIndex, 0).toString();
            String artist = activeTableModel.getValueAt(currentIndex, 1).toString();
            playSelectedSong(currentIndex, name, artist, path,activeTableModel,activeTable);
        }
    }

    public void playNextSong() {
    	stopCurrentPlayer();
        int nextIndex = (currentIndex + 1) % paths.size();
        String path = paths.get(nextIndex);
        String name = activeTableModel.getValueAt(nextIndex, 0).toString();
        String artist = activeTableModel.getValueAt(nextIndex, 1).toString();
        playSelectedSong(nextIndex, name, artist, path,activeTableModel,activeTable);
    }


    public void playPreviousSong() {
    	stopCurrentPlayer();
        int prevIndex = (currentIndex - 1 + paths.size()) % paths.size();
        String path = paths.get(prevIndex);
        String name = activeTableModel.getValueAt(prevIndex, 0).toString();
        String artist = activeTableModel.getValueAt(prevIndex, 1).toString();
        playSelectedSong(prevIndex, name, artist,path,activeTableModel,activeTable);
    }

    public void toggleFavorite() {
        if (currentPlayer != null && currentIndex >= 0) {
            int id = songIds.get(currentIndex); // Get the ID of the currently playing song
            try {
            	connectionDB();

                PreparedStatement checkStmt = connection.prepareStatement("select * from Favourites WHERE song_id=? AND email=?");
                checkStmt.setInt(1, id);
                checkStmt.setString(2, userEmail);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    // If it IS in the database, the user wants to REMOVE it
                    PreparedStatement deleteStmt = connection.prepareStatement("delete from Favourites WHERE song_id=? AND email=?");
                    deleteStmt.setInt(1, id);
                    deleteStmt.setString(2, userEmail);
                    deleteStmt.executeUpdate();
                    fav.setText("♡"); // Set button to empty heart
                    JOptionPane.showMessageDialog(null,"Removed from favourites!");
                } else {
                    // If it is NOT in the database, the user wants to ADD it
                    PreparedStatement insertStmt = connection.prepareStatement("insert into Favourites(song_id, email) VALUES(?, ?)");
                    insertStmt.setInt(1, id);
                    insertStmt.setString(2, userEmail);
                    insertStmt.executeUpdate();
                    fav.setText("❤"); // Set button to filled heart
                    JOptionPane.showMessageDialog(null,"Added to favourites!");
                }

                rs.close();
                checkStmt.close();
                connection.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Database error");
                ex.printStackTrace(); 
            }
        } else {
            JOptionPane.showMessageDialog(null,"Play a song first to add it to favourites.");

        }
    }
    public boolean feedback(User user ,String emotion) {
    	if(currentPlayer!=null&&currentIndex>=0) {
    		int id=songIds.get(currentIndex);
    		new FeedbackGUI(user,id,emotion);
    		return true;
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Select song first and then give feedback.");
    return 	false;
    	}
    }

 private void updateFavIcon(int songId) {
     try {
        connectionDB();
         PreparedStatement check = connection.prepareStatement("select * from Favourites where song_id=? AND email=?");
         check.setInt(1, songId);
         check.setString(2, userEmail);
         ResultSet rs = check.executeQuery();

         if (rs.next()) {
             fav.setText("❤"); // Song is in favorites
         } else {
             fav.setText("♡"); // Song is NOT in favorites
         }
         rs.close();
         check.close();
     } catch (Exception e) {
    	 JOptionPane.showMessageDialog(null,"Database error when updating fav icon: ");
         e.printStackTrace();  
     }
 }
    private void startSlider() {
        if (sliderTimer != null) {
            sliderTimer.cancel();
        }

        sliderTimer = new Timer();
        s.setValue(0); // Reset slider

        sliderTimer.scheduleAtFixedRate(new TimerTask() {
            int value = 0;

            @Override
            public void run() {
                if (isPlaying && value <= 100) {
                    s.setValue(value);
                    value++;
                } else {
                    sliderTimer.cancel();
                }
            }
        }, 0, 1000); // Update every 1 second
    }
    
} 