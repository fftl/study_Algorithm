package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//최소 비용으로 모든 노드에 방문해야 하는 겨웅에는 유니온 파인드를 이용한
//크루스칼 알고리즘이 풀이의 기본이라고 생각합니다.
public class Main_BJ_02098_G1_외판원순회 {
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		//parent는 최초에 자기 자신을 부모로 초기화 시켜줍니다.
		parent = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < args.length; j++) {
				
			}
		}
	}
	
	//연결되어 있는 노드들의 부모를 묶어줍니다.
	static void union() {
		
	}
	
	//부모를 찾아줍니다.
	static void find() {
		
	}
}
