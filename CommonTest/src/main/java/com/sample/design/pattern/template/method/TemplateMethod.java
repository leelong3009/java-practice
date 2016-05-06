package com.sample.design.pattern.template.method;

public class TemplateMethod {
	public static void main(String[] args) {
        
        HouseTemplate houseType = new WoodenHouse();
         
        //using template method
        houseType.buildHouse();
        System.out.println("************");
         
        houseType = new GlassHouse();
         
        houseType.buildHouse();
    }
}
