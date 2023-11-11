package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_21608_G5_상어초등학교 {
	static int N;
	static int[][] board;	//자리를 표현할 board
	static HashMap<int[], Student> fix;	//각 자리에 앉은 학생들의 정보를 담을 fix 입니다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		fix = new HashMap<>();
		
		//각 학생을 한명씩 입력 받으며 자리를 배치해줍니다.
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			//먼저 학생 번호를 받습니다.
			int number = Integer.parseInt(st.nextToken());

			//학생이 좋아하는 학생의 번호를 set으로 받아 빨리 확인할 수 있도록 하였습니다.
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			//일단 학생의 번호와 좋아하는 학생을 가져진 student 객체를 만듭니다.
			Student student = new Student(number, set);

			// 첫번째 학생은 자리가 정해져있기에 미리 입력을 해줍니다.
			if (fix.size() == 0) {
				student.y = 1;
				student.x = 1;
				fix.put(new int[] { 1, 1 }, student);
				board[1][1] = student.k;
			
			//첫번째 학생이 아닐 경우 자리 찾기를 시작합니다.
			} else {
				//학생이 배치될 수 있는 최적의 자리가 여러 자리 일 수 있습니다. 그를 담아줄 maxLike 입니다.
				ArrayList<int[]> maxLike = new ArrayList<>();
				
				//인접한 위치에 존재하는 좋아하는 학생수, 빈자리 수를 담아줍니다. 이후에 이 수 들보다 많은 값을 가진 위치가 나온다면 갱신해줍니다.
				int maxCnt = 0;
				int emptyCnt = 0;
				
				//반의 모든 빈 자리를 돌며 해당 자리가 배치 하기에 좋은 자리인지 판단합니다.
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						int nowCnt = 0;
						int nowEmptyCnt = 0;
						// 아직 학생이 없는 위치라면!
						if (board[r][c] == 0) {

							// 상하좌우(인접한)에 좋아하는 학생수와 인접한 빈 자리의 수를 카운트해줍니다.
							if (c - 1 >= 0) {
								if (student.set.contains(board[r][c - 1])) {
									nowCnt++;
								} else if (board[r][c - 1] == 0) {
									nowEmptyCnt++;
								}
							}
							if (r - 1 >= 0) {
								if (student.set.contains(board[r - 1][c])) {
									nowCnt++;
								} else if (board[r - 1][c] == 0) {
									nowEmptyCnt++;
								}
							}
							if (c + 1 < N) {
								if (student.set.contains(board[r][c + 1])) {
									nowCnt++;
								} else if (board[r][c + 1] == 0) {
									nowEmptyCnt++;
								}
							}
							if (r + 1 < N) {
								if (student.set.contains(board[r + 1][c])) {
									nowCnt++;
								} else if (board[r + 1][c] == 0) {
									nowEmptyCnt++;
								}
							}
							
						//학생이 있는 자리는 굳이 판단을 할 필요가 없습니다.
						} else {
							continue;
						}

						//만약 현재 담아놓은 자리들 보다 좋아하는 학생이 더 인접한 위치를 찾았다면 해당 자리들을 비우고
						//더 좋은 자리를 담습니다. 그리고 해당 위치의 수치로 갱신시켜줍니다.
						if (nowCnt > maxCnt) {
							emptyCnt = nowEmptyCnt;
							maxCnt = nowCnt;
							maxLike.clear();
							maxLike.add(new int[] { r, c });
						
						//문제의 조건 사항중 좋아하는 사람이 가장 많은 위치가 여러개라면, 인접한 위치에 빈 자리가 많은 자리가 다음 우선순위가 됩니다.
						//해당 조건을 위해 빈자리가 더 많은 자리가 발견된다면 해당 위치로 갱신시켜 줍니다.
						} else if (nowCnt == maxCnt && nowEmptyCnt > emptyCnt) {
							emptyCnt = nowEmptyCnt;
							maxLike.clear();
							maxLike.add(new int[] { r, c });
							
						//좋아하는 사람이 많은 자리와, 빈자리가 많은 자리와 각각의 개수가 같다면 해당 위치도 maxLike에 담아줍니다.
						} else if (nowCnt == maxCnt && nowEmptyCnt == emptyCnt) {
							maxLike.add(new int[] { r, c });
						}
					} // for c
				} // for r

				//모든 자리를 판단하며 적합한 자리들을 찾았다면, 그 중 가장 좌측 상단이 우선순위 이므로
				//배열의 첫번쨰 자리로 확정됩니다. 해당 자리를 student의 정보에 담아주고 board에 해당 학생이 위치했음을 표시해줍니다.
				int[] result = maxLike.get(0);
				student.y = result[0];
				student.x = result[1];
				fix.put(result, student);
				board[result[0]][result[1]] = student.k;
			}

		}
		
		//이제 마지막으로 학생들이 자리에 얼마나 만족하는지 구해야 합니다.
		//모든 자리를 돌며 학생들이 인접한 위치에 좋아하는 학생의 수를 세어 만족도를 result에 추가시켜줍니다.
		int result = 0;
		for(int[] key : fix.keySet()) {
				Student student = fix.get(key);
				int likeCnt = 0;
				if (student.y - 1 >= 0) {
					if (student.set.contains(board[student.y - 1][student.x])) {
						likeCnt++;
					}
				}
				if (student.x - 1 >= 0) {
					if (student.set.contains(board[student.y][student.x - 1])) {
						likeCnt++;
					}
				}
				if (student.y + 1 < N) {
					if (student.set.contains(board[student.y + 1][student.x])) {
						likeCnt++;
					}
				}
				if (student.x + 1 < N) {
					if (student.set.contains(board[student.y][student.x + 1])) {
						likeCnt++;
					}
				}

				if (likeCnt == 0)
					result += 0;
				else if (likeCnt == 1)
					result += 1;
				else if (likeCnt == 2)
					result += 10;
				else if (likeCnt == 3)
					result += 100;
				else
					result += 1000;
		}

		//결과물 출력!!
		System.out.println(result);
	}

static class Student {
	int k, y, x;
	HashSet<Integer> set;

	public Student(int k, HashSet<Integer> set) {
		this.k = k;
		this.set = set;
	}

	@Override
	public String toString() {
		return "Student [k=" + k + ", y=" + y + ", x=" + x + ", set=" + set + "]";
	}

}}
