package com.zdocuments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
*/
public class MST2_Prim {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); // 정점의 수
		int[][] input = new int[N][N]; // 가중치를 저장하는 배열
		boolean[] visited = new boolean[N]; // 정점 방문 체크
		int[] minEdge = new int[N]; // 최소 간선 정보 저장

		StringTokenizer tokens;
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		// minEdge에 최대값 초기화
//		for (int i = 0; i < N; i++) {
//			minEdge[i] = Integer.MAX_VALUE;
//		}

		// 배열을 특정한 값으로 모두 채울수 있다!!
		Arrays.fill(minEdge, Integer.MAX_VALUE);
//		System.out.println(Arrays.toString(minEdge));

		int minVertex, min, result = 0; // 선택된 최소 정점, 최소값 기준 최소 가중치 저장, 최소신장트리 가중치 누적 저장
		minEdge[0] = 0; // 임의의 시작 점 비용 0 셋팅

		for (int c = 0; c < N; c++) { //모든 정점 수 만큼 반복
			min = Integer.MAX_VALUE;//초기값으로 정수의 최대치를 주고 시작
			minVertex = 0;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min>minEdge[i]) { //최소 가중치값 찾기
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min; // 찾은 최소 가중치를 저장
			visited[minVertex] = true; //최소 가중치를 갖는 정점에 방문 체크
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && input[minVertex][i] != 0 
						&& minEdge[i] > input[minVertex][i]) { //이전보다 최솟값을 찾았다면 minEdge 갱신
					minEdge[i] = input[minVertex][i];
				}
			}
					
		} //전체 정점 탐색
		System.out.println(result);
		br.close();
	}
}
