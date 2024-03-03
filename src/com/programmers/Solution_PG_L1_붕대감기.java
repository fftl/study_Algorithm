package com.programmers;

//1초부터 실제로 피해량을 줄여주고, 회복량은 증가시켜주며
//직접 체력의 증감을 적용해 보면서 확인했습니다.
public class Solution_PG_L1_붕대감기 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2,10}, {9, 15}, {10, 5}, {11, 5}}));
	}

	public static int solution(int[] bandage, int health, int[][] attacks) {
		int maxHealth = health;
		int cool = bandage[0];
		int sheal = bandage[1];
		int plusHeal = bandage[2];

		int now = 0;
		int end = attacks[attacks.length-1][0];
		int attackIdx = 0;

		for(int i=1; i<=end; i++){
			int[] nowAttack = attacks[attackIdx];

			//공격이 오는 시간이라면?
			if(nowAttack[0] == i){
				now = 0;
				health -= nowAttack[1];

				if(health <= 0) return -1;

				attackIdx++;

			} else {
				now += 1;
				if(now == cool){
					health = (health + sheal + plusHeal) >= maxHealth ? maxHealth : health + sheal + plusHeal;
					now = 0;
				} else {
					health = (health + sheal) >= maxHealth ? maxHealth : health + sheal;
				}
			}


			// System.out.println(i+"초 >> "+health + ", 연속공격 >> " + now);
		}



		return health;
	}
}
