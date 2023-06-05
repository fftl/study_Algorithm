package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_02887_P5_행성터널 {
	static int N;
	static int[] parent;
	static PriorityQueue<int[]> pq;
	
	static class Planet{
		int idx, x, y, z;
		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public String toString() {
			return idx+","+x+","+y+","+z+"//";
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a>b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		else return find(parent[a]);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Planet[] arr = new Planet[N];
		parent = new int[N+1];
		for (int i = 0; i <=N; i++) parent[i] = i;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			arr[i] = new Planet(i, x, y, z);
		}
		
		pq = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				return a[2]-b[2];
			}
		});
		
		//각각 x, y, z 오름차순으로 정렬하여 각각의 가중치를 구해줍니다.
		Arrays.sort(arr, new Comparator<Planet>() {
			@Override
			public int compare(Planet a, Planet b) {
				return a.x-b.x;
			}
		});
		for (int i = 1; i < arr.length; i++) {
			pq.add(new int[] {arr[i-1].idx, arr[i].idx, Math.abs(arr[i-1].x-arr[i].x)});
		}
		
		Arrays.sort(arr, new Comparator<Planet>() {
			@Override
			public int compare(Planet a, Planet b) {
				return a.y-b.y;
			}
		});
		for (int i = 1; i < arr.length; i++) {
			pq.add(new int[] {arr[i-1].idx, arr[i].idx, Math.abs(arr[i-1].y-arr[i].y)});
		}
		
		Arrays.sort(arr, new Comparator<Planet>() {
			@Override
			public int compare(Planet a, Planet b) {
				return a.z-b.z;
			}
		});
		for (int i = 1; i < arr.length; i++) {
			pq.add(new int[] {arr[i-1].idx, arr[i].idx, Math.abs(arr[i-1].z-arr[i].z)});
		}
		//pq완성!!////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int res = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int a = now[0];
			int b = now[1];
			int v = now[2];
			
			//이미 연결되어 있다면?
			if(find(a) == find(b)) continue;
			else {
				union(a, b);
				res += v;
			}
		}
		
		System.out.println(res);
	}
}

