package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02263_G2_트리의순회 {
	static int N, idx;
	static int[] inOrder, postOrder, preOrder;
	
	static void getPreOrder(int is, int ie, int ps, int pe) {
		if(is<=ie && ps<=pe) {
			preOrder[idx++] = postOrder[pe];
			
			int pos = is;
			for (int i = is; i <= ie; i++) {
				if(inOrder[i] == postOrder[pe]) {
					pos = i;
					break;
				}
			}
			
			getPreOrder(is, pos-1, ps, ps+pos-is-1);
			getPreOrder(pos+1, ie, ps+pos-is, pe-1);
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		idx = 0;
		
		inOrder = new int[N];
		postOrder = new int[N];
		preOrder = new int[N];
		
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(i==0) inOrder[j] = Integer.parseInt(st.nextToken());
				else postOrder[j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getPreOrder(0, N-1, 0, N-1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < preOrder.length; i++) sb.append(preOrder[i]+" "); 
		
		System.out.println(sb.toString().trim());
	}
}
