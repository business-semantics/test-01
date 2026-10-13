package com.smartkyc.test.test01.persistence;

import java.util.List;

import com.zaxxer.hikari.HikariConfig;

/**
 * Persistence and Spring libraries managed by test-01-bom.
 */
public final class PersistenceLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			com.zaxxer.hikari.HikariConfig.class,
			org.hibernate.cfg.Configuration.class,
			jakarta.transaction.Transactional.class,
			jakarta.annotation.PostConstruct.class,
			org.springframework.aop.framework.ProxyFactory.class,
			org.springframework.beans.BeanWrapperImpl.class,
			org.springframework.context.annotation.AnnotationConfigApplicationContext.class,
			org.springframework.mail.SimpleMailMessage.class,
			org.springframework.core.io.ClassPathResource.class,
			org.springframework.expression.spel.standard.SpelExpressionParser.class,
			org.springframework.jdbc.core.JdbcTemplate.class,
			org.springframework.jms.core.JmsTemplate.class,
			org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.class,
			org.springframework.transaction.support.TransactionTemplate.class,
			org.springframework.data.jpa.repository.JpaRepository.class);

	private PersistenceLibraries() {
	}

	public static HikariConfig poolConfig(String jdbcUrl, int maxPoolSize) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setMaximumPoolSize(maxPoolSize);
		config.setPoolName("test-01");
		return config;
	}
}
