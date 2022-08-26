package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이 문제는 미세먼지의 확산, 공기청정 과정을 구현하는 것이 목표
public class Main_BJ_17144_G4_미세먼지안녕 {

	//static으로 데이터들을 선언!
	static int Y, X, T;
	static int[] gg;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map, copy;
	
	//공기청정이 완료되고 남아있는 미세먼지의 양을 출력합니다. 
	static int check() {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] != -1) sum += map[i][j];
			}
		}
		return sum;
	}

	//확산을 진행시켜주는 메소드입니다.
	//가운데 지점의 미세먼지 양은 확산된 방향의 개수를 필요로 하므로 cnt를 이용해
	//확산된 횟수를 세어주었습니다.
	static void diffusion(int y, int x) {
		int center = map[y][x];
		int num = center/5;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			//map의 크기를 벗어나지 않고, 공기청정기(-1)가 아니라면 확산값을 해당 좌표에 추가시켜줍니다.
			if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] != -1) {
				copy[ny][nx] += num;
				cnt++;
			}
		}
		
		//가운데에서 확산된 횟수만큼의 미세먼지를 빼어주었습니다.
		copy[y][x] += center-(num*cnt);
	}
	
	//확산 결과인 copy를 map에 옮겨주는 change()입니다.
	//공기청정기인 -1은 그대로 유지해줍니다.
	static void change() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j]!=-1) {
					map[i][j] = copy[i][j];
				}
			}
		}
	}
	
	//공기청정의 작동을 표현한 move() 메소드입니다.
	static void move() {
		
		//여기서 gg는 공기청정기의 위쪽 좌표입니다.
		int y = gg[0]-1;
		int x = gg[1];
		int key = 0;	//저는 key 값을 주어서 공기를 빨아들이는 뱡향이 변함을 표현해주었습니다.
		while(key<4) {
			switch(key) {
				//최초의 0은 세로방향
				//우측으로 꺽어야 한다면 1,
				//다시 아래로 돌아가야 한다면 2,
				//다시 좌측으로 돌아가야 한다면 3,
				//3을 끝내고 한바퀴 돌았다면 4로 종료시켜줍니다.
				case 0:
					if(y-1 >= 0) {
						map[y][x] = map[y-1][x];
						y--;
						if(y==0) key++;
					} 
					break;
				case 1:
					if(x+1 <= X-1) {
						map[y][x] = map[y][x+1];
						x++;
						if(x==X-1) key++;
					} 
					break;
				case 2:
					if(y+1 <= gg[0]) {
						map[y][x] = map[y+1][x];
						y++;
						if(y==gg[0]) key++;
					} 
					break;
				case 3:
					if(x-1 > 0) {
						map[y][x] = map[y][x-1];
						x--;
						if(x==1) {
							map[y][x] = 0;
							key++;
						}
					}
					break;
			}
		}
		
		//반대방향은 방향만 바꾸어 동일하게 시행하였습니다.
		y = gg[0]+2;
		x = gg[1];
		key = 0;
		while(key<4) {
			switch(key) {
				case 0:
					if(y+1 <= Y-1) {
						map[y][x] = map[y+1][x];
						y++;
						if(y==Y-1) key++;
					} 
					break;
				case 1:
					if(x+1 <= X-1) {
						map[y][x] = map[y][x+1];
						x++;
						if(x==X-1) key++;
					} 
					break;
				case 2:
					if(y-1 >= gg[0]+1) {
						map[y][x] = map[y-1][x];
						y--;
						if(y==gg[0]+1) key++;
					} 
					break;
				case 3:
					if(x-1 > 0) {
						map[y][x] = map[y][x-1];
						x--;
						if(x==1) {
							map[y][x] = 0;
							key++;
						}
					} 
					break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//각각의 데이터를 받아주었습니다.
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		gg = new int[2];	//공기청정기의 위치를 담아놓을 gg입니다.
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				
				if(n == -1 && gg[0] == 0) {
					gg[0] = i;
					gg[1] = j;
				}
			}
		}
		
		while(T>0) {
			//확산은 동시에 시행되어야 하기에 확산이 되기전 map과 동일한 크기의 copy를 두어
			//확산의 결과를 찾아준 뒤에 다시 map에 옮겨주는 방식을 사용하였습니다.
			copy = new int[Y][X];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] != 0) {
						diffusion(i, j);
					}
				}
			}
			change();
			move();
			T--;
		}
		
		System.out.println(check());
	}
}

