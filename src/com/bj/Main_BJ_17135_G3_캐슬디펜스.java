package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_17135_G3_캐슬디펜스 {
	static int Y, X;
	static ArrayList<int[]> combs;
	static int[] result;
	static boolean[] visited;
	
	static void comb(int s, int cnt) {
			if(cnt == 3) {
				combs.add(Arrays.copyOf(result, result.length));
				return;
			}
			
			for (int i = s; i < X; i++) {
				result[cnt] = i;
				comb(i+1, cnt+1);
			}
	}
	
	static ArrayList<int[]> copy(ArrayList<int[]> monster){
		ArrayList<int[]> nowMon = new ArrayList<>();
		for (int i = 0; i < monster.size(); i++) {
			int ny = monster.get(i)[0];
			int nx = monster.get(i)[1];
			nowMon.add(new int[] {ny, nx});
		}
		
		return nowMon;
	}

	static boolean end(ArrayList<int[]> nowMonster) {
		for (int i = 0; i < nowMonster.size(); i++) {
			if (nowMonster.get(i)[0] != 0 && nowMonster.get(i)[0] != -1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int max = 0;
		ArrayList<int[]> monster = new ArrayList<>();
		
		int[][] getMap = new int[Y][X];
		int[][] map = new int[Y+1][X];
		result = new int[3];
		visited = new boolean[X];
		combs = new ArrayList<>();
		comb(0, 0);
		
		//격자판을 입력받고
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				getMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//뒤집어주어 계산하기 편하도록 합니다.
		for (int i = 1; i < Y+1; i++) {
			for (int j = 0; j < X; j++) {
				int a = getMap[Y-i][j];
				map[i][j] = a;
				if(a==1) {
					monster.add(new int[] {i,j});
				}
			}
		}
		
		for(int c=0; c<combs.size(); c++) {
			int[] ht = combs.get(c);
			ArrayList<int[]> nowMonster = copy(monster);
			
			while(end(nowMonster)) {
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < 3; i++) {
					int nowHt = ht[i];
					int miny = -1;
					int minx = -1;
					int minl = Integer.MAX_VALUE;
					int idx = -1;
					
					for (int j = 0; j < nowMonster.size(); j++) {
						int[] nm = nowMonster.get(j);
						if(nm[0] == 0 || nm[0] == -1) continue; // 위치를 벗어나건, 죽은 몬스터는 건너뜁니다.
						int len = Math.abs(0-nm[0]) + Math.abs(nowHt-nm[1]); //궁수와 몬스터까지의 거리를 만들고,
						if(len<=d) { 	//사거리 이하라면,
							if(minl>=len) { 	//최소거리보다 작다면,
								if(minl == len) { //거리가 같다면
									//더 왼쪽에 있는 몬스터를 잡는다.
									if(minx>nm[1]) {
										miny = nm[0];
										minx = nm[1];
										idx = j;
									}
								} else {
									minl = len;
									miny = nm[0];
									minx = nm[1];
									idx = j;
								}
							}
						}
					}//for j
					if(idx != -1) q.add(idx);
				}//for i //궁수들이 쏠 몬스터를 다 정했다면
				while(!q.isEmpty()) {
					int mon = q.poll();
					int[] target = nowMonster.get(mon);
					target[0] = -1;
					nowMonster.remove(mon);
					nowMonster.add(mon, target);
				}
				
				//화살에 맞지 않은 몬스터들은 위로 한칸씩 이동합니다.
				for (int j = 0; j < nowMonster.size(); j++) {
					int[] nm = nowMonster.get(j);
					if(nm[0] == 0 || nm[0] == -1) continue;
					nm[0] -= 1;
					nowMonster.remove(j);
					nowMonster.add(j, nm);
				}
			}//while
			
			int nowCnt = 0;
			for (int j = 0; j < nowMonster.size(); j++) {
				int[] nm = nowMonster.get(j);
				if(nm[0] == -1) nowCnt++; 	//화살로 죽인 몬스터만 세어줍니다.
			}
			
			max = Math.max(nowCnt, max);
		}
		
		System.out.println(max);
	}
}
