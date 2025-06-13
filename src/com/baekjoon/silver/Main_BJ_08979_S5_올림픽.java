package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_08979_S5_올림픽 {

	static class Data{
		int idx, gold, silver, bronze;

		public Data(int idx,int gold,int silver,int bronze){
			this.idx=idx;
			this.gold=gold;
			this.silver=silver;
			this.bronze=bronze;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				if(o1.gold==o2.gold){
					if(o1.silver==o2.silver){
						return Integer.compare(o2.bronze,o1.bronze);
					}
					return Integer.compare(o2.silver,o1.silver);
				}
				return Integer.compare(o2.gold,o1.gold);
			}
		});

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			pq.add(new Data(idx, gold, silver, bronze));
		}

		int rank = 0;
		int nowGold = 0;
		int nowSilver = 0;
		int nowBronze = 0;
		int stack = 0;

		while(!pq.isEmpty()){
			if(rank==0){
				Data data = pq.poll();
				rank = 1;
				nowGold = data.gold;
				nowSilver = data.silver;
				nowBronze = data.bronze;
				stack++;
				if(data.idx == K) break;
			} else {
				Data now = pq.poll();
				if(nowGold != now.gold || nowSilver != now.silver || nowBronze != now.bronze){
					rank+=stack;
					nowGold = now.gold;
					nowSilver = now.silver;
					nowBronze = now.bronze;
					stack = 1;
				} else {
					stack++;
				}

				if(now.idx == K) break;
			}
		}

		System.out.println(rank);
	}
}
