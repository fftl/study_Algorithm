package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


//빼먹은거, 방향을 바꾼 물고기는 바꾼 방향을 유지한다.
//moveShak 의 첫번째 while문을 통해서 상어가 가야할 방향에 있는 물고기들을 확인했는데
//중간에 물고기가 없어도 그 다음칸 물고기를 탐색해야 하는데 탐색을 멈춰버렸다..
public class Main_BJ_19236_G2_청소년상어 {
	
	//주어지는 방향은 1 부터이니까 주어지는 방향-1 을 해야 합니다.
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	
	//현재 해당 칸의 상황을 표시해줄 state 입니다. 0 - 비어있음, 1 - 물고기, 2 - 상어
	static int[][] state, board;
	static int[] shark;
	static HashMap<Integer, int[]> fish; //각 물고기의 위치를 표현해줄 fish입니다.
	static int res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		res = 0;
		
		state = new int[4][4];
		board = new int[4][4];
		for (int i = 0; i < 4; i++) Arrays.fill(state[i], 1);
		fish = new HashMap<>();
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				fish.put(idx, new int[] {i,j,dir});
				board[i][j] = idx;
			}
		}
		
		init();

//		System.out.println("움직이기 전!! move Line =================================================================");
//		System.out.println(Arrays.deepToString(board));
//		System.out.println(Arrays.deepToString(state));
//		for (int i : fish.keySet()) {
//			System.out.println(i+"물고기 >> "+Arrays.toString(fish.get(i)));
//		}
//		
		//최초의 이동은 무조건 분기가 없으므로 하나로 끝냅니다.
		move(res, state, board, shark, fish);
		
		System.out.println(res);
	}
	
	//상어의 등장을 표현해줍니다.
	//0,0 위치에 있는 물고기를 먹고, res에 추가해준 뒤
	//물고기 정보를 없애줍니다.
	static void init() {
		int num = board[0][0];
		int[] start = fish.get(num);
//		System.out.println(Arrays.toString(start));
		
		res += num;
		board[0][0] = -1;
		state[0][0] = 2;
		fish.remove(num);
		
		shark = new int[] {0, 0, start[2]};
	}
	
	//물고기들의 이동을 표시해줍니다.
	static void move(int nowVal, int[][] state, int[][] board, int[] shark, HashMap<Integer, int[]> fish) {
		
		//1번 물고기부터 이동하는 것을 표현해줍니다.
		for(int i=1; i<=16; i++) {
			if(!fish.containsKey(i) ) continue;
			int[] now = fish.get(i);
			//반시계방향으로 45도 회전하는 것을 표현해주었습니다.
			for (int j = 0; j < 8; j++) {
				int ny = now[0] + dy[(now[2]+j)%8];
				int nx = now[1] + dx[(now[2]+j)%8];
				if(0<=ny && ny<4 && 0<=nx && nx<4 && state[ny][nx]<2) {
					int next = state[ny][nx];
					int nextNum = board[ny][nx];
					int[] nextFish = fish.get(nextNum);
					state[ny][nx] = 1;
					state[now[0]][now[1]] = next;
					
					board[ny][nx] = i;
					board[now[0]][now[1]] = nextNum;
					
					//fish 정보 바꿔주기!
					fish.put(i, new int[] {ny, nx, (now[2]+j)%8});
					if(next == 1) fish.put(nextNum, new int[] {now[0], now[1], nextFish[2]});
					break;
				}
			}
		}
		
//		System.out.println("move Line =================================================================");
//		System.out.println(Arrays.deepToString(board));
//		System.out.println(Arrays.deepToString(state));
//		for (int i : fish.keySet()) {
//			System.out.println(i+" >> "+Arrays.toString(fish.get(i)));
//		}
		
		moveShak(nowVal, state, board, shark, fish);
	}
	
	//상어의 이동을 표현해줍니다.
	static void moveShak(int nowVal, int[][] state, int[][] board, int[] shark, HashMap<Integer, int[]> fish) {
//		System.out.println("moveShak nowVal 파악해보기 >> " + nowVal);
		//만약 상어가 갈 수 있는 위치가 두개 이상이라면?
		//현재의 물고기, 상어, 등등 모든 정보를 저장해놓고
		//여기서 재귀를 이용해서 표현??
		ArrayList<int[]> arr = new ArrayList<>();
		int ny = shark[0] + dy[shark[2]];
		int nx = shark[1] + dx[shark[2]];
		
		//이 while 문에서
//		while(0<=ny && ny<4 && 0<=nx && nx<4 &&state[ny][nx] == 1) {
		//위와같이 조건을 달았다보니 중간에 빈 공간이 있다면 그 다음칸에 물고기가 있더라도 탐색을 멈춰버렸다..
		while(0<=ny && ny<4 && 0<=nx && nx<4) {
			if(state[ny][nx] == 1) {
				arr.add(new int[] {ny, nx});
			}
			ny = ny + dy[shark[2]];
			nx = nx + dx[shark[2]];
		}
		
//		System.out.println(arr.size());
		
		if(arr.size() == 0) {
//			System.out.println("============================================================");
			res = Math.max(res, nowVal);
		} else {
			for (int i = 0; i < arr.size(); i++) {
				
				int[] next = arr.get(i);
				int[][] nState = copyArr2(state);
				int[][] nBoard = copyArr2(board);
				int[] nShark = copyArr1(shark);
				HashMap<Integer, int[]> nFish = copyMap(fish);
				
				nState[shark[0]][shark[1]] = 0; //상어가 있던 칸은 빈칸이되고!
				nState[next[0]][next[1]] = 2; //상어가 이동할 칸은 상어라고 표시해줍니다.
				
				int nextFish = nBoard[next[0]][next[1]];
				int[] fishInfo = nFish.get(nextFish);
				nShark[0] = next[0];
				nShark[1] = next[1];
				nShark[2] = fishInfo[2];

				nBoard[next[0]][next[1]] = -1; //상어가 이동한 칸은 이제 물고기가 없습니다.
				
				int nextVal = nowVal + nextFish;
				nFish.remove(nextFish);
				
//				System.out.println(nextFish+"번 물고기를 먹었습니다!!");
//				System.out.println("복사 이동 전 -----------------------------");
//				System.out.println("board >> " + Arrays.deepToString(nBoard));
//				System.out.println("state >> " + Arrays.deepToString(nState));
//				System.out.println("shark >> " + Arrays.toString(nShark));
//				for (int s : nFish.keySet()) {
//					System.out.println(s+" >> "+Arrays.toString(nFish.get(s)));
//				}
//				
				move(nextVal, nState, nBoard, nShark, nFish);
			}
		}
	}
	
	static HashMap<Integer, int[]> copyMap(HashMap<Integer, int[]> map){
		HashMap<Integer, int[]> copy = new HashMap<>();
		for (int key : map.keySet()) {
			int[] nVal = map.get(key);
			copy.put(key, new int[] {nVal[0], nVal[1], nVal[2]});
		}
		
		return copy;
	}
	
	static int[] copyArr1(int[] arr){
		int[] copy = new int[3];
		for (int i = 0; i < 3; i++) {
				copy[i] = arr[i];
		}
		return copy;
	}
	
	static int[][] copyArr2(int[][] arr){
		int[][] copy = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
}
