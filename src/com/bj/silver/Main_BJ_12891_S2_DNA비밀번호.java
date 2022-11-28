package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//투포인터 ( 슬라이딩 윈도우 )
public class Main_BJ_12891_S2_DNA비밀번호 {
	static int n, p, result;
	static int[] cnts, nowCnts;
	static StringBuilder sb;
	static String data;
	
	static void check() {
		for(int i=0; i<4; i++) {
			if(cnts[i]>nowCnts[i]) {
				return;
			}
		}
		result++;
		return;
	}

	// 문자열의 모든 문자가 A C G T 여야 합니다.
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		result = 0;

		data = br.readLine();

		cnts = new int[4];
		nowCnts = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cnts.length; i++) {
			cnts[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p; i++) {
			switch (data.charAt(i)) {
			case 'A':
				nowCnts[0]++;
				break;
			case 'C':
				nowCnts[1]++;
				break;
			case 'G':
				nowCnts[2]++;
				break;
			case 'T':
				nowCnts[3]++;
				break;
			}
		}
		
		check();
		
		for(int i=1; i<=n-p; i++) {
			switch (data.charAt(i-1)) {
			case 'A':
				nowCnts[0]--;
				break;
			case 'C':
				nowCnts[1]--;
				break;
			case 'G':
				nowCnts[2]--;
				break;
			case 'T':
				nowCnts[3]--;
				break;
			}
			
			switch (data.charAt(i+p-1)) {
			case 'A':
				nowCnts[0]++;
				break;
			case 'C':
				nowCnts[1]++;
				break;
			case 'G':
				nowCnts[2]++;
				break;
			case 'T':
				nowCnts[3]++;
				break;
			}
			check();
		}
		
		

		System.out.println(result);
	}

}
