package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_07662_G4_이중우선순위큐 {

	public static void main(String[] args) throws Exception{
		
		//T 테스트케이스 수
		//k 연산의 개수 <= 1 000 000 
		//k 개수만큼의 연산 'D' or 'I'
		//D 1 -> 최대값 삭제, D -1 -> 최소값 삭제
		//I N -> Q에 N을 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			//최소, 최대를 가지는 우선순위 큐 두개를 만들고 최대값이 필요할 때에는 pq2에서 꺼내 삭제한 뒤 pq1에서 그 수를 찾아 삭제
			//반대의 경우에는 pq1에서 꺼낸뒤 pq2에서 그 수를 찾아 삭제..?
			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			
			//명령문 하나씩 실행
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String key = st.nextToken();				//명령어와
				int num = Integer.parseInt(st.nextToken());	//숫자를 받아줍니다.
				
				//명령어가 I 일 경우에는 pq1, pq2 모두에 같은 숫자를 입력해줍니다.
				if(key.equals("I")) {
					if(!map.containsKey(num)) map.put(num, 1);
					else map.put(num, map.get(num)+1);
					
					pq1.add(num);
					pq2.add(num);
					
				} else { //명령어가 D연산일 경우
					if(map.isEmpty()) continue; //Q가 비어있을 때의 D연산은 무시합니다.

					//Q가 비어있지 않다면 num의 값에 따라 -1이면 pq1에서, 1이면 pq2에서 숫자를 꺼낸 뒤
					//반대쪽 pq에서도 동일하게 삭제해줍니다.
					if(num == -1) {
						int now = 0;
						while(true) {
							now = pq1.poll();
							if(map.containsKey(now)) break;
						}
						
						int size = map.get(now);
						if(size>1) map.put(now, map.get(now)-1);
						else map.remove(now);
						
					} else {
						int now = 0;
						while(true) {
							now = pq2.poll();
							if(map.containsKey(now)) break;
						}
						
						int size = map.get(now);
						if(size>1) map.put(now, map.get(now)-1);
						else map.remove(now);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for (int num : map.keySet()) {
				min = Math.min(num, min);
				max = Math.max(num, max);
			}
			
			
			//연산이 모두 끝나고 Q가 비어있다면 EMPTY를
			//아니라면 pq2로 최대값, pq1으로 최소값을 출력해줍니다.
			if(map.isEmpty()) sb.append("EMPTY\n");
			else {
				sb.append(max+" "+min+"\n");
			}
		}
		
		//결과값 출력!
		System.out.println(sb.toString().trim());
	}
}
