package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_10773_S4_제로 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		//0이나오면 가장 최근의 수를 지워야 하기 때문에 stack을 사용해보았습니다!
		Stack<Integer> st = new Stack<>();
		
		//숫자를 하나씩 받으며 0일경우 st에서 하나의 수를 빼주고
		//0이 아닐경우 st에 추가해줍니다.
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now == 0) st.pop();
			else st.add(now);
		}
		
		//스택의 size만큼 포문을 돌면서 숫자를 더해줄건데
		//st.size()를 for문의 조건에 바로 넣을 경우 st.size()는 계속 줄어들것이라 오류가 발생 할 수 있기 때문에
		//미리 size라는 변수에 담아주어 사용합니다!
		int res = 0;
		int size = st.size();
		for (int i = 0; i < size; i++) {
			res += st.pop();
		}
		
		System.out.println(res);
	}
}
