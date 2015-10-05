package org.demo.javacore.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.demo.javacore.xml.model.Employee2;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domParserExample {
	public static void main(String[] args){
		String filePath = "/home/lee/workspace/temp/employee.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			//now XML is loaded as Document in memory, lets convert it to Object List
			NodeList nodeList = doc.getElementsByTagName("Employee");
			List<Employee2> empList = new ArrayList<Employee2>();
			for(int i=0; i<nodeList.getLength(); i++){
				empList.add(getEmployee(nodeList.item(i)));
			}
			 //lets print Employee list information
            for (Employee2 emp : empList) {
                System.out.println(emp.toString());
            }
		}catch(Exception e){
			
		}
	}
	
	public static Employee2 getEmployee(Node node){
		Employee2 emp = new Employee2();
		if(node.getNodeType() == Node.ELEMENT_NODE){
			Element element = (Element)node;
			emp.setAge(Integer.parseInt(getTagValue("age", element)));
			emp.setGender(getTagValue("gender", element));
			emp.setName(getTagValue("name", element));
			emp.setRole(getTagValue("role", element));
		}
		return emp;
	}
	
	public static String getTagValue(String tag, Element element){
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
