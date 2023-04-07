package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_21608_G5_상어초등학교 {
	static int N;
	static int[][] board;
	static HashMap<int[], Student> fix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		fix = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());

			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			Student student = new Student(number, set);

			//첫번째 학생은 자리가 정해져있다.
			if (fix.size() == 0) {
				fix.put(new int[]{1, 1}, student);
				board[1][1] = student.k;

			} else {
				ArrayList<int[]> maxLike = new ArrayList<>();
				int maxCnt = 0;
				for (int r = 0; r < N; r++) {
					int nowCnt = 0;
					for (int c = 0; c < N; c++) {
						if (board[r][c] == 0) {
							if (c - 1 >= 0) {
								if (student.set.contains(board[r][c - 1])) {
									nowCnt++;
								}
							}
							if (r - 1 >= 0) {
								if (student.set.contains(board[r-1][c])) {
									nowCnt++;
								}
							}
							if (c + 1 < N) {
								if (student.set.contains(board[r][c+1])) {
									nowCnt++;
								}
							}
							if (r + 1 < N) {
								if (student.set.contains(board[r+1][c])){
									nowCnt++;
								}
							}
						}

						if(nowCnt>maxCnt){
							maxCnt = nowCnt;
							maxLike.clear();
							maxLike.add(new int[]{r, c});
						} else if(nowCnt == maxCnt){
							maxLike.add(new int[]{r, c});
						}
					} // for c

				}

			}


		}
	}

	static class Student{
		int k, y, x;
		HashSet<Integer> set;
		public Student(int k, HashSet<Integer> set) {
			this.k = k;
			this.set = set;
		}
	}
}
