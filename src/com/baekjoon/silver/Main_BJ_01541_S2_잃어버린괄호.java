package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_01541_S2_잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Character> cmd = new ArrayList<>();
		
		int s = 0;
		int i = 0;
		while (i<str.length()) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				nums.add(Integer.parseInt(str.substring(s, i)));
				cmd.add(str.charAt(i));
				s=i+1;
			}
			i++;
		}
		
		nums.add(Integer.parseInt(str.substring(s, str.length())));
		
		int j=0;
		ArrayList<Integer> minusIdx = new ArrayList<>();
		while(j<cmd.size()) {
			char now = cmd.get(j);
			if(now == '-') {
				for (int k = j+1; k < cmd.size(); k++) {
					char know = cmd.get(k);
					if(know == '-') {
						for (int l =j+1; l <= k; l++) {
							minusIdx.add(l);
						}
						j = k;
						break;
					}
				}
				break;
			}
			j++;
		}
		
		
		for (int l=j+1; l <= cmd.size(); l++) {
			minusIdx.add(l);
		}
		
		int result = 0;
		for (int k = 0; k < nums.size(); k++) {
			if(minusIdx.contains(new Integer(k))) {
				result -= nums.get(k);
			} else {
				result += nums.get(k);
			}
		}
		System.out.println(result);
	}
}
