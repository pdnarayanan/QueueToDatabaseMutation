package com.narayan.test.data.dao;

import com.narayan.test.model.Employee;

/**
 * The CURD operation interface for Employee model
 * 
 * @author Narayanan Durgadathan
 *
 *TODO use JPA Repository
 */
public interface EmployeeDAO {

	void saveOrUpdate(Employee employee) throws RuntimeException ;
	
	Employee get(Integer id) throws RuntimeException ;
}
