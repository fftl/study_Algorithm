package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_15683_G4_감시 {

	static int Y, X, minRes, E;	//격자 크기 Y,X 결과값 minRes, 카메라 개수 E
	static int[][] board, copyBoard;	//입력으로 주어지는 board와 각 카메라의 회전마다 생겨질 copyBoard 입니다.
	static int[] dy = { -1, 0, 1, 0 };	//회전을 표현할 dy, dx
	static int[] dx = { 0, 1, 0, -1 };
	static ArrayList<Pair> camera;	//카메라들을 담아줄 ArrayList

	//카메라의 좌표 y, x와 카메라의 종류 k 그리고 카메라가 보고있는 뱡항 d를 표시해줍니다.
	public static class Pair {
		int y, x, k, d;

		public Pair(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + ", k=" + k + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		//데이터 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[Y][X];
		minRes = Y*X; //최소값을 구해야 하기 때문에 초기에는 최대 값으로 줍니다.
		camera = new ArrayList<>();

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num>0 && num<6) {
					camera.add(new Pair(i, j, num));
				}
				board[i][j] = num;
			}
		}

		//카메라 개수 확인
		E = camera.size();
		dfs(0);
	}

	static void dfs(int cnt) {
		if(cnt==E) {
			minCheck();
			return;
		}

		for (int i = cnt; i < E; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.println(i+","+j);
				camera.get(i).k=j;
				dfs(cnt+1);
			}
		}
	}

	//카메라를 배치한뒤 볼수 있는 방향을 표시하고, 사각지대의 개수를 세어줍니다.
	//만약 최소값이 나왔다면 갱신해줍니다.
	static void minCheck() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (copyBoard[i][j] == 0)
					cnt++;
			}
		}
		minRes = Math.min(cnt, minRes);
	}

	static void print() {
		for (int i = 0; i < Y; i++) {
			String str = "";
			for (int j = 0; j < X; j++) {
				str += copyBoard[i][j] + " ";
			}
			System.out.println(str);
		}

	}
}
