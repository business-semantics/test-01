package com.smartkyc.test.test01.documents;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class DocumentLibrariesTest {

	static Stream<Class<?>> usedLibraries() {
		return DocumentLibraries.USED.stream();
	}

	@ParameterizedTest
	@MethodSource("usedLibraries")
	void libraryIsOnClasspath(Class<?> type) {
		assertThat(type.getPackage(), notNullValue());
	}

	@Test
	void createsPdf() throws Exception {
		assertThat(new String(DocumentLibraries.blankPdf(2), 0, 5, StandardCharsets.US_ASCII), equalTo("%PDF-"));
	}
}
