package sample;

import java.sql.*;
import java.util.*;

public class mulesoftask {

	public static void main(String[] args) 
	{
		    try 
		    {
		      Class.forName("org.sqlite.JDBC");
		      Connection con=DriverManager.getConnection("jdbc:sqlite:DataBaseMovies.db");
		      if(con != null)
		      {
		        System.out.println("Successful connected");
		        
		      
		        //String query="Drop table Movies";
		        //String query="create table Movies(movie text primary key, actor text, actress text, directr text, release int)" ;
		        //PreparedStatement pstmt=con.prepareStatement(query);  
		        
		        //pstmt.executeUpdate();
		        
		        PreparedStatement pstmt2=con.prepareStatement("insert into Movies values(?,?,?,?,?)");
		        
		        System.out.print("Enter no.of records :: ");
		        Scanner sc=new Scanner(System.in);
		        int no=sc.nextInt();
		        
		        for(int i=0;i<no;i++)
		        {
		          System.out.print("Enter MovieName :: ");
		          String movie=sc.next();
		          
		          System.out.print("Enter HeroName :: ");
		          String hero=sc.next();
		          
		          System.out.print("Enter HeroineName :: ");
		          String heroine=sc.next();
		         
		          
		          System.out.print("Enter Director's Name :: ");
		          String dir=sc.next();
		          
		          System.out.print("Enter Year of Release :: ");
		          int year=sc.nextInt();
		          
		          
		          pstmt2.setString(1, movie);
		          pstmt2.setString(2, hero);
		          pstmt2.setString(3, heroine);
		          pstmt2.setInt(4, year);
		          pstmt2.setString(5, dir);
		          
		          int inserted = pstmt2.executeUpdate();
		          System.out.println(inserted);
		        }
		        
		        PreparedStatement pstmt3 = con.prepareStatement("select * from Movies");
		        ResultSet rs=pstmt3.executeQuery();
		        
		        System.out.println("\nMovie\tActor\tActress\tYear\tDirector");
		        System.out.println("---------------------------------------------");
		        while(rs.next())
		        {
		          System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
		        }
		        
		        System.out.print("\nPlease Enter Hero name to get movies - ");
		        String actor_name=sc.next();
		        
		        PreparedStatement pstmt4 = con.prepareStatement("select * from Movies where Actor=? ");
		        pstmt4.setString(1,actor_name);
		        ResultSet rs2=pstmt4.executeQuery();
		        System.out.println("\nAll the movies of '"+actor_name+"'");
		        
		        System.out.println("Movie\tActor\tActress\tReleaseYear");
		        System.out.println("---------------------------------------------");
		        while(rs2.next())
		        {
		          System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getInt(4));
		        }
		        
		      }
		    }
		    catch(Exception e) {
		      System.out.println(e);
		    }
		  }

	}

