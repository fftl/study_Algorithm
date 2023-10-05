package com.codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class 토끼와경주 {

    static class Rabbit{
        int jump, y, x, id, d;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Rabbit{");
            sb.append("jump=").append(jump);
            sb.append(", y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", id=").append(id);
            sb.append(", d=").append(d);
            sb.append('}');
            return sb.toString();
        }

        public Rabbit(int jump, int y, int x, int id, int d) {
            this.jump = jump;
            this.y = y;
            this.x = x;
            this.id = id;
            this.d = d;
        }
    }

    //두개를 선언해 놓은 이유가 무엇일까?
    static TreeSet<Rabbit> set;
    static ArrayList<Rabbit> all;
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            String[] strs = br.readLine().split(" ");
            int key = Integer.parseInt(strs[0]);

            if(key == 100) init(strs);
            else if(key == 400) end(strs);
            else run(strs);
        }

    }

    static void init(String[] strs){

        set = new TreeSet<>(new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                return 0;
            }
        });
        all = new ArrayList<>();

        N = Integer.parseInt(strs[1]);
        M = Integer.parseInt(strs[2]);

        int t = Integer.parseInt(strs[3]);

        int idx = 4;
        while(idx<strs.length){
            all.add(new Rabbit(0, 0, 0, Integer.parseInt(strs[idx++]), Integer.parseInt(strs[idx++])));
        }
        for (Rabbit r : all) set.add(r);
    }
    static void end(String[] strs){

    }

    static void run(String[] strs){
    	int round = Integer.parseInt(strs[1]); //라운드 수
    	
    	//각 라운드를 진행합니다.
    	for (int i = 0; i < round; i++) {
			
		}
    }
}
