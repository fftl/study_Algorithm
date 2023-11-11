package com.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_02309_B1_일곱난쟁이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] users = new int[9]; //난쟁이는 무조건 9명!
		int sum = 0;

		//입력을 받으면서 미리 전체 합계를 구해줍니다.
		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			users[i] = num;
			sum += num;
		}

		//이중포문을 통해서 난장이 두명의 조합을 찾아 전체 합계에서 빼주었을 때
		//100이 나오는 두명을 찾아냅니다.
		end: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				int now = sum;
				now -= users[i];
				now -= users[j]; 
				if (now == 100) { //두명의 값을 빼주었을 때 그 두명이 난쟁이가 아님!

					//정렬을 해서 출력을 해줘야 하기 때문에 해당 값들을 미리 not 배열에 담아줍니다.(인덱스가 흐트러짐)
					int[] not = { users[i], users[j] };	
					StringBuilder sb = new StringBuilder();
					Arrays.sort(users); 

					//위의 두명의 값을 제외한 나머지 값들을 담아주어 해결!
					for (int k = 0; k < 9; k++) {
						if (users[k] != not[0] && users[k] != not[1])
							sb.append(users[k] + "\n");
					}

					System.out.println(sb.toString().trim());
					break end;
				}
			}
		}
		
		sc.close();

	}

}
