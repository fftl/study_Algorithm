package com.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1244_S3_스위치켜고끄기_not {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] light = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			if(st.nextToken().equals("1")) {
				light[i] = true;
			}
		}
		
		int p = Integer.parseInt(br.readLine());
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				
				for(int j=1; j<=N; j++) {
					if(j%num == 0) {
						light[j] = light[j] ? false : true;  
					}
				}
				
			} else {
				light[num] = light[num] ? false : true;
				int before = num-1;
				int after = num+1;
				
				while(0 <= before && after < N+1) {
					if(light[before] == light[after]) {
						light[before] = light[before] ? false : true;
						light[after] = light[after] ? false : true;
						before--;
						after++;
					} else {
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(light[i]) sb.append("1 ");
			else sb.append("0 ");
			if(i%20 == 0) sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

}
