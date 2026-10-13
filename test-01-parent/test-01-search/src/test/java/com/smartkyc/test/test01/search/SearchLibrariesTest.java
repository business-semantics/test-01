package com.smartkyc.test.test01.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SearchLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return SearchLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void scoresMatchingText() throws Exception {
		assertThat(SearchLibraries.score("know your customer screening", "customer"), greaterThan(0f));
		assertThat(SearchLibraries.score("know your customer screening", "invoice"), equalTo(0f));
	}
}
