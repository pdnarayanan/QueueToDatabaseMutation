package com.narayan.test.data.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class contains the database configuration beans
 * 
 * @author Narayanan Durgadathan
 *
 */
@Configuration
public class DatabaseConfig {
	
	/**
	 * Creates a DataSource and returned
	 * 
	 * @return {@link DataSource}
	 * @throws SQLException
	 */
	@Bean
	public DataSource dataSource() throws SQLException {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:employee.db");
        DataSource dataSource = dataSourceBuilder.build();
        dataSource.getConnection().setAutoCommit(true);
        return dataSource;  
	}
	
	

}
