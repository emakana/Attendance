package com.csg.Attendance.configuration;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Configuration
@EnableJpaRepositories("com.csg.Attendance.entity")
@EnableTransactionManagement
public class PersistenceConfig implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(PersistenceConfig.class);

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// dataSource.setDriverClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");

		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		dataSource.setDriverClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		dataSource.setUrl("jdbc:mysql://localhost:3306/attendance");

		return dataSource;
	}
	/**
	 * 
	 * @param emf
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	/**
	 * 
	 * @return
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}
	/**
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan("com.csg.Attendance.entity");
		return lemfb;
	}
}
