package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 문제만 읽으면 dfs를 이용해서 모든 경우를 확인하면 되는 간단한 문제..
 필요 기능
 1. 사다리를 놓을 수 있는 모든 경우의 수를 구하는 dfs
 - 어떻게 사다리의 위치를 표현할지. 어떻게 하면 사다리를 놓을 수 있는 위치인지
 파악할지.
 2. 사다리가 i->i로 가는지 확인하는 check
 */

public class Main_BJ_15684_G3_사다리조작 {
	static int Y, X, M;
	static boolean[][] line;
	static boolean end;

	public static void main(String[] args) throws Exception{
		//데이터 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		line = new boolean[Y][X-1]; //가로선이 놓일 수 있는 자리를 선언하기에 X-1의 크기가 됩니다.
		end = false; //가능한 방법을 찾았을 때 바로 종료하기 위함입니다.

		//일단 주어지는 가로선을 line에 표현해줍니다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			line[a][b] = true;
		}

		//가로선을 추가하지 않은 상태에서도 통과할 수 있기에 한번 탐색해줍니다.
		if(check()){
			System.out.println(0);
			return;
		}

		//최대 가로선 갯수를 늘려주며 탐색을 시작합니다.
		for (int i = 0; i < 4; i++) {
			dfs(0, i);
			if(end){
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
		return;
	}

	//i->i로 가는지 확인
	static boolean check(){
		for (int i = 0; i < X; i++) {
			int now = i;
			int h = 0;
			//왼쪽에 가로선이 있는지, 오른쪽에 가로선이 있는지 확인한 뒤 now의 위치를 옮겨줍니다.
			while(h<Y){
				if(0<=now-1 && line[h][now-1]) now = now-1;
				else if(now<X-1 &&line[h][now]) now = now+1;
				h++;
			}
			
			//이번 세로선이 다 내려왔는데 출발점과 다르다면 그냥 바로 false를 반환합니다.
			if(i!=now) return false;
		}
		
		//모든선을 지나는 동안 return false를 한번도 거치지 않았다면 성공입니다!
		return true;
	}

	//사다리가 잘 배치되어 있는지 확인하기 위한 print입니다.
	static void print(){
		for (int i = 0; i < Y; i++) {
			String str = "";
			for (int j = 0; j < X-1; j++) {
				if(line[i][j]) str+="1 ";
				else str+="0 ";
			}
			System.out.println(str);
		}
	}


	//사다리를 놓을 수 있는 모든 경우의 수를 확인
	static void dfs(int cnt, int nowMax){
		//dfs를 빠르게 멈춰주기 위해서 end로 탐색해줍니다.
		if(end) return;

		//현재 개수의 사다리를 모두 놓았다면 check()를 이용하여 올바른 배치가 되었는지 확인해줍니다.
		if(cnt==nowMax){
			if(check()) {
				end = true;
			}
			return;
		}

		//이중 포문을 통해서 가능한 위치에 사다리를 놓습니다.
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X-1; j++) {
				
				//사다리를 놓을 수 없는 상황들을 모두 걸러줍니다.
				if(line[i][j]) continue;
				if(0<=j-1 && line[i][j-1]) continue;
				if(j+1<X-1 && line[i][j+1]) continue;

				line[i][j] = true;
				dfs(cnt+1, nowMax);
				line[i][j] = false;

			}
		}
	}
}
