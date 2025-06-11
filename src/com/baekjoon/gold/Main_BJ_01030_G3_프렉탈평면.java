package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01030_G3_프렉탈평면 {
	static int s, N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		if (s == 0) {
			System.out.println("0");
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				sb.append(isBlack(i, j, s) ? "1" : "0");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	// 특정 좌표가 검은색인지 판단하는 함수
	static boolean isBlack(long r, long c, int depth) {
		if (depth == 1) {
			// 기본 단계: N×N 크기에서 중앙 K×K 영역이 검은색인지 확인
			r %= N;
			c %= N;
			int half = N/2;
			if (N % 2 == 0) {
				return (half-K/2 <= r && r <= half+(K/2-1)) &&
						(half-K/2 <= c && c <= half+(K/2-1));
			} else {
				return (half-K/2 <= r && r <= half+K/2) &&
						(half-K/2 <= c && c <= half+K/2);
			}
		}

		// 현재 단계의 크기 계산
		long size = 1L;
		for (int i = 0; i < depth; i++) {
			size *= N;
		}

		// 현재 좌표를 현재 단계 크기로 나눈 나머지 계산
		long nextR = r % size;
		long nextC = c % size;

		// 다음 단계의 크기
		long nextSize = size / N;

		// 현재 단계에서 검은색 영역에 속하는지 확인
		long half = size / 2;
		boolean isCenter;
		if (size % 2 == 0) {
			isCenter = (half-size*K/(2*N) <= nextR && nextR <= half+size*K/(2*N)-1) &&
					(half-size*K/(2*N) <= nextC && nextC <= half+size*K/(2*N)-1);
		} else {
			isCenter = (half-size*K/(2*N) <= nextR && nextR <= half+size*K/(2*N)) &&
					(half-size*K/(2*N) <= nextC && nextC <= half+size*K/(2*N));
		}

		// 현재 단계가 검은색이면 true, 아니면 다음 단계 확인
		return isCenter || isBlack(nextR, nextC, depth-1);
	}
}
