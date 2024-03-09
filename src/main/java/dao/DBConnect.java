package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("b1");
		String url="jdbc:sqlserver://DESKTOP-FF1278R\\SQLEXPRESS:1433;databaseName=QLMayTinh;user=sa;password=123";
		cn= DriverManager.getConnection(url);
		System.out.print("Da ket noi");
	}
}
