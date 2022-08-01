package com.ssafy.before;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class 서울_13반_이동민_2001
{
	public static void main(String args[]) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T=Integer.parseInt(br.readLine());
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
             
            int max = 0;
             
            int[][] board = new int[n][n];
             
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0; i<n-m+1; i++){
                for(int j=0; j<n-m+1; j++){
                    int now = 0;
                    for(int a=0; a<m; a++){
                        for(int b=0; b<m; b++){
                            now += board[i+a][j+b];
                        }
                    }
                     
                    max = Math.max(now, max);
                }
            }
             
            System.out.println("#"+test_case+" "+max);
 
        }
    }
}