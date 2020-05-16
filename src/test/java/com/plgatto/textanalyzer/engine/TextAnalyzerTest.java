package com.plgatto.textanalyzer.engine;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TextAnalyzerTest {

	static String TEST_SENTENCE_1 = "Lorem ipsum dolor sit amet, consectetur adipisci elit, lorem ipsum dolor sit amet";
	static String TEST_SENTENCE_2 = "Lorem ipsum dolor sit amet, consectetur adipisci elit. Lorem ipsum dolor sit amet.";
	static String TEST_SENTENCE_3 = "Lorem ipsum dolor sit amet ;consectetur   adipisci elit! Lorem ipsum dolor sit amet.";
	
	Map<String, Integer> words = new HashMap<String, Integer>();

	private TextAnalyzer textAnalyzer = new TextAnalyzer() ;
	
	@Test
	public void testAnalyzeSentence() {
		int wordSetSize = 2;
		
		words = textAnalyzer.analyze(TEST_SENTENCE_1, wordSetSize); 
		checkResult();
		
		words = textAnalyzer.analyze(TEST_SENTENCE_2, wordSetSize); 
		checkResult();
		
		words = textAnalyzer.analyze(TEST_SENTENCE_3, wordSetSize); 
		checkResult();
	}

	private void checkResult() {
		assertEquals(Integer.valueOf(2), words.get("lorem ipsum"));
		assertEquals(Integer.valueOf(2), words.get("ipsum dolor"));
		assertEquals(Integer.valueOf(2), words.get("dolor sit"));
		assertEquals(Integer.valueOf(2), words.get("sit amet"));
		assertEquals(Integer.valueOf(1), words.get("consectetur adipisci"));
		assertEquals(Integer.valueOf(1), words.get("adipisci elit"));
	}
}
