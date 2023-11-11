package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16434_G4_드래곤앤던전 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long atk = Integer.parseInt(st.nextToken());
		long hp = 0;
		long maxHp = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int matk = Integer.parseInt(st.nextToken());
			int mhp = Integer.parseInt(st.nextToken());
			
			//몬스터일경우
			if(k == 1) {
				long cnt = 0;
				if(mhp%atk > 0) {
					cnt+=mhp/atk;
					cnt++;
				} else {
					cnt+=mhp/atk;
				}
				
				hp += (cnt-1) * matk;
				
			//포션일경우
			} else {
				atk += matk;//공격력 증가
				if(mhp >= hp) {//회복량이 더 많다면 0까지 회복
					maxHp = Math.max(hp, maxHp);
					hp = 0;
				} else {//아니면 빼줍니다.
					maxHp = Math.max(hp, maxHp);
					hp -= mhp;
				}
			}//if
		}//for i 
		
		maxHp = Math.max(hp, maxHp);
		System.out.println(maxHp+1);
		
	}
}
