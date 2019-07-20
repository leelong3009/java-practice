package com.bgl.challenge.PhoneWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

	private static final Logger LOGGER = Logger.getLogger(Util.class.getName());
	
	public static List<String> readFile(String filePath) {
		try {
			Path path = Paths.get(filePath);
			Stream<String> lineStream = Files.lines(path);
	    	List<String> lines = lineStream.map(String::trim).map(s -> s.replaceAll("[\\s,]+", "")).collect(Collectors.toList());
	    	lineStream.close();
	    	return lines;
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Can't open file " + filePath, e);
		} catch (InvalidPathException e) {
			LOGGER.log(Level.SEVERE, "Invalid file path " + filePath, e);
		}
    	
		return Collections.emptyList();
	}
	
	public static Dictionary createDictionary(List<String> words) {
		return new Dictionary(words);
	}
}
