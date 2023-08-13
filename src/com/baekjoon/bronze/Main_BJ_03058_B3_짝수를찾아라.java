package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_03058_B3_짝수를찾아라 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <7; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now%2==0){
                    min = Math.min(now, min);
                    sum += now;
                }
            }

            System.out.println(sum+" "+min);
        }
    }
}