package com.tic.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "hr";
	private static final String PWD = "hr";

	@Test
	public void testConn() throws Exception {
		Class.forName(DRIVER);
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD)) {
			System.out.println(conn); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// java.sql.sqlexception: 로케일을 인식할 수 없습니다. 
	// Mac의 언어 및 지역 설정을 미국으로 변경 후 한국으로 복구하니 정상동작.
}
