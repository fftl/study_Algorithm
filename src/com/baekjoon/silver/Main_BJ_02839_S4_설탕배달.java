package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_02839_S4_설탕배달 {

	public static void main(String[] ages) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;

		while (true) {
			//n이 5로 나누어 떨어진다면 나눈 뒤 지금까지 빼준 3키로 설탕의 개수를 더해줍니다.
			if (n % 5 == 0) {
				System.out.println(n / 5 + cnt);
				break;
			} else if (n < 0) { // 3키로 설탕을 뺴주었는데 음수가 되었다면, 정확하게 N킬로그램을 만들 수 없습니다.
				System.out.println(-1);
				break;
			}

			//3키로 설탕을 뺴줍니다.
			n = n - 3;
			cnt++;
		}
		
		sc.close();
	}
}
