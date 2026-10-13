package com.smartkyc.test.test01.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PersistenceLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return PersistenceLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void queriesInMemoryDatabase() {
		JdbcTemplate jdbc = new JdbcTemplate(new DriverManagerDataSource(PersistenceLibraries.poolConfig("jdbc:hsqldb:mem:test01", 2).getJdbcUrl(), "SA", ""));
		assertThat(jdbc.queryForObject("VALUES (1 + 1)", Integer.class), equalTo(2));
	}
}
