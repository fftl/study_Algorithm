package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SW_수열편집 {

	static ArrayList<Integer> arr;
	static int n, m, l;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++)
		{
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //최초 수열 크기
			m = Integer.parseInt(st.nextToken()); //명령어 개수
			l = Integer.parseInt(st.nextToken()); //출력할 수 인덱스

			arr = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				if(cmd=='I'){
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					arr.add(idx, num);
				} else if(cmd=='D'){
					int idx = Integer.parseInt(st.nextToken());
					arr.remove(idx);
				} else {
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					arr.set(idx, num);
				}
			}

			if(arr.size()-1 < l){
				sb.append(-1+"\n");
			} else {
				sb.append(arr.get(l)+"\n");
			}
		}

		System.out.println(sb.toString().trim());
	}
}
