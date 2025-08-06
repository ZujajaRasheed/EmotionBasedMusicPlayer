package defaultt;


import java.sql.*;

public class FeedbackLogic {
    private Connection connection;
    private String email;
    private int songId;

    public FeedbackLogic(String email, int songId) {
        this.email = email;
        this.songId = songId;
    }

    public void connectionDB() {
        try {
        	 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
             connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\EmotionBasedMusicPlayer.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
           
          
        } catch (Exception ex) {
            System.out.println("Error in connection: " + ex.getMessage());
          
        }
    }

    public String saveFeedback(String columnName, String input) {
        try {
           connectionDB();

            // Check if feedback record already exists
            String checkQuery = "SELECT * FROM Feedback WHERE song_id = ? AND email = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setInt(1, songId);
            checkStmt.setString(2, email);
            
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
            	String feedback=rs.getString(columnName);
                if(feedback!=null&&!feedback.trim().isEmpty())
                {
                	return  "Feedback already given in " + columnName;
                }
                else
                {
                	 String updateQuery = "UPDATE Feedback SET " + columnName + " = ? WHERE song_id = ? AND email = ?";
                     PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                     updateStmt.setString(1, input);
                     updateStmt.setInt(2, songId);
                     updateStmt.setString(3, email);
                     updateStmt.executeUpdate();
                     checkStmt.close();
                     updateStmt.close();
                     return "Feedback added successfully";
                }
            }
            
                else
                {
                	// Step 4: First-time feedback, insert new record
                    String insertQuery = "INSERT INTO Feedback (song_id, email, " + columnName + ") VALUES (?, ?, ?)";
                    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                    insertStmt.setInt(1, songId);
                    insertStmt.setString(2, email);
                    insertStmt.setString(3, input);
                    insertStmt.executeUpdate();
                    insertStmt.close();
                    return "Feedback saved successfully.";
                }	
             
            }catch(Exception e)
        {
            	System.out.println("failed to add feedback");
            	e.printStackTrace();
        }
        finally
        {
        	try
        	{
        		if(connection!=null&&!connection.isClosed())
        			connection.close();
        			
        		
        	}catch(Exception e1)
        	{
        		e1.printStackTrace();
        		
        	}
        }
        	 return "Your feedback was not saved!";
        }
    
    }

