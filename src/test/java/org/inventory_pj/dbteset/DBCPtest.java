package org.inventory_pj.dbteset;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("root-context.xml�� Ǯ���")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPtest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()) {
			System.out.println("DBCP ���� ����");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
