package com.swexpertacademy;

import java.util.Scanner;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution_SW_D2_01961_숫자배열회전
{
	public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
             
            int[][] t90 = new int[n][n];
            int[][] t180 = new int[n][n];
            int[][] t270 = new int[n][n];
             
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
             
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    t90[i][j] = arr[n-j-1][i];
                }
            }
             
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    t180[i][j] = t90[n-j-1][i];
                }
            }
             
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    t270[i][j] = t180[n-j-1][i];
                }
            }
             
            StringBuilder sb = new StringBuilder();
             
            sb.append("#"+test_case+"\n");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sb.append(t90[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<n; j++){
                    sb.append(t180[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<n; j++){
                    sb.append(t270[i][j]);
                }
                if(i<n-1){
                    sb.append("\n");    
                }
            }
             
            System.out.println(sb.toString());
        }
        sc.close();
    }
}