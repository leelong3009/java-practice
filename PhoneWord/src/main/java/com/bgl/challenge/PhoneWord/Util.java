package com.bgl.challenge.PhoneWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

	public List<String> loadWords(String filePath) {
		try {
			Path path = Paths.get(filePath);
			Stream<String> lines = Files.lines(path);
	    	List<String> words = lines.map(String::trim).map(String::toUpperCase).collect(Collectors.toList());
	    	lines.close();
	    	return words;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidPathException e) {
			e.printStackTrace();
		}
    	
		return Collections.emptyList();
	}
	
	public Dictionary createDictionary(List<String> words) {
		return new Dictionary(words);
	}
}
