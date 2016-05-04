package com.sample.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public enum EnumWithProperties 
{
	IT(1, 20),
	BANKING(2, 12),
	ACCOUNTING(3, 33);
	
	private int id;
	private int quantity;
	
	private static final Map<Integer, EnumWithProperties> MAP_ALL = new HashMap<Integer, EnumWithProperties>();
	
	static {
		for(EnumWithProperties entity : values()) {
			MAP_ALL.put(entity.id, entity);
		}
	}
	
	private EnumWithProperties(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
    public static void main( String[] args )
    {
        int total = 0;
        Set<Integer> keys = MAP_ALL.keySet();
        for(Integer key : keys){
        	total += MAP_ALL.get(key).quantity;
        }
        System.out.println("Total students : " + total);
    }

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}
    
    
}
