package com.swexpertacademy;

import java.io.IOException;
import java.util.Scanner;

public class Solution_SW_D2_01954_달팽이숫자 {

	// 순서대로 우측 증가, 아래 증가, 좌측 증가, 위 증가
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	
	// 완성된 board를 형식에 맞추어 출력해주는 print 함수입니다.
	static void print(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			//nxn 크기의 board를 만들고
			//달팽이 모양으로 방향을 전환하기 편하도록 방문을 표시해줄 visited도 함께 만듭니다.
			int[][] board = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			
			int num = 1;
			int dr = 0;	//방향 전환을 표현해주기 위한 dr 입니다. 위의 dy, dx를 이용하기 위함입니다.
			int y = 0; int x = 0;
			
			while(num<=n*n) {
				
				//방문하지 않은 위치라면 숫자를 추가하고 방문표시를 해줍니다.
				if(!visited[y][x]) {
					board[y][x] = num;
					visited[y][x] = true;
				}
				
				//다음에 갈만한 위치를 먼저 담아주고
				int ny = y+dy[dr%4];
				int nx = x+dx[dr%4];
				
				//board 범위 내에 존재하는지, 그리고 이미 방문하지 않았는지 확인합니다.
				if(0 <= ny && ny <n && 0 <= nx && nx<n && !visited[ny][nx]) {
					//방문하지 않았다면 해당 방향으로 더 진행합니다.
					num++;
					y += dy[dr%4];
					x += dx[dr%4];
				} else {
					//이미 방문했던 곳이라면 방향을 틀어줘야 합니다. dr을 증가시키고, 방향을 꺾어 전진해줍니다.
					dr++;
					num++;
					y += dy[dr%4];
					x += dx[dr%4];
				}
			} //while
			
			System.out.println("#"+tc);
			print(board); //위의 print를 통해서 출력해줍니다.
		}
		
		sc.close();
	}

}
