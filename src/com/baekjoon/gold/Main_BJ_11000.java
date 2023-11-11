package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_11000_G5_강의실배정 {

	static boolean check(boolean[] visited) {
		boolean run = false;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				run = true;
				break;
			}
		}
		return run;
	}

	// 우선순위큐로 종료, 시작 오름차순 정렬
	// 가장 처음꺼를 뺸뒤, 하나의 강의실에서 이어질 수 있는 강의를 모두 찾아냅니다.
	// 그리고 그 다음 강의실 +++ 반복
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		boolean[] visited = new boolean[N];

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

		int cnt = 0;
		while (check(visited)) {
			cnt++;
			for(int i=0; i<list.size(); i++) {
				if(!visited[i]) {
					int end = list.get(i)[1];
					visited[i] = true;
					
					for (int j = i+1; j < list.size(); j++) {
						if(!visited[j] && end<=list.get(j)[0]) {
							visited[j] = true;
							end = list.get(j)[1];
						}
					}
					
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}