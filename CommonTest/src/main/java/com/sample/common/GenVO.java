package com.sample.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenVO implements Serializable{
	private static final long serialVersionUID = -6477184931953963715L;
	private int genLevel;
	private int sum;
	private List<Integer> indexsChain = new ArrayList<Integer>();
	
	public int getSum() {
		return sum;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public List<Integer> getIndexsChain() {
		return indexsChain;
	}
	
	public void setIndexsChain(List<Integer> indexsChain) {
		this.indexsChain = indexsChain;
	}
	
	public int getGenLevel() {
		return genLevel;
	}
	
	public void setGenLevel(int genLevel) {
		this.genLevel = genLevel;
	}
	
	public void addSum(int index, int value) {
		this.indexsChain.add(index);
		sum += value;
	}
	
	public int lastIndex() {
		return indexsChain.get(indexsChain.size()-1);
	}
	
	@Override
	public String toString() {
		return this.genLevel + "-" + this.sum + "-" + this.indexsChain;
	}
}
