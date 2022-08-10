package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_SW_D4_01861_정사각형방 {

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[][] map;
	static int n, max, temp;
	static Map<Integer, ArrayList<Integer>> memory;

	//이동할 수 있는 칸 수 확인
	static void run(int y, int x, int num) {
		// 받아온 y, x 위치에서 갈수있는 네 방향을 확인하며 현재 값보다 1 높은 같을 찾아
		// 이동해줍니다. temp는 몇 칸째 인지
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < n && 0 <= nx && nx < n) {
				if (map[ny][nx] == num + 1) {
					temp++;
					run(ny, nx, num + 1);
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_1861.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 데이터를 입력받습니다.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine()); // 방의 크기
			map = new int[n][n]; // 방의 숫자들
			max = 0; // 최대 이동거리
			memory = new HashMap<>(); // 출발지에서의 이동거리를 저장
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 받은 방의 숫자들을 하나씩 run에 넣어서 개수를 확인합니다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp = 1;
					run(i, j, map[i][j]);

					// 이번에 이동한 칸수가 현재의 이동값보다 높다면
					// 최대 이동값을 갱신해주고, 출발위치와 이동 칸수를 map에 저장해줍니다.
					if (max <= temp) {
						max = temp;
						memory.putIfAbsent(temp, new ArrayList<>());
						memory.get(temp).add(map[i][j]);
					}
				}
			}

			System.out.println(memory.toString());

			// map의 key중에 최대값, 즉 가장 많이 이동한 값을 찾아줍니다.
			int maxKey = 0;
			for (int i : memory.keySet()) {
				maxKey = Math.max(i, maxKey);
			}

			// 해당하는 출발지 중에서 가장 작은 값을 구해주기 위해서 오름차순 정렬해줍니다.
			ArrayList<Integer> maxStarts = memory.get(maxKey);
			Collections.sort(maxStarts);

			System.out.println("#" + tc + " " + maxStarts.get(0) + " " + maxKey);
			System.out.println();
			if(tc==10)break;
		}

	}

}
