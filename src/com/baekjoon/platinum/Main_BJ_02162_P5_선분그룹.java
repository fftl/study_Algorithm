package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02162_P5_선분그룹 {

	static int[] parents;
	static ArrayList<Point[]> list;

	static class Point{
		int y, x;
		public Point(int y, int x){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		parents = new int[n];
		for(int i=0; i<n; i++){
			parents[i] = i;

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Point[] temp = new Point[2];

			temp[0] = new Point(y, x);

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			temp[1] = new Point(y, x);

			list.add(temp);
		}

//		System.out.println(list.size());

		for(int i=0; i<n; i++){
			Point[] a = list.get(i);

			for(int j=i+1; j<n; j++){
				Point[] b = list.get(j);
				if(isIntersect(a[0],a[1],b[0],b[1])){
					union(i, j);
//					System.out.println(Arrays.toString(parents));
				}
			}
		}

//		System.out.println();
//		System.out.println(Arrays.toString(parents));

		int[] count = new int[n];
		for(int i=0; i<n; i++){
			count[find(i)]++;
		}

		int groupCnt = 0;
		int maxCnt = 0;

		for(int i=0; i<n; i++){
			if(count[i]>0) groupCnt++;
			maxCnt = Math.max(maxCnt, count[i]);
		}

		System.out.println(groupCnt);
		System.out.println(maxCnt);
	}

	// ccw 함수
	static int ccw(Point a, Point b, Point c) {
		long cross = (long)(b.x - a.x) * (c.y - a.y) - (long)(b.y - a.y) * (c.x - a.x);
		return Long.compare(cross, 0); // -1, 0, 1
	}

	// 선분 교차 여부 확인
	static boolean isIntersect(Point a1, Point a2, Point b1, Point b2) {
		int ab = ccw(a1, a2, b1) * ccw(a1, a2, b2);
		int cd = ccw(b1, b2, a1) * ccw(b1, b2, a2);

		if (ab == 0 && cd == 0) {
			// 선분이 일직선 → 겹치는지 확인
			return overlap(a1, a2, b1, b2);
		}

		return ab <= 0 && cd <= 0;
	}
	static boolean overlap(Point a1, Point a2, Point b1, Point b2) {
		// 각 선분을 (작은 좌표, 큰 좌표)로 정렬
		if (a1.x > a2.x || (a1.x == a2.x && a1.y > a2.y)) { Point t=a1; a1=a2; a2=t; }
		if (b1.x > b2.x || (b1.x == b2.x && b1.y > b2.y)) { Point t=b1; b1=b2; b2=t; }

		if (a1.x == a2.x) { // 수직선분: y축으로만 비교
			int aMin = Math.min(a1.y, a2.y), aMax = Math.max(a1.y, a2.y);
			int bMin = Math.min(b1.y, b2.y), bMax = Math.max(b1.y, b2.y);
			return Math.max(aMin, bMin) <= Math.min(aMax, bMax);
		} else {            // 그 외: x축으로 비교
			int aMin = Math.min(a1.x, a2.x), aMax = Math.max(a1.x, a2.x);
			int bMin = Math.min(b1.x, b2.x), bMax = Math.max(b1.x, b2.x);
			return Math.max(aMin, bMin) <= Math.min(aMax, bMax);
		}
	}

	static int find(int a){
		if(parents[a] == a){
			return a;
		} else {
			return parents[a] = find(parents[a]);
		}
	}

	// union
	static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a != b){
			parents[Math.min(a,b)] = Math.max(a,b);
		}
	}
}
