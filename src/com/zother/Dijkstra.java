package com.zother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */
/*
                 출발                                                                도착
          a      b      c       d      e       f
거리           무한        무한        무한         무한        무한         무한
=================================================== 
기준a      0      3      5      무한        무한         무한
=================================================== 
기준b                   3+2     3+6
          0      3      5       9     무한         무한
=================================================== 
기준c                           5+4    5+6
          0      3      5       9      11     무한
=================================================== 
기준d                                  9+2    9+3
          0      3      5       9      11     12
=================================================== 
기준e                                         11+6
          0      3      5       9      11     12          
=================================================== 
기준f  ==> 최종도착점 : 종료


//==> 2는 그냥 2가 아니고  내거리+너거리
                    ============
//==> 내거리: 시작점에서 부터 기준정점까지의 거리 
//==> 너거리: 현재(기준)정점에서 부터의 거리  

결론) 기존거리   <===비교===>   내거리+너거리

 */

public class Dijkstra {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0;
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//1단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;  //최소 비용의 방문하지 않은 노드 찾기 위한 초기화
			for(int j=0; j<V; ++j){
				if(!visited[j]     
					//방문하지 않았고(아직 출발점 또는 출발점으로 부터의 선택된 기준이 되지 못했다면) 
					&& distance[j] < min){  //최소 비용을 갖는 노드가 있다면
					min = distance[j];  //최소 비용값 저장
					current = j;        //가장 최소 비용을 갖는 노드의 위치 확인
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			if(current == end){ // 선택 정점이 도착정점이면 탈출.
				break;
			}
			
			//2단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] //방문하지 않았고 ==> 다시 되돌아 가지 않을래
						       //이미 최단 거리를 구했고 되돌아 가면 어차피 거리만 늘어나
				   && 	matrix[current][c] != 0  //진입이 가능한 경로라면
				   &&  distance[c] > min+matrix[current][c]){ 
		    //출발점에서 얻은 거리(내거리)와  새로 진행을 통해 얻은 거리(너거리)를 더한 값이 
			//기존에 저장된 거리보다 최단 거리라면
					distance[c] = min+matrix[current][c];
					//최단거리 갱신
				}
			}
		}
		System.out.println(distance[end]); //시작점에서 도착점까지의 최단 비용 출력
		
	}

}
