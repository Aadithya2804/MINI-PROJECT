package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AdminModel;
import utility.ConnectionManager;
public class AdminDao extends GetConnection{

	   Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
		////////Insert/////

		
		public void storeAdminRecord(ArrayList<AdminModel> adminlist) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String INSERT = "INSERT  INTO theater(StudentId,StudentName,Marks) values(?,?,?)";
			try {
				PreparedStatement ps = dbConn.prepareStatement(INSERT);
				for(AdminModel admin:adminlist) {
					ps.setInt(1, admin.getStudentId());
					ps.setString(2, admin.getStudentName());
					ps.setInt(3, admin.getMarks());

					ps.executeUpdate();
					System.out.println(" Record Added Sucessfully");
				}
				
			}catch (SQLException e) {
				System.out.println("Failed");
			}
		}
    ///////view customer //////

		public void ViewAdminModel() throws ClassNotFoundException {
			dbConn = getDbConnection();
			String VIEW = "SELECT * FROM theater";
			try {
			Statement stmt =  dbConn.createStatement();
			 ResultSet rs = ((java.sql.Statement) stmt).executeQuery(VIEW);
			 System.out.println("Student_Id,Student_Name,Marks");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" ");
			 } 
			 }catch(SQLException e) {
				 System.out.println("Failed to view");
			 }
			}
   ////////Update/////////

		public void UpdateAdminModel(int update, int updateStudentId, String newStudentName) throws ClassNotFoundException {
		
			dbConn = getDbConnection();
			String UPDATE = null;
			if(update == 1)
				UPDATE = "UPDATE theater SET StudentName = ? WHERE StudentId=?";
			else if(update == 2)
				UPDATE = "UPDATE theater SET StudentName = ? WHERE StudentId=?";
			else if(update == 3)
				UPDATE = "UPDATE theater SET Marks = ? WHERE StudentId=?";


          try {
        	  PreparedStatement ps = dbConn.prepareStatement(UPDATE);
	
			ps.setString(1,newStudentName);
        	  ps.setInt(2, updateStudentId);
        	  int result = ps.executeUpdate();
        	  if(result==1) {
        		  System.out.println("Record Upadted");
        	  }
        	  
          }catch(SQLException e) {
    		  System.out.println("Fail to Upadte");

          }


		}
///////////Delete/////////

		public void DeleteAdminModel(int deleteStudentId) throws ClassNotFoundException 
		{
			dbConn = getDbConnection();
		String DELETE = "DELETE FROM theater WHERE StudentId = "+ deleteStudentId;
		
			try {
				Statement stmt =dbConn.createStatement();
				int RowAffected = stmt.executeUpdate(DELETE);
//				System.out.println(RowAffected);
				if(RowAffected!=0)
				{
				System.out.println("Rows Affected :"+RowAffected);
				System.out.println("Record deleted Sucessfully");
				}

			}catch(SQLException e) {
				System.out.println("\n Failed to delete the Record");
                e.printStackTrace();
			}
		}
		public void DeleteAdminModel(String s) throws ClassNotFoundException 
		{
			System.out.println("Your input is not valid...Integer datatype input is required to delete a field");
		}
		}

	
     
	