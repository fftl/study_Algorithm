package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//한번이라도 진실을 아는 사람과 파티의 간 사람들도
//진실을 아는 사람이라고 판단하고
//그렇지 않은 사람들이 모인 파티의 개수만 세면 됩니다.
public class Main_BJ_01043_G4_거짓말 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //사람의 수 <= 50
		int M = Integer.parseInt(st.nextToken()); //파티의 수 <= 50
		
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken()); //진실을 아는사람 수 <= 50
		
		boolean[] check = new boolean[51];
		if(cnt == 0) {
			System.out.println(M);
			return;
		} else {
			for (int i = 0; i < cnt; i++) {
				int now = Integer.parseInt(st.nextToken());
				check[now] = true;
			}
		}
		
		ArrayList<ArrayList<Integer>> party = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int nowN = Integer.parseInt(st.nextToken());
			
			boolean key = false;
			ArrayList<Integer> nowArr = new ArrayList<>();
			for (int j = 0; j < nowN; j++) {
				int nowVal = Integer.parseInt(st.nextToken());
				if(check[nowVal]) key = true;
				nowArr.add(nowVal);
			}
			
			//여긴 진실이 퍼진 파티! 이 파티의 구성원들은 진실을 알고있다.
			if(key) {
				for (int j = 0; j < nowArr.size(); j++) {
					check[nowArr.get(j)] = true;
				}
			}
			
			party.add(nowArr);
		}
		
		int cntCheck = 0;
		
		while(cntCheck<M) {
			for (int i = 0; i < party.size(); i++) {
				boolean key = false;
				ArrayList<Integer> nowArr = party.get(i);
				for (int j = 0; j < nowArr.size(); j++) {
					if(check[nowArr.get(j)]) {
						key = true;
						break;
					}
				}
				
				if(key) {
					for (int j = 0; j < nowArr.size(); j++) {
						check[nowArr.get(j)] = true;
					}
				}
			}
			cntCheck++;
		}
		
		int result = 0;
		run : for (int i = 0; i < party.size(); i++) {
			ArrayList<Integer> nowArr = party.get(i);
			for (int j = 0; j < nowArr.size(); j++) {
				if(check[nowArr.get(j)]) continue run;
			}
			result++;
		}
		
		System.out.println(result);
	}
}
