package com.pg;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_PG_L3_다단계칫솔판매 {
    static HashMap<String, String> parent; //부모 관계를 담아줄 맵
    static HashMap<String, Integer> pay;   //현재 판매원의 이익을 담을 맵

	public static void main(String[] args) throws Exception {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(solution(enroll, referral, seller, amount));
	}

	static void dfs(String s, int amount) {

		// center는 금액 계산이 필요없으니 종료해줍니다.
		if (s.equals("-")) {
			return;
		}

		// 만약 현재 금액이 10원보다 적다면 자신(s) 가 모두 가집니다.
		if (amount < 10) {
			pay.put(s, pay.get(s) + amount);
			return;
		}

		// s의 부모에게 줄 금액과 s 본인이 가질 금액을 amount를 이용하여 계산합니다.
		String nParent = parent.get(s);

		int parentMoney = amount / 10; // 부모에게 넘길 금액
		int myMoney = amount - parentMoney; // 본인이 가질 금액

		pay.put(s, pay.get(s) + myMoney); // 본인이 가질 금액을 더해주고

		dfs(nParent, parentMoney); // 부모에게 부모에게 넘길 금액을 넘깁니다.
	}

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        pay = new HashMap<>();
        parent = new HashMap<>();
        
        //부모관계를 담아주고, 각 판매원들의 초기금액 0을 넣어줍니다.
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
            pay.put(enroll[i], 0);
        }
        
        //직접 수익을 낸 seller들을 돌며 dfs를 실행해줍니다.
        for(int i=0; i<seller.length; i++){
            dfs(seller[i], amount[i]*100);
        }

        //이익 배분이 끝나고 answer 배열에 pay의 계산 값들을 모두 넘깁니다.
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = pay.get(enroll[i]);    
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
