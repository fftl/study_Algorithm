package com.codetree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class 코드트리_등산_게임 {
    static int Q;
    static ArrayList<Integer> board;
    static int[] dp;

    static void init(String[] strs){
        board = new ArrayList<>();
        for(int i=2; i<strs.length; i++){
            board.add(Integer.parseInt(strs[i]));
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
            String[] strs = br.readLine().split(" ");
            if(strs[0].equals("100")){
                // System.out.println("100 ---");
                init(strs);
                // System.out.println(board);
            } else if(strs[0].equals("200")){
                // System.out.println("200 ---");
                board.add(Integer.parseInt(strs[1]));
                // System.out.println(board);
            } else if(strs[0].equals("300")){
                // System.out.println("300 ---");
                board.remove(board.size()-1);
                // System.out.println(board);
            } else {
                // System.out.println("400 ---");
                // System.out.println(board);
                sb.append(run(Integer.parseInt(strs[1]))+"\n");
            }
        }

        System.out.println(sb.toString());
    }

    //케이블카는 무조건 타는게 이득.
    //케이블카가 어디 있던 케이블카 까지의 LIS를 구한다.
    //케이블카에 도착하면 이제 전체에 대한 LIS를 구한다. 끝?
    static long run(int cable){
        long result = 0;
        dp = new int[cable];
        Arrays.fill(dp, 1000000); //중요
        int LIS = 0;
        for(int i=cable-1; 0<=i; i--){
            if(i!=cable-1 && board.get(i)>=board.get(cable-1)){
                continue;
            }
            int idx = binary(0, LIS, board.get(i), LIS+1, true);
            if(idx == -1) {
                dp[LIS++] = board.get(i);
            }
            else {
                dp[idx] = board.get(i);
            }
        }

        result += LIS * 1000000;

        dp = new int[board.size()];
        LIS = 0;
        int max = 0;
        for(int i=0; i<board.size(); i++){
            int idx = binary(0, LIS, board.get(i), LIS+1, false);
            if(idx == -1) {
                max = board.get(i);
                dp[LIS++] = board.get(i);
            }
            else {
                dp[idx] = board.get(i);
            }
        }

        result += (LIS-1) * 1000000;
        return result+max;
    }


    static int binary(int s, int e, int val, int size, boolean k){
        int res = 0;
        while(s<=e){
            int mid = (s+e)/2;
            if(k){
                if(val>=dp[mid]){
                    res = mid;
                    e = mid - 1;
                } else{
                    s = mid + 1;
                }

            } else {
                if(val<=dp[mid]){
                    res = mid;
                    e = mid - 1;
                } else{
                    s = mid + 1;
                }
            }
        }

        if(s == size){
            return -1;
        } else {
            return res;
        }
    }
}
