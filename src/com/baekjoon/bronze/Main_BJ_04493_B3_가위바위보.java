package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_04493_B3_가위바위보 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++){
			int v = Integer.parseInt(br.readLine());
			int a = 0;
			int b = 0;
			for(int j=0; j<v; j++){
				st = new StringTokenizer(br.readLine());
				String ac = st.nextToken();
				String bc = st.nextToken();
				int c = check(ac, bc);
				if(c==1) a++;
				else if(c==2) b++;
			}

			if(a>b) System.out.println("Player "+1);
			else if(a<b) System.out.println("Player "+2);
			else System.out.println("TIE");
		}
	}

	static int check(String a, String b){
		if(a.equals("R")){
			if(b.equals("R")) return 0;
			else if(b.equals("S")) return 1;
			else if(b.equals("P")) return 2;
		}

		if(a.equals("S")){
			if(b.equals("S")) return 0;
			else if(b.equals("P")) return 1;
			else if(b.equals("R")) return 2;
		}

		if(a.equals("P")){
			if(b.equals("P")) return 0;
			else if(b.equals("R")) return 1;
			else if(b.equals("S")) return 2;
		}

		return -1;
	}
}
