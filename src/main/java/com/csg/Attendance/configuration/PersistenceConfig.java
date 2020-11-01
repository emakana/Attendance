package com.csg.Attendance.configuration;

import java.io.Serializable;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
	
	@Value("${spring.datasource.url}")
	private String databaseUrl;
	
	@Value("${spring.datasource.platform}")
	private String datasourcePlatform;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
			
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${spring.jpa.database-platform}")
	private String databasePlatform;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateAuto;
	/**
	 * 
	 * @return
	 */
	@Bean
	public SessionFactory setSessionFactory(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory().getNativeEntityManagerFactory().unwrap(SessionFactory.class);
	} 
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(databaseUrl);

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
		jpaVendorAdapter.setDatabasePlatform(databasePlatform);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}
	/**
	 * 
	 * @return
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan("com.csg.Attendance.entity");
		return lemfb;
	}
	
	private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", hibernateAuto);
        hibernateProperties.setProperty(
          "hibernate.dialect", databasePlatform);
 
        return hibernateProperties;
    }
}
