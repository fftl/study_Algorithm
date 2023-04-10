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
		minRes = Y * X; // 최소값을 구해야 하기 때문에 초기에는 최대 값으로 줍니다.
		camera = new ArrayList<>();

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int num = Integer.parseInt(st.nextToken());
				//해당 위치가 카메라 라면, camera에 추가해줍니다.
				if (num > 0 && num < 5) {
					camera.add(new Pair(i, j, num, 0));
				}
				board[i][j] = num;
			}
		}

		// 5번은 모든 방향이므로 dfs에 포함시키기에는 비효율적입니다.
		// 미리 5번은 board에 표시해줍니다.
		copyBoard = copyBoard();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (board[i][j] == 5) {
					look(new Pair(i, j, 5, 0));
				}
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				board[i][j] = copyBoard[i][j];
			}
		}

		//5번을 미리 표시해 놓은 board를 가지고 dfs를 시작합니다.
		E = camera.size();
		dfs(0);

		System.out.println(minRes);
	}

	//카메라가 보는 위치가 map을 벗어나는지 확인하기 위한 함수입니다.
	static boolean isRange(int y, int x) {
		return (0 <= y && y < Y && 0 <= x && x < X);
	}

	//카메라가 보는 방향을 실제로 표시해줍니다.
	static void lookRun(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];

		//while을 통해서 해당 방향이 갈 수 있는 곳인지 먼저 판단합니다.
		while (isRange(ny, nx)) {
			
			if (copyBoard[ny][nx] == 6) // 벽을 만나면 바로 종료합니다.
				break; 
			else { // 벽이 아니고
				if (copyBoard[ny][nx] == 0) { // 아직 감시되고 있지 않다면
					copyBoard[ny][nx] = -1;
				}
			}
			
			//다음 위치를 확인합니다.
			ny = ny + dy[d];
			nx = nx + dx[d];
		}
	}

	// y,x 좌표에서 k를 바라보고 있다는 표시를 해줍니다.
	static void look(Pair pair) {
		int y = pair.y;
		int x = pair.x;
		int k = pair.k;
		int d = pair.d;
		
		//switch를 통해서 각 카메라가 볼 수 있는 방향을 lookRun을 통해서 표시해줍니다.
		switch (k) {
		case 1:
			lookRun(y, x, (d + 1) % 4);
			break;
		case 2:
			lookRun(y, x, (d + 1) % 4);
			lookRun(y, x, (d + 3) % 4);
			break;
		case 3:
			lookRun(y, x, d);
			lookRun(y, x, (d + 1) % 4);
			break;
		case 4:
			lookRun(y, x, d);
			lookRun(y, x, (d + 1) % 4);
			lookRun(y, x, (d + 3) % 4);
			break;

		case 5: // 모든방향! 회전해도 변화가 없기에 최초에 그냥 일괄처리를 합니다.
			lookRun(y, x, d);
			lookRun(y, x, (d + 1) % 4);
			lookRun(y, x, (d + 2) % 4);
			lookRun(y, x, (d + 3) % 4);
			break;
		}
	}

	// 각 카메라 배치마다 새로운 맵을 그려줘야 하기 때문에 board를 복사해줍니다.
	static int[][] copyBoard() {
		int[][] copy = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

	static void dfs(int cnt) {
		// 카메라 세개를 다 뽑았다면 연산을 시작합니다.
		if (cnt == E) {
			copyBoard = copyBoard();
			for (int i = 0; i < camera.size(); i++) {
				look(camera.get(i));
			}
			minCheck();
			return;
		}

		/**
		 * 틀린 코드 for (int i = cnt; i < E; i++) { for(int j=1; j<=5; j++) {
		 * camera.get(cnt).k = j; dfs(cnt+1); } }
		 */
		
		//각 카메라가 모든 방향을 봐볼 수 있다고 생각하여 표현해주었습니다.
		for (int j = 0; j <= 3; j++) {
			camera.get(cnt).d = j;
			dfs(cnt + 1);
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
