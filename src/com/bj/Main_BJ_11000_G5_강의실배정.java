package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_11000_G5_강의실배정 {

	static ArrayList<int[]> list;
	
	//우선순위큐로 종료, 시작  오름차순 정렬
	//가장 처음꺼를 뺸뒤, 하나의 강의실에서 이어질 수 있는 강의를 모두 찾아냅니다.
	//그리고 그 다음 강의실 +++ 반복
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] now = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			list.add(now);
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		System.out.println();
		
		
	}
}