package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D3_02805_농작물수확하기 {

	public static void main(String args[]) throws IOException {
//		System.setIn(new FileInputStream("res/sw_input_2805.txt")); // input 가져오기
		
		//입력값이 많을 수 있으므로 bufferedReader를 사용하였습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //test case를 담아주고 풀이를 시작해줍니다.

		for (int tc = 1; tc <= T; tc++) {
			
			//기준점을 받아서 기준점의 제곱크기의 int배열을 만들어 주었습니다.
			int n = Integer.parseInt(br.readLine()); 
			int[][] board = new int[n][n];

			//string으로 데이터를 받아 charAt으로 숫자들을 각각의 자리에 넣어주었습니다.
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}
			
			int cen = n / 2; //항상 농장은 홀수이기에 가운데 수는 이렇게 구할 수 있습니다.
			int width = 0;	 //양쪽으로 퍼져나가 마름모가 만들어 지는 것을 표현해 주기 위한 width 입니다.
			int result = 0;	 //결과 값을 담아줄 result 입니다.
			boolean half = true; //마름모가 작아지는 즉 절반 이후임을 알아주기 위해  half를 만들었습니다.
			
			//for문을 통해서 한줄씩 데이터를 확인합니다.
			for (int i = 0; i < board.length; i++) {
				//가운데 기준점으로부터 -width 부터 +width 된 곳 까지 더해주는 것을 반복합니다.
				for (int j = cen - width; j <= cen + width; j++) {
					result += board[i][j];
				}

				//만약 이번줄이 농장의 가운데 줄이라면 half를 false로 변경하여
				//width값이 줄어들도록 해줍니다.
				if (i == cen)
					half = false;

				//half값을 기준으로 width를 증가 또는 감소시켜줍니다.
				if (half) {
					width++;
				} else {
					width--;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}
}