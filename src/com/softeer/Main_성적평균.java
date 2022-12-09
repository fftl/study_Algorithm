package com.softeer;

import java.util.*;
import java.io.*;


public class Main_성적평균
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n+1];
        int[] sums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sums[1] = nums[1];
        for(int i=2; i<=n; i++){
            sums[i] = sums[i-1]+nums[i];
        }

        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(sums));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            double sum = sums[e] - sums[s-1];
            sb.append(String.format("%.2f", sum/(e-(s-1)))+"\n");
        }

        System.out.println(sb.toString());
    }
}