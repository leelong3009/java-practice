package org.solid.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelReader implements IReader {
	public ExcelReader(){
		System.out.println("Start excel reader !!!");
	}

	public List<String> readFile(String filePath) {
		System.out.println("Reading file " + filePath);
		return new ArrayList<String>(Arrays.asList("0","1", "8", "12"));
	}

}
