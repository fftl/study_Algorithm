package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D4_01233_사칙연산유효성검사 {

	// 자식노드를 가지고 있다면 무조건 연산자여야 한다.
	// 리프노드는 무조건 숫자여야 한다!
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1233.txt")); // input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			int n = Integer.parseInt(br.readLine());
			boolean check = true;
			String yunsan = "-+*/";
			for(int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if(str.length <3) {
					if(!yunsan.contains(str[1])) {
						continue;
						} else {
							check = false;
						}
				} else {
					if(yunsan.contains(str[1])) {
						continue;
					} else {
						check = false;
					}
				}
			}
			
			if(check) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.println(sb.toString().trim());
	}
}