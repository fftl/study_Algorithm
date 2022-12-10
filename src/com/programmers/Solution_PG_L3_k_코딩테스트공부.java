package com.programmers;

public class Solution_PG_L3_k_코딩테스트공부 {

	public static void main(String[] args) throws Exception {
		int alp = 10;
		int cop = 10;
		int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
		System.out.println(solution(alp, cop, problems));
	}

	static int[][] init(int[][] dp){
        for(int i=0; i<200; i++){
            for(int j=0; j<200; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return dp;
    }
	
	static int solution(int alp, int cop, int[][] problems) {
        // int tAlp = -1; int tCop = -1;
        /* 위처럼 초기화를 해놓을 경우 for문에서 찾아낸 tAlp와 tCop중 하나만 초기값보다 크면
        if 종료문을 회피하게 되며 초기값 보다 작은 다른쪽은 잘못된 목표 값을 가진채 계산에 들어가게 됩니다.*/
        int tAlp = alp; int tCop = cop;
        
        for(int i=0; i<problems.length; i++){
            tAlp = Math.max(tAlp, problems[i][0]);
            tCop = Math.max(tCop, problems[i][1]);
        }
        
        if(tAlp<=alp && tCop<=cop){
            return 0;
        }
        
        int[][] dp = new int[200][200];
        dp = init(dp);
        dp[alp][cop] = 0;
        
        for(int i=alp; i<151; i++){
            for(int j=cop; j<151; j++){
                
                int just = dp[i][j]+1;
                //문제를 풀지않고 1시간을 들여 코딩력, 알고력을 증가시키켜줍니다.
                dp[i+1][j] = Math.min(just, dp[i+1][j]);
                dp[i][j+1] = Math.min(just, dp[i][j+1]);
                
                //모든 문제를 확인하며 풀수 있는 문제 일 경우 풀어봅니다.
                for(int k=0; k<problems.length; k++){
                    int[] nowPro = problems[k];
                    
                    //풀 수 있는 문제일 때
                    if(nowPro[0]<=i && nowPro[1]<=j){
                        
                        //알고코딩 둘다 초과할 때
                        if(i+nowPro[2]>=tAlp && j+nowPro[3]>=tCop){
                            dp[tAlp][tCop] = Math.min(dp[tAlp][tCop], dp[i][j]+nowPro[4]);
                            
                        //알고력만 초과할 때
                        } else if(i+nowPro[2]>tAlp && j+nowPro[3]<tCop){
                            dp[tAlp][j+nowPro[3]] = Math.min(dp[tAlp][j+nowPro[3]], dp[i][j]+nowPro[4]); 
                        
                        //코딩력만 초과할 때
                        } else if(i+nowPro[2]<tAlp && j+nowPro[3]>tCop){
                            dp[i+nowPro[2]][tCop] = Math.min(dp[i+nowPro[2]][tCop], dp[i][j]+nowPro[4]);
                        
                        //둘다 안넘을때
                        } else{
                            dp[i+nowPro[2]][j+nowPro[3]] = Math.min(dp[i+nowPro[2]][j+nowPro[3]], dp[i][j]+nowPro[4]);    
                        }
                    }
                }
            }
        }
        
        return dp[tAlp][tCop];
    }
}
