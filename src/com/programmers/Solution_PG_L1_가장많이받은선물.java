package com.programmers;

import java.util.*;
import java.io.*;
public class Solution_PG_L1_가장많이받은선물 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
	}

	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;
		int fsize = friends.length;
		int[] giftVal = new int[fsize]; //선물지수
		int[] result = new int[fsize];

		HashMap<String, Integer> names = new HashMap<>();
		ArrayList<int[]> data = new ArrayList<>(); //각 선물 주고받은 정보를 담습니다.

		for(int i=0; i<fsize; i++){
			names.put(friends[i], i);
			data.add(new int[fsize]);
		}

		//이번 달 까지 주고받은 선물 수를 파악합니다.
		for(int i=0; i<gifts.length; i++){
			String[] nows = gifts[i].split(" ");
			// System.out.println(nows[0] + "," + nows[1]);

			int from = names.get(nows[0]);
			int to = names.get(nows[1]);

			data.get(from)[to]++;

			//선물 지수를 계산
			giftVal[from]++;
			giftVal[to]--;
		}

		// System.out.println(Arrays.toString(giftVal));

		for(int a=0; a<fsize; a++){
			for(int b=a+1; b<fsize; b++){

				//서로가 주고 받은 선물이 하나라도 있다면
				if(data.get(a)[b] + data.get(b)[a] > 0 && data.get(a)[b] != data.get(b)[a]){
					if(data.get(a)[b] > data.get(b)[a]) result[a]++;
					if(data.get(a)[b] < data.get(b)[a]) result[b]++;
				} else {
					if(giftVal[a] != giftVal[b]){
						if(giftVal[a] > giftVal[b]) result[a]++;
						if(giftVal[a] < giftVal[b]) result[b]++;
					}
				}
			}
		}

		for(int i=0; i<fsize; i++){
			answer = Math.max(answer, result[i]);
		}

		return answer;
	}
}
