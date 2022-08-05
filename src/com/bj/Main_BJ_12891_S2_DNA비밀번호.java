package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분집합으로 풀이, 시간초과
public class Main_BJ_12891_S2_DNA비밀번호 {
	static int n, p, result;
	static int[] cnts;
	static StringBuilder sb;
	static char[] data;
	static boolean[] visited;

	static void check() {
		String now = "";
		boolean yes = true;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				now += data[i];
			}
		}

		if (now.length() == p) {
			int[] nowCnt = new int[4];
			for (int i = 0; i < now.length(); i++) {
				switch (now.charAt(i)) {
				case 'A':
					nowCnt[0]++;
					break;
				case 'C':
					nowCnt[1]++;
					break;
				case 'G':
					nowCnt[2]++;
					break;
				case 'T':
					nowCnt[3]++;
					break;
				}
			}

			for (int i = 0; i < 4; i++) {
				if (cnts[i] > nowCnt[i]) {
					yes = false;
					break;
				}
			}
			if (yes) {
				result++;
			}
		} else {
			return;
		}
	}

	//부분집합 이해해보기
	static void powerSet(int idx) {
		if (idx == n) {
			check();
			return;
		}

		visited[idx] = false;
		powerSet(idx + 1);

		visited[idx] = true;
		powerSet(idx + 1);
	}

	// 문자열의 모든 문자가 A C G T 여야 합니다.
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		result = 0;

		data = br.readLine().toCharArray();
		visited = new boolean[data.length];

		cnts = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cnts.length; i++) {
			cnts[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0);
		System.out.println(result);
	}
}
