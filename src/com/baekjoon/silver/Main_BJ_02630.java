package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//재귀 문제
public class Main_BJ_02630_S2_색종이만들기 {
	
	static int white, blue, n;
	
	//배열을 네등분하고, 각 부분의 상태를 확인합니다.
	static void slice(int[][] board, int dep) {
		//dep이 1이라면 더이상 분할할 수 없는 하나의 종이입니다.
		//색상에 맞는 종이를 증가시켜주고 끝냅니다.
		if(dep == 1) {
			if(board[0][0] == 1) blue++;
			else white++;
			return;
		}
		
		//dep의 절반을 구합니다. 
		int half = dep/2;
		
		//네 등분의 시작점을 i, j로 구해줍니다.
		for (int i = 0; i < dep; i+=half) {
			for (int j = 0; j < dep; j+=half) {
				
				//이번 작은 영역을 확인하며 흰색, 파란색을 개수를 세어줍니다.
				//분할 된 작은 배열을 만들기 위해서 y, x를 이용해 인덱스를 만들었습니다.
				int y = 0;
				int x = 0;
				int blueCnt = 0;
				int whiteCnt = 0;
				int[][] subBoard = new int[half][half];
				for (int i2 = i; i2 < i+half; i2++) {
					for (int j2 = j; j2 < j+half; j2++) {
						if(board[i2][j2] == 0) whiteCnt++;
						else blueCnt++;
						
						subBoard[y][x] = board[i2][j2];
						x++;
					}
					x=0;
					y++;
				}
				
				//작은 배열의 내부에서 하나라도 개수가 0이라면 종이가 됩니다.
				//아니라면 subBoard를 이용해 다시 slice를 진행합니다.
				if(blueCnt == 0) {
					white++;
				} else if(whiteCnt == 0) {
					blue++;
				} else {
					slice(subBoard, half);
				}
				
				
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		//데이터를 입력받습니다. 
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//결과를 담을 white와 blue 전역변수입니다.
		white = 0;
		blue = 0;
		
		//첫 시작할때의 종이 상태를 확인합니다. 이미 하나의 종이라면 분할 탐색을 진행할 필요가 없습니다.
		int blueCnt = 0;
		int whiteCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 0) whiteCnt++;
				else blueCnt++;
			}
		}
		
		//blueCnt나 whiteCnt 둘중 하나라도 0이라면 종이가 완성되었다는 것!
		if(blueCnt == 0) {
			white++;
		} else if(whiteCnt == 0) {
			blue++;
		}
		
		//하나의 종이가 완성되었다면 바로 출력하고 종료시킵니다.
		if(white!=0 || blue!=0) {
			System.out.println(white);
			System.out.println(blue);
			return;
		}
		
		//위의 과정에서 종료되지 않았다면 분할을 시작합니다.
		slice(board, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
}
