package com.sw;

import java.util.Scanner;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution_SW_D2_1974_스도쿠검증
{
	public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] arr = new int[9][9];
             
            boolean check = true;
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
             
            for(int i=0; i<9; i++){
                if(check){
                    int[] numCol = new int[10];
                    int[] numRow = new int[10];
                    for(int j=0; j<9; j++){
                        if(numCol[arr[i][j]] == 1){
                            check = false;
                            break;
                        } else {
                            numCol[arr[i][j]] = 1;
                        }
                         
                        if(numRow[arr[j][i]] == 1){
                            check = false;
                            break;
                        } else {
                            numRow[arr[j][i]] = 1;
                        }
                    }
                } else {
                    break;
                }
            }
             
            for(int i=0; i<9; i+=3){
                if(check){
                    for(int j=0; j<9; j+=3){
                        int[] num = new int[10];
                        for(int k=0; k<3; k++){
                            for(int l=0; l<3; l++){
                                if(num[arr[i+k][j+l]] == 1){
                                    check = false;
                                    break;
                                } else {
                                    num[arr[i+k][j+l]] = 1;
                                }
                            }
                        }
                    }
                } else {
                    break;
                }
            }
             
            if(!check) {
                System.out.println("#"+test_case+" "+0);
            } else {
                System.out.println("#"+test_case+" "+1);
            }
             
             
        }
        sc.close();
    }
}