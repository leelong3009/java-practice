package com.sample.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortObject implements Comparable<SortObject>{
	private String name;
	private int value;
	
	public SortObject(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public static void main(String[] args) {
		SortObject s1 = new SortObject("b", 2);
		SortObject s2 = new SortObject("a", 1);
		SortObject s3 = new SortObject("c", 2);
		SortObject s4 = new SortObject("d", 3);
		SortObject s5 = new SortObject("e", 2);
		List<SortObject> list = new ArrayList<SortObject>();
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);
		Collections.sort(list);
		for(SortObject o : list) {
			System.out.println(o.getName() + o.getValue());
		}
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int compareTo(SortObject o) {
		return this.getValue() - o.getValue();
	}

}
