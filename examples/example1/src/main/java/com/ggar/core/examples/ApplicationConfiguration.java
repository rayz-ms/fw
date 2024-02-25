package com.ggar.core.examples;

import com.ggar.core.examples.domain.Log;
import com.ggar.core.examples.domain.LogId;
import com.ggar.core.examples.domain.Request;
import com.ggar.core.examples.entity.*;
import com.ggar.core.examples.adapter.FindByLogMessageAdapter;
import com.ggar.core.examples.repository.LogRepository;
import com.ggar.core.logging.BaseLogger;
import com.ggar.core.logging.processor.LogLevels;
import com.ggar.core.logging.processor.LogProcessor;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

@EnableJpaRepositories(basePackages = {"com.ggar.core.examples.repository"})
@AutoConfiguration(before = { HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration
@Configuration
public class ApplicationConfiguration {

	@Bean
	public DataSource dataSource(@Value("${spring.datasource.driver-class-name}") String driverClassName, @Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

//	@Bean
//	public DataSource datasource() {
//		return new EmbeddedDatabaseBuilder()
//			.setType(EmbeddedDatabaseType.H2)
//			.build();
//	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
//
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.ggar.core.examples.entity");
//		factory.setPersistenceUnitName("log");
//		factory.setPersistenceUnitName("translation");
//		factory.setPersistenceUnitName("application");
//		factory.setPersistenceUnitName("system");
//		factory.setDataSource(datasource);
//		return factory;
//	}

//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory);
//		return txManager;
//	}

//	@Bean
//	public JpaRepository<ApplicationEntity, Long> applicationRepository(EntityManager em) {
//		return new SimpleJpaRepository<>(ApplicationEntity.class, em);
//	}
//
//	@Bean
//	public JpaRepository<SystemEntity, Long> systemRepository(EntityManager em) {
//		return new SimpleJpaRepository<>(SystemEntity.class, em);
//	}
}
