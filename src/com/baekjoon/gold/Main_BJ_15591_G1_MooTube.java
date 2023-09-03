package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_15591_G1_MooTube {

	static int N, Q, k; //문제에서 주어지는 N과 Q, 그리고 사용할 k
	static HashMap<Integer, ArrayList<Integer>> map; //key 위치에 직접 연결 된 value 위치들
	static int[][] arr; //이차원 배열을 이용해 표현한 해당 i, j 사이의 유사도

	//디버깅을 하기 위해 만든 Print() 함수
	static void Print(){
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//주어진 데이터를 입력 받아 줍니다.
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		map = new HashMap<>();

		//N-1 라인 만큼 입력을 받아 arr에 유사도를 표시해줍니다.
		//유사도는 단방향이 아니기 때문에 양쪽으로 표시해 주었습니다.
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[s][e] = v;
			arr[e][s] = v;

			//직접 연결된 두 좌표에 대해서는 주어진 유사도보다 작은 유사도가 주어질 수 없기에
			//빠르게 판단하기 위해 map에 담아줍니다.
			if(!map.containsKey(s)){
				map.put(s, new ArrayList<>());
				map.get(s).add(e);
			} else {
				map.get(s).add(e);
			}

			if(!map.containsKey(e)){
				map.put(e, new ArrayList<>());
				map.get(e).add(s);
			} else {
				map.get(e).add(s);
			}
		}

		StringBuilder sb = new StringBuilder();

		//이제 문제 Q를 직접 받아들이며 개수를 세어줄겁니다.
		for (int i = 0; i < Q; i++) {

			//문제에서 주어지는 k와 기준 영상 p!
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			//bfs에 사용될 q를 선언해주고, 시작점이 될 영상 p를 입력해줍니다.
			Queue<Integer> q = new LinkedList<>();
			q.add(p);

			//유사도가 k이상이라면 개수에 포함되어야 함, 그 개수를 세어줄 cnt 입니다.
			int cnt = 0;

			//양방향 관계이기에 무한루프가 돌 수 있으니까 방문처리를 해주어 반복을 멈춰줄
			//visited 입니다.
			boolean[] visited = new boolean[N+1];

			//bfs 진행!
			while(!q.isEmpty()){

				//q에서 좌표 하나를 꺼내줍니다!
				int now = q.poll();
				visited[now] = true; //방문처리!
				if(now != p) cnt++;  //시작할 때는 본인의 위치이나 얘는 cnt에 들어가지 않음 그 외에는 cnt++;

				//현재 위치(영상)에서 갈 수 있는 곳들의 리스트를 가져옵니다!
				ArrayList<Integer> nowArr = map.get(now);

				//현재 영상과 연결되어 있는 좌표를 꺼내주고
				//현재 영상과 다음 영상의 유사도가 k보다 클 때만! q에 담아줍니다.
				//k보다 작다면 이를 통해서 연결된 모든 영상들은 k유사도 미만의 값을 가지기 때문에 어차피
				//cnt에 포함될 수 없기에 담을 필요가 없습니다!!
				for (int j = 0; j < nowArr.size(); j++) {
					int nowEnd = nowArr.get(j);
					if(arr[now][nowEnd] >= k && !visited[nowEnd]) q.add(nowEnd);
				}
			}

			//위를 통해서 세어진 cnt를 sb에 추가해줍니다.
			sb.append(cnt+"\n");
		}

		//sb 출력을 통해서 결과!!
		System.out.println(sb.toString().trim());
	}
}
