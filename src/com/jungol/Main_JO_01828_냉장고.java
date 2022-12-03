package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 정올 홈페이지에 접속이 되지 않아 문제만 인터넷에서 찾아서 풀어보았습니다.
// 그래서 정올에서 정답인지 확인은 해보지 못했습니다.
public class Main_JO_01828_냉장고 {
	static int N;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		//배열로 데이터를 받았습니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		//최고온도로 우선 오름차순 정렬, 최고온도가 같다면 최저온도로 오름차순 정렬 
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		//첫번째 물질을 먼저 넣고, 첫번째 물질의 최고 온도보다 다음 물질의 최저온도가 낮다면 같은 냉장고에 담을 수 있습니다.
		//그러나 다음 물질의 최저 온도가 현재 물질의 최고온도보다 높다면 새로운 냉장고를 마련합니다.
		int cnt = 1;
		int nowMin = list.get(0)[0];
		int nowMax = list.get(0)[1];
		
		for (int i = 1; i < list.size(); i++) {
			if(nowMax<list.get(i)[0]) {
				cnt++;
				nowMax = list.get(i)[1];
			}
		}
		
		System.out.println(cnt);
		
	}
}
