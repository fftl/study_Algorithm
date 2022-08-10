package com.bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_BJ_06603_S2_로또 {

	static int[] nums;
	static int cnt;
	static boolean[] visited;
	static ArrayList<String> memo;

	public static void combi(int cnt, int s) {
		if (cnt >= 6) {
			String check = "";
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < nums.length; i++) {
				if (visited[i]) {
					sb.append(nums[i] + " ");
					check += nums[i];
				}
			}
			
			//contains는 주소값 비교가 아니라 문자열 동등비교!
			if(memo.contains(check)) {
				return;
			} else {
				memo.add(check);
				System.out.println(sb.toString().trim());
			}
			
			return;
		} else {
			//이렇게 할 경우
			for (int i = s; i < nums.length; i++) {
				if (visited[i])
					continue;
				visited[i] = true;
				combi(cnt + 1, s + 1);
				visited[i] = false;

			}
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		while (cnt != 0) {
			nums = new int[cnt];
			visited = new boolean[cnt];
			memo = new ArrayList<>();

			for (int i = 0; i < cnt; i++) {
				nums[i] = sc.nextInt();
			}

			combi(0, 0);

			cnt = sc.nextInt();
			System.out.println();
		}

		sc.close();
	}// main
}// class
