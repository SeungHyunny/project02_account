package homebook.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn;

	public synchronized static Connection create() throws SQLException{

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="homebook"; 
		String password ="homebook";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC 드라이버가 없습니다.");
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url,user,password);
		return conn;
	} 

	public synchronized static void close() throws SQLException {
		if(conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
