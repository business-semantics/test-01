package com.smartkyc.test.test01.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CoreLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return CoreLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void writesYaml() throws Exception {
		assertThat(CoreLibraries.toYaml(Map.of("name", "test-01")), containsString("name: \"test-01\""));
	}

	@Test
	void buildsCoordinates() {
		assertThat(new Library("com.smartkyc.test", "test-01-core", "1").coordinates(), equalTo("com.smartkyc.test:test-01-core:1"));
	}
}
