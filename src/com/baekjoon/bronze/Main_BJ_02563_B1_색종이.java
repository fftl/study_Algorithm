package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02563_B1_색종이 {

	public static void main(String[] args) throws Exception{

		//데이터 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		//색종이 맵!
		boolean[][] memory = new boolean[101][101];
		
		for (int i = 0; i < n; i++) {
			//색종이의 크기는 항상 10x10이기 때문에 이렇게 할 수 있습니다.
			int x = sc.nextInt();
			int y = sc.nextInt();
			int ex = x+10;
			int ey = y+10;
			
			//색종이의 크기만큼 true처리
			for (int a = y; a < ey ; a++) {
				for (int b = x; b < ex; b++) {
					memory[a][b] = true;
				}
			}
		}
		
		//true처리 된 곳을 카운트하여 검은색 영역을 구해줍니다.
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory.length; j++) {
				if(memory[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
		
	}

}
