package com.day25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String inputFile = "C:\\Users\\Administrator\\Desktop\\Text File\\input.txt";
		String outputFile = "C:\\Users\\Administrator\\Desktop\\Text File\\output.txt";
		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Map<String, Integer> wordFrequency = new HashMap<>();
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for(String word : words) {
					word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
					if(!word.isEmpty()) {
						wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
					}
				}
			}
			bufferedReader.close();
			FileWriter fileWriter = new FileWriter(outputFile);
			for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
				fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			fileWriter.close();
			System.out.println("Word frequencies have been written to " + outputFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
