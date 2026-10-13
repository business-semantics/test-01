package com.smartkyc.test.test01.search;

import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.memory.MemoryIndex;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;

/**
 * Search and natural language libraries managed by test-01-bom.
 */
public final class SearchLibraries {

	/** One public type of every library this module depends on. */
	public static final List<Class<?>> USED = List.of(
			uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler.class,
			org.elasticsearch.client.RestHighLevelClient.class,
			org.apache.lucene.analysis.standard.ClassicAnalyzer.class,
			org.apache.lucene.analysis.standard.StandardAnalyzer.class,
			org.apache.lucene.facet.FacetsConfig.class,
			org.apache.lucene.search.highlight.Highlighter.class,
			org.apache.lucene.search.join.ToParentBlockJoinQuery.class,
			org.apache.lucene.index.memory.MemoryIndex.class,
			org.apache.lucene.queries.function.FunctionQuery.class,
			org.apache.lucene.queryparser.classic.QueryParser.class,
			zemberek.morphology.TurkishMorphology.class,
			morfologik.stemming.polish.PolishStemmer.class,
			com.smartkyc.stemmers.tagalog.TagalogStemmer.class,
			sk.essentialdata.nlp.stemmer.sk.SlovakStemmer.class,
			weka.core.stemmers.SerbianStemmer.class,
			com.smartkyc.stemmers.uzbek.UzbekStemmer.class,
			com.smartkyc.stemmers.azerbaijani.AzerbaijaniStemmer.class);

	private SearchLibraries() {
	}

	public static float score(String text, String query) throws ParseException {
		try (StandardAnalyzer analyzer = new StandardAnalyzer()) {
			MemoryIndex index = new MemoryIndex();
			index.addField("content", text, analyzer);
			return index.search(new QueryParser("content", analyzer).parse(query));
		}
	}
}
