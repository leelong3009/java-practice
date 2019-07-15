package com.sample.common;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> items;
	
	public Stack() {
		items = new LinkedList<T>();
	}
	
	public void put(T item) {
		items.addFirst(item);
	}
	
	public T pop() {
		return items.removeFirst();
	}
	
}
