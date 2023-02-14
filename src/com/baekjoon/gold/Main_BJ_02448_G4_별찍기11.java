package com.baekjoon.gold;

import java.util.Scanner;

public class Main_BJ_02448_G4_별찍기11 {
	private static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//n을 이용해서 틀의 크기를 찾습니다.
		map = new char[n][2 * n - 1];

		//공백으로 꽉 채워진 map을 만듭니다.
		for (int i = 0; i<n; i++)
			for (int j = 0; j < 2*n-1; j++)
				map[i][j] = ' ';

		//실제로 별을 채워넣는 함수입니다.
		drawStar(0, n-1, n);

		//완성된 map을 출력해줍니다!
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			for (int j = 0; j < 2*n-1; j++)
				sb.append(map[i][j]);
			if(i<n-1) sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	//실제로 별을 그리는 함수! 재귀를 사용!
	//별 탑의 꼭대기부터 시작합니다.
	//꼭대기부터 높이가 n-3이 될 때까지 n/2를 하면서 내려갑니다.
	//높이가 n/3이 된다면 가장 작은 탑을 그려주고 다음 탑을 그리기 위해 이동합니다.
	private static void drawStar(int x, int y, int n) {

		if (n == 3) {
			map[x][y] = '*';
			map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
			map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
			return;
		}

		drawStar(x, y, n / 2); //n/2만큼만 내려가기 위해!

		//높이가 충분하다면 좌, 우 탑으로 나뉘어 주어야 합니다!
		drawStar(x + n / 2, y - n / 2, n / 2);
		drawStar(x + n / 2, y + n / 2, n / 2);
	}
}

