package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_18111_S2_마인크래프트 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		//최초의 블록 상태를 저장하기 위한 map 입니다.
		int[][] map = new int[Y][X];
		
		//가장 높은 블록, 가장 낮은 블록을 저장하기 위해 초기화 해 놓은 변수 max, min 입니다.
		int max = 0;
		int min = 257;
		
		//map 과 max, min을 각각 채워줍니다.
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				max = Math.max(max, now);
				min = Math.min(min, now);
			}
		}
		
		//time은 최솟값, floor는 최댓값을 구하는 문제이기때문에
		//각각을 알맞게 초기화 시켜 주었습니다.
		int time = Integer.MAX_VALUE;
		int floor = 0;
		
		//가장 높은 층부터 1씩 내려가며 해당 층을 완성할 수 있는지, 완성할 수 있다면 몇초의 시간이 걸리는지를 탐색할 예정입니다.
		for (int i = max; min<=i; i--) {
			//현재 층에서의 시간과 블록 개수를 선언하고 시작합니다.
			int nowT = 0;
			int nowB = b;
			
			//먼저 모든 블록을 돌며 현재 층 i 보다 높은 블럭이 있다면 깎아서 nowB에 담아줍니다.
			//블록을 깎아 nowB에 담는 행위는 개당 2초가 걸리기 때문에 *2를 해주었습니다.
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					if(map[j][k] > i) {
						nowB += map[j][k]-i;
						nowT += (map[j][k]-i) * 2;
					}
				}
			}
			
			//이번에는 nowB의 블록을 이용해 모자른 층을 쌓아줘야 하는데 블록이 모자르다면 바로 멈춰줄 예정입니다.
			//바로 멈추기 위해서 stop boolean을 만들었습니다.
			boolean stop = false;
			
			//이번에도 역시 모든 블록을돌며 이번에는 i보다 낮은 층을 확인합니다.
			//그리고 인벤토리(nowB)에 블록이 남았다면 채워주고 만약에 블록이 모자라다면
			//for문을 중지시켜버립니다.
			run : for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					if(map[j][k] < i) {
						nowB -= i - map[j][k];
						if(nowB<0) {
							stop = true;
							break run;
						}
						nowT += i-map[j][k];
					}
				}
			}
			
			//stop이 false라면 즉 해당 층을 완성할 수 있었다면
			//걸린 시간과, 층수를 갱신해줍니다.
			if(stop) continue;
			else {
				if(time>nowT) {
					time = nowT;
					floor = i;
				} else if(time == nowT) {
					floor = Math.max(i, floor);
				}
			}
		}
		
		//결과물 출력!!
		System.out.println(time + " " + floor);
	}
}
