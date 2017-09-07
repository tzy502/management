package util;

import java.sql.Connection;

public class DBUtil {
	private static final String jdbcUrl = "jdbc:mysql://192.168.1.220:3306/HJ212_DB";
	private static final String dbUser = "root";
	private static final String dbPwd = "whllp771006";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws java.sql.SQLException {
		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
	}
}