package com.bgl.challenge.PhoneWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

	private static final Function<String, String> removeAllPunctuation = s -> s.replaceAll("[\\s.,?!'\":;\\-\\(\\)\\[\\]]+", "");
	
	public static List<String> readFile(String filePath) {
		try {
			Path path = Paths.get(filePath);
			Stream<String> lineStream = Files.lines(path);
	    	List<String> lines = lineStream.map(String::trim).map(removeAllPunctuation).collect(Collectors.toList());
	    	lineStream.close();
	    	return lines;
		} catch (IOException e) {
			System.out.println("----> Can't open file \"" + filePath + "\"");
		} catch (InvalidPathException e) {
			System.out.println("----> Invalid file path \"" + filePath + "\"");
		}
    	
		return Collections.emptyList();
	}
	
	public static Dictionary createDictionary(List<String> words) {
		return new Dictionary(words);
	}
	
	public static String removePunctuation(String s) {
		if (s != null && !s.isEmpty()) {
			return removeAllPunctuation.apply(s);
		}
		return "";
	}
}
