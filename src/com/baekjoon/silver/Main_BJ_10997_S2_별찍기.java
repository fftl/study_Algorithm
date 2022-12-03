package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_10997_S2_별찍기 {

	static char[][] stars;
	static int y, x;

	//가장 안쪽의 마지막 별들은 반복과는 상관이 없는 별이라
	//직접 위치를 정해 줄 수 있었기 때문에 이렇게 직접 넣어줬습니다.
	static void center() {
		stars[y / 2][x / 2] = '*';
		stars[y / 2 - 1][x / 2] = '*';
		stars[y / 2 + 1][x / 2] = '*';

		stars[y / 2 - 1][x / 2 + 1] = '*';
	}

	//처음에는 char의 기본형을 생각하지 못하고 그대로 만들었다가
	//이후에는 두번째줄에는 * 하나만 존재하는데 공백으로 모두 채워서 실패 했었습니다.
	static void print(char[][] stars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stars.length; i++) {
			if (i == 1) {
				sb.append("*\n");
				continue;
			}
			for (int j = 0; j < stars[0].length; j++) {
				if (stars[i][j] != '*')
					sb.append(" ");
				else
					sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n == 1) {
			System.out.println("*");
			return;
		}

		//가로 세로 크기는 최초 7, 5에서 각각 4씩 증가하는 규칙을 찾아서
		//구해주었습니다.
		y = 7 + 4 * (n - 2);
		x = 5 + 4 * (n - 2);
		stars = new char[y][x];

		
		int t = 0;
		int depth;
		//t는 반복횟수로 왜인지 모르게 규칙이 주어진 수의 -1 만큼 반복하게 되어 이렇게 지정해 주었습니다.
		while (t < n - 1) {
			//반복이 계속됨에 따라서 안쪽으로 들어가는 수의 depth가 2씩 증가합니다.
			depth = t * 2; 
			
			// 상단부분 별 그리기
			for (int i = depth; i < x-depth; i++) {
				stars[depth][i] = '*';
			}

			// 하단부분 별 그리기
			for (int i = depth; i < x - depth; i++) {
				stars[y - 1 - depth][i] = '*';
			}

			// 우측부분 별 그리기
			stars[2+depth][x-1-depth-1] = '*';
			for (int i = 2 + depth; i < y - depth; i++) {
				stars[i][x - 1 - depth] = '*';
			}

			// 좌측부분 별 그리기
			for (int i = depth; i < y - depth; i++) {
				stars[i][depth] = '*';
			}

			t++;
		}

		center();
		print(stars);
		
	}// main
}// class
