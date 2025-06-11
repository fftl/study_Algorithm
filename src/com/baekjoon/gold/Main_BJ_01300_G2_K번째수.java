package com.baekjoon.gold;

import java.util.*;

public class Main_BJ_01300_G2_K번째수 {
	static long n, k;

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		k = sc.nextLong();
		long answer = 0;
		long left = 1;
		long right = n*n;
		boolean key = false;
		while(left<right){
			long mid = (left+right) / 2;
			long cnt = count(mid);

			if(k<=cnt){
				right = mid;
			} else {
				left = mid +1;
			}
		}

		if(!key) answer = left;

		System.out.println(answer);
		sc.close();
	}

	static long count(long num){
		long cnt = 0;
		for(long i=1; i<=num; i++){
			if(num/i==0 || n<i) break;
			if(i*n<=num){
				cnt += n;
			} else {
				cnt += num / i;
			}
		}
		return cnt;
	}

	static void print(int[][] board){
		StringBuilder sb = new StringBuilder();
		for(int j=1; j<board.length; j++){
			for(int k=1; k<board.length; k++){
				sb.append(board[j][k]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
