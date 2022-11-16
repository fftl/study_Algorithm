package com.pg;

public class Solution_PG_L0_옹알이1 {

	public static void main(String[] args) throws Exception {
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		System.out.println(solution(babbling));
	}

	static int solution(String[] babbling) {
        int answer = 0;
        
        String[] able = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            String now = babbling[i];
            for(int j=0; j<4; j++){
                now = now.replace(able[j], " ");
            }
            if(now.trim().equals("")){
                answer++;
            }
        }
        return answer;
    }
}
