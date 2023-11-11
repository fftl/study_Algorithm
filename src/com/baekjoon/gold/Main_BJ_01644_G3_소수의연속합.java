package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//n까지의 모든 소수를 미리 구한다. ( 에라토스테네스의 체 )
//이제 첫번째 소수부터 N을 넘을때 까지의 연속된 소수를 더해준뒤
//시작 소수와 종료 소수를 변형시켜가며 모든 경우의 수를 찾아본다?
public class Main_BJ_01644_G3_소수의연속합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] che = new boolean[n+1];
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=2; i<n+1; i++) {
			if(che[i]) continue;
			arr.add(i);
			for(int j=i+i; j<n+1; j+=i) {
				che[j] = true;
			}
		}
		
		if(arr.size() == 0) {
			System.out.println(0);
			return;
		}
		
		int s = 0;
		int e = 0;
		int sum = arr.get(0);
		int aSize = arr.size();
		int result = 0;
		while(s+1<aSize) {
			if(s==0 && sum<n) {
				e++;
				sum += arr.get(e);
			} else {
				if(sum<n) {
					if(e+1<aSize) { 
						e++;
						sum += arr.get(e);
					}
				} else if(n<sum) {
					sum -= arr.get(s);
					s++;
				} else {
					result++;
					if(e+1<aSize) { 
						e++;
						sum += arr.get(e);
					} else {
						s++;
					}
				}
			}
		}
		
		if(arr.get(aSize-1) == n) result++;
		System.out.println(result);
	}
}
