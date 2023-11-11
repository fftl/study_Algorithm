package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02096_G5_내려가기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[][] board = new int[t][3]; //주어지는 숫자들을 담을 board배열
		int[][] max = new int[t][3];   //최대값을 찾기 위한 dp배멸 max
		int[][] min = new int[t][3];   //최소값을 찾기 위한 dp배열 min
		
		//StringTokenizer를 이용해 board를 채워줍니다.
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[i][0] = a;
			board[i][1] = b;
			board[i][2] = c;
		}
		
		//max와 min모두 첫 시작은 똑같으므로 같이 초기화를 해줍니다.
		max[0][0] = board[0][0];
		max[0][1] = board[0][1];
		max[0][2] = board[0][2];
		
		min[0][0] = board[0][0];
		min[0][1] = board[0][1];
		min[0][2] = board[0][2];
		
		//t-1라인까지 반복하는 for문
		for (int i = 1; i < t; i++) {
			
			//max의 경우
			//0번 index에는 0, 1에서 올 수 있고
			//1번 index에는 0, 1, 2 모든 곳에서,
			//2번 index에는 1, 2에서 올 수 있습니다. 그렇기 때문에 i-1 라인에서 각각 index에 올 수 있는 곳들 중 가장 큰 숫자에서 값을 가져와 i번 라인의 index의 수와 더해주는 작업을 반복합니다.
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + board[i][0];
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + board[i][1];
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + board[i][2];
			
			//min의 경우
			//각각의 위치에 올 수 있는 index는 같지만 max와 달리 가장 작은 값을 찾아 i번의 라인으로 넘기는 작업을 반복하면 됩니다!
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + board[i][0];
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + board[i][1];
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + board[i][2];
		}
		
		//위의 작업이 끝나고 가장 마지막 줄인 t-1의 수 중에 가장 큰 값, 가장 작은값을 각각 구하면 해당 값들이 답이 됩니다.
		int maxResult = Math.max(Math.max(max[t-1][0], max[t-1][1]), max[t-1][2]);
		int minResult = Math.min(Math.min(min[t-1][0], min[t-1][1]), min[t-1][2]);
		
		//결과물 출력!
		System.out.println(maxResult+" "+minResult);
	}
}
