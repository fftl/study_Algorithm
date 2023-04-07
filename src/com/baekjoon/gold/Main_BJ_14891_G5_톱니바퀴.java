package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_14891_G5_톱니바퀴 {
	
	static List<LinkedList<Integer>> list;
	
	//톱니바퀴를 회전시키는 함수입니다. 톱니바퀴의 idx(몇 번 톱니바퀴인지.), 방향을 받아 회전시킵니다.
	static void turnGear(int idx, int cmd) {
		if(cmd==1) {
			LinkedList<Integer> now = list.get(idx);
			now.addFirst(now.getLast());
			now.removeLast();
		} else {
			LinkedList<Integer> now = list.get(idx);
			now.addLast(now.getFirst());
			now.removeFirst();
		}
	}
	
	public static void main(String[] args) throws Exception{
		list = new ArrayList<>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//톱니바퀴의 정보를 입력받아 LinkedList에 입력해주었습니다.
		for (int i = 0; i < 4; i++) {
			list.add(new LinkedList<>());
			
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				list.get(i).add(str.charAt(j)-'0');
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//명령어를 하나씩 받으며 톱니바퀴 회전을 시작합니다.  
		for (int i = 0; i < n; i++) {
			
			//톱니바퀴의 회전 여부를 판단하고 바로 회전을 시키게 되면 다음 판단에 영향을 줄 수 있기 떄문에
			//회전의 여부를 담아놓고 해당 시퀀스가 끝날 때 한번에 회전시켜주기 위한 배열들입니다.
			boolean[] check = new boolean[4];
			int[] direction = new int[4];
			
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;	//톱니바퀴는 1번부터 시작하기 때문에 0부터 시작하는 배열과 맞추어 주기 위해 -1을 해주었습니다.
			int cmd = Integer.parseInt(st.nextToken());
			
			//0번, 3번 톱니바퀴일 경우 끝에 있으므로 가장 인접한 톱니부터 확인하였습니다.
			//if else를 통해서 인접한 부분이 같지않다면 바로 종료를 시켜주는 방식으로 진행하였습니다.
			if(idx == 0) {
				
				//각 톱니바퀴들의 맞닿는 부분의 극이 같은지 다른지 판단하여 다르다면 회전여부를 체크해주는 것을
				//반복합니다.
				if(list.get(0).get(2)!=list.get(1).get(6)) {
					check[1] = true;
					direction[1] = cmd*-1;
					if(list.get(1).get(2)!=list.get(2).get(6)) {
						check[2] = true;
						direction[2] = cmd;
						if(list.get(2).get(2)!=list.get(3).get(6)) {
							check[3] = true;
							direction[3] = cmd*-1;
						}
					}
				}
				check[idx] = true;
				direction[idx] = cmd;
				
			} else if(idx == 3) {
				if(list.get(3).get(6)!=list.get(2).get(2)) {
					check[2] = true;
					direction[2] = cmd*-1;
					if(list.get(2).get(6)!=list.get(1).get(2)) {
						check[1] = true;
						direction[1] = cmd;
						if(list.get(1).get(6)!=list.get(0).get(2)) {
							check[0] = true;
							direction[0] = cmd*-1;
						}
					}
				}
				check[idx] = true;
				direction[idx] = cmd;
				
			//1, 2번 톱니바퀴는 각각 양쪽의 톱니바퀴를 확인하며 회전 여부를 체크합니다.
			} else if(idx == 1) {
				if(list.get(1).get(6)!=list.get(0).get(2)) {
					check[0] = true;
					direction[0] = cmd*-1;
				}
				
				if(list.get(1).get(2)!=list.get(2).get(6)) {
					check[2] = true;
					direction[2] = cmd*-1;
					if(list.get(2).get(2)!=list.get(3).get(6)) {
						check[3] = true;
						direction[3] = cmd;
					}
				}
				check[idx] = true;
				direction[idx] = cmd;
				
			} else if(idx == 2){
				if(list.get(2).get(2)!=list.get(3).get(6)) {
					check[3] = true;
					direction[3] = cmd*-1;
				}
				if(list.get(2).get(6)!=list.get(1).get(2)) {
					check[1] = true;
					direction[1] = cmd*-1;
					if(list.get(1).get(6)!=list.get(0).get(2)) {
						check[0] = true;
						direction[0] = cmd;
					}
				}
				check[idx] = true;
				direction[idx] = cmd;
			}
			
			//위의 체크를 통해서 알아낸 회전이 필요한 톱니바퀴들을 회전시켜 줍니다.
			for (int j = 0; j < 4; j++) {
				if(check[j]) turnGear(j, direction[j]);
			}
		}
		
		//회전이 끝난 뒤 각 톱니바퀴들의 12시 방향을 확인한 뒤 점수를 부여해줍니다.
		int res = 0;
		res += list.get(0).get(0) == 0 ? 0 : 1;
		res += list.get(1).get(0) == 0 ? 0 : 2;
		res += list.get(2).get(0) == 0 ? 0 : 4;
		res += list.get(3).get(0) == 0 ? 0 : 8;
		
		
		//출력!
		System.out.println(res);
	}
}
