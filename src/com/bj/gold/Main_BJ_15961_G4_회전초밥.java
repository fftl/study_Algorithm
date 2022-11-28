package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15961_G4_회전초밥 {
	static int N, d, k, c, max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		max = 0;
		
		int[] arr = new int[N+k];
		int[] selected = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 1;
		selected[c]+=1;
		
		for (int i = N; i < N+k; i++) {
			arr[i] = arr[i-N];
			if(selected[arr[i]] == 0) {
				result++;
			}
			selected[arr[i]]++;
		}
		
		int nowSum = result;
		
		for(int i=k; i<N+k; i++) {
			int deleteNum = arr[i-k];
			selected[deleteNum]--;
			if(selected[deleteNum]==0) {
				nowSum--;
			}
			
			int addNum = arr[i];
			selected[addNum]++;
			
			if(selected[addNum]==1) {
				nowSum++;
			}
			
			result = Math.max(result, nowSum);
		}
		
		System.out.println(result);
	}
}
