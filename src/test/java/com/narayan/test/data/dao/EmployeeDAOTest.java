package com.narayan.test.data.dao;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import com.narayan.test.model.Employee;

/**
 * Unit test for {@linbk EmployeeDAO}
 * 
 * @author narayanandurgadathan
 *
 */
public class EmployeeDAOTest {

	@Mock
	private DataSource dataSource;

	@Mock
	private Connection conn;

	@Mock
	private PreparedStatement preparedStatement;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private EmployeeDAO dao = new EmployeeDAOImpl();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		try {
			when(conn.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(dataSource.getConnection()).thenReturn(conn);
		} catch (SQLException e) {
			fail("SQL Exception in init");
		}
		Whitebox.setInternalState(dao, "dataSource", dataSource);
	}

	@Test
	public void testSaveOrUpdate() throws Exception {
		dao.saveOrUpdate(getTestEmployee());

		verify(preparedStatement, times(1)).executeUpdate();
		verify(preparedStatement, times(1)).close();
		verify(preparedStatement, times(9)).setString(anyInt(), anyString());
	}

	@Test
	public void testSaveOrUpdateException() throws Exception {
		when(conn.prepareStatement(anyString())).thenThrow(new SQLException("TEST"));
		exception.expect(DAOException.class);
		exception.expectMessage("TEST");
		dao.saveOrUpdate(getTestEmployee());
	}

	private Employee getTestEmployee() {
		Employee employee = new Employee();
		employee.setId(101);
		employee.setFirstName("FN");
		employee.setLastName("LN");
		employee.setAddress1("AD1");
		employee.setAddress2("AD2");
		employee.setState("ST");
		employee.setState("ST");
		employee.setZip("ZIP");
		employee.setEmail("EM");

		return employee;
	}
}
