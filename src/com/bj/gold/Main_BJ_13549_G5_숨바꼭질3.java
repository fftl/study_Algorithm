package com.bj.gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_13549_G5_숨바꼭질3{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
        
        boolean[] visited = new boolean[100001];
        pq.add(new int[] {n, 0});
        
        ArrayList<Integer> results = new ArrayList<>();
        run : while(!pq.isEmpty()) {
        	int size = pq.size();
        	for (int i = 0; i < size; i++) {
				int[] now = pq.poll();
				if(now[0] == k) results.add(now[1]);
				if(!visited[now[0]]) {
					visited[now[0]] = true;
					if(now[0]*2<=100000) pq.add(new int[] {now[0]*2, now[1]});
					if(now[0]+1<=100000) pq.add(new int[] {now[0]+1, now[1]+1});
					if(now[0]-1>=0) pq.add(new int[] {now[0]-1, now[1]+1});
				}
			}
        	
        	if(!results.isEmpty()) break;
        }
        
        Collections.sort(results);
        
        
        System.out.println(results.get(0));
    }
}