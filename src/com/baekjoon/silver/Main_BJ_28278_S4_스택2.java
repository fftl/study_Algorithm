package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_28278_S4_스택2 {
	static class Stack{
		int[] num;
		int k;

		public void init(){
			num = new int[1000001];
		}

		public void add(int v){
			num[k] = v;
			k++;
		}

		public int pop(){
			int res = -1;
			if(k>=1){
				res = num[k-1];
				k--;
			}
			return res;
		}

		public int size(){
			return k;
		}

		public int isEmpty(){
			if(size()>0) return 0;
			return 1;
		}

		public int peek(){
			int res = -1;
			if(k>=1){
				res = num[k-1];
			}
			return res;
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack st = new Stack();
		st.init();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			if(str.length == 2){
				st.add(Integer.parseInt(str[1]));
			} else {
				int cmd = Integer.parseInt(str[0]);
				switch (cmd){
					case 2:
						sb.append(st.pop()+"\n");
						break;
					case 3:
						sb.append(st.size()+"\n");
						break;
					case 4:
						sb.append(st.isEmpty()+"\n");
						break;
					case 5:
						sb.append(st.peek()+"\n");
						break;
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}
