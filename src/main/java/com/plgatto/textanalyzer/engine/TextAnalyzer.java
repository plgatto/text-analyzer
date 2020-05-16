package com.plgatto.textanalyzer.engine;

import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

	public Map<String, Integer> analyze(String text, int wordsSetSize) {
		Map<String, Integer> wordsSets = new HashMap<String, Integer>();
		text = text.toLowerCase();
		String[] subSentences = text.split("\\p{Punct}");
		for (String sentence : subSentences) {
//			System.out.println(sentence);
			String[] words = sentence.strip().split("\\s+");
			for (int i = 0; i < words.length - wordsSetSize; i++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < wordsSetSize; k++) {
					sb.append(words[i + k]).append(" ");
				}
				String wordsSet = sb.toString().strip();
				if (wordsSet.split(" ").length != wordsSetSize) {
					System.err.println("Words sets \"" + wordsSet + "\" does not contains " + wordsSetSize + " words\n"
							+ "Sentence: " + sentence);
				}
				if (!wordsSets.containsKey(wordsSet)) {
					wordsSets.put(wordsSet, 1);
				} else {
					wordsSets.put(wordsSet, wordsSets.get(wordsSet) + 1);
				}
//				System.out.println(wordsSets.toString());
			}
		}
		return wordsSets;
	}
}
