package com.smartkyc.test.test01.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.ImmutableSortedMap;

/**
 * General purpose libraries managed by test-01-bom.
 */
public final class CoreLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			org.joda.time.DateTime.class,
			org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch.class,
			com.ibm.icu.text.Transliterator.class,
			org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.class,
			org.apache.commons.collections.CollectionUtils.class,
			org.apache.commons.collections4.CollectionUtils.class,
			com.google.common.collect.ImmutableMap.class,
			org.apache.commons.codec.binary.Base64.class,
			org.apache.commons.lang3.StringUtils.class,
			org.antlr.runtime.ANTLRStringStream.class,
			org.antlr.v4.runtime.CharStreams.class,
			org.apache.commons.csv.CSVFormat.class,
			com.fasterxml.jackson.databind.ObjectMapper.class,
			com.fasterxml.jackson.core.JsonFactory.class,
			com.fasterxml.jackson.datatype.guava.GuavaModule.class,
			com.fasterxml.jackson.datatype.jdk8.Jdk8Module.class,
			com.fasterxml.jackson.datatype.jsr310.JavaTimeModule.class,
			com.fasterxml.jackson.dataformat.yaml.YAMLFactory.class,
			com.fasterxml.jackson.annotation.JsonProperty.class,
			com.fasterxml.jackson.dataformat.xml.XmlMapper.class,
			com.fasterxml.jackson.dataformat.csv.CsvMapper.class,
			org.apache.commons.io.FileUtils.class,
			ch.qos.logback.classic.LoggerContext.class,
			org.apache.logging.log4j.LogManager.class,
			org.apache.logging.slf4j.SLF4JLoggerContextFactory.class,
			org.slf4j.LoggerFactory.class,
			org.slf4j.simple.SimpleLogger.class,
			org.slf4j.jul.JDK14LoggerAdapter.class,
			org.apache.commons.logging.LogFactory.class,
			org.apache.log4j.Logger.class,
			org.mapstruct.Mapper.class,
			io.jsonwebtoken.Jwts.class,
			io.jsonwebtoken.impl.DefaultJwtBuilder.class,
			io.jsonwebtoken.jackson.io.JacksonSerializer.class,
			org.yaml.snakeyaml.Yaml.class,
			org.jetbrains.annotations.NotNull.class);

	private CoreLibraries() {
	}

	public static String toYaml(Map<String, ?> values) throws IOException {
		return new ObjectMapper(new YAMLFactory()).writeValueAsString(ImmutableSortedMap.copyOf(values));
	}
}
