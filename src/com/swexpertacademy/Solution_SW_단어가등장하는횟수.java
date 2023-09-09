package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_단어가등장하는횟수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            int cnt = 0;
            sb.append("#"+tc+" ");
            String b = br.readLine();
            String S = br.readLine();

            for (int i = 0; i < b.length(); i++) {
                int now = 0;
                for (int j = 0; j < S.length(); j++) {
                    if(i+j>=b.length()) break;
                    if(b.charAt(i+j) == S.charAt(j)) now++;
                    else break;
                }
                if(now == S.length()) cnt++;
            }
            sb.append(cnt+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}
