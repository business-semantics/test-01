package com.smartkyc.test.test01.http;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class HttpLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return HttpLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void buildsClient() {
		assertThat(HttpLibraries.client(Duration.ofSeconds(5)).callTimeoutMillis(), equalTo(5000));
	}
}
