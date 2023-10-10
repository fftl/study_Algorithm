package com.codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 메이즈러너 {
    static int N, M, K;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static Exit exit;
    static HashMap<Integer, Person> person;

    static class Person{
        int y, x, id, len;

        public Person(int y, int x, int id, int len) {
            this.y = y;
            this.x = x;
            this.id = id;
            this.len = len;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", id=").append(id);
            sb.append(", len=").append(len);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Exit{
        int y, x;

        public Exit(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Exit{");
            sb.append("y=").append(y);
            sb.append(", x=").append(x);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        person = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int ny = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            person.put(i, new Person(ny, nx, i, 0));
        }

        st = new StringTokenizer(br.readLine());
        int exitY = Integer.parseInt(st.nextToken());
        int exitX = Integer.parseInt(st.nextToken());
        exit = new Exit(exitY, exitX);

        for (int i = 0; i < K; i++){
            run();
        }
    }

    static void run(){
        for(int idx : person.keySet()){
            Person now = person.get(idx);
        }
    }

    static void find(){

    }

    static void turn(){

    }
}
