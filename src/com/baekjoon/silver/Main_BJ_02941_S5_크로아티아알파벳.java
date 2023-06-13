package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BJ_02941_S5_크로아티아알파벳 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//일단 크로아티아 알파벳에 포함되려면 해당 문자들로 시작해야하기 때문에 미리 걸러주기 위한 check입니다.
		String check = "cdlnsz";
		
		//check안에 포함되는 문자로 시작한다면 이번에는 set을 통해서 실제 크로아티아 알파벳에 존재하는지 확인합니다.
		HashSet<String> set = new HashSet<>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		
		//이제 현재 idx와 몇개의 문자로 표현될 수 있는지 result를 가지고 시작합니다.
		int len = str.length();
		int idx = 0;
		int result = 0;
		
		//안의 로직을 통해서 idx가 문자열의 크기를 넘어선다면 종료해줍니다.
		while(idx<len) {
			String now = str.charAt(idx)+""; //idx를 통해서 현재 문자를 찾습니다.
			
			//만약 현재 문자가 크로아티아 알파벳 시작 숫자에 포함된다면 안의 탐색을 시작합니다.
			if(check.contains(now)) {
				
				//만약 현재문자+2가 가능하다면 dz= 가 가능할 수 도 있기에 한번 확인해줍니다.
				if(idx+3<=len && set.contains(str.substring(idx, idx+3))) {
					idx+=3;
					result++;
				
				//위에서 걸러지지 않았다면 나머지 문자들을 확인합니다.
				} else if(idx+2<=len && set.contains(str.substring(idx, idx+2))) {
					idx+=2;
					result++;
					
				//그것도 안된다면 그냥 하나의 문자로 증가시켜줍니다.
				} else {
					idx++;
					result++;
				}
			} else {
				idx++;
				result++;
			}
		}
		
		//결과!!
		System.out.println(result);
	}
}
