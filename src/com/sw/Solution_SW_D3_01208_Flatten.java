package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D3_01208_Flatten {
	//10개의 테스트 케이스를 합쳐서 20초라는 시간이 주어졌습니다.
	//그래서 매번 Array.sort를 해주어도 문제가 없을 것이라 생각했습니다.
	
	public static void main(String args[]) throws IOException {
//		System.setIn(new FileInputStream("res/sw_input_1208.txt")); //input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int cnt = Integer.parseInt(br.readLine()); //덤프 횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[100]; //가로길이는 항상 100이기 때문에 배열의 크기는 100
			
			//배열을 채워줍니다.
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			//덤프 횟수만큼 arr를 정렬해주면서 가장 큰값 -1 가장 작은값 +1을 반복해줍니다.
			for (int i = 0; i < cnt; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}

			//마지막으로 한번더 정렬해줍니다.
			Arrays.sort(arr);

			//출력
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));

		}

	}
}