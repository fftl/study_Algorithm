package com.programmers;

import java.util.HashMap;

public class Solution_PG_L1_k_숫자문자열과영단어 {

	public static void main(String[] args) throws Exception {
		String s = "2three45sixseven";
		System.out.println(solution(s));
	}

	static int solution(String s) {
		// 숫자로 변환을 시켜주기 위한 재료로 map에 각각 담아놓습니다.
		HashMap<String, Integer> map = new HashMap<>();
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);

		// 결과를 담을 result와
		// 숫자가 될 문자열을 담을 str을 담습니다.
		String result = "";
		String str = "";

		// 주어진 문자열을 char로 하나씩 꺼내어 판단해줍니다.
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (!Character.isDigit(now)) { // 만약 이번 char가 숫자가 아니라면 문자열이 시작된다는 뜻입니다.
				str += now; // str에 이번 문자를 더해주고
				if (map.containsKey(str)) { // 만약 지금까지 완성된 문자가 map의 key에 포함된다면
					result += map.get(str); // 해당 수를 result에 더해주고
					str = ""; // str은 초기화 해줍니다.
				}
			} else { // 숫자였다면 그냥 result에 이어주면 됩니다.
				result += now;
			}
		}

		// 결과 반환!
		return Integer.parseInt(result);
	}
}
