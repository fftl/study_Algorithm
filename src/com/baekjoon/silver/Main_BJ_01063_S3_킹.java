package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_01063_S3_킹 {
	static HashMap<String, int[]> cmd;
	static HashMap<Character, Integer> alpha;
	static HashMap<Integer, Character> reverseAlpha;

	public static void main(String[] args) throws Exception{
		init();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String stone = st.nextToken();

		int n = Integer.parseInt(st.nextToken());

		int[] k = new int[]{king.charAt(1)-'0', alpha.get(king.charAt(0))};
		int[] s = new int[]{stone.charAt(1)-'0', alpha.get(stone.charAt(0))};

		for (int i = 0; i < n; i++) {
			String nowCmd = br.readLine();
			int[] move = cmd.get(nowCmd);

			//일단 킹이 이동할 수 있을 때,
			if(1<=k[0]+move[0] && k[0]+move[0]<=8 && 1<=k[1]+move[1] && k[1]+move[1]<=8){

				//돌은 움직일 필요가 없음
				if(k[0]+move[0] != s[0] || k[1]+move[1] != s[1]){
					k[0] += move[0];
					k[1] += move[1];
				} else {
					//돌이 움직여야 하는데 움직일 수 있다면.
					if(1<=s[0]+move[0] && s[0]+move[0]<=8 && 1<=s[1]+move[1] && s[1]+move[1]<=8){
						k[0] += move[0];
						k[1] += move[1];
						s[0] += move[0];
						s[1] += move[1];
					}
				}
			}
		}
		System.out.println(""+reverseAlpha.get(k[1])+k[0]);
		System.out.println(""+reverseAlpha.get(s[1])+s[0]);
	}

	static void init(){
		cmd = new HashMap<>();
		cmd.put("R", new int[]{0, 1});
		cmd.put("L", new int[]{0, -1});
		cmd.put("B", new int[]{-1, 0});
		cmd.put("T", new int[]{1, 0});
		cmd.put("RT", new int[]{1, 1});
		cmd.put("LT", new int[]{1, -1});
		cmd.put("RB", new int[]{-1, 1});
		cmd.put("LB", new int[]{-1, -1});

		alpha = new HashMap<>();
		alpha.put('A', 1);
		alpha.put('B', 2);
		alpha.put('C', 3);
		alpha.put('D', 4);
		alpha.put('E', 5);
		alpha.put('F', 6);
		alpha.put('G', 7);
		alpha.put('H', 8);

		reverseAlpha = new HashMap<>();
		reverseAlpha.put(1, 'A');
		reverseAlpha.put(2, 'B');
		reverseAlpha.put(3, 'C');
		reverseAlpha.put(4, 'D');
		reverseAlpha.put(5, 'E');
		reverseAlpha.put(6, 'F');
		reverseAlpha.put(7, 'G');
		reverseAlpha.put(8, 'H');
	}
}
