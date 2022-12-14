package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_09019_G4_DSLR {
	
	//파라미터로 넘기는 것 보다 편리하게 사용하기 위해서 전역 변수로 사용하였습니다.
	static Queue<Root> q;
	static boolean[] visited;
	
	//D 연산입니다.
	static void D(Root now) {
		
		//n*2가 9999를 넘는다면
		if(now.n*2>9999) {
			
			//%10000을 val에 담아줍니다.
			int val = (now.n*2)%10000;
			
			//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
			if(!visited[val]) {
				q.add(new Root(val, now.root+"D"));
				visited[val] = true;
			}
			
		//n*2가 9999를 넘지 않는다면
		} else {
			
			//now*2를 그대로 넣어줍니다.
			int val = now.n*2;
			
			//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
			if(!visited[val]) {
				q.add(new Root(now.n*2, now.root+"D"));
				visited[val] = true;
			}
		}
	}
	
	//S연산입니다.
	static void S(Root now) {
		
		//n이 0이라면
		if(now.n==0) {
			//9999를 val에 담아 줍니다.
			int val = 9999;
			
			//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
			if(!visited[val]) {
				q.add(new Root(val, now.root+"S"));
				visited[val] = true;
			}
		
		//0이 아니라면
		} else {
			
			//n-1의 값을 val에 담아줍니다.
			int val = now.n-1;
			
			//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
			if(!visited[val]) {
				q.add(new Root(val, now.root+"S"));
				visited[val] = true;
			}
		}
	}
	
	//L연산입니다.
	static void L(Root now) {
		
		//문자를 옮겨야 하기 때문에 사용하기 쉽게 String으로 변경하여 진행했습니다.
		String str = Integer.toString(now.n);
		
		//네자리수가 되지 않을 경우 0으로 채워주고 회전을 시킵니다.
		while(str.length()<4) {
			str = "0"+str;
		}
		
		//왼쪽방향으로 1씩 이동시킵니다. (1 index 수 ~ 마지막 index 수) + (0 index 수) 방식으로 회전시켜주었습니다.
		int val = Integer.parseInt(str.substring(1, str.length())+str.charAt(0));
		
		//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
		if(!visited[val]) {
			q.add(new Root(val, now.root+"L"));
			visited[val] = true;
		}
	}
	
	//R연산입니다.
	static void R(Root now) {

		//문자를 옮겨야 하기 때문에 사용하기 쉽게 String으로 변경하여 진행했습니다.
		String str = Integer.toString(now.n);
		
		//네자리수가 되지 않을 경우 0으로 채워주고 회전을 시킵니다.
		while(str.length()<4) {
			str = "0"+str;
		}
		
		//오른쪽 방향으로 1씩 이동시킵니다. (마지막 index 수) + (0 index 수 ~ 마지막 index-1 수) 방식으로 회전시켜 주었습니다.
		int val = Integer.parseInt(str.charAt(str.length()-1)+str.substring(0, str.length()-1));
		
		//val에 아직 방문한적이 없다면 q에 담아주고 방문 처리를 해줍니다.
		if(!visited[val]) {
			q.add(new Root(val, now.root+"R"));
			visited[val] = true;
		}
	}
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		//테스트 케이스의 수 만큼 반복
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			//시작 숫자와 종료 숫자를 받습니다.
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			//bfs를 진행하며 이미 방문했던 숫자는 다시 방문하지 않기 위해서
			//boolean 배열을 이용해서 체크합니다.
			//Queue를 이용해 bfs를 진행하기 위한 q 입니다.
			visited = new boolean[10001];
			q = new LinkedList<>();
			
			//시작 숫자는 미리 방문처리를 해주고, q에도 시작이 될 Root를 추가해줍니다.
			visited[s] = true;
			q.add(new Root(s, ""));
			
			//만약에 답을 찾았다면 담아서 출력하기 위한 result 입니다.
			String result = "";
			
			//bfs 탐색을 진행합니다. 만약 종료 숫자를 찾게되면 바로 종료하기 위한
			//run을 부여해 주었습니다.
			run : while(!q.isEmpty()) {
				
				//같은 depth는 한번에 수행하기 위해서 size를 통해 같이 들어온 Queue의 수를 담아줍니다.
				int size = q.size();
				
				//size만큼 반복하는 for문입니다.
				for (int j = 0; j < size; j++) {
					Root now = q.poll();	//이번의 Root를 꺼내 탐색을 시작합니다.
					
					//만약 이번의 값이 e와 같다면 종료!
					if(now.n == e) {
						result = now.root;
						break run;
					
					//아니라면 DSLR 연산을 각각 실행시켜줍니다.
					} else {
						
						//D 연산
						D(now);
						
						//S 연산
						S(now);
						
						//L 연산
						L(now);
						
						//R 연산
						R(now);
						
					}
				}
			}
			
			//결과물 출력!
			System.out.println(result);
		}
	}
	
	//현재 수와 지나온 경로를 표시하기 편하도록 Root class를 만들어 주었습니다.
	static class Root{
		int n;
		String root;
		public Root(int n, String root) {
			super();
			this.n = n;
			this.root = root;
		}
		@Override
		public String toString() {
			return "Root [n=" + n + ", root=" + root + "]";
		}
	}
}
