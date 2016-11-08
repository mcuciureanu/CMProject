package cm.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cm.model.UserModel;

public class UserConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/user_database";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "123456";

	public Connection conn = null;
	public PreparedStatement stmt = null;
	public ResultSet result;

	public UserModel u_model;
	public ArrayList<UserModel> a_list;

	public UserConnection() {
		a_list = new ArrayList<UserModel>();
	}

	public ArrayList<UserModel> getUsersAndScore() {

		try {
			// STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM user");
			result = stmt.executeQuery();

			while (result.next()) {

				u_model = new UserModel(result.getString(2), result.getInt(4));
				a_list.add(u_model);

			}

		} catch (

		SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				// nothing we can do
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return a_list;
	}

	public ArrayList<UserModel> getA_list() {
		return a_list;
	}

	public void setA_list(ArrayList<UserModel> a_list) {
		this.a_list = a_list;
	}
}
