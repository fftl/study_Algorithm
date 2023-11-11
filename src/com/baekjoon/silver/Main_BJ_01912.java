package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01912_S2_연속합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		//일단 입력 데이터를 받아주면서 그중 최대 값을 찾아줍니다.
		//모든 수가 0 보다 작을경우 여기서 찾은 최대값이 결과 값이 됩니다.
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		//이제 첫 번째 숫자부터 확인하며 연속 수중 최대값을 찾습니다.
		//연속된 수를 찾다가 현재까지의 합과 그 다음값을 더한것이 0보다 크다면 연속된 수를 이어갈 의미가 있습니다.
		//그러나 연속된 수의 합이 0이하가 된다면 더이상 연속할 의미가 없어집니다.
		//이 아이디어를 구현하여 답을 찾아주었습니다.
		int now = 0;
		for (int i = 0; i < arr.length; i++) {
			
			//현재까지의 수 합+다음수가 0보다 크다면 연속을 이어갑니다!
			if(now+arr[i]>0) {
				now = now+arr[i];
				max = Math.max(now, max);
			} else {
				now = 0;
			}
		}
		
		//답 출력!
		System.out.println(max);
	}
}
