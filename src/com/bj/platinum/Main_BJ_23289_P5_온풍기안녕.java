package com.bj.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_23289_P5_온풍기안녕 {
	static int Y, X, K;
	static int[][] map;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static HashMap<String, String> wall = new HashMap<>();
	static ArrayList<Machine> mc = new ArrayList<>();
	static ArrayList<int[]> check = new ArrayList<>();

	// 바깥칸 온도 감소 0보다 큰 테두리의 온도는 감소합니다.
	static void outDown() {
		for (int i = 0; i < Y; i++)
			if (map[i][0] > 0)
				map[i][0]--;
		for (int i = 0; i < Y; i++)
			if (map[i][X - 1] > 0)
				map[i][X - 1]--;
		for (int i = 1; i < X - 1; i++)
			if (map[0][i] > 0)
				map[0][i]--;
		for (int i = 1; i < X - 1; i++)
			if (map[Y - 1][i] > 0)
				map[Y - 1][i]--;
	}

	//온도 조절입니다. 온도조절도 동시에 발생해야하기 때문에 copy 맵을 만들어서 사용합니다.
	static void control() {
		int[][] copy = new int[Y][X];
		
		//이중포문으로 모든 좌표를 돕니다.
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				
				//현재 좌표의 벽 정보를 가져와서
				String key = i + "," + j;
				String val = "" + wall.get(key);

				int w = map[i][j];
				for (int k = 0; k < 4; k++) {
					if (!val.contains(Integer.toString(k))) { //벽이 없는 방향과의 온도 조절을 실행합니다.
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (0 <= ny && ny < Y && 0 <= nx && nx < X) { //범위 안의 좌표이고, 기준 좌표보다 온도가 낮다면 온도조절을 합니다. 기준좌표는 뺴주고, 방향좌표는 더해주고
							int nw = map[ny][nx];
							if (w > nw) {
								int sw = (w - nw) / 4;
								copy[i][j] -= sw;
								copy[ny][nx] += sw;
							}
						}
					}
				}
			}
		}
		
		//온도조절을 마치고 온도조절 결과를 map에 더해줍니다.
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] += copy[i][j];
			}
		}
	}

	static void wind() {
		int[][] copy = new int[Y][X];
		for (int i = 0; i < mc.size(); i++) {
			Machine m = mc.get(i);
			int y = m.y;
			int x = m.x;

			//오른쪽 방향으로 바람이 불 때.
			if (m.d == 1) {
				//온풍기의 첫번째 바람은 해당 방향으로 한개만 가니까 갈수있는지 확인하여 먼저 처리해줍니다.
				boolean[][] visited = new boolean[Y][X];
				Queue<int[]> q = new LinkedList<>();
				String fkey = y + "," + x;	
				String fval = "" + wall.get(fkey);	//현재 좌표의 벽을 불러와서
				if (!fval.contains("3")) {	//오른쪽방향에 벽이 없다면?
					int ny = y + dy[3];	
					int nx = x + dx[3];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {	//그리고 범위 안이고, 아직 바람을 쐬어준 적이 없다면?
						q.add(new int[] { ny, nx });
						visited[ny][nx] = true;
						copy[ny][nx] += 5;	//지금은 온풍기의 바람값? 만을 구해줘야 하기 때문에 copy 배열에 따로 담아줍니다.
					}
				}
				
				//두번째 바람은 4부터 시작합니다.
				int k = 4;

				//두번째 바람 부터는 우상단, 우측, 우하단 이렇게 세곳으로 바람을 뻣을 수 있습니다.
				//해당 방향들을 모두 확인하면서 가능할 경우에 q에 담아주는 방법을 취했습니다.
				while (!q.isEmpty()) {
					if (k == 0) //바람의 세기가 0이되면 종료
						break;
					int size = q.size();
					//size가 곧 같은 세기를 가지는 바람들을 표현합니다.
					for (int j = 0; j < size; j++) {
						int[] now = q.poll();
						String key = now[0] + "," + now[1];
						String val = "" + wall.get(key); //이번에도 이번 좌표의 벽의 정보를 가져온뒤 확인을 시작합니다.
						
						for (int l = 0; l < 4; l++) {
							if (l == 2)	 // 이 온풍기는 좌측 방향은 볼 필요가 없습니다.
								continue;
							if (l == 3) { // 오른쪽 방향은 벽이 없다면 바로 바람이 갑니다.
								if (!val.contains(Integer.toString(l))) {
									int ny = now[0] + dy[l];
									int nx = now[1] + dx[l];

									if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
										q.add(new int[] { ny, nx });
										visited[ny][nx] = true;
										copy[ny][nx] += k;
									}
								}
							} else { //이제 우상단, 우하단을 위해 위쪽, 아래쪽을 봐야합니다.우상단을 기준으로 설명하면
								if (!val.contains(Integer.toString(l))) { //현 기준좀 에서 위쪽으로 벽이 있는지 없는지 확인 없다면
									int ry = now[0] + dy[l];
									int rx = now[1] + dx[l];
									if (0 <= ry && ry < Y && 0 <= rx && rx < X) { //해당 방향의 좌표가 맵안에 포함되는지 확인하고

										String nextVal = "" + wall.get(ry + "," + rx);	//해당 좌표의 벽 중에 오른쪽 벽이 없는지 확인합니다.
										if (!nextVal.contains("3")) {	//오른쪽 벽도 없다면 바람을 불 수 있습니다.
											int ny = ry + dy[3];
											int nx = rx + dx[3];
											
											//우상단이 맵안의 포함되는 좌표라면, k온도를 올려주고 방문표시, q에 담아서 해당 위치에서도 다음 바람을 탐색할 수 있도록 합니다.
											if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) { 
												q.add(new int[] { ny, nx });
												visited[ny][nx] = true;
												copy[ny][nx] += k;
											}
										}
									}
								}
							}
						}
					}
					k--;

				}
				// >> 방향만 바꿔 반복
			} else if (m.d == 2) {

				boolean[][] visited = new boolean[Y][X];
				Queue<int[]> q = new LinkedList<>();
				String fkey = y + "," + x;
				String fval = "" + wall.get(fkey);
				if (!fval.contains("2")) {
					int ny = y + dy[2];
					int nx = x + dx[2];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
						q.add(new int[] { ny, nx });
						visited[ny][nx] = true;
						copy[ny][nx] += 5;
					}
				}

				int k = 4;

				while (!q.isEmpty()) {
					if (k == 0)
						break;
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int[] now = q.poll();
						String key = now[0] + "," + now[1];

						String val = "" + wall.get(key);
						for (int l = 0; l < 4; l++) {
							if (l == 3)
								continue; // 이 온풍기는 우측 방향은 볼 필요가 없습니다.
							if (l == 2) { // 왼쪽 방향은 벽이 없다면 바로 바람이 갑니다.
								if (!val.contains(Integer.toString(l))) {
									int ny = now[0] + dy[l];
									int nx = now[1] + dx[l];

									if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
										q.add(new int[] { ny, nx });
										visited[ny][nx] = true;
										copy[ny][nx] += k;
									}
								}
							} else {
								if (!val.contains(Integer.toString(l))) {
									int ry = now[0] + dy[l];
									int rx = now[1] + dx[l];
									if (0 <= ry && ry < Y && 0 <= rx && rx < X) {

										String nextVal = "" + wall.get(ry + "," + rx);
										if (!nextVal.contains("2")) {
											int ny = ry + dy[2];
											int nx = rx + dx[2];

											if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
												q.add(new int[] { ny, nx });
												visited[ny][nx] = true;
												copy[ny][nx] += k;
											}
										}
									}
								}
							}
						}
					}
					k--;
				}
			} else if (m.d == 3) {

				boolean[][] visited = new boolean[Y][X];
				Queue<int[]> q = new LinkedList<>();
				String fkey = y + "," + x;
				String fval = "" + wall.get(fkey);
				if (!fval.contains("0")) {
					int ny = y + dy[0];
					int nx = x + dx[0];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
						q.add(new int[] { ny, nx });
						visited[ny][nx] = true;
						copy[ny][nx] += 5;
					}
				}

				int k = 4;

				while (!q.isEmpty()) {
					if (k == 0)
						break;
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int[] now = q.poll();
						String key = now[0] + "," + now[1];

						String val = "" + wall.get(key);
						for (int l = 0; l < 4; l++) {
							if (l == 1)
								continue; // 이 온풍기는 아래측 방향은 볼 필요가 없습니다.
							if (l == 0) { // 위쪽 방향은 벽이 없다면 바로 바람이 갑니다.
								if (!val.contains(Integer.toString(l))) {
									int ny = now[0] + dy[l];
									int nx = now[1] + dx[l];

									if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
										q.add(new int[] { ny, nx });
										visited[ny][nx] = true;
										copy[ny][nx] += k;
									}
								}
							} else {
								if (!val.contains(Integer.toString(l))) {
									int ry = now[0] + dy[l];
									int rx = now[1] + dx[l];
									if (0 <= ry && ry < Y && 0 <= rx && rx < X) {

										String nextVal = "" + wall.get(ry + "," + rx);
										if (!nextVal.contains("0")) {
											int ny = ry + dy[0];
											int nx = rx + dx[0];

											if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
												q.add(new int[] { ny, nx });
												visited[ny][nx] = true;
												copy[ny][nx] += k;
											}
										}
									}
								}
							}
						}
					}
					k--;
				}

			} else {

				boolean[][] visited = new boolean[Y][X];
				Queue<int[]> q = new LinkedList<>();
				String fkey = y + "," + x;
				String fval = "" + wall.get(fkey);
				if (!fval.contains("1")) {
					int ny = y + dy[1];
					int nx = x + dx[1];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
						q.add(new int[] { ny, nx });
						visited[ny][nx] = true;
						copy[ny][nx] += 5;
					}
				}

				int k = 4;

				while (!q.isEmpty()) {
					if (k == 0)
						break;
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int[] now = q.poll();
						String key = now[0] + "," + now[1];

						String val = "" + wall.get(key);
						for (int l = 0; l < 4; l++) {
							if (l == 0)
								continue; // 이 온풍기는 위측 방향은 볼 필요가 없습니다.
							if (l == 1) { // 아래쪽 방향은 벽이 없다면 바로 바람이 갑니다.
								if (!val.contains(Integer.toString(l))) {
									int ny = now[0] + dy[l];
									int nx = now[1] + dx[l];

									if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
										q.add(new int[] { ny, nx });
										visited[ny][nx] = true;
										copy[ny][nx] += k;
									}
								}
							} else {
								if (!val.contains(Integer.toString(l))) {
									int ry = now[0] + dy[l];
									int rx = now[1] + dx[l];
									if (0 <= ry && ry < Y && 0 <= rx && rx < X) {

										String nextVal = "" + wall.get(ry + "," + rx);
										if (!nextVal.contains("1")) {
											int ny = ry + dy[1];
											int nx = rx + dx[1];

											if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
												q.add(new int[] { ny, nx });
												visited[ny][nx] = true;
												copy[ny][nx] += k;
											}
										}
									}
								}
							}
						}
					}
					k--;
				}

			}
		}

		//온풍기 바람을 원래 맵에 더해줍니다.
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] += copy[i][j];
			}
		}

		control(); //온도조절
		outDown();

	} // wind()

	// 온도가 모두 넘었는지 확인합니다.
	static boolean end() {
		for (int i = 0; i < check.size(); i++) {
			int[] now = check.get(i);
			if (map[now[0]][now[1]] < K) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int n = Integer.parseInt(st.nextToken());
				//기계를 mc 리스트에 담아줍니다.
				if (n > 0 && n < 5) {
					mc.add(new Machine(i, j, n));
				}
				//온도를 체크해야할 위치를 담아줍니다.
				if (n == 5) {
					check.add(new int[] { i, j });
				}
			}
		}

		int w = Integer.parseInt(br.readLine());

		//벽의 좌표를 키로, 방향을 값으로 하는 map에 ,를 이용해 구분하여 담아주었습니다.
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());

			if (t == 0) {
				String a = y + "," + x;
				String b = (y - 1) + "," + x;

				if (!wall.containsKey(a))
					wall.put(a, "0");
				else
					wall.put(a, wall.get(a) + "0");

				if (!wall.containsKey(b))
					wall.put(b, "1");
				else
					wall.put(b, wall.get(b) + "1");

			} else {
				String a = y + "," + x;
				String b = y + "," + (x + 1);

				if (!wall.containsKey(a))
					wall.put(a, "3");
				else
					wall.put(a, wall.get(a) + "3");

				if (!wall.containsKey(b))
					wall.put(b, "2");
				else
					wall.put(b, wall.get(b) + "2");
			}
		}

		int result = 0;
		while (end()) {
			if (result > 100) //100보다 크면 바로 종료
				break;
			wind();
			result++;
		}
		System.out.println(result);
	}

	static class Machine {
		int y, x, d;

		public Machine(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Muchine [y=" + y + ", x=" + x + ", d=" + d + "]";
		}

	}
}
