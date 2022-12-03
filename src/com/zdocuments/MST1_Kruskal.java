package com.zdocuments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
// 크루스칼 알고리즘이용
/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

==>10
----------------------------------

7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14

==>31

 */

public class MST1_Kruskal{
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight="
					+ weight + "]";
		}
		@Override //가중치를 기준으로 오름차순!
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static Edge[] edgeList;	//간선리스트, 간선 배열
	static int[] parents;	//대표자 정보
	static int V,E;			//정점, 간선
	
	public static void make() {
		for (int i = 0; i < V; i++) { //정점의 수 만큼 집합 만들기
			parents[i] = i;
		}
	}
	public static int find(int a){
		if(parents[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parents[a] = find(parents[a]);	//대표값을 향해서 가는 길에 있는 애들의 모든 대표값을 최종 대표값으로 바꿔줍니다.
	}
	
	//a가 가지고 있는 대표와 b가 가지고 있는 대표를 비교한 뒤 다른 집합이라면
	//b의 대표값을 a의 대표값으로 변경해줍니다.
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		// 두 노드의 root가 다르면 합침
		parents[bRoot] = aRoot;
		return true;
	}	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken()); //정점의 수
        E = Integer.parseInt(st.nextToken()); //간선의 수
        parents = new int[V];
        edgeList = new Edge[E];
        
        for(int i=0; i<E; ++i){ //간선의 수 만큼 입력
        	st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());//시작정점
        	int to = Integer.parseInt(st.nextToken());	//끝정점
        	int weight = Integer.parseInt(st.nextToken());//가중치, 비용
  
	        edgeList[i] = new Edge(from ,to, weight);

        }//간선 저장
        
        make();

        // 간선비용이 작은 순서대로 정렬
        Arrays.sort(edgeList);
        int result = 0;
        int count=0;// 연결 간선수
	    for(Edge edge : edgeList){
	    	if(union(edge.start,edge.end)){ // 싸이클이 발생하지 않았으면(같은 집함이면 무조건 사이클)
	    		System.out.println("시작 정점 :"+edge.start);
	    		System.out.println("끝 정점 :"+edge.end);
	    		result += edge.weight;
	    		if(++count == V-1){ // 연결 간선수가 정점수-1이면 다 연결한 것임.
	    			break;
	    		}
	    	}
	    }
        System.out.println(result); //최소 신장트리의 가중치 합
    }
}// end class
