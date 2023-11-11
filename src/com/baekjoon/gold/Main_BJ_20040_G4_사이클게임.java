package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사이클 게임 문제를 읽어보면 노드들을 연결하다가 사이클이 생기면
//몇번째에 생기는지를 출력, 사이클이 생기지 않고 모두 연결된다면
//0을 출력하는 문제이다. 이는 유니온 파인드를 이용해서 연결을 해주다가.
//이미 부모가 같은 두 노드를 연결할 때 사이클이 생긴다고 판단할 수 있을것으로 생각됩니다.
//이를 이용한 풀이를 진행해보겠습니다.
public class Main_BJ_20040_G4_사이클게임 {
	static int N, M;
	static int[] parent;
	
	//두 노드를 연결함을 표현하는 union 입니다.
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	//해당 노드의 부모 idx를 찾는 find 입니다.
	static int find(int n) {
		if(parent[n] == n) return n;
		else return find(parent[n]);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//각 노드의 부모를 표현한 parent입니다. 각각은 자기 자신을 최초의 부모로 가집니다.
		parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;
		
		//시작 부분의 설명대로 각각의 부모를 비교하다가
		//이미 같은 부모를 가진 노드들을 연결할 때 사이클이 발생한다고 판단합니다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//부모가 다르다면 해당 노드들을 연결 해줍니다.
			if(find(a) != find(b)) {
				union(a, b);
			} else { //이미 부모가 같은 a, b의 연결 요청이 나왔습니다. 이는 사이클의 발생을 의미합니다. 결과를 바로 출력합니다.
				System.out.println(i+1);
				return;
			}
		}
		
		//한번도 사이클이 발생하지 않았으면 0을 반환합니다.
		System.out.println(0);
	}
}
