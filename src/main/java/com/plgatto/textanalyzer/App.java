package com.plgatto.textanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.plgatto.textanalyzer.engine.TextAnalyzer;

public class App 
{
	static TextAnalyzer textAnalyzer = new TextAnalyzer(); 
	
    public static void main( String[] args )
    {
        File file = new File("test.txt");
        try {
			String data = FileUtils.readFileToString(file, "UTF-8");
			Map<String, Integer> result = textAnalyzer.analyze(data, 2);
			
			Map<String, Integer> sortedByCount = result.entrySet()
	                .stream()
	                .sorted(Map.Entry.comparingByValue())
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));	
			
			for(String wordsSet : sortedByCount.keySet()) {
				System.out.println(wordsSet + ": " + sortedByCount.get(wordsSet));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
