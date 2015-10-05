package org.demo.javacore.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.demo.javacore.xml.model.Employee2;

public class StaxXMLReader {
	public static void main(String[] args){
		String fileName = "/home/lee/workspace/temp/employee.xml";
        List<Employee2> empList = parseXML(fileName);
        for(Employee2 emp : empList){
            System.out.println(emp.toString());
        }
	}
	
	public static List<Employee2> parseXML(String fileName){
		List<Employee2> empList = new ArrayList<Employee2>();
		Employee2 emp = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try{
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while(xmlEventReader.hasNext()){
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if(xmlEvent.isStartElement()){
					StartElement startElement = xmlEvent.asStartElement();
					if(startElement.getName().getLocalPart().equals("Employee")){
						emp = new Employee2();
						//Get the 'id' attribute from Employee element
						Attribute idAttr = startElement.getAttributeByName(new QName("id"));
						if(idAttr != null){
							emp.setId(Integer.parseInt(idAttr.getValue()));
						}
					}					
					//set the other varibles from xml elements
					else if(startElement.getName().getLocalPart().equals("age")){
					    xmlEvent = xmlEventReader.nextEvent();
					    emp.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
					}else if(startElement.getName().getLocalPart().equals("name")){
					    xmlEvent = xmlEventReader.nextEvent();
					    emp.setName(xmlEvent.asCharacters().getData());
					}else if(startElement.getName().getLocalPart().equals("gender")){
					    xmlEvent = xmlEventReader.nextEvent();
					    emp.setGender(xmlEvent.asCharacters().getData());
					}else if(startElement.getName().getLocalPart().equals("role")){
					    xmlEvent = xmlEventReader.nextEvent();
					    emp.setRole(xmlEvent.asCharacters().getData());
					}
				}
				
				if(xmlEvent.isEndElement()){
					EndElement endElement = xmlEvent.asEndElement();
					if(endElement.getName().getLocalPart().equals("Employee")){
						empList.add(emp);
					}
				}
			}
		}catch(FileNotFoundException | XMLStreamException e){
			e.printStackTrace();
		}
		return empList;
	}
}
