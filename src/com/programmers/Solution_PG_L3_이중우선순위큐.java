package com.programmers;

import java.util.*;

public class Solution_PG_L3_이중우선순위큐 {

	public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
	}

	static int[] solution(String[] operations) {
		int[] answer = {};
		int len = 0;

		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<operations.length; i++){
			String[] now = operations[i].split(" ");
			int cmd = Integer.parseInt(now[1]);

			if(now[0].equals("I")){
				minQ.add(cmd);
				maxQ.add(cmd);
				len++;
			} else {
				if(len == 0) continue;
				else{
					if(cmd == 1){
						int n = maxQ.poll();
						minQ.remove(new Integer(n));
					} else {
						int n = minQ.poll();
						maxQ.remove(new Integer(n));
					}
					len--;
				}
			}
		}

		if(len==0) return new int[]{0, 0};
		else return new int[]{maxQ.peek(), minQ.peek()};
	}
}
