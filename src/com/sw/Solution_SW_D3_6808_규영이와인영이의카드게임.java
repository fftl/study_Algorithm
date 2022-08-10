package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D3_6808_규영이와인영이의카드게임 {
	static int m, win, lose;
	static int[] gu, en, now;
	static boolean[] visited;
	
	static void vs(int[] guCards, int[] enCards) {
		int gScore = 0;
		int eScore = 0;
		for(int i=0; i<9; i++) {
			if(guCards[i] > enCards[i]) {
				gScore += guCards[i] + enCards[i]; 
			} else {
				eScore += guCards[i] + enCards[i];
			}
		}
		
		if(gScore>eScore) win++;
		else lose++;
	} 
	
	static void perm(int cnt) {
		if(cnt == m) {
			vs(gu, now);
			return;
		}
		
		for(int i=0; i<m; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			now[cnt] = en[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_6808.txt")); // input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			m = 9;
			win = 0;
			lose = 0;
			gu = new int[9];
			en = new int[9];
			now = new int[9];
			visited = new boolean[9];
			
			for (int i = 0; i < 9; i++) {
				gu[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean check = true;
				for (int j = 0; j < 9; j++) {
					if (i == gu[j]) {
						check = false;
					}
				}
				if (check) {
					en[idx] = i;
					idx++;
				}
			}

			Arrays.sort(en);
			perm(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}

}
