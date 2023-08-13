package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_이진수표현 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			int lastNBit = (1 << (n)) - 1;  // 111...1 (길이 N)
			if ((lastNBit & num) == lastNBit) {
				System.out.println("ON");
			} else {
				System.out.println("OFF");
			}
		}
	}
}
