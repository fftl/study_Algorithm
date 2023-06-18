package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//로봇이 움직일 수 있는 곳은 1~N까지의 인덱스 뿐
//인덱스를 자유롭게 움직일 수 있으며 해당 인덱스의 데이터에 접근하여 변경하기 쉬운
//ArrayList를 이용해서 문제를 풀었습니다.
public class Main_BJ_20055_G5_컨베이어벨트위의로봇 {
	static int N, K, zeroCnt;
	static ArrayList<Integer> up, down;
	static ArrayList<Boolean> rb; 

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//처음에는 로봇이 하나도 없기에 false로 표현하였습니다.
		rb = new ArrayList<>();
		for (int i = 0; i < N; i++) rb.add(false);
		
		up = new ArrayList<>();
		down = new ArrayList<>();
		
		//1-n까지는 벨트의 상단인 up에 n+1 - 2n 까지는 하단인 down에 넣었습니다.
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2*N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(i<=N) up.add(now);
			else down.add(now);
			
			if(now == 0) zeroCnt++;
		}
		
		//단계를 표현할 cnt 입니다.
		int cnt = 1;
		//이제 문제에 주어진 조건대로 구현을 하였습니다.
		while(zeroCnt<K) {
//			System.out.println("==================================");
//			System.out.println(up);
//			System.out.println(down);
			//1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전하다.
			//벨트 회전
			int upLast = up.get(up.size()-1);
			up.remove(up.size()-1);
			down.add(0, upLast);
			
			int downLast = down.get(down.size()-1);
			down.remove(down.size()-1);
			up.add(0, downLast);
			
			//로봇도 함께 이동함
			rb.add(0, false);
			
			//마지막 위치위 벨트를 빼주고,
			rb.remove(rb.size()-1);
			//마지막 위치가 무엇이었던 도착하는 순간 로봇이 내려가기 때문에 false로 해주어야 한다.
			//그래서 그냥 한개 더 빼주고 false를 넣어서 표현해줍니다.
			rb.set(rb.size()-1, false);
			
			
//			System.out.println("컨베이어 회전 후 ==================================");
//			System.out.println(up);
//			System.out.println(down);
			
			//2. 맨앞의 로봇부터, 다음 방향으로 이동할 수 있다면 이동
			for (int i = rb.size()-2; i >= 0; i--) {
				//해당 위치에 로봇이 존재할 때
				if(rb.get(i)) { 
					//그리고 다음 칸에 내구도가 0보다 크고, 로봇이 존재하지 않다면
					//이동시켜주고 해당 칸의 내구도를 감소시켜줍니다.
					if(up.get(i+1) > 0 && !rb.get(i+1)) {
						rb.set(i, false);
						rb.set(i+1, true);
						up.set(i+1, up.get(i+1)-1);
						if(up.get(i+1) == 0) zeroCnt++;
					}
				}
			}
			
//			System.out.println("로봇 이동 후 ==================================");
//			System.out.println(up);
//			System.out.println(down);
			
			//3. up의 첫번쨰 위치가 내구도 0보다 크다면 로봇을 올림다.
			if(up.get(0)>0) {
				rb.set(0, true);
				up.set(0, up.get(0)-1);
				if(up.get(0) == 0) zeroCnt++;
			}
//			System.out.println("로봇은?");
//			System.out.println(rb);
//			
//			System.out.println(zeroCnt);
			cnt++;
		}
		
		//while을 벗어났다는 것은 cnt-1 단계에서 zeroCnt가 k를 넘었다는 것입니다.
		System.out.println(cnt-1);
	}
}
