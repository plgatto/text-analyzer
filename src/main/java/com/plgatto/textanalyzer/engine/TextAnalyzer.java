package com.plgatto.textanalyzer.engine;

import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

	// TODO update with regex
	public Map<String, Integer> analyze(String text, int wordsSetSize) {
		Map<String, Integer> wordsSets = new HashMap<String, Integer>();
		text = text.toLowerCase();
		String[] subSentences = text.split(",");
		for(String sentence : subSentences) {
//			System.out.println(sentence);
			String[] words = sentence.strip().split(" ");
			for (int i = 0; i < words.length - 1; i++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < wordsSetSize; k++) {
					sb.append(words[i+k]).append(" ");
				}
				String wordsSet = sb.toString().strip();
				if(!wordsSets.containsKey(wordsSet)) {
					wordsSets.put(wordsSet, 1);
				} else {
					wordsSets.put(wordsSet, wordsSets.get(wordsSet)+1);
				}
//				System.out.println(wordsSets.toString());
			}
		}
		return wordsSets;
	}
}
