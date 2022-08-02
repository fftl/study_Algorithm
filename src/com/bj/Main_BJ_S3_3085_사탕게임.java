package com.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_S3_3085_사탕게임 {
	
	//우측 아래측 방향 두 가지만 판단해도 모든 인접 사탕을 확인할 수 있기 때문에 이렇게 진행을 하였습니다.
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int result;
	static char[][] cArr;

	public static void check() {
		int max = 1;
		for (int i = 0; i < cArr.length; i++) {

			char c1 = cArr[i][0];
			int now1 = 1;
			for (int j = 1; j < cArr.length; j++) {
				if (c1 == cArr[i][j]) {
					now1++;
				} else {
					max = Math.max(max, now1);
					c1 = cArr[i][j];
					now1 = 1;
				}
			}
			max = Math.max(max, now1);

			char c2 = cArr[0][i];
			int now2 = 1;
			for (int j = 1; j < cArr.length; j++) {
				if (c2 == cArr[j][i]) {
					now2++;
				} else {
					max = Math.max(max, now2);
					c2 = cArr[j][i];
					now2= 1;
				}
			}
			max = Math.max(max, now2);
		}
		result = Math.max(result, max);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// board크기
		int n = Integer.parseInt(br.readLine());
		cArr = new char[n][n]; //n x n 크기의 char 배열입니다.

		//데이터를 cArr에 담아줍니다.
		for (int i = 0; i < cArr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				cArr[i][j] = str.charAt(j);
			}
		}

		//일단 처음상태의 최대 사탕을 찾아줍니다. 종종 사탕을 하나도 교환하지 못하는 경우가 있어
		//먼저 해당 상태를 확인해줍니다.
		check();
		
		//그리고 이중 포문을 이용해서 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char c = cArr[i][j];

				for (int k = 0; k < 2; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (0 <= ny && ny < n && 0 <= nx && nx < n) {
						if (cArr[ny][nx] != c) {
							char temp1 = cArr[i][j];
							cArr[i][j] = cArr[ny][nx];
							cArr[ny][nx] = temp1;
							
							check();

							char temp2 = cArr[i][j];
							cArr[i][j] = cArr[ny][nx];
							cArr[ny][nx] = temp2;
						}
					}
					
				}
			}
		}
		
		System.out.println(result);

	}

}
