package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20056_G4_마법사상어와파이어볼 {
	//N-맵크기, M-파이어볼 개수, K-명령 횟수
	static int N, M, K;
	static ArrayList<Fire> fires = new ArrayList<>();
	static int[][] map;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Fire{
		int y, x, m, s, d;//y, x, 질량, 속력, 방향

		public Fire(int y, int x, int m, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fires.add(new Fire(y, x, m, s, d));
			map[y][x] += 1;
		}
		
		while(K>0) {
			//파이어볼 방향으로, 속도만큼 이동합니다.
			for (int i = 0; i < fires.size(); i++) {
				
				Fire fire = fires.get(i);
				
				map[fire.y][fire.x] -= 1;
				int ny = fire.y + dy[fire.d]*(fire.s%N);
				int nx = fire.x + dx[fire.d]*(fire.s%N);

				
				ny = (ny<0) ? N+ny : ny;
				nx = (nx<0) ? N+nx : nx;
				
				ny = (N<=ny) ? 0+(ny-N) : ny;
				nx = (N<=nx) ? 0+(nx-N) : nx;
				fire.y = ny;
				fire.x = nx;
				map[fire.y][fire.x] += 1;
			}
			
			//같은 자리에 존재하는 파이어볼을 나누어 줍니다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > 1) {
						ArrayList<Fire> nowArr = new ArrayList<>();
						int odd = 0;
						int even = 0;
						int sumM = 0;
						int sumS = 0;
						int size = map[i][j];
						
						for (int k = 0; k < fires.size(); k++) {
							Fire fire = fires.get(k);
							
							//같은 좌표에 위치한 파이어볼의 정보를 확인해줍니다.
							if(fire.y==i && fire.x==j) {
								nowArr.add(fire);
								if(fire.d%2==0) {
									even++;
								} else {
									odd++;
								}
								
								sumM += fire.m;
								sumS += fire.s;
							}
						}
						
						//나누었을 때질량이 0이 아니라면 파이어볼을 나누어 줍니다.
						if(sumM/5 != 0) {
							int nowM = sumM/5;
							int nowS = sumS/size;
							
							//합쳐진 파이어볼의 방향이 모두 홀수이거나 짝수라면
							if(odd==0||even==0) {
								fires.add(new Fire(i, j, nowM, nowS, 0));
								fires.add(new Fire(i, j, nowM, nowS, 2));
								fires.add(new Fire(i, j, nowM, nowS, 4));
								fires.add(new Fire(i, j, nowM, nowS, 6));
							} else {
								fires.add(new Fire(i, j, nowM, nowS, 1));
								fires.add(new Fire(i, j, nowM, nowS, 3));
								fires.add(new Fire(i, j, nowM, nowS, 5));
								fires.add(new Fire(i, j, nowM, nowS, 7));
							}
							
							for (int k = 0; k < nowArr.size(); k++) {
								fires.remove(nowArr.get(k));
							}
							
							map[i][j] = 4;
						} else {
							
							//질량이 0이라면 그냥 삭제만 해줍니다.
							for (int k = 0; k < nowArr.size(); k++) {
								fires.remove(nowArr.get(k));
							}
							map[i][j] = 0;
						}
						
						//질량이 0이라면 그냥 삭제만 해줍니다.
						for (int k = 0; k < nowArr.size(); k++) {
							fires.remove(nowArr.get(k));
						}
						
						
					}
				}
			}
			
			K--;
		}
		
		int result = 0;
		for (int k = 0; k < fires.size(); k++) {
			result += fires.get(k).m;
		}
		
		System.out.println(result);
	}
}
