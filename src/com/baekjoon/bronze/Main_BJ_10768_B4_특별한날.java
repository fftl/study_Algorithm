package com.baekjoon.bronze;

import java.util.*;
import java.io.*;

class Main_BJ_10768_B4_특별한날{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        
        if(month==1 || (month==2 && day<18)){
            System.out.println("Before");
        } else if(month==2 && day==18){
            System.out.println("Special");
        } else {
            System.out.println("After");
        }ㅇ
    }
}