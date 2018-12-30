package com.narayan.test.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.narayan.test.model.Employee;

/**
 * 
 * Implementation for {@link EmployeeDAO}
 * 
 * @author  Narayanan Durgadathan
 *
 */
@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	private static final String GET_QUERY = "SELECT id, first_name, last_name, address1, address2, city, state, zip, email "
			+ "FROM employee WHERE id=?";

	private static final String MUTATE_QUERY = "INSERT OR REPLACE INTO "
			+ "employee(id, first_name, last_name, address1, address2, city, state, zip, email) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Autowired
	private DataSource dataSource;

	@Override
	public void saveOrUpdate(Employee employee) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(MUTATE_QUERY);
			ps.setString(1, employee.getId() == null ? null : employee.getId().toString());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getAddress1());
			ps.setString(5, employee.getAddress2());
			ps.setString(6, employee.getCity());
			ps.setString(7, employee.getState());
			ps.setString(8, employee.getZip());
			ps.setString(9, employee.getEmail());
			ps.executeUpdate();

			ps.close();
		} catch (Exception e) {
			logger.error("DataBase Isertion failed...", e);
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException ee) {
					// no-op
				}
			}

			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.commit();
					conn.close();
				} catch (SQLException e) {
					// no-op
				}
			}
		}

	}

	@Override
	public Employee get(Integer id) throws RuntimeException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(GET_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Employee employee = new Employee();

			if (rs.next()) {
				employee.setId(id);
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setAddress1(rs.getString("address1"));
				employee.setAddress2(rs.getString("address2"));
				employee.setCity(rs.getString("city"));
				employee.setState(rs.getString("state"));
				employee.setZip(rs.getString("zip"));
				employee.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();
			return employee;
		} catch (Exception e) {
			// TODO logging
			throw new RuntimeException(e);
		} finally {
			closeConnection(conn);

		}

	}

	private void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// No-op
			}
		}
	}

}
