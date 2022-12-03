package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_11651_S5_좌표정렬하기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		//입력받은 좌표들을 받을 이차원 배열을 만들어 주었습니다.
		int[][] arr = new int[t][2];
		
		//t만큼 반복하며 arr에 해당 좌표들을 입력시켜줍니다.
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		//Comparator 정렬을 이용해서 첫번째로 y를 비교하며 오름차순으로
		//y값이 같다면 x를 비교하여 오름차순으로 정렬을 해주었습니다.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] != b[1]) {
					return a[1]-b[1];
				} else {
					return a[0]-b[0];
				}
			}
		});
		
		//많은 줄을 출력해야하기 때문에 StringBuilder를 사용했습니다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		
		//결과물 출력!!
		System.out.println(sb.toString().trim());
	}
}
