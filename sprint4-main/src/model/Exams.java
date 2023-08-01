package model;
import java.sql.*;
import java.util.*;

public class Exams {

	public static void takeExam() throws ClassNotFoundException, SQLException 
	{
		int marks=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Now you may start your exam...");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_db","root","aadi@2804");
		Statement statement=connection.createStatement();
		String str="Select * from chemistry";
		ResultSet rs=statement.executeQuery(str);
		while(rs.next())
		{
			String ques=rs.getString(2);
			System.out.println(ques);
			String ans=rs.getString(4);
			System.out.println("Your answer is...");
			String input=sc.nextLine();

			if(input.equals(ans))
			{
				marks=marks+rs.getInt(3);
			}
		}
		System.out.println("Do you wish to see your marks...????"+"\n"+"If so , Enter 1 to view mrks..");
		int s=sc.nextInt();
		sc.nextLine();
		if(s==1)
		System.out.println("Your marks is "+marks);
		else
		{
			System.out.println("You have entered a wrong input ...");
		}
		
	}

}
