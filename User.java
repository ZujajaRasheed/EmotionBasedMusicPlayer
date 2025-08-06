package defaultt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class User {

	protected String email;
	protected String password;
	protected String name;
	protected int age;
	protected String gender;
	protected Connection connection;
	protected User(String name,String email,String password,String gender,int age)
	{
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
		
		
	}
	public User()
	{
		
	}
	
	public User(String email,String password)
	{
		this.setEmail(email);
		this.setPassword(password);
	}
	
	
	protected void connectionDB()
	{
	try
	{

		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
        connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\EmotionBasedMusicPlayer.accdb");//Establishing Connection
        System.out.println("Connected Successfully");
	}catch(Exception e)
	{
		System.out.println("Error in connection");
	}
	}
	
	
	
	
	
	boolean userLogin()
	{
		try
		{	connectionDB();
	         PreparedStatement stmt=connection.prepareStatement("select * from user where email =? AND password =? ");
		    stmt.setString(1, email);
		    stmt.setString(2, password);
	         ResultSet userResult=stmt.executeQuery();
		         
		        if(userResult.next())    //if not admin ,check in user table 
		         {
		        return true;	
		         }
		        else
		        
		      	return false;
		         
		}catch(Exception e)
		{
			System.out.println("Error");
			e.getStackTrace();
		}
		finally
		{
			try
			{if (connection!=null && !connection.isClosed())
			connection.close();
		}catch(Exception ex)
			{
			ex.printStackTrace();
			}
		}

		
		return false;
		
	}
	
	 public boolean  userSignup()
	{
		try//database inserrtion
		{
		connectionDB()	;         
	   PreparedStatement  stmt=connection.prepareStatement("insert into USER  (name,age,gender,email,password)values(?,?,?,?,?)");
	stmt.setString(1, name);
	stmt.setInt(2, age);
	stmt.setString(3, gender);
	stmt.setString(4, email);
	stmt.setString(5, password);
	   int c=   stmt.executeUpdate();
			  
	   stmt.close();
	   if (connection != null && !connection.isClosed()) {
           connection.close(); // ✅ Close connection
       }
	   if(c>0)   
			    {
				 
				
				 System.out.println(" Data inserted successfully");
			        
				 
				 return true;
			       }
			 else
			    	   
			       {
			    	   
			    	   return false;
			    	   
			    	   }
			 

		}catch(Exception e1)  {
			System.out.println("\nError in query");
			         
		}
				return false;
	
	}
	
	
	public String getProfileInfo()
	{StringBuilder userInfo= new StringBuilder();
		try {
			connectionDB();
			PreparedStatement stmt=connection.prepareStatement("select * from user where email=?");
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				name=rs.getString("name");
				age=rs.getInt("age");
				gender=rs.getString("gender");
				
				
			}

			stmt.close();
			rs.close();
			connection.close();
			Emotion e=new Emotion();
			String emotion=e.getPreviousEmotion(email);
		
			userInfo.append("*******My PROFILE*******").append("\n\nName:  ").append(name).append("\n").append("Email:  ").append(email).append("\n").append("Age:  ").append(age).append("\n").append("Gender:  ").append(gender).append("\n\n").append("Previous-emotions-detail\n\n").append(emotion).append("\n");
			
			
		}catch(Exception e)
		{System.out.println("Error in query");
			e.printStackTrace();
		}
		return userInfo.toString();
		
		
		
		
	}
	
	
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
