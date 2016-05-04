package com.sample.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

public class Algorithm_nearestNumbers {

	public static void main(String[] args) {
//		Integer[] M = {1,3,5,5,14};
		List<Integer> M = new ArrayList<Integer>(300);
		Random d = new Random();
		for (int i=0; i<300; i++) {
			M.add(d.nextInt(1000));
		}
//		List<GenVO> generation = new ArrayList<GenVO>();
		boolean firstGen = true;
		Map<Integer, List<GenVO>> genMap = new HashMap<Integer, List<GenVO>>();
		
		for(int j=0; j < M.size(); j++) {
			List<GenVO> pendingItems = new ArrayList<GenVO>();
			List<GenVO> generation = genMap.get(j-1);
			if (generation == null) {
				generation = new ArrayList<GenVO>();
			}
			
			for(int i=0; i < M.size() ; i++) {
				System.out.println(String.format("i %d j %d", i, j));
				if (firstGen) {
					if (i == 0 || !M.get(i).equals(M.get(i-1))) {
						GenVO genVo = new GenVO();
						genVo.addSum(i, M.get(i));
						genVo.setGenLevel(j+1);
						pendingItems.add(genVo);
					}
				} else {
//					if (i == 0 || (M[i] != M[i-1])) {
						ListIterator<GenVO> iterator = generation.listIterator();
						while(iterator.hasNext()) {
							GenVO genVo = iterator.next(); 
							if (genVo.getGenLevel() == j && i > genVo.lastIndex() && (!M.get(i).equals(M.get(i-1)) || genVo.lastIndex() == i-1)) {
								GenVO clone = (GenVO) SerializationUtils.clone(genVo);
								clone.addSum(i, M.get(i));
								clone.setGenLevel(j+1);
								pendingItems.add(clone);
//								iterator.add(clone);
							}
						}
						
//					}
					
				}
				
				if (i == M.size()-1) {
					firstGen = false;
				}
				
//				for(GenVO genVo : generation) {
//					System.out.println("*** " + genVo.toString());
//				}
			}
			
			genMap.put(j, pendingItems);
		}
		
		Comparator<GenVO> comparator = new Comparator<GenVO>() {
			
			public int compare(GenVO o1, GenVO o2) {
				// TODO Auto-generated method stub
				return new CompareToBuilder()
						.append(o1.getGenLevel(), o2.getGenLevel())
						.append(o1.getSum(), o2.getSum())
						.toComparison();
			}
		};
		
//		Collections.sort(generation, comparator);
		Set<Integer> keys = genMap.keySet();
		for (Integer key : keys) {
			List<GenVO> list = genMap.get(key);
			for(GenVO genVo : list) {
				System.out.println("*** " + genVo.toString());
			}
		}

	}
	
	private static String getKey(List<Integer> list) {
		return list.toString();
	}

	private static List<Integer> clone(List<Integer> fromList) {
		List<Integer> toList = new ArrayList<Integer>();
		for (Integer i : fromList) {
			toList.add(i);
		}
		return toList;
	}
}
