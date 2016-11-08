package cm.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import cm.model.GameModel;

public class QAConnection implements TypeOfGame{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/qa_database";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "123456";

	final static Logger log = Logger.getLogger(QAConnection.class.getName());

	public Connection conn = null;
	public PreparedStatement stmt = null;
	public ResultSet result;

	// id of CurrentQuestion
	public int id = 1;

	public GameModel g_model;
	public ArrayList<GameModel> a_list;

	public QAConnection(String typeOfQuestion) {
		log.info("> buildMySQLConnection call ");
		try {

			a_list = new ArrayList<GameModel>();

			// STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (typeOfQuestion.equals(TYPE1)) {
				stmt = conn.prepareStatement("SELECT * FROM game WHERE type_game = 1");
				result = stmt.executeQuery();

			} else if (typeOfQuestion.equals(TYPE2)) {
				stmt = conn.prepareStatement("SELECT * FROM game WHERE type_game = 2");
				result = stmt.executeQuery();

			} else if (typeOfQuestion.equals(TYPE3)) {
				stmt = conn.prepareStatement("SELECT * FROM game WHERE type_game = 3");
				result = stmt.executeQuery();
			}

			while (result.next()) {

				g_model = new GameModel(id, result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7), result.getString(8));
				id++;
				a_list.add(g_model);

			}

		} catch (SQLException se) {
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
		log.info("< buildMySQLConnection call ");
	}

	public ArrayList<GameModel> getA_list() {
		return a_list;
	}

	public void setA_list(ArrayList<GameModel> a_list) {
		this.a_list = a_list;
	}

}
