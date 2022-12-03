package com.zdocuments.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW_D0_00000_낚시터자리잡기 {

	// static class
	// 낚시터 출입구 정보 idx == 위치, size == 몇명
	static class Fis {
		int idx;
		int size;

		public Fis(int idx, int size) {
			this.idx = idx;
			this.size = size;
		}
	}

	// static fields
	static int N, idx;
	static Fis[] farr = new Fis[3];
	static char[] visited;

	// 다음 낚시터 자리찾기
	static String findNext(char[] visited) {
		boolean left = true;
		boolean right = true;
		int k = 0;
		int cnt = 0;

		// 갈 수 있는 자리를 한개라도 찾으면 멈추는 while
		while (cnt == 0) {
			if (left) {
				if (visited[idx - k] == '0') {
					cnt += 1;
				}
			}
			if (right) {
				if (visited[idx + k] == '0') {
					cnt += 2;
				}
			}

			k++;

			// 낚시터의 어느 방향이 범위를 벗어나게 되었다면 해당 방향은 탐색을 멈춥니다.
			if (idx - k < 1)
				left = false;
			if (N < idx + k)
				right = false;
		}

		// k가 마지막에 ++되어 나오기 때문에 1을 빼서 확인해줍니다.
		k--;

		// 답안의 길이(갈수 있는 위치가 두 개가 될 수도 있기에 String을 이용해서 동적인 return값을 표현해주었습니다.
		String result = "";
		if (cnt == 3) { // 양쪽의 거리가 같다면
			result += Integer.toString(idx - k) + " " + Integer.toString(idx + k);
		} else if (cnt == 1) { // 왼쪽 방향이 가능하다면
			result += Integer.toString(idx - k);
		} else { // 오른쪽 방향이 가능하다면
			result += Integer.toString(idx + k);
		}

		// 문자열 리턴
		return result;
	}

	// main
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_낚시터자리잡기.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 낚시터의 수

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				farr[i] = new Fis(idx, size);
			}

			// 출입구를 고르는 모든 경우의 수
			int[][] cases = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 0, 1 } };

			for (int[] c : cases) { // 해당순서로 출입구의 순서를 결정하였다면?
				// 두 가지로 갈릴 수 있는 현재의 상태를 각각 저장해주기 위해서.
				Queue<String[]> q = new LinkedList<>();
				visited = new char[N + 1];
				Arrays.fill(visited, '0');

				for (int a = 0; a < c.length; a++) {
					idx = farr[c[a]].idx;
					int people = farr[c[a]].size;

					// 최초에만 실행
					if (a == 0)
						q.add(new String[] { new String(visited), "0" });

					while (people > 0) {
						int size = q.size();

						for (int i = 0; i < size; i++) {
							String[] nowStr = q.poll();
							char[] nowVis = nowStr[0].toCharArray();
							int sum = Integer.parseInt(nowStr[1]);
							String ables = findNext(nowVis);

							String[] strs = ables.split(" ");
							
							//갈수 있는 가까운 거리 낚시터가 두 개인데, 마지막 사람인 경우
							if (strs.length == 2 && people == 1) {
								int left = Integer.parseInt(strs[0]);
								int right = Integer.parseInt(strs[1]);
								//왼쪽 방향을 가는 가능성을 q에 추가
								nowVis[left] = '1';
								q.add(new String[] { new String(nowVis), Integer.toString(sum + (idx - left + 1)) });
								nowVis[left] = '0';

								//오른쪽 방향을 가는 가능성을 q에 추가
								nowVis[right] = '1';
								q.add(new String[] { new String(nowVis), Integer.toString(sum + (right - idx + 1)) });
								nowVis[right] = '0';

							} else {
								//아니라면 갈 수 있는 곳이 두개라도 어디부터 가든 같으므로 가져온 곳의 아무데나 가줍니다.
								int nextIdx = Integer.parseInt(strs[0]);
								nowVis[Integer.parseInt(strs[0])] = '1';
								q.add(new String[] { new String(nowVis),
										Integer.toString(sum + Math.abs(idx - nextIdx) + 1) });
								nowVis[Integer.parseInt(strs[0])] = '0';
							}
						}
						people--;
					}

					// 마지막 출입구도 끝났다면 현재까지의 거리중 가장 짧은애를 찾아서 반환해줍니다.
					if (a == 2) {
						while (!q.isEmpty()) {
							String[] s = q.poll();
							int nowInt = Integer.parseInt(s[1]);
							min = Math.min(min, nowInt);
						}
					}

				} // for int now
			} // for int[] c;

			System.out.println("#" + tc + " " + min);
		}
	}
}
