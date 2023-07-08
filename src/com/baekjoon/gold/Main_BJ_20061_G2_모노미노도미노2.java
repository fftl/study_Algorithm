package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20061_G2_모노미노도미노2 {

	static int score, bx, by, gx, gy;
	static ArrayList<int[]> main, blue, green;

	static void goBlue(int t, int x, int y) {
		switch (t) {
		case 1:
			for (int i = 0; i < by; i++) {
				if (blue.get(i)[x] != 0) {
					blue.get(i - 1)[x] = 1;
					break;
				}

				if (i == by - 1) {
					blue.get(by - 1)[x] = 1;
				}
			}
			break;
		case 2:
			for (int i = 0; i < by; i++) {
				if (blue.get(i)[x] != 0) {
					blue.get(i - 1)[x] = 1;
					blue.get(i - 2)[x] = 1;
					break;
				}

				if (i == by - 1) {
					blue.get(by - 1)[x] = 1;
					blue.get(by - 2)[x] = 1;
				}
			}
			break;
		case 3:
			for (int i = 0; i < by; i++) {
				if (blue.get(i)[x] != 0 || blue.get(i)[x + 1] != 0) {
					blue.get(i - 1)[x] = 1;
					blue.get(i - 1)[x + 1] = 1;
					break;
				}

				if (i == by - 1) {
					blue.get(by - 1)[x] = 1;
					blue.get(by - 1)[x + 1] = 1;
				}
			}
			break;
		}
	}

	static void goGreen(int t, int y, int x) {
		switch (t) {
		case 1:
			for (int i = 0; i < gy; i++) {
				if (green.get(i)[x] != 0) {
					green.get(i - 1)[x] = 1;
					break;
				}

				if (i == gy - 1) {
					green.get(gy - 1)[x] = 1;
				}
			}
			break;
		case 2:
			for (int i = 0; i < gy; i++) {
				if (green.get(i)[x] != 0 || green.get(i)[x + 1] != 0) {
					green.get(i - 1)[x] = 1;
					green.get(i - 1)[x + 1] = 1;
					break;
				}

				if (i == gy - 1) {
					green.get(gy - 1)[x] = 1;
					green.get(gy - 1)[x + 1] = 1;
				}
			}
			break;
		case 3:
			for (int i = 0; i < gy; i++) {
				if (green.get(i)[x] != 0) {
					green.get(i - 1)[x] = 1;
					green.get(i - 2)[x] = 1;
					break;
				}

				if (i == gy - 1) {
					green.get(gy - 1)[x] = 1;
					green.get(gy - 2)[x] = 1;
				}
			}
			break;
		}
	}

	static void greenLineCheck() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 2; i < gy; i++) {
			int cnt = 0;
			for (int j = 0; j < gx; j++) {
				if (green.get(i)[j] == 1)
					cnt++;
			}

			if (cnt == 4) {
				arr.add(i);
			}
		}

		score += arr.size();
		
		// 블록을 지워줍니다.
		if (arr.size() == 2) {
			green.remove(arr.get(arr.size() - 1).intValue());
			arr.remove(1);
			green.remove(arr.get(arr.size() - 1).intValue());
			green.add(0, new int[gx]);
			green.add(0, new int[gx]);
		} else if (arr.size() == 1) {
			green.remove(arr.get(arr.size() - 1).intValue());
			green.add(0, new int[gx]);
		}
		
		// 블럭을 지웠는데도 연한 부분에 블럭이 존재한다면?
		int softCnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < gx; j++) {
				if (green.get(i)[j] == 1) {
					softCnt++;
					break;
				}
			}
		}

		for (int i = 0; i < softCnt; i++) {
			green.add(0, new int[gx]);
			green.remove(green.size() - 1);
		}
	}
	
	static void blueLineCheck() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 2; i < gy; i++) {
			int cnt = 0;
			for (int j = 0; j < gx; j++) {
				if (blue.get(i)[j] == 1)
					cnt++;
			}

			if (cnt == 4) {
				arr.add(i);
			}
		}

		score += arr.size();
		
		// 블록을 지워줍니다.
		if (arr.size() == 2) {
			blue.remove(arr.get(arr.size() - 1).intValue());
			arr.remove(1);
			blue.remove(arr.get(arr.size() - 1).intValue());
			blue.add(0, new int[gx]);
			blue.add(0, new int[gx]);
			
		} else if (arr.size() == 1) {
			blue.remove(arr.get(arr.size() - 1).intValue());
			blue.add(0, new int[gx]);
		}
		
		// 블럭을 지웠는데도 연한 부분에 블럭이 존재한다면?
		int softCnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < gx; j++) {
				if (blue.get(i)[j] == 1) {
					softCnt++;
					break;
				}
			}

		}
		for (int i = 0; i < softCnt; i++) {
			blue.add(0, new int[gx]);
			blue.remove(blue.size() - 1);
		}
	}
	
	public static int allCnt() {
		int cnt = 0;
		for (int i = 0; i < by; i++) {
			for (int j = 0; j < bx; j++) {
				if(blue.get(i)[j] == 1) cnt++;
			}
		}
		
		for (int i = 0; i < gy; i++) {
			for (int j = 0; j < gx; j++) {
				if(green.get(i)[j] == 1) cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		by = 6;
		bx = 4;
		gy = 6;
		gx = 4;
		score = 0;

		blue = new ArrayList<>();
		green = new ArrayList<>();

		// 각 생상보드 초기화
		for (int i = 0; i < by; i++) {
			blue.add(new int[bx]);
		}

		for (int i = 0; i < gy; i++) {
			green.add(new int[gx]);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			switch (t) {
			case 1:
				goBlue(t, y, x);
				goGreen(t, y, x);
				greenLineCheck();
				blueLineCheck();
				break;
			case 2:
				goBlue(t, y, x);
				goGreen(t, y, x);
				greenLineCheck();
				blueLineCheck();
				break;
			case 3:
				goBlue(t, y, x);
				goGreen(t, y, x);
				greenLineCheck();
				blueLineCheck();
				break;
			}
		}

		System.out.println(score);
		System.out.println(allCnt());
	}
}
