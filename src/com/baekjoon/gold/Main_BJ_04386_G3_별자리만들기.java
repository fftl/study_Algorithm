package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//문제는 결국 모든 별을 연결하는데 최소 비용으로 하는 것!
//결국 최소 신장 트리? 크루스칼 알고리즘을 사용하면 풀 수 있습니다.
//다만 입력으로 주어지는 비용이 존재하지 않기 때문에 각각의 좌표를 가지고
//각각의 비용을 구해준 뒤 이를 이용한 크루스칼 알고리즘을 이용해야합니다.
public class Main_BJ_04386_G3_별자리만들기 {
	static int N;
	static int[] parent;
	
	static class Node{
		int a, b;
		double val;
		public Node(int a, int b, double val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		public String toString() {
			return a+","+b+","+val;
		}
	}
	
	//좌표의 부모가 같은지 확인합니다.
	static int find(int n) {
		if(parent[n] == n) return n;
		else {
			return find(parent[n]);
		}
	}
	
	//부모가 다를 경우 부모를 합쳐줍니다. 이제 해당 노드들은 연결되어 있음을 표현합니다.
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		//arr는 최초로 입력을 받는 좌표들을 담습니다. 그리고 소수점으로 계산하기 귀찮을까봐 *100을 해서
		//int로 받아주었습니다.
		ArrayList<int[]> arr = new ArrayList<>();
		
		//Node를 이용해서 nodes 리스트를 만들어 주었습니다. 
		//Node는 연결된 좌표들의 idx와 비용을 가지고 있으므로 이를 이용해서 크루스칼 알고리즘을 실행해 줄 것 입니다.
		ArrayList<Node> nodes = new ArrayList<>();
		
		//각 입력 좌표를 *100 해서 arr에 추가해줍니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = (int) Double.parseDouble(st.nextToken())*100;
			int b = (int) Double.parseDouble(st.nextToken())*100;
			arr.add(new int[] {a, b});
		}
		
		//이제 각 좌표의 거리를 계산해주어 nodes를 채워줍니다.
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i+1; j < arr.size(); j++) {
				double val = Math.sqrt(Math.pow(Math.abs(arr.get(i)[0]-arr.get(j)[0]), 2) + Math.pow(Math.abs(arr.get(i)[1]-arr.get(j)[1]), 2));
				nodes.add(new Node(i, j, val));
			}
		}
		
		//이제 비용순으로 오름차순을 해준 뒤 크루스칼 알고리즘을 실행합니다.
		Collections.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node a, Node b) {
				return Double.compare(a.val, b.val);
			}
		});
		
//		System.out.println(nodes);
		
		//각 좌표의 부모 idx를 자신의 위치로 초기화 해준뒤
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) parent[i] = i;
		
		//비용이 가장 작은 node를 꺼내어 연결해주고, 해당 비용을 더해주는 작업을 반복합니다.
		//만약 이미 연결되어 있다면 이를 건너뜁니다.
		double res = 0;
		for (int i = 0; i < nodes.size(); i++) {
			Node now = nodes.get(i);
			if(find(now.a) != find(now.b)) {
				res += now.val;
				union(now.a, now.b);
//				System.out.println(now);
//				System.out.println(Arrays.toString(parent));
			}
		}
		
		//결과를 출력합니다. 입력 받을 때 *100을 해주었으므로 /100을 해줍니다.
		System.out.println(res/100.0);
 	}
}

