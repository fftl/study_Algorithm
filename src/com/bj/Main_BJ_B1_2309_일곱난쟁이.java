package com.bj;

import java.util.Arrays;
import java.util.Scanner;

/*
20
7
23
19
10
15
25
8
13
 */

public class Main_BJ_B1_2309_일곱난쟁이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] users = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			users[i] = num;
			sum += num;
		}

		boolean end = false;
		for (int i = 0; i < 9; i++) {
			if (end)
				break;

			for (int j = i + 1; j < 9; j++) {
				int now = sum;
				now -= users[i];
				now -= users[j];
				if (now == 100) {

					int[] not = { users[i], users[j] };
					StringBuilder sb = new StringBuilder();
					Arrays.sort(users);

					for (int k = 0; k < 9; k++) {
						if (users[k] != not[0] && users[k] != not[1])
							sb.append(users[k] + "\n");
					}

					System.out.println(sb.toString().trim());
					end = true;
					break;
				}
			}
		}

	}

}
