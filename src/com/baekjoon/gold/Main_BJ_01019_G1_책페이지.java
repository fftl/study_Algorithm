package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01019_G1_책페이지 {

	static long[] res;

	//파라미터로 받은 x를 10으로 나누며 자리수를 나눠 ans배열에 더한다.
	public static void cal(int x, int[] ans, int point) {
		System.out.println("--- cal 새로 시작 ---");
		System.out.println("시작 x : " + x);
		while (x > 0) {
			ans[x % 10] += point;
			x /= 10;

			System.out.println("매번 x : " + x);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[10];
		int point = 1; //자릿수
		int start = 1;

		while (start <= n) {

			System.out.println("--- 새로운 턴 ---");
			// n의 끝자리 9로 만들기
			while (n % 10 != 9 && start <= n) {
				cal(n, ans, point); //감소시킨 n도 ans배열에 등장횟수를 증가시킨다.
				n--; //n을 감소시키면서
			}

			if (n < start) {
				break;
			}

			// start의 끝자리 0으로 만들기
			while (start % 10 != 0 && start <= n) {
				cal(start, ans, point);
				start++; //start를 증가시키면서 10으로 만든다.
			}

			start /= 10;
			n /= 10;

			for (int i = 0; i < 10; i++) { //반복되는 등장횟수를 더해준다.
				ans[i] += (n - start + 1) * point;
			}
			point *= 10; //다음 자리수로 넘어가기 위해 * 10을 해준다.

			System.out.println("이번 턴의 start : "+start);
			System.out.println("이번 턴의 n : "+n);
		}

		for (int i = 0; i < 10; i++) { //출력
			System.out.print(ans[i] + " ");
		}
	}
}
