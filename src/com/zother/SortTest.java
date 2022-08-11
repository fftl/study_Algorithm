package com.zother;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortTest {
	static int[] data = {99, 2341, 56, 121 ,1 ,2, 3};
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	});
	
	public static void main(String[] args) {
		
		for (int i = 0; i < data.length; i++) {
			pq.add(data[i]);
		}
		//toString으로 데이터 볼때는 정렬이 되어있진않네용 
		System.out.println(pq.toString());
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
