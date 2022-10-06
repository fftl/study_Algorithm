package com.pg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution_PG_L3_보석쇼핑 {

	public static void main(String[] args) throws Exception {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(solution(gems));
	}

	static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        //최대값을 gems 크기로 놓는다.
        int len = gems.length;
        int s = 0;
        int ts = 0;
        
        for (int i = 0; i < gems.length; i++) {
			String now = gems[i]; //보석을 하나씩 꺼내며
			
			//맵과 큐에 추가시켜줍니다.
			if(!map.containsKey(now)) map.put(now, 1);
			else map.put(now, map.get(now)+1);
			q.add(now);
			
			while(true) {
				//큐의 첫번째 가장 앞에 있는 보석을 꺼내 
				String first = q.peek();
				
				//보석이 하나보다 더 가지고 있는지 확인합니다.
				//더 가지고 있을 경우  그 보석은 빼줘도 되기 때문에 해당 보석의 개수 1을 빼주고
				//큐에서도 빼줍니다.
				//그리고 시작위치를 앞으로 빼줍니다.
				if(map.get(first)>1) {
					map.put(first, map.get(first)-1);
					q.poll();
					ts++;
				} else {
					break;
				}
			}
			
			//위의 작업중에 보석을 가지고 있는 길이가 작아졌다면
			//길이와 시작값을 갱신해줍니다.
			if(map.size() == set.size() && len > q.size()) {
				len = q.size();
				s = ts;
			}
		}
        
        
        //시작 좌표와 시작좌표+보석개수를 반환!
        return new int[] {s+1, s+len};
    }
}
