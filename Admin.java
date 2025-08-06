//package defaultt;
//
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.ResultSetMetaData;
////import java.util.ArrayList;
////import java.util.List;
////
////import javax.swing.table.DefaultTableModel;
////
////public class Admin extends User {
////
////	 private List<String> paths = new ArrayList<>();
////	  //  private List<Integer> songIds = new ArrayList<>();
////	
////	public Admin()
////	{
////		super();
////	}
////	
////	public Admin(String email,String password)
////	{
////		super(email,password);
////	}
////	
////	
////	boolean adminLogin()
////	{PreparedStatement stmt =null;
////	 ResultSet adminResult=null;
////	 connectionDB();
////		try {
////		
////	
////	
////	 stmt=connection.prepareStatement("select * from admin where email =? AND password =? " );
////	 stmt.setString(1, email);
////	    stmt.setString(2, password);
////	  adminResult=stmt.executeQuery();
////    
////     if(adminResult.next())    //check in admin table
////   	      {
////   	    	  System.out.println(" admin login");
////   	     
////   	    	  return true ;
////   	      }
////     else 
////    	 return false;
////                
////		
////	}catch(Exception e)
////		{
////	System.out.println("Error in query");
////		e.getStackTrace();
////		}
////		finally
////		{
////			try
////			{
////				if(stmt!=null)
////					stmt.close();
////				if(adminResult!=null)
////					adminResult.close();
////				if(connection!=null&&!connection.isClosed())
////					connection.close();
////				
////			}catch(Exception e1)
////			{
////				System.out.println("Error in closing connection");
////				e1.printStackTrace();
////			}
////		}
////		return false;
////	
////	}
////
////	
////	public boolean deleteSong(int songid)
////	{
////		connectionDB();
////		try
////		{
////		PreparedStatement stmt =connection.prepareStatement("Delete  from songs where song_id =?");
////		stmt.setInt(1, songid);
////		int c=stmt.executeUpdate();
////		stmt.close();
////		connection.close();
////		return c>0;
////		
////		
////	}catch(Exception e)
////		{
////		System.out.println("Error in query");
////		e.printStackTrace();
////		}
////		
////		return false;//if exception occur then return false
////	}
////	
////	public boolean addSong(String s_name,String s_artist,String s_genre,String s_path,String s_emotion)
////	{
////		connectionDB();
////		PreparedStatement stmt=null;
////		
////		try
////		{
////			stmt=connection.prepareStatement("insert into Songs(song_title,artist_name,song_genre,file_path,emotion_type)values(?,?,?,?,?)");
////		stmt.setString(1, s_name);
////		stmt.setString(2, s_artist);
////		stmt.setString(3, s_genre);
////		stmt.setString(4, s_path);
////		stmt.setString(5, s_emotion);
////			int c=stmt.executeUpdate();
////		return c>0;
////		
////		}catch(Exception e)
////		{
////			System.out.println("Error in query");
////			e.printStackTrace();
////		}
////		finally {
////			try
////			{
////				if(stmt!=null)
////					stmt.close();
////				if(connection!=null&&!connection.isClosed())
////					connection.close();
////			}catch(Exception e1)
////			{
////				System.out.println("Error in closing connection");
////			}
////		}
////		return false;
////		
////	}
////	public boolean deleteUser(String email1)
////	{
////		PreparedStatement stmt=null;
////		connectionDB();
////		try
////		{
////			stmt=connection.prepareStatement("Delete from USER where email=?");
////		stmt.setString(1,email1);
////	int	c=stmt.executeUpdate();
////		return c>0;
////		
////		
////		}catch(Exception e)
////		{
////			System.out.println("Error in query");
////			e.printStackTrace();
////		}finally {
////			try {
////				if(stmt!=null)
////					stmt.close();
////				if(connection!=null&&!connection.isClosed())
////					connection.close();
////			}catch(Exception e1)
////			{
////				System.out.println("Error in closing connection");
////			}
////			
////			
////		}
////		return false;
////	}
////	
////	
////	
////	public boolean deleteFeedback(String email1)
////	{
////		PreparedStatement stmt=null;
////		connectionDB();
////		try
////		{
////			stmt=connection.prepareStatement("Delete from USER where email=?");
////		stmt.setString(1,email1);
////	int	c=stmt.executeUpdate();
////		return c>0;
////		
////		
////		}catch(Exception e)
////		{
////			System.out.println("Error in query");
////			e.printStackTrace();
////		}finally {
////			try {
////				if(stmt!=null)
////					stmt.close();
////				if(connection!=null&&!connection.isClosed())
////					connection.close();
////			}catch(Exception e1)
////			{
////				System.out.println("Error in closing connection");
////			}
////			
////			
////		}
////		return false;
////	}
////	
////	
////	public DefaultTableModel viewSongs() {
////		
////	DefaultTableModel model=new DefaultTableModel(
////			new String[] {"ID", "Title", "Artist", "Genre", "Path", "Emotion"},0);
////	
////		   paths.clear();
////
////		try {
////			connectionDB();
////			PreparedStatement pst=connection.prepareStatement("select * from Songs");
////			ResultSet rs=pst.executeQuery();
////			while(rs.next()) {
////				int id=rs.getInt("song_id");
////				String name=rs.getString("song_title");
////				String artist=rs.getString("artist_name");
////				String genre=rs.getString("song_genre");
////				String filePath=rs.getString("file_path");
////				String emotion=rs.getString("emotion_type");
////				paths.add(filePath);
////				model.addRow(new Object[] {id,name,artist,genre,filePath,emotion});
////			}
////			
////}
////		
////		catch(Exception e1) {
////			e1.printStackTrace();
////		}
////		return model;
////}
//////	
//////	public void playmusic(String filePath) {
//////        
//////		if (currentPlayer != null) {
//////			//isStopped=true;//stop any song
//////            currentPlayer.close();
//////        }
//////		 System.out.println("Trying to play: " + filePath);
//////		 
//////		 //Highlight the currently playing song's row.
////////Automatically scroll to that row so the user can see which song is playing
////		 if(table!=null) {
//////	    	   table.setRowSelectionInterval(currentIndex, currentIndex);
//////	    	   table.scrollRectToVisible(table.getCellRect(currentIndex,0,true));
//////	       }
//////        new Thread(() -> {
//////            try {
//////                FileInputStream f = new FileInputStream(filePath);
//////                BufferedInputStream b = new BufferedInputStream(f);
//////                currentPlayer = new Player(b);
//////                currentPlayer.play();
//////            } catch (Exception e) {
//////                e.printStackTrace();
//////            }
//////        }).start();
//////       isPlaying = true;
//////     
//////      
//////    }
////	public DefaultTableModel viewUser()
////	{
////		DefaultTableModel model=new DefaultTableModel();
////		try
////		{
////			connectionDB();
////			PreparedStatement stmt=connection.prepareStatement("select * from USER");
////			ResultSet rs=stmt.executeQuery();
////			ResultSetMetaData metaData=rs.getMetaData();
////			int columnCount =metaData.getColumnCount();
////			for(int i=1;i<=columnCount;i++)
////			{
////				model.addColumn(metaData.getColumnName(i));
////			}
////			while(rs.next())
////			{Object rowData[]=new Object[columnCount];
////			
////				for(int i=1;i<=columnCount;i++)
////				{
////					rowData[i-1]=rs.getObject(i);
////				}
////				model.addRow(rowData);
////			}
////			rs.close();
////			stmt.close();
////			connection.close();
////		}catch(Exception e)
////		{
////			System.out.println("Error in user query");
////			e.printStackTrace();
////		}
////		return model;
////		
////	}
//	
//	//
//	import java.awt.event.MouseAdapter;
//	import java.awt.event.MouseEvent;
//	import java.io.BufferedInputStream;
//	import java.io.FileInputStream;
//	import java.sql.PreparedStatement;
//	import java.sql.ResultSet;
//	import java.sql.ResultSetMetaData;
//	import java.util.ArrayList;
//	import java.util.List;
//	import java.util.Timer;
//	import java.util.TimerTask;
//
//	import javax.swing.JTable;
//	import javax.swing.table.DefaultTableModel;
//
//	import javazoom.jl.player.Player;
//
//	public class Admin extends User {
//	AdminDashboard obj;
//		 private List<String> paths = new ArrayList<>();
//		 private int currentIndex=-1;
//		 private Player currentPlayer;
//		 private boolean isPlaying=true;
//		 private boolean isPaused=false;
//		 private Timer sliderTimer;
//		
//		public Admin(AdminDashboard Dashboard)
//		{
//		//	super();
//			this.obj=Dashboard;
//		}
//		
//		public Admin(String email,String password)
//		{
//			super(email,password);
//		}
//		
//		
//		boolean adminLogin()
//		{PreparedStatement stmt =null;
//		 ResultSet adminResult=null;
//		 connectionDB();
//			try {
//			
//		
//		
//		 stmt=connection.prepareStatement("select * from admin where email =? AND password =? " );
//		 stmt.setString(1, email);
//		    stmt.setString(2, password);
//		  adminResult=stmt.executeQuery();
//	    
//	     if(adminResult.next())    //check in admin table
//	   	      {
//	   	    	  System.out.println(" admin login");
//	   	     
//	   	    	  return true ;
//	   	      }
//	     else 
//	    	 return false;
//	                
//			
//		}catch(Exception e)
//			{
//			System.out.println("Error in query");
//			e.getStackTrace();
//			}
//			finally
//			{
//				try
//				{
//					if(stmt!=null)
//						stmt.close();
//					if(adminResult!=null)
//						adminResult.close();
//					if(connection!=null&&!connection.isClosed())
//						connection.close();
//					
//				}catch(Exception e1)
//				{
//					System.out.println("Error in closing connection");
//					e1.printStackTrace();
//				}
//			}
//			return false;
//		
//		}
//		
//
//		
//		public boolean deleteSong(int songid)
//		{
//			connectionDB();
//			try
//			{
//			PreparedStatement stmt =connection.prepareStatement("Delete  from songs where song_id =?");
//			stmt.setInt(1, songid);
//			int c=stmt.executeUpdate();
//			stmt.close();
//			connection.close();
//			return c>0;
//			
//			
//		}catch(Exception e)
//			{
//			System.out.println("Error in query");
//			e.printStackTrace();
//			}
//			
//			return false;//if exception occur then return false
//		}
//		
//		public boolean addSong(String s_name,String s_artist,String s_genre,String s_path,String s_emotion)
//		{
//			connectionDB();
//			PreparedStatement stmt=null;
//			
//			try
//			{
//				stmt=connection.prepareStatement("insert into Songs(song_title,artist_name,song_genre,file_path,emotion_type)values(?,?,?,?,?)");
//			stmt.setString(1, s_name);
//			stmt.setString(2, s_artist);
//			stmt.setString(3, s_genre);
//			stmt.setString(4, s_path);
//			stmt.setString(5, s_emotion);
//				int c=stmt.executeUpdate();
//			return c>0;
//			
//			}catch(Exception e)
//			{
//				System.out.println("Error in query");
//				e.printStackTrace();
//			}
//			finally {
//				try
//				{
//					if(stmt!=null)
//						stmt.close();
//					if(connection!=null&&!connection.isClosed())
//						connection.close();
//				}catch(Exception e1)
//				{
//					System.out.println("Error in closing connection");
//				}
//			}
//			return false;
//			
//		}
//		public boolean deleteUser(String email1)
//		{
//			PreparedStatement stmt=null;
//			connectionDB();
//			try
//			{
//				stmt=connection.prepareStatement("Delete from USER where email=?");
//			stmt.setString(1,email1);
//		int	c=stmt.executeUpdate();
//			return c>0;
//			
//			
//			}catch(Exception e)
//			{
//				System.out.println("Error in query");
//				e.printStackTrace();
//			}finally {
//				try {
//					if(stmt!=null)
//						stmt.close();
//					if(connection!=null&&!connection.isClosed())
//						connection.close();
//				}catch(Exception e1)
//				{
//					System.out.println("Error in closing connection");
//				}
//				
//				
//			}
//			return false;
//		}
//		
//		
//		
//		public boolean deleteFeedback(String email1)
//		{
//			PreparedStatement stmt=null;
//			connectionDB();
//			try
//			{
//				stmt=connection.prepareStatement("Delete from USER where email=?");
//			stmt.setString(1,email1);
//		int	c=stmt.executeUpdate();
//			return c>0;
//			
//			
//			}catch(Exception e)
//			{
//				System.out.println("Error in query");
//				e.printStackTrace();
//			}finally {
//				try {
//					if(stmt!=null)
//						stmt.close();
//					if(connection!=null&&!connection.isClosed())
//						connection.close();
//				}catch(Exception e1)
//				{
//					System.out.println("Error in closing connection");
//				}
//				
//				
//			}
//			return false;
//		}
//		public DefaultTableModel viewFavourites() {
//			DefaultTableModel model=new DefaultTableModel(new String[] {"Song","Useremail"},0) {
//				public boolean isCellEditable(int rows,int column) {
//					return false;
//				}
//			};
//			try {
//				connectionDB();
//				PreparedStatement pst=connection.prepareStatement("Select s.song_id,s.song_title,f.email from Favourites f join Songs s on f.song_id=s.song_id");
//				  ResultSet rs=pst.executeQuery();
//				  while(rs.next()) {
//					  int id=rs.getInt("song_id");
//					  String name=rs.getString("song_title");
//					  String email=rs.getString("email");
//					  model.addRow(new Object[] {name,email});
//				  }
//				  pst.close();
//				  rs.close();
//				  connection.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			return model;
//		}
//		
//		
//		DefaultTableModel model;
//		public DefaultTableModel viewSongs() {
//			
//		model=new DefaultTableModel(new String[] {"ID", "Title", "Artist", "Genre", "Path", "Emotion"},0) {
//			public boolean isCellEditable(int rows,int column) {
//				return false;
//			}
//		};
//			   paths.clear();
//
//			try {
//				connectionDB();
//				PreparedStatement pst=connection.prepareStatement("select * from Songs");
//				ResultSet rs=pst.executeQuery();
//				while(rs.next()) {
//					int id=rs.getInt("song_id");
//					String name=rs.getString("song_title");
//					String artist=rs.getString("artist_name");
//					String genre=rs.getString("song_genre");
//					String filePath=rs.getString("file_path");
//					String emotion=rs.getString("emotion_type");
//					paths.add(filePath);
//					model.addRow(new Object[] {id,name,artist,genre,filePath,emotion});
//				}
//				
//	}	
//			catch(Exception e1) {
//				e1.printStackTrace();
//			}
//			
//			obj.getTable().addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					int sr=obj.getTable().getSelectedRow();
//					if(sr>=0) {
//						currentIndex=sr;
//			            String name = model.getValueAt(sr, 1).toString();
//			            String artist =model.getValueAt(sr, 2).toString();
//			            String path = model.getValueAt(sr, 4).toString();
//							
//							playmusic(path);
//							obj.getplaypause().setText("||");
//							isPaused=false;     
//					}
//				}
//			});
//			
//			return model;
//		}
//		
//		public void playmusic(String filePath) {
//	        
//			if (currentPlayer != null) {
//	            currentPlayer.close();
//	        }
//			 System.out.println("Trying to play: " + filePath);
//			 
//			// Selects the row at currentIndex in the table and ensures it is visible by scrolling to it
//			 if(obj.getTable()!=null) {
//				 obj.getTable().setRowSelectionInterval(currentIndex, currentIndex);
//				 obj.getTable().scrollRectToVisible(obj.getTable().getCellRect(currentIndex,0,true));
//		       }
//	        new Thread(() -> {
//	            try {
//	                FileInputStream f = new FileInputStream(filePath);
//	                BufferedInputStream b = new BufferedInputStream(f);
//	                currentPlayer = new Player(b);
//	                currentPlayer.play();
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	       
//	        }).start();
//	        startSlider();
//	        isPlaying = true;
//	    }
//		private void startSlider() {
//	        if (sliderTimer != null) {
//	            sliderTimer.cancel();
//	        }
//
//	        sliderTimer = new Timer();
//	        obj.updateSlider(0); // Reset slider
//
//	        sliderTimer.scheduleAtFixedRate(new TimerTask() {
//	            int value = 0;
//
//	            @Override
//	            public void run() {
//	                if (isPlaying && value <= 100) {
//	                    obj.updateSlider(value);
//	                    value++;
//	                } else {
//	                    sliderTimer.cancel();
//	                }
//	            }
//	        }, 0, 1000); // Update every 1 second
//	    }
//		public DefaultTableModel viewUser()
//		{
//			DefaultTableModel model=new DefaultTableModel();
//			try
//			{
//				connectionDB();
//				PreparedStatement stmt=connection.prepareStatement("select * from USER");
//				ResultSet rs=stmt.executeQuery();
//				ResultSetMetaData metaData=rs.getMetaData();
//				int columnCount =metaData.getColumnCount();
//				for(int i=1;i<=columnCount;i++)
//				{
//					model.addColumn(metaData.getColumnName(i));
//				}
//				while(rs.next())
//				{Object rowData[]=new Object[columnCount];
//				
//					for(int i=1;i<=columnCount;i++)
//					{
//						rowData[i-1]=rs.getObject(i);
//					}
//					model.addRow(rowData);
//				}
//				rs.close();
//				stmt.close();
//				connection.close();
//			}catch(Exception e)
//			{
//				System.out.println("Error in user query");
//				e.printStackTrace();
//			}
//			return model;
//			
//		}
//		
//		public void prev() {
//			if(paths.size()>0) {
//		        int prevIndex=(currentIndex-1+paths.size())%paths.size();
//		        currentIndex=prevIndex;
//		         String name = model.getValueAt(prevIndex, 1).toString();
//		         playmusic(paths.get(prevIndex));
//				}  
//		}
//		public void play() {
//			 if (!isPlaying && currentIndex >= 0) {
//		         playmusic(paths.get(currentIndex));
//		         obj.getplaypause().setText("||");
//		     } else {
//		         if (currentPlayer != null) {
//		             currentPlayer.close();
//		             isPlaying = false;
//		             obj.getplaypause().setText("▶");
//		         }
//		     }
//		}
//		public void next() {
//			if(paths.size()>0) {
//		        int nextIndex=(currentIndex+1)%paths.size();
//		        currentIndex=nextIndex;
//		        String name = model.getValueAt(nextIndex, 1).toString();
//		        playmusic(paths.get(nextIndex));
//		        
//			}
//		}
//		
//	}
//

package defaultt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javazoom.jl.player.Player;

public class Admin extends User {

	 private List<String> paths = new ArrayList<>();
	 private Player currentPlayer;
	 private boolean isPlaying = false;
	 private int currentIndex = -1;	
	 private Timer sliderTimer;
	 private DefaultTableModel model;
	 
	 //Referrence to UI components from Admin Dashboard
	 private JSlider s;
	 private JButton play_pause;
	 private JTable table;//to highlight rows
	 private DefaultTableModel tablemodel;//to access data from table
	public Admin()
	{
		super();
	}
	
	public Admin(String email,String password)
	{
		super(email,password);
	}
	public void setSlider(JSlider slider) {
        this.s = slider;
    }

    public void setPlay(JButton button) {
        this.play_pause = button;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setCurrentIndex(int index) {
        this.currentIndex = index;
    }
	
public	boolean  adminLogin()
	{PreparedStatement stmt =null;
	 ResultSet adminResult=null;
	 connectionDB();
		try {
		
	
	
	 stmt=connection.prepareStatement("select * from admin where email =? AND password =? " );
	 stmt.setString(1, email);
	    stmt.setString(2, password);
	  adminResult=stmt.executeQuery();
    
     if(adminResult.next())    //check in admin table
   	      {
   	    	  System.out.println(" admin login");
   	     
   	    	  return true ;
   	      }
     else 
    	 return false;
                
		
	}catch(Exception e)
		{
		System.out.println("Error in query");
		e.getStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(adminResult!=null)
					adminResult.close();
				if(connection!=null&&!connection.isClosed())
					connection.close();
				
			}catch(Exception e1)
			{
				System.out.println("Error in closing connection");
				e1.printStackTrace();
			}
		}
		return false;
	
	}

	
	public boolean deleteSong(int songid)
	{
		connectionDB();
		try
		{
		PreparedStatement stmt =connection.prepareStatement("Delete  from songs where song_id =?");
		stmt.setInt(1, songid);
		int c=stmt.executeUpdate();
		stmt.close();
		connection.close();
		return c>0;
		
		
	}catch(Exception e)
		{
		System.out.println("Error in query");
		e.printStackTrace();
		}
		
		return false;//if exception occur then return false
	}
	
	public boolean addSong(String s_name,String s_artist,String s_genre,String s_path,String s_emotion)
	{
		connectionDB();
		PreparedStatement stmt=null;
		
		try
		{
			stmt=connection.prepareStatement("insert into Songs(song_title,artist_name,song_genre,file_path,emotion_type)values(?,?,?,?,?)");
		stmt.setString(1, s_name);
		stmt.setString(2, s_artist);
		stmt.setString(3, s_genre);
		stmt.setString(4, s_path);
		stmt.setString(5, s_emotion);
			int c=stmt.executeUpdate();
		return c>0;
		
		}catch(Exception e)
		{
			System.out.println("Error in query");
			e.printStackTrace();
		}
		finally {
			try
			{
				if(stmt!=null)
					stmt.close();
				if(connection!=null&&!connection.isClosed())
					connection.close();
			}catch(Exception e1)
			{
				System.out.println("Error in closing connection");
			}
		}
		return false;
		
	}
	public boolean deleteUser(String email1)
	{
		PreparedStatement stmt=null;
		connectionDB();
		try
		{
			stmt=connection.prepareStatement("Delete from USER where email=?");
		stmt.setString(1,email1);
	int	c=stmt.executeUpdate();
		return c>0;
		
		
		}catch(Exception e)
		{
			System.out.println("Error in query");
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(connection!=null&&!connection.isClosed())
					connection.close();
			}catch(Exception e1)
			{
				System.out.println("Error in closing connection");
			}
			
			
		}
		return false;
	}
	
	
	
	public void deleteCompFeedback(String email1,int songid)
	{
		PreparedStatement stmt=null;
		connectionDB();
		try
		{
			stmt=connection.prepareStatement("Delete from Feedback where email=? and song_id =?");
		stmt.setString(1,email1);
		stmt.setInt(2, songid);	
		int	c=stmt.executeUpdate();
		if( c>0)
		{
			JOptionPane.showMessageDialog(null,"Feedback deleted successfully");
		
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"No Feedback availabe on " +email1 +" and SongID "+songid);
		}
		stmt.close();
		connection.close();
		}catch(Exception e)
		{
			System.out.println("Error in query");
			e.printStackTrace();
		}
			
		}
		
	
	public void deleteSFeedback( String emailaddr,int songid,String columnName)
	{
		try
		{
			connectionDB();
			PreparedStatement stmt =connection.prepareStatement("Update Feedback SET " +columnName+ "= NULL where song_id=? and email=?");
		stmt.setInt(1, songid);
		stmt.setString(2, emailaddr);
	int c=	stmt.executeUpdate();
		if(c>0)
		{
			JOptionPane.showMessageDialog(null, columnName +"of "+emailaddr+" on SongID "+songid+"has been deleted successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Feedback deletion failed! as " +emailaddr+ " did not give "+columnName+" on SongID "+songid);	
		}
		stmt.close();
		connection.close();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	
	public DefaultTableModel viewFavourites() {
	 model=new DefaultTableModel(new String[] {"Song","Useremail"},0) {
			public boolean isCellEditable(int rows,int column) {
				return false;
			}
		};
		try {
			connectionDB();
			PreparedStatement pst=connection.prepareStatement("Select s.song_id,s.song_title,f.email from Favourites f join Songs s on f.song_id=s.song_id");
			  ResultSet rs=pst.executeQuery();
			  while(rs.next()) {
				  int id=rs.getInt("song_id");
				  String name=rs.getString("song_title");
				  String email=rs.getString("email");
				  model.addRow(new Object[] {name,email});
			  }
			  pst.close();
			  rs.close();
			  connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public DefaultTableModel viewSongs() {
		
	DefaultTableModel model=new DefaultTableModel(
			new String[] {"ID", "Title", "Artist", "Genre", "Path", "Emotion"},0);
	
		   paths.clear();

		try {
			connectionDB();
			PreparedStatement pst=connection.prepareStatement("select * from Songs");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("song_id");
				String name=rs.getString("song_title");
				String artist=rs.getString("artist_name");
				String genre=rs.getString("song_genre");
				String filePath=rs.getString("file_path");
				String emotion=rs.getString("emotion_type");
				paths.add(filePath);
				model.addRow(new Object[] {id,name,artist,genre,filePath,emotion});
			}
			
}
		
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return model;
}
	
	public void playmusic(String filePath) {
        
		if (currentPlayer != null) {
            currentPlayer.close();
            if (sliderTimer != null) {
                sliderTimer.cancel();
            }
        }
		
		 System.out.println("Trying to play: " + filePath);
		 
		 //Highlight the currently playing song's row.
		 //Automatically scroll to that row so the user can see which song is playing
		 if(table!=null) {
	    	   table.setRowSelectionInterval(currentIndex, currentIndex);
	    	   table.scrollRectToVisible(table.getCellRect(currentIndex,0,true));
	       }
        new Thread(() -> {
            try {
                FileInputStream f = new FileInputStream(filePath);
                BufferedInputStream b = new BufferedInputStream(f);
                currentPlayer = new Player(b);
                isPlaying=true;
                play_pause.setText("||");
                startSlider();
                currentPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
                isPlaying=false;
                play_pause.setText("▶");
            }
        }).start();
      
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
	
	
	
	public DefaultTableModel viewFeedback() {
		model=new DefaultTableModel();
		try {connectionDB();
		PreparedStatement stmt=connection.prepareStatement("select s.song_id,s.song_title,f.email,f.feedback1,f.feedback2,f.feedback3 from Feedback f join Songs s on f.song_id=s.song_id");
		ResultSet rs= stmt.executeQuery();
		ResultSetMetaData metaData=rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		for(int i=1;i<=columnCount;i++)
		{
			model.addColumn(metaData.getColumnName(i));
			
		}
		while(rs.next())
		{
			Object rowData[]=new Object[columnCount];
			for(int i=1;i<=columnCount;i++)
			{
				rowData[i-1]=rs.getObject(i);
				
			}
			model.addRow(rowData);
			
			
		}
		rs.close();
		stmt.close();
		connection.close();
		
		
			
		}catch(Exception e)
		{
			System.out.println("Error in query");
			e.printStackTrace();
		}
		return model;
		}
		

	public DefaultTableModel viewUser()
	{
		 model=new DefaultTableModel();
		try
		{
			connectionDB();
			PreparedStatement stmt=connection.prepareStatement("select * from USER");
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			int columnCount =metaData.getColumnCount();
			for(int i=1;i<=columnCount;i++)
			{
				model.addColumn(metaData.getColumnName(i));
			}
			while(rs.next())
			{Object rowData[]=new Object[columnCount];
			
				for(int i=1;i<=columnCount;i++)
				{
					rowData[i-1]=rs.getObject(i);
				}
				model.addRow(rowData);
			}
			rs.close();
			stmt.close();
			connection.close();
		}catch(Exception e)
		{
			System.out.println("Error in user query");
			e.printStackTrace();
		}
		return model;
		
	}
	
	public void prev() {
		if(paths.size() > 0) {
            if (currentPlayer != null) {
                currentPlayer.close();
                if (sliderTimer != null) {
                    sliderTimer.cancel();
                }
            }
            int prevIndex = (currentIndex - 1 + paths.size()) % paths.size();
            currentIndex = prevIndex;
           playmusic(paths.get(prevIndex));
           play_pause.setText("||");

		}
	}
	public void play() {
		if (!isPlaying && currentIndex >= 0 && currentIndex < paths.size()) {
            playmusic(paths.get(currentIndex));
            play_pause.setText("||"); 
        } else if (isPlaying) {
            if (currentPlayer != null) {
                currentPlayer.close();
            }
            isPlaying = false; 
            play_pause.setText("▶"); 
            if (sliderTimer != null) {
                sliderTimer.cancel(); 
            }
        } else {
            System.out.println("No song selected to play/pause.");
        }
	}
	public void next() {
		if(paths.size() > 0) {
            if (currentPlayer != null) {
                currentPlayer.close();
                if (sliderTimer != null) {
                    sliderTimer.cancel();
                }
            }

            int nextIndex = (currentIndex + 1) % paths.size();
            currentIndex = nextIndex;
           playmusic(paths.get(nextIndex));
           play_pause.setText("||");
			}  
	}

}



