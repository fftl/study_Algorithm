package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_02961_S2_도영이가만든맛있는음식 {

	//입력값의 신맛 쓴맛의 조건이 최대 10억까지의 수가 들어갈 수 있어서 long을 사용했습니다.
	static boolean[] visited;
	static long[][] data;
	static int N;
	static long result;
	
	static void powerSet(int cnt, long ssn, long sin) {
		//부분집합이 구해졌을 때, 바로 신맛과 쓴맛의 차를 구해 최소값을 갱신해줍니다.
		if(cnt == N) {
			if(ssn == 1 && sin == 0) {
				return;
			}
			
			result = Math.min(result, Math.abs(ssn-sin));
			return;
		}
		
		//파라미터에 각각 신맛, 쓴맛의 값을 전달하며 연산을 바로바로 해줍니다.
		visited[cnt] = true;
		powerSet(cnt+1, ssn*data[cnt][0], sin+data[cnt][1]);
		
		visited[cnt] = false;
		powerSet(cnt+1, ssn, sin);
		
	}
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new long[N][2];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			data[i][0] = sc.nextLong();
			data[i][1] = sc.nextLong();
		}
		
		powerSet(0, 1, 0);
		
		System.out.println(result);
		sc.close();
		
	}

}
