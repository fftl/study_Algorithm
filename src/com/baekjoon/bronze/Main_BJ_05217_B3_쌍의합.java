package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_05217_B3_쌍의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int now = Integer.parseInt(br.readLine());
			boolean start = false;
			sb.append("Pairs for "+now+": ");
			for (int j = 1; j <= now; j++) {
				for (int k=j+1; k<=now; k++){
					if(j+k==now){
						if(!start){
							sb.append(j+" "+k);
							start = true;
						} else {
							sb.append(", "+j+" "+k);
						}
					}

				}
			}
			sb.append("\n");
			System.out.println(sb.toString().trim());
		}
	}
}
