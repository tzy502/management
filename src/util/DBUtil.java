package util;

import java.sql.Connection;

public class DBUtil {
	private static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/data?useSSL=false";
	private static final String dbUser = "502";
	private static final String dbPwd = "502";

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