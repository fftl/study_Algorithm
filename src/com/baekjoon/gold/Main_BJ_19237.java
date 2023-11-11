package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//1. 모든 상어가 자신의 위치에 냄새를 뿌림
//2. 그 후 1초마다 모든 상어가 동시에 상하좌우로 인접한 칸 중 하나로 이동하고, 그 자신의 냄새를 그 칸에 뿌림
//  2-1 냄새는 상어가 k번 이동하고 나면 사라짐
//3. 상어의 이동 방향은 1. 인접한 칸중 냄새가 없는 칸, 2. 자신의 냄새가 있는 칸?
//4. 이동한 뒤 한 칸에 여러마리 상어가 있다면 가장 작은 번호를 가진 상어를 제외하고 모두 사라진다.
public class Main_BJ_19237_G2_어른상어 {
	
	static int N, M, k, cnt;
	static int[][] board;
	static HashMap<Integer, ArrayList<int[]>> map;
	static HashMap<Integer, int[]> shark;
	static Info[][] smell;
	static int[] dir;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	//냄새 정보를 쉽게 표현하기 위해서 만든 Info입니다.
	static class Info{
		int n, cnt;
		public Info(int n, int cnt) {
			this.cnt = cnt;
			this.n = n;
		}
		@Override
		public String toString() {
			return n+","+cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = M;
		
		board = new int[N][N]; 
		smell = new Info[N][N];		//냄새를 표현하기 위함!
		dir = new int[M+1];			//각 상어의 현재 방향을 잡아줍니다.
		shark = new HashMap<>();	//상어의 위치를 빠르게 찾기 위함
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				board[i][j] = now;
				
				if(now > 0) {
					shark.put(now, new int[] {i, j});
				}
			}
		}
		
		//최초의 상어의 방향을 정해줍니다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			dir[i+1] = Integer.parseInt(st.nextToken())-1;
		}
		
		map = new HashMap<>();
		//각 상어의 이동 우선순위 방향을 정해줍니다.
		for (int i = 1; i <= M; i++) {
			ArrayList<int[]> arr = new ArrayList<>();
			for (int j = 1; j <= 4; j++) {
				int[] nowD = new int[4];
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 4; j2++) {
					nowD[j2] = Integer.parseInt(st.nextToken())-1;
				}
				arr.add(nowD);
			}
			map.put(i, arr);
		}
		
		//정보입력 종료 -----------------------------------------------------------
		// -------------------------------------------------------------------
		
		int sec = 0;
		
		//상어가 이동하고 냄새를 풍기는 동작을 반복해줍니다.
		while(true) {
			if(shark.size()==1) break;
			if(sec>1000) break;
			gSmell();
			move();
			downSmell();
			sec++;
			
		}
		
		if(sec<=1000) System.out.println(sec);
		else System.out.println(-1);
}
	
	static void gSmell() {
		//상어의 위치에 각 상어의 냄새를 표현해줍니다.
		for (int i = 1; i <= M; i++) {
			if(!shark.containsKey(i)) continue;
			int[] nowShark = shark.get(i);
			smell[nowShark[0]][nowShark[1]] = new Info(i, k);
		}
	}
	
	//냄새를 소모시켜줍니다.
	static void downSmell() {
		//상어의 위치에 각 상어의 냄새를 표현해줍니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(smell[i][j] != null) {
					smell[i][j].cnt--;
					if(smell[i][j].cnt == 0) {
						smell[i][j] = null;
					}
				}
			}
		}
	}
	
	static void move() {
		
		//상어의 이동은 모두 동시에 발생해야 하기에 새로운 배열을 만들어
		//앞선 상어의 이동으로 다음 상어들의 이동에 영향을 주지 않도록 합니다.
		int[][] next = new int[N][N];
		
		//상어를 하나씩 꺼내며 이동한 것을 표현해줍니다.
		for (int i = 1; i <= M; i++) {
			if(!shark.containsKey(i)) continue;
			int[] nowShark = shark.get(i); //현재 상어의 위치를 가져오고ㅗ
			int d = dir[i]; //현재 방향을 가져와줍니다.
			
			//이제 현재 상어가 보고있는 방향 기준으로 이동할 방향의 우선순위를 확인합니다.
			int[] nowDir = map.get(i).get(d);
//			System.out.println(i+"번째 상어입니다." + "보고있는 방향은 "+ d +"입니다.");
//			System.out.println(Arrays.toString(nowDir));
			boolean move = false;
			for (int j = 0; j < 4; j++) {
				if(move) break;
				int ny = nowShark[0]+dy[nowDir[j]];
				int nx = nowShark[1]+dx[nowDir[j]];
				if(0<=ny && ny<N && 0<=nx && nx<N && smell[ny][nx] == null) {
					//갈 수 있는 방향을 찾았다면 일단 해당 방향으로 상어의 방향을 변경해줍니다.
					dir[i] = nowDir[j];
					move = true;
					//일단 여기 들어왔다는 것은 해당 위치로 이동할 수 있었다는 뜻!
					//다만 같은 위치에 번호가 더 낮은 상어가 있다면 퇴출된 것으로 처리해야합니다.
					
					//아직 해당 위치에 상어가 없다면 그냥 들어가면 됩니다!
					if(next[ny][nx] == 0) {
						next[ny][nx] = i;	//다음 board 표시!
						nowShark[0] = ny;	//상어 위치 변경!
						nowShark[1] = nx;
					} else { //상어가 이미 존재한다면! 어차피 상어 번호순으로 하기 때문에 존재한다면 어차피 이동 불가! 그냥 그 상어는 바로 퇴출한다.
						shark.remove(i);
					}
				}
			}
			
			//인접한 위치에 빈 공간이 없었다면! 나의 냄새가 있는 곳이라도 찾아야합니다.
			if(!move) {
				for (int j = 0; j < 4; j++) {
					if(move) break;
					int ny = nowShark[0]+dy[nowDir[j]];
					int nx = nowShark[1]+dx[nowDir[j]];
					if(0<=ny && ny<N && 0<=nx && nx<N && smell[ny][nx].n == i) {
						//갈 수 있는 방향을 찾았다면 일단 해당 방향으로 상어의 방향을 변경해줍니다.
						dir[i] = nowDir[j];
						move = true;
						//일단 여기 들어왔다는 것은 해당 위치로 이동할 수 있었다는 뜻!
						//다만 같은 위치에 번호가 더 낮은 상어가 있다면 퇴출된 것으로 처리해야합니다.
						
						//아직 해당 위치에 상어가 없다면 그냥 들어가면 됩니다!
						if(next[ny][nx] == 0) {
							next[ny][nx] = i;	//다음 board 표시!
							nowShark[0] = ny;	//상어 위치 변경!
							nowShark[1] = nx;
						} else { //상어가 이미 존재한다면! 어차피 상어 번호순으로 하기 때문에 존재한다면 어차피 이동 불가! 그냥 그 상어는 바로 퇴출한다.
							shark.remove(i);
						}
					}
				}
			}
		}
	}
}
