package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_12100_G2_2048Easy {

	static int max, N;

	//map을 깊은복사 해주는 copyMap입니다.
	static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	//최고숫자를 갱신해주는 update 함수입니다!
	static void update(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
	}

/*
4
2 2 4 16
0 0 0 0
0 0 0 0
0 0 0 0
answer - 16
*/
	//실질적으로 map을 움직여주는 move함수입니다!
	static int[][] move(int[][] map, int key) {
		Deque<Integer> q = new LinkedList<>();

		//key에 따라서 방향을 다르게 움직여줍니다.
		switch (key) {
		case 1: // 왼쪽밀기
			
			for (int i = 0; i < map.length; i++) {
				// q에 하나씩 넣으면서 0이라면 건너뛰기, 아니라면 그냥 넣어주기를 반복합니다.
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
				}
				
				// 위에서 만들어진 큐를 같은 방향으로 하나씩 넣어줍니다.
				for (int j = 0; j < map[0].length; j++) {
					
					//q에 수가 존재한다면
					if (!q.isEmpty()) {
						int now = q.pollFirst();//일단 하나를 꺼내어 줍니다.
						if (!q.isEmpty() && now == q.peekFirst()) {//q에 아직 수가 더 있고, 그 수가 미리꺼낸 now와 같다면
							map[i][j] = q.pollFirst() * 2;//그 두 수를 합친 수(즉 *2한 수)를  해당 위치에 넣어줍니다.
						} else {//수가 더 없다면 합칠수 없으므로 그냥 now를 넣어줍니다.
							map[i][j] = now;
						}
					
						//q에 수가 존재하지 않는다면 0을 넣어줍니다.
					} else {
						map[i][j] = 0;
					}
				}
			}
			break;
			
		//이를 for문으로 표현한 각 방향에 동일하게 시행해줍니다.
		case 2: // 오른쪽밀기
			for (int i = 0; i < map.length; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
				}

				for (int j = N - 1; j >= 0; j--) {
					if (!q.isEmpty()) {
						int now = q.pollFirst();
						if (!q.isEmpty() && now == q.peekFirst()) {
							map[i][j] = q.pollFirst() * 2;
						} else {
							map[i][j] = now;
						}
					} else {
						map[i][j] = 0;
					}
				}
			}
			break;
		case 3: // 위쪽밀기
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
				}
				for (int j = 0; j < map[0].length; j++) {
					if (!q.isEmpty()) {
						int now = q.pollFirst();
						if (!q.isEmpty() && now == q.peekFirst()) {
							map[j][i] = q.pollFirst() * 2;
						} else {
							map[j][i] = now;
						}
					} else {
						map[j][i] = 0;
					}
				}
			}
			break;
		case 4: // 아래밀기
			for (int i = 0; i < map.length; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
				}

				for (int j = N - 1; j >= 0; j--) {
					if (!q.isEmpty()) {
						int now = q.pollFirst();
						if (!q.isEmpty() && now == q.peek()) {
							map[j][i] = q.pollFirst() * 2;
						} else {
							map[j][i] = now;
						}
					} else {
						map[j][i] = 0;
					}
				}
			}
			break;
		}

		return map;

	}

	
	//실제 실행입니다.
	static void run(int[][] map, int cnt) {
		update(map); // 현재의 map에서 최대값을 찾아 max값을 갱신해줍니다.
		if (cnt >= 5) {//만약 5번의 움직임이 끝났다면 종료해줍니다.
			return;
		}
		
		//각각의 움직임의 상태를 저장하기 위해서 copy를 복사해서 사용해줍니다.
		int[][] copy1 = copyMap(map);
		run(move(copy1, 1), cnt + 1);

		int[][] copy2 = copyMap(map);
		run(move(copy2, 2), cnt + 1);
		
		int[][] copy3 = copyMap(map);
		run(move(copy3, 3), cnt + 1);

		int[][] copy4 = copyMap(map);
		run(move(copy4, 4), cnt + 1);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		//map에 데이터를 담아줍니다.
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//run을 통해서 움직임을 실행합니다.
		run(map, 0);
		System.out.println(max);
	}
}
