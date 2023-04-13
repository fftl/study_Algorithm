package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		line = new boolean[Y][X-1];
		end = false;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			line[a][b] = true;
		}

		for (int i = 0; i < 4; i++) {
			dfs(0, i);
		}
	}

	//새로운 사다리를 놓는 것을 출력하여 확인합니다.
	static void print() {
		for (int i = 0; i < Y; i++) {
			String str = "";
			for (int j = 0; j < X - 1; j++) {
				if (line[i][j]) str += "1 ";
				else str += "0 ";
			}
			System.out.println(str);
		}
	}

	//i->i로 가는지 확인
	static boolean check(){
		int ly = line.length;
		int lx = line[0].length;

		for (int i = 0; i < X; i++) {
			int now = i;
			int h = 0;
			while(h<Y){
				
				h++;
			}


			if(now!=i) return false;
		}

		return true;
	}

	//사다리를 놓을 수 있는 모든 경우의 수를 확인
	static void dfs(int cnt, int nowMax){
		if(end) return;

		if(cnt==nowMax){
			System.out.println("----------------------------------");
			print();
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
