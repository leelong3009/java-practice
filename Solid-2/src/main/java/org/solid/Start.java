package org.solid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.solid.output.ConsoleOutput;
import org.solid.output.DatabaseOutput;
import org.solid.output.IOutput;
import org.solid.output.LoggerOuput;
import org.solid.reader.IReader;
import org.solid.reader.ReaderFactory;
import org.solid.validate.IValidator;
import org.solid.validate.isNumberValidator;
import org.solid.validate.notNegativeZeroValidator;
import org.solid.validate.notNullEmptyValidator;

/**
 * Hello world!
 *
 */
public class Start 
{
    public static void main( String[] args ) throws IOException
    {
    	// Init validators
    	List<IValidator> validators = new ArrayList<IValidator>(Arrays.asList(
    			new notNullEmptyValidator(),
    			new isNumberValidator(),
    			new notNegativeZeroValidator()
    	));
    	
    	// Output decorator
    	IOutput console = new ConsoleOutput(null);
    	IOutput databaseOutput = new DatabaseOutput(console);
    	IOutput output = new LoggerOuput(databaseOutput);
    	
    	// Reader file path from console
        System.out.println( "SOLID Test" );
        System.out.print("Input file path: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        String readerType = filePath.substring(filePath.indexOf(".") + 1, filePath.length());
        
        // Processing
        IReader fileReader = ReaderFactory.getReaderInstance(readerType);
        if(filePath!=null && readerType != null && !filePath.isEmpty() && !readerType.isEmpty()){
        	List<String> list = fileReader.readFile(filePath);
        	List<String> validNumbers = new ArrayList<String>();
        	boolean isValid = true;
        	for(String s : list) {
        		isValid = true;
        		for(IValidator v : validators) {
        			isValid = isValid && v.validate(s); 
        			if(!isValid) break;
        		}
        		if(isValid) validNumbers.add(s);
        	}
        	// print out
        	output.process(validNumbers);
        }
    }
}
