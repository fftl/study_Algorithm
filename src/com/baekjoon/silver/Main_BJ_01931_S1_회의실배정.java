package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01931_S1_회의실배정 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//데이터 개수
		int n = Integer.parseInt(br.readLine());
		
		//시작, 종료시간을 받은 이차원 배열
		//데이터 입력
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			data[i] = new int[] {a, b};
		}
		
		//회의가 끝나는 시간 순으로 정렬
		//만약에 동시간에 끝나는 회의가 존재한다면 시작시간 순으로 정렬
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] != b[1]) {
					return a[1] - b[1];
				} else {
					return a[0] - b[0];
				}
			}
		});
		
		//회의의 횟수를 셀 cnt
		//이번 회의가 끝난 시간을 저장할 end
		int cnt = 0;
		int end = 0;
		
		//위에 정렬한 배열을 하나씩 꺼내며 가능한 회의의 개수를 셉니다.
		for (int i = 0; i < data.length; i++) {
			//시작 시간이 현재 end 시간보다 같거나 크다면
			if(data[i][0]>=end) {	//종료시간을 갱신시켜주고, 횟수를 증가시켜줍니다.
				end = data[i][1];
				cnt++;
			}
		}
		
		//결과물 출력!
		System.out.println(cnt);
	}
}
