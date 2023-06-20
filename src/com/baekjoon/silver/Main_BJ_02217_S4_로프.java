package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//뭔가 분류는 그리디인데.. 이게 그리디인가?
//뭔가 조금 수학적인 문제였던 것 같습니다.
public class Main_BJ_02217_S4_로프 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//일단 입력을 받습니다.
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		//그리고 배열을 오름차순으로 정렬해줍니다.
		Arrays.sort(arr);
		
		//문제의 풀이 방법입니다. 결국 여러개의 로프로 무게를 들 때 들 수 있는 가장 큰 무게는
		//로프중 가장 작은 로프의 무게 * 로프 수 입니다.
		//그렇기 때문에 오름차순 해놓은 로프들에서 가장 작은 무게의 로프를 가지고 들 수 있는
		//무게를 갱신하면서 확인하는 방법을 사용했습니다.
		int max = 0;
		for (int i = 0; i < n; i++) {
			int now = arr[i];	//현재 로프 무게
			int nowCnt = n-i;	//현재 로프 수
			
			int nowMax = now*nowCnt;	//현재 조합으로 들 수 있는 가장 큰 무게
			max = Math.max(nowMax, max);	//매번 갱신해주기
		}
		
		System.out.println(max);
	}
}

