package com.pg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_PG_L1 {

	public static void main(String[] args) throws Exception {

		String today = "2020.01.01"; 
		String[] terms = {"Z 3", "D 5"}; 
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		int[] r = solution(today, terms, privacies);
		System.out.println(Arrays.toString(r));
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String[] tdStr = today.split("[.]");
        int[] td = {Integer.parseInt(tdStr[0]), Integer.parseInt(tdStr[1]), Integer.parseInt(tdStr[2])};

        for(int i=0; i<terms.length; i++){
            String[] strs = terms[i].split(" ");
            map.put(strs[0], Integer.parseInt(strs[1]));
        }

        for(int i=0; i<privacies.length; i++){
            String[] strs = privacies[i].split(" ");
            String[] nStrDay = strs[0].split("[.]");
            int[] nowDay = {Integer.parseInt(nStrDay[0]), Integer.parseInt(nStrDay[1]), Integer.parseInt(nStrDay[2])};
            int term = map.get(strs[1]);

            int pyear = nowDay[0] + term/12;
            int pmonth = nowDay[1] + term%12;
            int pday = nowDay[2]-1;
            if(pmonth>12) {
            	pyear+=1;
            	pmonth-=12;
            }
            if(pday==0) {
            	pday = 28;
            	pmonth-=1;
            	if(pmonth==0) {
            		pmonth = 12;
            		pyear-=1;
            	}
            }
            
            //"2020.01.01";
            System.out.println(pyear+","+pmonth+","+pday);
            if(pyear<td[0]){
                result.add(i+1);
            } else if(pyear==td[0] && pmonth<td[1]){
                result.add(i+1);
            } else if(pmonth==td[1] && pday<td[2]){
                result.add(i+1);
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
