package com.baekjoon.silver;

public class Main_BJ_04673_S5_셀프넘버 {
	public static void main(String[] args) throws Exception{
		boolean[] check = new boolean[10001];
		for(int i=1; i<100001; i++){
			String now = Integer.toString(i);
			int cutSum = 0;
			for (int j = 0; j < now.length(); j++) {
				cutSum += now.charAt(j)-'0';
			}

			int num = cutSum + i;
			if(num<=10000)check[num] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			if(!check[i]) sb.append(i+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
