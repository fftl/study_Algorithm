package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차원배열?
public class Main_BJ_07569_G5_토마토 {
	static int Y, X, H, now, max;
	
	//앞뒤좌우 네 방향으로 이동하는 동작을 편하게 사용하기 위한 dy, dx
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력값의 순서를 주의 해야한다, 일반적으로 Y, X, H 같은 순서나
		//H, Y, X 같은 순으로 입력될 텐데 요상하게도  X, Y, H 순서로 입력을 받아 헷갈리도록 되어 있습니다.
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		//-1 즉 비어있는 칸이 없을 때 익어야 하는 모든 토마토의 개수 입니다.
		max = X*Y*H;
		
		//실제 토마토의 상태를 다루기 위해서 3차원 배열을 만들어 주었습니다.	
		int[][][] board = new int[H][Y][X];
		
		//익은 토마토개수, 비어있는 공간의 개수를 세어줍니다. 
		int pl = 0;
		int ma = 0;
		
		//익은 토마토의 정보를 담아 bfs를 사용하기 위해서 Queue를 만들어 데이터를 담아줍니다.
		Queue<Tomato> q = new LinkedList<>();
		
		//실제 토마토 데이터를 3차원 배열에 담아주며
		//1, -1의 개수를 세어줍니다. 1일 경우(익은 토마토)에는 q에다가 정보를 담아줍니다.
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < Y; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < X; k++) {
					
					//3차원 배열에 정보를 넣어주고 
					int n = Integer.parseInt(st.nextToken());
					board[i][j][k] = n;
					
					//익은 토마토의 경우 q에 추가해줍니다. 그리고 값이 1, -1인경우
					//각각 pl, ma를 증가시켜줍니다.
					if(n == 1) {
						pl++;
						q.add(new Tomato(i,j,k));
					}
					if(n == -1) ma++;
				}
			}
		}
		
		//max-ma의 값이 익은 토마토의 최대 개수입니다.
		//now+pl의 값은 현재 시작시의 익은토마토의 개수입니다. max의 값까지 도달해야만 합니다.
		max -= ma;
		now += pl;
		
		//익은토마토가 하나도 없다면 절대 모든 토마토를 익게 만들 수 없기 때문에
		//바로 종료시킵니다.
		if(now == 0) {
			System.out.println(-1);
			return;
		}
		
		//며칠이 흘렀는지 표시해줄 day
		int day = 0;
		
		//q의 데이터를 기반으로 bfs를 진행시켜줍니다.
		while(!q.isEmpty()) {
			if(now == max) break; //지난번 탐색을 통해서 now가 max와 같아졌다면 모든 토마토가 익은것 종료합니다.
			int sCnt = now;		  //토마토가 더이상 익지 못하는 상태인지 확인하기 위해 이번 탐색을 시작하기 전의 익은 토마토 개수를 저장해놓습니다.
			int size = q.size();  //이번 날짜에 탐색할 토마토의 개수를 담아줍니다. 
			
			for (int i = 0; i < size; i++) {
				
				//익은 토마토를 하나 꺼냅니다.
				Tomato t = q.poll();
				
				//앞뒤좌우 방향을 확인하며 해당 방향에 익지않은 토마토가 존재한다면
				//토마토를 익었다고 표시해주고, q에 추가시켜줍니다. now도 1 증가시켜 현재의 익은 토마토 개수를 갱신해줍니다.
				for(int u=0; u<4; u++) {
					int ny = t.y + dy[u];
					int nx = t.x + dx[u];
					
					if(0<=ny && ny<Y && 0<=nx && nx<X) {
						if(board[t.h][ny][nx] == 0) {
							board[t.h][ny][nx] = 1;
							q.add(new Tomato(t.h, ny, nx));
							now++;
						};
					}
				}
				
				//위, 아래층이 존재할 수 있다면 해당 층도 확인합니다.
				//위의 네 방향 탐색과 마찬가지로 진행합니다.
				if(t.h-1>=0) {
					if(board[t.h-1][t.y][t.x] == 0) {
						board[t.h-1][t.y][t.x] = 1;
						q.add(new Tomato(t.h-1, t.y, t.x));
						now++;
					};
				}
				if(t.h+1<H) {
					if(board[t.h+1][t.y][t.x] == 0) {
						board[t.h+1][t.y][t.x] = 1;
						q.add(new Tomato(t.h+1, t.y, t.x));
						now++;
					};
				}
			}
			
			//탐색전의 sCnt와 탐색후의 now의 값을 비교하고 만약 값이 변화가 없다면
			//더이상 토마토를 익게 만들 수 없다는 뜻 이므로 날짜를 -1으로 변경하고 종료시켜줍니다.
			if(sCnt == now) {
				day = -1;
				break;
			}
			
			//아직 토마토를 익히는 과정이 진행중이라면 day를 증가시키고 다음 반복을 진행시켜줍니다.
			day++;
		}
		
		//결과물 출력!
		System.out.println(day);
	}
	
	//토마토의 정보를 더 간단하게 담기 위해서 Tomato 클래스를 만들었습니다.
	static class Tomato{
		int h, y, x;

		public Tomato(int h, int y, int x) {
			super();
			this.h = h;
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Tomato [h=" + h + ", y=" + y + ", x=" + x + "]";
		}
		
	}
}

