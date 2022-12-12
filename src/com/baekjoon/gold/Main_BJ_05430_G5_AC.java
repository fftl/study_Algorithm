package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_BJ_05430_G5_AC {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트케이스 수 <= 100
		
		//정답을 담기 위한 sb 입니다.
		StringBuilder sb = new StringBuilder();
		
		//테스트케이스 만큼 반복합니다. 중간에 error가 발생할 경우 더 이상의 연산이 필요하지 않기 때문에
		//continue를 해주기 위한 run 입니다.
		run : for (int i = 0; i < t; i++) {
			
			//명령어 cmd, 수의 개수 n, 그리고 문자형태로 주어진 배열 arr를 받습니다.
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			
			//앞, 뒤에서 데이터를 삭제하기에 적합한 자료구조인 Deque를 사용해 보았습니다.
			Deque<Integer> dq = new LinkedList<>();
			
			//문자형태의 배열의 앞뒤 '[',']' 를 잘라내고 ',' 콤마를 기준으로 잘라낸 문자열 배열을 만들어줍니다.
			String[] nums = arr.substring(1, arr.length()-1).split(",");
			
			//위에서 만든 nums 배열을 int형태로 변환하며 dq에 입력시켜줍니다.
			for (int j = 0; j < n; j++) {
				dq.add(Integer.parseInt(nums[j]));
			}
			
			//r함수가 실행되면 삭제할 방향을 변경해주어야 하므로 그를 표시해 줄 head 입니다.
			boolean head = true; //true - 정방향, false - 역방향(reverse시 바꾸어줍니다.)
			
			//명령어의 개수만큼 반복합니다.
			for (int j = 0; j < cmd.length(); j++) {
				
				//이번 명령어를 담습니다.
				char now = cmd.charAt(j);
				
				//이번 명령어가 'R'이면 head를 변경해줍니다.
				if(now =='R') head = !head;
				else {
					//R이 아니라면 D란 뜻 만약 dq가 비었다면 error로 끝나야 합니다.
					if(dq.isEmpty()) {
						sb.append("error\n");	//sb에 error를 추가해주고
						continue run;			//continue run을 이용해 바로 다음 문제를 향해 가줍니다.
					} else {					//비어있지 않다면 head의 방향에 맞추어 데이터를 삭제해줍니다.
						if(head) dq.pollFirst();
						else dq.pollLast();
					}
				}
			}
			
			//이번 테스트케이스의 결과를 완성시켜줍니다.
			sb.append("[");			//괄호를 시작하고
			if(dq.isEmpty()) {		//만약 dq가 비었다면 바로 닫아줍니다.(이를 하지 않으면 밑의 과정에서 null이 들어가게 됩니다.)
				sb.append("]\n");
			}else {					//숫자가 하나라도 있다면 데이터를 채워줘야 합니다.
				if(head) {			//이번에도 역시 head의 방향에 따라서 채워주어야 할 방향이 다릅니다. true라면 정방향으로 숫자를 꺼내 채워주고
					while(dq.size()>1) {
						sb.append(dq.pollFirst()+",");
					}
					sb.append(dq.pollFirst()+"]\n");
				} else {			//false라면 끝에서부터 숫자를 꺼내서 채워줍니다.
					while(dq.size()>1) {
						sb.append(dq.pollLast()+",");
					}
					sb.append(dq.pollLast()+"]\n");
				}
			}
		}
		
		//결과 출력!
		System.out.println(sb.toString().trim());
	}
}
