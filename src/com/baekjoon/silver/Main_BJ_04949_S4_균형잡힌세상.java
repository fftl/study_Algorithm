package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_04949_S4_균형잡힌세상 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열의 길이를 알 수 없기 때문이 일단 true를 사용한 while을 실행시킵니다.
		while(true) {
			
			String str = br.readLine(); //이번 라인의 문자열을 불러옵니다.
			if(str.equals(".")) break;	//문제의 조건중에 문자열이 "." 하나 뿐이라면 문제가 종료됨을 표현해 주었습니다. 

			boolean check = true; 					//중간에 균형이 맞지 않은 문자열임이 판별된다면 바로 표시해주기 위한 check 입니다.
			Stack<Character> st = new Stack<>();	//괄호를 하나씩 받으며 균형이 맞는지 확인하기 위한 stack 입니다.
			
			for (int i = 0; i < str.length(); i++) {	//문자열 길이만큼의 for문을 돌며 괄호들을 확인합니다.
				char now = str.charAt(i);				//문자열을 charAt(i)를 이용해서 char 하나씩 확인합니다.
				if(st.isEmpty()) {						//만약 st이 비어있는 상태에서
					if(now == ')' || now == ']') {		//닫는 괄호가 먼저 온다면 바로 균형이 깨져버립니다.
						check = false;					//균형이 맞지 않는다고 표시해주고 for문을 중지시킵니다.
						break;
					} else if (now == '(' || now == '[') {	//만약 여는 괄호였다면 무엇이든 상관없으니 스택에 담아주고 넘깁니다.
						st.add(now);
					}
				} else {							//스택이 비어있지 않다면 스택의 가장 위에 있는 괄호와 비교를 해보며 균형이 맞는지 확인해야 합니다.
					char top = st.peek();			//일단 가장 위에있는 괄호를 peek()을 이용해서 담아놓습니다.
					if(now == '(' || now == '[') {	//이번에 오는 괄호가 여는 괄호라면 균형이 깨질 일이 없으므로 일단 담아주고 넘깁니다.
						st.add(now);
					
					//만약에 이번에 오는 괄호가 닫는 괄호였다면 top과 짝이 맞는 괄호인지 확인한 뒤
					//짝이 맞다면 st의 top을 비워주고 짝이 맞지않다면 균형이 맞지 않는 문자열임을 표시해주고 for문을 끝냅니다.
					} else if(now == ')') { 
						if (top=='(') {
							st.pop();
						} else {
							check = false;
							break;
						}
					} else if(now == ']') {
						if (top=='[') {
							st.pop();
						} else {
							check = false;
							break;
						}
					}
				}
			}
			
			//모든 문자열을 확인한 뒤 균형이 맞는 문자열이었다면 st이 비어있어야 합니다.
			//스택이 비어있지 않다면 균형이 맞지 않는 문자열임을 표시해줍니다.
			if(st.size() != 0) check = false;
			
			//check가 true면 균형잡힌 문자열이므로 yes 아니라면 no를 출력해줍니다.
			if(check) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
