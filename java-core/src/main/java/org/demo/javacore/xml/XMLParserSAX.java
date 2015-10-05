package org.demo.javacore.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.demo.javacore.xml.model.Employee2;
import org.xml.sax.SAXException;

public class XMLParserSAX {
	public static void main(String[] args){
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxFactory.newSAXParser();
			MyHandler handler =  new MyHandler();
			saxParser.parse(new File("/home/lee/workspace/temp/employee.xml"), handler);
			//Get Employees list
	        List<Employee2> empList = handler.getEmpList();
	        //print employee information
	        for(Employee2 emp : empList)
	            System.out.println(emp);
		}catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
	}
}
