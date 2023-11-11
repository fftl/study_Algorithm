package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//dp문제들을 순차적으로 풀어보질 않아서 쉽게 풀어내지 못함
//뭔가 풀이 아이디어 비슷한 느낌은 떠올렸으나 못풀었습니다.

public class Main_BJ_02156_S1_포도주시식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//일단 데이터를 받아줍니다.
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//그리고 각 idx에 담을 수 있는 최대값을 담아놓을 dp 배열을 생성합니다.
		int[] dp = new int[n+1];
		
		//1번 자리는 무조건 arr[1]이 최대값입니다.
		dp[1] = arr[1];
		
		//만약 n이 1이면 dp[2]는 존재할 수 없으므로 걸러주고
		//그 이상이라면 dp[2]도 채워줍니다.
		if(n>1) dp[2] = arr[1]+arr[2];
		
		//이제 분기가 갈릴 수 있는 3번부터 dp를 제대로 채워주기 시작합니다.
		for (int i = 3; i <= n; i++) {
			
			//dp[i] 올 수 있는 수는 세가지 입니다.
			//dp[i]를 선택하지 않는 경우 => dp[i-1]를 그대로 가져옵니다.
			//dp[i-2]와 arr[i]를 선택하는 경우
			//dp[i-3]와 arr[i-1]+arr[i]를 선택하는 경우
			//세가지의 경우중 가장 큰 수를 dp[i]에 넣어주는 것을 반복합니다.
			dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]), dp[i-3]+arr[i-1]+arr[i]); 
		}
		
		//출력
		System.out.println(dp[n]);
	}
}
