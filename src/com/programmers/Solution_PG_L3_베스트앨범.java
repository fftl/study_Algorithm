package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution_PG_L3_베스트앨범 {
    
    static HashMap<String, ArrayList<int[]>> map; //고유번호, 각각의 재생수를 담을 맵
    static HashMap<String, Integer> max;          //장르의 최대 재생수를 담을 맵

	public static void main(String[] args) throws Exception {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(solution(genres, plays));
	}

	static int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        max = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>(); //결과를 담을 리스트
        
        //일단 genres를 모두 돌면서 각각의 맵에 알맞는 데이터를 입력합니다.
        for(int i=0; i<genres.length; i++){
            
            //map에는 int[]{고유번호, 플레이수}를 각각의 장르에 추가해주고                
            //max에는 현재 장르의 재생수를 계속해서 더해줍니다.
            if(!map.containsKey(genres[i])){
                ArrayList<int[]> arr = new ArrayList<>();
                arr.add(new int[]{i, plays[i]});    
                map.put(genres[i], arr);

                max.put(genres[i], plays[i]);
            } else {
                map.get(genres[i]).add(new int[]{i, plays[i]});
                
                max.put(genres[i], max.get(genres[i])+plays[i]);
            }
        }
        
        //map의 키들을 가진 리스트를 만들고
        List<String> keys = new ArrayList<>(map.keySet());
        
        //value순으로 내림차순 정렬을 해줍니다. (가장 많이 재생된 장르순)
        keys.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return max.get(o2)-max.get(o1);
            }
        });
        
        //이제 가장 많이 재생된 장르부터 꺼냅니다.
        for(String k : keys){
            ArrayList<int[]> now = map.get(k);
            
            //해당 장르중에서 가장 많이 재생된 노래, 재생 수가 같다면
            //고유번호가 낮은 노래 순으로 정렬해줍니다.
            Collections.sort(now, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[1] != o2[1]){
                        return o2[1]-o1[1];
                    } else {
                        return o1[0]-o2[0];
                    }
                }
            });
            
            //만약 장르내의 노래가 두개 초과라면 가장 앞의 두개만
            //결과에 추가하고 아니라면 모두 추가해줍니다.
            if(now.size()>2){
                for(int i=0; i<2; i++){
                    res.add(now.get(i)[0]);
                }
            } else {
                for(int[] n : now){
                    res.add(n[0]);
                }
            }
        }
        
        //res에 답이 만들어졌습니다. 이를 결과 타입인 int[]으로
        //변환해줍니다.
        int[] answer = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}
