package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_BJ_11559_G4_PuyoPuyo {
	static char[][] board;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int cnt;
	static ArrayList<ArrayList<int[]>> nodes;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		board = new char[12][6];
		
		cnt = 0;
		nodes = new ArrayList<ArrayList<int[]>>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		//뿌요가 4개이상 연결 된 것이 없을 때 까지 반복해줍니다.
		while(true) {
			visited = new boolean[12][6];
			int nowCnt = 0; //연결된 뿌요가 4개이상 존재하는 즉 영역의 개수를 세어줍니다.
			
			//모든 좌표를 확인하여 줍니다.
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					
					//블럭이 존재한다면 탐색을 시작합니다.
					if(board[i][j] != '.' && !visited[i][j]) {
						
						//현재 위치의 블럭이 무엇인지 담아두고
						//해당 블럭의 좌표를 담아줍니다.
						char nowC = board[i][j];  
						nodes.add(new ArrayList<int[]>());
						nodes.get(nowCnt).add(new int[] {i, j});
						
						//4방향을 탐색하기 위한 bfs를 위한 q를 생성합니다.
						//그리고 현재 위치는 미리 방문표시 해놓습니다.
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] {i, j});
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							//현재 노드를 꺼내어주고
							int[] node = q.poll();
							
							//상하좌우 중 같은 뿌요를 가진 것들을 찾아 q에 추가해줍니다.
							for (int k = 0; k < 4; k++) {
								int ny = node[0] + dy[k];
								int nx = node[1] + dx[k];
								
								//범위 안에 존재하고, 아직 방문한적이 없고, 같은 뿌요일 경우
								//방문처리 해주고, 같은 뿌요의 무리에 추가, 그리고 q에 추가해줍니다.
								if(0<=ny && ny<12 && 0<=nx && nx<6 && !visited[ny][nx] && board[ny][nx] == nowC) {
									visited[ny][nx] = true;
									nodes.get(nowCnt).add(new int[] {ny, nx});
									q.add(new int[] {ny, nx});
								}
							}
						}
						
						//현재 담겨진 뿌요가 4개 이상이라면 사라져야할 뿌요입니다.
						//4보다 작다면 해당 뿌요는 remove 해줍니다.
						if(nodes.get(nowCnt).size()>=4) {
							nowCnt++;
						} else {
							nodes.remove(nowCnt);
						}
					}
				}
			}
			
			//위의 과정을 통해서 이번 맵에 사라져야 할 뿌요 그룹이 하나라도 존재한다면
			//해당 뿌요들을 모두 '.'으로 변경해줍니다.
			if(nowCnt>0) {
				for (int i = 0; i < nodes.size(); i++) {
					ArrayList<int[]> now = nodes.get(i);
					for (int j = 0; j < now.size(); j++) {
						int[] nowNode = now.get(j);
						board[nowNode[0]][nowNode[1]] = '.';
					}
				}
				
				cnt++; //현재 위치의 블럭을 담아주고 
				nodes.clear(); //그리고 다음 탐색을 위해 nodes를 비워주고
				gravity();	   //중력을 적용시켜 줍니다.
				
			//사라질 뿌요가 하나도 없다면 반복을 바로 중단시켜버립니다.
			} else {
				break;
			}
			
		}
		
		//정답 출력!!
		System.out.println(cnt);
	}
	
	//중력이 적용하는 모습을 보여줍니다.
	static void gravity() {
		
		//스택 자료구조를 이용해 중력을 표현해 주었습니다.
		Stack<Character> st = new Stack<>();
		
		//세로로 한 줄씩 탐색하며 나오는 블럭들을 스택에 담아주었고,
		//탐색이 끝 난 뒤 해당 줄의 가장 하단부터 하나씩 꺼내어 줌으로서 중력을 표현하였습니다.
		for (int i = 0; i < 6; i++) {
			
			//블럭 찾기
			for (int j = 0; j < 12; j++) {
				if(board[j][i] != '.') {
					st.add(board[j][i]);
					board[j][i] = '.';
				}
			}
			
			//가장 아래부터 하나씩 쌓아주기
			int idx = 11;
			while(!st.isEmpty()) {
				board[idx][i] = st.pop();
				idx--;
			}
		}
	}
	
}
