package defaultt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Emotion {

	private Connection connection=null;
	private HashMap<String ,String[]> emotionMap;
	private  String emotion;
	
	public Emotion()
	{
		emotionMap=new HashMap<>();
		
		
	}
	
	
	
	
	public void connectionDB()
	{
		try
		{
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
		     connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\EmotionBasedMusicPlayer.accdb");//Establishing Connection
		   System.out.println("Connected Successfully");	
	}catch(Exception e)
		{
		System.out.println("Error in connection");
		e.getStackTrace();
		
		
		}
	}
	private void loadDataFromDB()
	{
		try
		{
			connectionDB();
				         
		   PreparedStatement  pst=connection.prepareStatement("Select emotion_type,synonyms from emotions");
		   ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			
			 emotion=rs.getString("emotion_type");
			String emotion_synonyms=rs.getString("synonyms");
			String synonyms[]=emotion_synonyms.toLowerCase().split(",");
			emotionMap.put(emotion,synonyms);
		}
			rs.close();
			pst.close();
			connection.close();
			
		
		}catch(Exception e)
		{
			System.out.println("Error");
			e.getStackTrace();
		}	
	}
	
	
	
	public String detectUserEmotion(String userText) {
	    loadDataFromDB(); // Assume this fills emotionMap: Map<String, String[]>

	    String userWords[] = userText.toLowerCase().split(" ");
	    Map<String, Integer> emotionMatchCounts = new HashMap<>();

	    int maxMatchCount = 0;

	    for (Map.Entry<String, String[]> entry : emotionMap.entrySet()) {
	        String emotion = entry.getKey();
	        String[] synonyms = entry.getValue();
	        int matchCount = 0;

	        for (String word : userWords) {
	            for (String synonym : synonyms) {
	                if (word.equals(synonym)) {
	                    matchCount++;
	                }
	            }
	        }

	        emotionMatchCounts.put(emotion, matchCount);
	        if (matchCount > maxMatchCount) {
	            maxMatchCount = matchCount;
	        }
	    }

	    // Collect all emotions that have the max match count (and matchCount > 0)
	    List<String> topEmotions = new ArrayList<>();
	    for (Map.Entry<String, Integer> entry : emotionMatchCounts.entrySet()) {
	        if (entry.getValue() == maxMatchCount && maxMatchCount > 0) {
	            topEmotions.add(entry.getKey());
	        }
	    }

	    if (topEmotions.isEmpty()) {
	        return null;
	    }

	    return String.join(",", topEmotions);  // e.g., "happy,sad"
	}

	
	
	
	
	
	
	
	

	public void insertUserEmotion(String email, String emotion) 
	{
        try {
        	Thread.sleep(200);
        	connectionDB();
        	
        String[] newemotions=emotion.split(",");
        	
        
        for(String emotion1:newemotions)
        {
        
		   PreparedStatement  pst=connection.prepareStatement("insert into user_emotion  (email,emotion_type,date_time)values(?,?,?)");
			
        	
        	
            pst.setString(1, email);
            pst.setString(2, emotion1);
            pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));

            int c=   pst.executeUpdate();
            if(c>0)
            {
            	System.out.println(" inserted "+emotion1 );
            }
            pst.close();
        }
            connection.close();
        } catch (Exception ex) {
        	System.out.println("Error in query ");
            ex.printStackTrace();
        }
        
        
        
    }
	
	
	public String getPreviousEmotion(String email)

	{
		StringBuilder emotions= new StringBuilder();
boolean flag=false;
		try
		{connectionDB();
			PreparedStatement  pst =connection.prepareStatement("select emotion_type , date_time from user_emotion where email=?");
		pst.setString(1,email);
		ResultSet rs =pst.executeQuery();
		while(rs.next())
		{flag=true;
			 String emotiontype=rs.getString("emotion_type");
			java.sql.Timestamp datetime=rs.getTimestamp("date_time");
		emotions.append(emotiontype).append(" on ").append(datetime.toString()).append("\n");
		
		
		}
		
	
			
		rs.close();
		pst.close();
		connection.close();
		if(!flag)
		{
			return "No previous emotion found";
		}
		}catch(Exception e)
		{
			System.out.println("errorr in query");
			e.printStackTrace();
		}
		return emotions.toString();
		
	}
	
	
	
}
	
	
	
