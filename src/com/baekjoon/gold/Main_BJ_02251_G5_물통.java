package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BJ_02251_G5_물통 {
	static int as, bs, cs;
	static int[] frame;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception{
		//데이터 입력!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<Integer> res = new TreeSet<>(); //결과를 오름차순으로 출력해야 하기에 TreeSet을 이용하였습니다.
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		//일단 시작할 때 a가 0이기에 c의 값을 미리 저장합니다.
		res.add(c);
		
		as = 0; bs = 0; cs = c; //실제 물통에 담겨있는 물을 저장합니다.
		frame = new int[] {a, b, c}; //물통의 크기를 저장합니다.
		
		visited = new boolean[201][201][201]; //최대 현재 A, B, C의 크기에 방문한 적이 있는지 표시합니다.
		Queue<int[]> q = new LinkedList<>(); //bfs를 하기위한 Queue 입니다.
		
		//최초의 상태를 q에 넣어주고, 방문처리 해줍니다.
		q.add(new int[] {as,bs,cs});
		visited[as][bs][cs] = true;
		
		//bfs 시작!
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			//현재 A,B,C 상태에서 이동할 수 있는 모든 경우의수는 6개
			//각각을 모두 확인하며 A==0 의 상태를 확인하며 res를 추가하고
			//방문여부를 확인하여 방문하지 않았다면 Queue를 추가해줍니다.
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i==j) continue;
					int[] nowC = move(i, j, now);
					if(now[0] == 0) res.add(now[2]);
					if(!visited[nowC[0]][nowC[1]][nowC[2]]) {
						visited[nowC[0]][nowC[1]][nowC[2]] = true;
						q.add(nowC);
					} else {
					}
				}
			}
		}
		
		
		//bfs 탐색을 끝내고 res에 담긴 값들을 꺼내서 출력하여 줍니다!
		StringBuilder sb = new StringBuilder();
		while(!res.isEmpty()) {
			sb.append(res.pollFirst()+" ");
		}
		
		//답!!
		System.out.println(sb.toString().trim());
	}
	
	//문제 풀이의 핵심이 되는 move 함수입니다. from에서 to로 물을 옮겨주는 행위를 하는 메소드입니다.
	static int[] move(int from, int to, int[] now) {
		
		int yubun = frame[to]-now[to]; //물을 받을 물통에 물을 받을수 있는 공간이 얼마나 남았는지 확인해줍니다.
		int motgan = (now[from]-yubun) > 0 ? now[from]-yubun : 0; //만약 받을 수 있는 공간이 더 크다면 물을 모두 넘겨주고 못간 값을 0으로 아니라면 못간 물을 남깁니다.
		int gan = now[from] - motgan; //물이 얼마나 넘어갔는지 구해줍니다.
		
		int[] result = new int[3];
		boolean[] visit = new boolean[3];
		visit[from] = true;
		visit[to] = true;
		
		//못간 값과
		//이동한 후의 값들을 각각 담아줍니다.
		result[from] = motgan;
		result[to] = now[to]+gan;
		
		for(int i=0; i<3; i++) {
			if(!visit[i]) result[i] = now[i];
		}
		
		//반환합니다!
		return result;
	}
}
