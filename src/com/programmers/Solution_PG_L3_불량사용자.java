package com.programmers;

import java.util.*;

public class Solution_PG_L3_불량사용자 {
	static HashSet<String> set;
	static HashSet<HashSet<String>> data;
	static HashMap<String, HashSet<String>> map;
	static int len, answer;

	static void dfs(int idx, int cnt, String[] ban){
		if(cnt == len){
			data.add(new HashSet<>(set));
			return;
		}

		for(String s : map.get(ban[idx])){
			if(!set.contains(s)){
				// System.out.println(s);
				set.add(s);
				dfs(idx+1, cnt+1, ban);
				set.remove(s);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
	}

	static int solution(String[] user_id, String[] banned_id) {
		answer = 0;
		len = banned_id.length;

		map = new HashMap<>();
		set = new HashSet<>();
		data = new HashSet<>();

		for(String s : banned_id){
			map.put(s, new HashSet<>());
		}

		for(int i=0; i<user_id.length; i++){
			int len = user_id[i].length();
			for(int j=0; j<banned_id.length; j++){
				if(banned_id[j].length() != len) continue;

				boolean able = true;
				for(int k=0; k<len; k++){
					if(banned_id[j].charAt(k) != '*' && user_id[i].charAt(k) != banned_id[j].charAt(k)){
						able = false;
						break;
					}
				}

				if(able){
					map.get(banned_id[j]).add(user_id[i]);
				}
			}
		}


		// System.out.println(map);
		// System.out.println("---------------------------");
		dfs(0, 0, banned_id);

		return data.size();
	}
}
