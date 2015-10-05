package org.solid.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextReader implements IReader {
	public TextReader(){
		System.out.println("Start text reader !!!");
	}
	
	public List<String> readFile(String filePath) {
		System.out.println("Reading file " + filePath);
		return new ArrayList<String>(Arrays.asList("-10","1", "18", "11"));
	}

}
