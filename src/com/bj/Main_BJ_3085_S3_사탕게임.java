package com.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_3085_S3_사탕게임 {
	
	//우측 아래측 방향 두 가지만 판단해도 모든 인접 사탕을 확인할 수 있기 때문에 이렇게 진행을 하였습니다.
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int result;
	static char[][] cArr;

	//연속된 사탕의 개수를 세주는 check()입니다.
	public static void check() {
		
		//무조건 사탕 1개는 되니까 1로 표시해주었습니다.
		int max = 1;
		
		for (int i = 0; i < cArr.length; i++) {
			
			//가장 왼쪽의 사탕을 선택한 뒤 해당 행을 진행하며 연속된 사탕의 개수를 찾습니다.
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

			//가장 위쪽의 사탕을 선택한 뒤 해당 열을 진행하며 연속된 사탕의 개수를 찾습니다.
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
			
			//가로 세로를 모두 돌았을 때 최고값을 갱신해줍니다.
			max = Math.max(max, now2);
		}
		
		//이번 check를 통해 얻은 max와 기존의 최고값 result를 비교해 최고값을 갱신해줍니다.
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

		//일단 처음상태의 최대 사탕을 찾아줍니다. 종종 사탕을 하나도 교환하지 못하는 경우가 있어 해당
		//상태가 최대값인 경우가 있습니다.
		check();
		
		//그리고 이중 포문을 이용해서 사탕을 하나씩 확인하며 오른쪽, 아래방향에
		//변경할 수 있는 사탕이 있는지 확인합니다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char c = cArr[i][j];

				for (int k = 0; k < 2; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (0 <= ny && ny < n && 0 <= nx && nx < n) {
						//현재 위치와 다음 위치의 사탕이 다를경우 변경해준 뒤
						//check() 함수를 실행시켜 연속된 사탕의 개수를 다시 세줍니다.
						if (cArr[ny][nx] != c) {
							char temp1 = cArr[i][j];
							cArr[i][j] = cArr[ny][nx];
							cArr[ny][nx] = temp1;
							
							check();

							//다시 원래대로 사탕을 옮겨줍니다.
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
