package org.inventory_pj.dbteset;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCtest {
	String driver = "com.mysql.cj.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/inventory?serverTimezone=Asia/Seoul";

	String user = "root";

	String password = "1234";

	@Test
	public void testConnetion() throws Exception {
		Class.forName(driver);
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
