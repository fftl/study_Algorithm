package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_23290_G1_마법사상어와복제_2 {
	static int N, M, S, sy, sx, eCnt;
	static String root;
	static int[][] sMap;
	
	static int[] sdy = {-1, 0, 1, 0};
	static int[] sdx = {0, -1, 0, 1};
	
	static int[] fy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] fx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][][] fish = new int[4][4][8];
	static int[][][] copy = new int[4][4][8];

	//1번 복사를 위해 미리 복사를 해서 담아놓습니다.
	static void makeCopy() {
		copy = new int[4][4][8];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					copy[i][j][j2] = fish[i][j][j2];
				}
			}
		}
	}
	
	//1번에서 해놓은 복사 물고기를 원본에 추가해줍니다.
	static void goCopy() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					fish[i][j][j2] += copy[i][j][j2];
				}
			}
		}
	}
	
	//모든 물고기를 세어줍니다.
	static int cnt() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					result += fish[i][j][j2];
				}
			}
		}
		
		return result;
	}
	
	//물고기냄새를 감소시켜줍니다.
	static void downSmell() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(sMap[i][j]>0) sMap[i][j]-=1;
			}
		}
	}
	
	//상어가 물고기를 먹을 경로를 찾습니다.
	static void sharkEat(int y, int x, String r, int[][] fishMap) {
		//r이 길이가 3이되면 확인을 해줍니다.
		if(r.length() == 3) {
			String visit = "";	//상어가 가는 길중에 이미 왔던곳을 다시 왔을때 확인하기 위한 String입니다.
			int sum = 0;
			int ny = sy;	//상어의 위치를 시작으로 놓고		
			int nx = sx;
			
			//r의 경로대로 이동해줍니다.
			for (int i = 0; i < 3; i++) {
				ny += sdy[r.charAt(i)-'0'];
				nx += sdx[r.charAt(i)-'0'];
				//만약 이동하는 중에 해당 좌표에 아직 방문하지 않았다면 해당 좌표의 물고기 수를 sum에 더해주고,
				//visit에 문자열을 이어서 방문처리를 해줍니다.
				//어차피 모든 좌표가 한자리 수이기 떄문에 23,34,43, 이런식으로 되어서 이렇게 방문처리가 가능합니다.
				if(!visit.contains(ny+""+nx)){
					sum += fishMap[ny][nx];
					visit += ny+""+nx+",";
				}
			}
			//이제 해당 경로가 물고기를 가장 많이먹고, 사전순에 맞는지 확인하여줍니다.
			if(sum>eCnt) {
				eCnt = sum;
				root = r;
			}
			return;
		}
		
		//갈수 있는 방향으로만 dfs를 이용해서 경로를 구해줍니다.
		for (int i = 0; i < 4; i++) {
			int ny = y+sdy[i];
			int nx = x+sdx[i];
			if(0<=ny && ny<4 && 0<=nx && nx<4) {
				sharkEat(ny, nx, r+i, fishMap);
			}
		}
		
	}
	
	static void fishMove() {
		int[][][] fcopy = new int[4][4][8];
		
		//물고기가 존재할 수 있는 모든 위치를 돌며 해당 물고기들을 이동시켜줍니다.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					
					//물고기가 한마리라도 존재한다면
					if(fish[i][j][j2] > 0) {
						boolean in = true;	//아무데도 갈 수 없는 경우를 체크하기 위함입니다.
						//반시계방향으로 8방향을 돌다가, 갈 수 있는 방향이면 해당 방향에 물고기를 더해주고, 바로 멈춰줍니다.
						for (int k = 0; k < 8; k++) {
							int ny = i + fy[(j2-k+8)%8];
							int nx = j + fx[(j2-k+8)%8];
							
							if(0<=ny && ny<4 && 0<=nx && nx<4 && sMap[ny][nx] == 0) {
								if(ny==sy && nx==sx) continue;
								//여기까지 도달하면 갈 수 있는 방향이다!
								in = false;
								fcopy[ny][nx][(j2-k+8)%8] += fish[i][j][j2];
								break;
							}
						}
						//만약 8방향중에 갈곳이 없었다면 현재위치에 물고기를 그냥 더해줍니다.
						if(in) fcopy[i][j][j2] += fish[i][j][j2];
					}
				}
			}
		}
		
		//4*4*8 배열이지만 한 좌표의 모든 물고기수를 알아야 하기 때문에 직접 더해서
		//fishMap 배열을 만들어 줍니다.
		int[][] fishMap = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < 8; j2++) {
					sum += fcopy[i][j][j2];
				}
				fishMap[i][j] += sum;
			}
		}
		
		root = "";
		eCnt = -1;
		
		//상어의 경로를 구해줍니다.
		sharkEat(sy, sx, "", fishMap);
		
		//구한 상어의 경로(root)를 그대로 따라가며 해당 위치에 물고기가 하나라도 있다면 del에 담아줍니다.
		int ny = sy;
		int nx = sx;
		
		ArrayList<int[]> del = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ny += sdy[root.charAt(i)-'0'];
			nx += sdx[root.charAt(i)-'0'];
			if(fishMap[ny][nx] > 0) {
				del.add(new int[] {ny, nx});
			}
		}
		
		sy = ny;
		sx = nx;
		
		//del에서 좌표를 하나씩 꺼내며 해당 좌표에 냄새를 남겨주고, 해당 위치의 물고기를 모두 비워줍니다.
		for (int i = 0; i < del.size(); i++) {
			int[] now = del.get(i);
			sMap[now[0]][now[1]] = 3;
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 4; j2++) {
					for (int l = 0; l < 8; l++) {
						if(now[0] == j && now[1] == j2) {
							fcopy[j][j2][l] = 0;
						}
					}
				}
			}
		}
		
		//테두리 온도를 낮춰줍니다.
		downSmell();
		
		//상어가 먹고난 행동까지 완료한 fcopy를 fish에 덮어씌워줍니다.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					fish[i][j][j2] = fcopy[i][j][j2];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = 4;
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		sMap = new int[4][4];
		
		fish = new int[4][4][8];
		//물고기 정보 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ny = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fish[ny-1][nx-1][d-1] += 1;
		}
		
		//상어 정보 받기
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken())-1;
		sx = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 0; i < S; i++) {
			makeCopy();
			fishMove();
			goCopy(); //위에서 복사해놓았던 물고기를 다시 합쳐줍니다.
		}
		
		System.out.println(cnt());
	}
	
}
