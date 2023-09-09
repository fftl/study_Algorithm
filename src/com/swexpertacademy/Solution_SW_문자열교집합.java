package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_SW_문자열교집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int tc = 1; tc <= T; tc++)
        {
            set = new HashSet<>();
            sb.append("#"+tc+" ");
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                set.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                if(set.contains(st.nextToken())) cnt++;
            }

            sb.append(cnt+"\n");

        }

        System.out.println(sb.toString().trim());
    }
}
