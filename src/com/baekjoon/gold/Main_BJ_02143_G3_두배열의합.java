package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02143_G3_두배열의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			B[i] = Integer.parseInt(st.nextToken());
		}

		//입력 ---

		for(int i=1; i<n; i++){
			A[i] += A[i-1];
		}
		for(int i=1; i<m; i++){
			B[i] += B[i-1];
		}

		int aSize = n*(n+1)/2;
		int bSize = m*(m+1)/2;

		long[] aSum = new long[aSize];
		int idx=0;
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int av = A[j];
				if(i>0) av -= A[i-1];
				aSum[idx++] = av;
			}
		}

		long[] bSum = new long[bSize];
		idx=0;
		for(int i=0; i<m; i++){
			for(int j=i; j<m; j++){
				int bv = B[j];
				if(i>0) bv -= B[i-1];
				bSum[idx++] = bv;
			}
		}

		Arrays.sort(aSum);
		Arrays.sort(bSum);
		int left = 0;
		int right = bSize-1;
		long cnt = 0;
		while(left<aSize && right>-1){
			long asv = aSum[left], bsv = bSum[right];
			long sum = asv + bsv;
			if(sum == T){
				long ac = 0, bc = 0;
				while(left<aSize && asv == aSum[left]){
					left++;
					ac++;
				}

				while(right>-1 && bsv == bSum[right]){
					right--;
					bc++;
				}
				cnt += ac*bc;
			}

			if(sum>T) right--;
			else if(sum<T) left++;
		}
		System.out.println(cnt);
	}
}
