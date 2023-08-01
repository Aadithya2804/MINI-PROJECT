package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AdminModel;
import model.ResultModel;
import utility.ConnectionManager;
public class ResultDao extends GetConnection{

	   Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
		////////Insert/////

		
		public void storeAdminRecord(ArrayList<ResultModel> adminlist) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String INSERT = "INSERT  INTO theater(StudentId,Subject,Marks) values(?,?,?)";
			try {
				PreparedStatement ps = dbConn.prepareStatement(INSERT);
				for(ResultModel admin:adminlist) {
					ps.setInt(1, admin.getStudentId());
					ps.setString(2, admin.getSubject());
					ps.setInt(3, admin.getMarks());

					ps.executeUpdate();
					System.out.println(" Record Added Sucessfully");
				}
				
			}catch (SQLException e) {
				System.out.println("Failed");
			}
		}
}

