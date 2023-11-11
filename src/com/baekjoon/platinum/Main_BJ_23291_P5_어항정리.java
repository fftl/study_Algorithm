package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_23291_P5_어항정리 {
	
	static ArrayList<LinkedList<Integer>> arr;
	static int N, K, max, min, res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		arr.add(list);
		
		res = 0;
		while(true) {
			max = 0; min = 10000;
			check();
			if(max-min <= K) break;
			
			//start 최소 어항에 물고기를 +1 해줍니다.
			//그리고 가장 왼쪽의 어항을 올려줍니다.
			System.out.println(arr.toString());
			start();
			System.out.println(arr.toString());
			
			System.out.println("시작 최소어항 +1, 왼쪽어항 올리기-----------------------------------");
			
			//어항을 말아봅니다. 비어버린 링크드 리스트는 그대로 남아있나? OK
			//공중부양 작업! ( 조건이 조금 애매하긴합니다. )
			while(arr.size()<=(arr.get(0).size()-arr.get(1).size())) {
				roll();
				System.out.println(arr.toString());
			}
			System.out.println("어항을 돌돌 말아줍니다! 2층이상 어항 들어서 눕혀서 얹기-----------------------------------");
			
			//인접한 어항에 대한 물고기 나누기를 실행합니다!!
			move();
			System.out.println(arr.toString());
			System.out.println("다 얹은 어항의 물고기를 한번 정리해줍니다.-----------------------------------");
		
			//어항을 일자로 펴줍니다!
			spread();
			System.out.println(arr.toString());
			System.out.println("어항을 한번 1자로 펴줍니다. -----------------------------------");
			
			//n/2으로 잘라서 어항을 다시 얹어줍니다!!
			half();
			System.out.println(arr.toString());
			half();
			System.out.println(arr.toString());
			System.out.println("n/2 공중부양 작업을 두번 해줍니다.-----------------------------------");
			
			//두번 얹은 물고기들을 다시 나누어줍니다!!
			move();
			System.out.println(arr.toString());
			System.out.println("다 얹은 어항의 물고기를 한번 더!! 정리해줍니다.-----------------------------------");
			
			//어항을 마지막으로!! 일자로 펴줍니다!
			spread();
			System.out.println(arr.toString());
			System.out.println("어항을 한번 1자로 펴줍니다. -----------------------------------");
			
			res++;
		}
		
		System.out.println(res);
	}
	
	//ArrayList<ArrayList<>> 또는 ArrayList<Queue<>>으로 될 수도 있을 것 같다.
	
	//start 가장 물고기가 적은 어항에 물고기++ 해줌
	//그리고 가장 왼쪽의 어항을 들어서 그 다음칸 위에 올려줌
	static void start() {
		//가장 물고기가 적은 어항에 물고기를++ 해주었습니다.
		for (int i = 0; i < arr.size(); i++) {
			LinkedList<Integer> now = arr.get(i);
			for (int j = 0; j < now.size(); j++) {
				int val = now.get(j);
				if(val == min) {
					now.add(j, val+1);
					now.remove(j+1);
				}
			}
		}
		
		//가장 왼쪽의 어항을 오른쪽 어항 위에 올리는 것을 표현해줍니다.
		int first = arr.get(0).pollFirst();
		LinkedList<Integer> nList = new LinkedList<>();
		nList.add(first);
		
		arr.add(nList);
	}
	
	//어항을 말아줍니다.
	static void roll() {
		//반복을 해주어야 하는 횟수, 바닥층이 아닌 곳의 배열의 크기!
		int len = arr.get(1).size();
		int aSize = arr.size();
		Stack<LinkedList<Integer>> sta = new Stack<>();
		for (int i = 0; i < len; i++) {
			LinkedList<Integer> nList = new LinkedList<>();
			for (int j = 0; j < aSize; j++) {
				nList.add(arr.get(j).pollFirst());
			}
			sta.add(nList);
		}
		
		while(!sta.isEmpty()) {
			arr.add(sta.pop());
		}
		
		//새로운 LinkedList를 생성하며 중간에 비어있는 linkeList가 생깁니다.
		//그 친구들을 제거해줘야합니다. 그리고 그 친구들은 크기가 2층이상인 배열의 크기라고 볼 수 있습니다.
		gc(aSize-1);
	}
	
	//빈 어항을 제거해줍니다.
	static void gc(int size) {
		for (int i = 0; i < size; i++) {
			arr.remove(1);
		}
	}
	
	//어항을 펴줍니다.
	static void spread() {
		//반복을 해주어야 하는 횟수, 바닥층이 아닌 곳의 배열의 크기!
		int len = arr.get(1).size();
		int aSize = arr.size();
		LinkedList<Integer> nList = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < aSize; j++) {
				nList.add(arr.get(j).pollFirst());
			}
		}
		
		int fLen = arr.get(0).size();
		for (int i = 0; i < fLen; i++) {
			nList.add(arr.get(0).pollFirst());
		}
		
		arr.clear();
		arr.add(nList);
	}
	
	//절반을 180도 회전 쌓기!
	static void half() {
		int size = arr.size();
		Stack<Stack<Integer>> frame = new Stack<>();
		for (int i = 0; i < size; i++) {
			Stack<Integer> sta = new Stack<>();
			int subLen = arr.get(i).size();
			for (int j = 0; j < subLen/2; j++) {
				sta.add(arr.get(i).pollFirst());
			}
			frame.add(sta);
		}
		
		while(!frame.isEmpty()) {
			Stack<Integer> now = frame.pop();
			LinkedList<Integer> nList = new LinkedList<>();
			while(!now.isEmpty()) {
				nList.add(now.pop());
			}
			arr.add(nList);
		}
	}
	
	//각 어항 물고기 수 확인
	static void check() {
		for (int i = 0; i < arr.size(); i++) {
			LinkedList<Integer> now = arr.get(i);
			for (int j = 0; j < now.size(); j++) {
				int num = now.get(j);
				max = Math.max(num, max);
				min = Math.min(num, min);
			}
		}
	}
	
	//인접한 어항에 대해서 물고기 수의 차를 구하고, 이 차이를 5로 나눈 몫 d가 0보다 크다면
	//두 어항중 물고기의 수가 많은 곳의 물고기 d마리를 적은곳으로 보낸다. ( 동시에 발생 )
	static void move() {
		int[] dy = {0, 0, -1, 1};
		int[] dx = {1, -1, 0, 0};
		
		ArrayList<int[]> copy = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) copy.add(new int[arr.get(i).size()]);
		
		//모든 좌표를 돌면서 인접한 어항에 대한 물고기의 이동을 copy에다가 표현해줍니다.
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				
				int base = arr.get(i).get(j);
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(0 <= ny && ny<arr.size() && 0<=nx && nx<arr.get(ny).size()) {
						int next = arr.get(ny).get(nx);
						int cha = Math.abs(base-next)/5;
						if(cha>0) {
							if(base>next) {
								copy.get(i)[j] -= cha;
								copy.get(ny)[nx] += cha;
							} else {
								copy.get(i)[j] += cha;
								copy.get(ny)[nx] -= cha;
							}
						}
					}
				}
			}
		}
		
		//위의 과정을 수행하면 같은 a, b 어항에 대한 비교가 두번씩 이루어지기 때문에 /2 한 값을
		//실제 어항에 반영시켜주었습니다.
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				arr.get(i).set(j, arr.get(i).get(j)+(copy.get(i)[j])/2);
			}
		}
	}
}
