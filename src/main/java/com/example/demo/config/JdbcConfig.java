package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class JdbcConfig {
	
	@Value("${DATABASE_NAME}")
	String db_name;
	@Value("${DB_USER}")
	String user_name;
	@Value("${DB_PASS}")
	String password;
	@Value("${DB_URL}")
	String db_url;
	
@Bean
@Primary
public DataSource getDataSource() {
		
	HikariDataSource ds = new HikariDataSource();
	String db_name = "TestDatabase";
	String user_name = "root";
	String password = "root";
	String db_url = "jdbc:mysql://localhost:3306";
	String database_connection_url = db_url+"/"+db_name;
	
	ds.setJdbcUrl(database_connection_url);
	ds.setUsername(user_name);
	ds.setPassword(password);
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	
	
	return ds;
	
}

@Bean
public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
}

@Bean
public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
}



}
