package defaultt;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javazoom.jl.player.Player;




public class favPlayer {
	private Player currentPlayer;
	private Favourites fp;
	private String useremail;
    private int currentIndex=-1;
    private boolean isPlaying=false;
	private boolean isPaused=false;
	 private DefaultTableModel tableModel;
	 private JTable tb;
    List<String> paths=new ArrayList<>();
    private Connection connection;
	private JLabel songlabel;
	private JButton play_pause;
   // public SongsLogic obj1;
    
	public favPlayer(String email){
		this.useremail=email;
	}
	public void setTableModel(DefaultTableModel model) {
    	 this.tableModel=model;
    }
    public void setTable(JTable table) {
    	this.tb=table;
    }
    public void setsongLabel(JLabel songlabel) {
    	this.songlabel=songlabel;
    }
    public void setPlay(JButton button) {
        this.play_pause = button;
    }
	 public void connectionDB() {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	             connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\EmotionBasedMusicPlayer.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");

			}catch(Exception e) {
				
			}
		}
	 public void loadfav() {
	        tableModel.setRowCount(0);
	        try {
	           connectionDB();

	            PreparedStatement pst = connection.prepareStatement(
	                "SELECT s.song_id, s.song_title, s.file_path " +
	                "FROM Songs s JOIN Favourites f ON s.song_id = f.song_id " +
	                "WHERE f.email = '"+useremail+"'"
	            );
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	                int songid = rs.getInt("song_id");
	                String name = rs.getString("song_title");
	                String path = rs.getString("file_path");
	                paths.add(path);
	                tableModel.addRow(new Object[] {name,"❤",path});
	            }
	            rs.close();
	            pst.close();
	            connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        tb.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                int row = tb.getSelectedRow();
	                int col = tb.getSelectedColumn();

	                if (row >= 0) {
	                    String title = tableModel.getValueAt(row, 0).toString();
	                    String path = tableModel.getValueAt(row, 2).toString();
	                    try {
	                        connectionDB();
	                        PreparedStatement pst = connection.prepareStatement(
	                            "SELECT s.song_id FROM Songs s WHERE s.song_title = '"+title+"'"
	                        );
	        
	                        ResultSet rs = pst.executeQuery();

	                        if (rs.next()) {
	                            int songId = rs.getInt("song_id");
	                            if (col == 1) {
	                                System.out.println("Unliked song: " + title);
	                                unfavouriteSong(songId);
	                                loadfav(); 
	                            } else {
	                                System.out.println("Playing song: " + title);
	                                currentIndex=row;
	                                playmusic(path);
	                            	songlabel.setText("Now Playing: "+title);
	                            	play_pause.setText("||");
	            					isPaused=false;
	                            }
	                        }
	                        rs.close();
	                        pst.close();
	                        connection.close();

	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            }
	        });

	    }
		 public void unfavouriteSong(int songId) {
		        try {
		           connectionDB();
		            PreparedStatement pst = connection.prepareStatement("DELETE FROM Favourites WHERE song_id = "+songId+" AND email = '"+useremail+"'");
		   
		            pst.executeUpdate();
		            pst.close();
		            connection.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void playmusic(String filePath) {
			if (currentPlayer != null) {
	            currentPlayer.close();
	        }
	       if(tb!=null) {
	    	   tb.setRowSelectionInterval(currentIndex, currentIndex);
	    	   tb.scrollRectToVisible(tb.getCellRect(currentIndex,0,true));
	       }
	        new Thread(() -> {
	            try {
	                FileInputStream f = new FileInputStream(filePath);
	                BufferedInputStream b = new BufferedInputStream(f);
	                currentPlayer = new Player(b);
	                currentPlayer.play();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
	       isPlaying = true;
	     
	    }
	    public void prev() {
	    	if(paths.size()>0) {
	    		int prevIndex=(currentIndex-1+paths.size())%paths.size();
	    		currentIndex=prevIndex;
	    		String name=tableModel.getValueAt(prevIndex,0).toString();
	    		songlabel.setText("Now Playing:"+name);
	    		playmusic(paths.get(prevIndex));
	    		play_pause.setText("||");
	    	}
	    }
	    public void next() {
	    	if(paths.size()>0) {
	    		int nextIndex=(currentIndex+1)%paths.size();
	    		currentIndex=nextIndex;
	    		String name=tableModel.getValueAt(nextIndex,0).toString();
	    		songlabel.setText("Now Playing:"+name);
	    		playmusic(paths.get(nextIndex));
	    		play_pause.setText("||");
	    	}
	    }
	    public void play() {
	    	if(!isPlaying&&currentIndex>0) {
	    		playmusic(paths.get(currentIndex));
	    		play_pause.setText("||");
	    	}
	    	else
	    		if(currentPlayer!=null) {
	    			currentPlayer.close();
	    			isPlaying=false;
	    			play_pause.setText("▶");
	    		}
	    }

	}