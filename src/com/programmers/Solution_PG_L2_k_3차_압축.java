package com.programmers;

import java.util.*;

public class Solution_PG_L2_k_3차_압축 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution("happy"));
	}

	//사전을 표현해줄 map 입니다.
	static HashMap<String, Integer> map;

	public static int[] solution(String msg) {
		int[] answer = {};
		ArrayList<Integer> res = new ArrayList<>(); //출력을 담아줄 res입니다.
		mapInit();

		int idx = 0; //현재 입력(읽어야할 부분을 표시해줍니다.)
		int mapIdx = 27; //다음으로 사전에 등록될 문자열의 idx 입니다.
		int len = msg.length(); //문자열 탐색이 끝났을 때를 알기위한 len 입니다.

		run : while(idx<len){
			int size = 1;   //현재 탐색할 문자열 길이입니다.

			//문자열 길이를 늘려가며 사전에 존재하지 않을 때 까지 탐색합니다.
			while(true){

				//만약 idx+size가 len을 넘었다는 것은 현재 idx~끝까지의 문자열이
				//사전에 존재한다는 것 입니다.
				//해당 사전 번호를 출력한뒤 탐색을 끝냅니다!
				if(idx+size > len){
					res.add(map.get(msg.substring(idx, len)));
					break run;
				}

				//이번 문자열이 사전에 있는지 없는지 확인한 뒤
				//존재하지 않는다면 이번문자열-1 까지의 문자열은 사전에 존재한다는 것
				//해당 문자열의 사전번호를 res에 추가해주고,
				//이번문자열은 사전에 mapIdx로 새로 등록해줍니다.
				//그리고 사전번호를 증가시킵니다.
				String now  = msg.substring(idx, idx+size);
				if(!map.containsKey(now)){
					res.add(map.get(msg.substring(idx, idx+size-1)));
					map.put(now, mapIdx);
					mapIdx++;
					break;
				}

				//사전에 문자열이 존재함을 확인했으면 사이즈를 증가시켜줍니다.
				size++;
			}

			//사전에 새로 등록했다면 등록하게 된 문자열-1크기 만큼 idx를 증가시켜줍니다.
			idx+=size-1;
		}

		//return을 위한 int[] 배열을 생성해줍니다.
		answer = new int[res.size()];
		for(int i=0; i<res.size(); i++){
			answer[i] = res.get(i);
		}

		return answer;
	}

	//A-Z 까지의 사전의 기본요소를 넣어줍니다.
	static void mapInit(){
		map = new HashMap<>();
		for(int i=1; i<=26; i++){
			char in = 'A';
			map.put(String.valueOf(in+(i-1)), i);
		}
	}
}
