package com.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 포탑부수기 {

    static int N, M, K, min, max;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[] ady = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] adx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Turret[][] board;
    static Turret attacker, target;

    static class Node{
        int y, x;
        String root;
        public Node(String root, int y, int x){
            this.root = root;
            this.y = y;
            this.x = x;
        }
    }

    static class Turret{
        int power, recent, y, x;
        boolean yes; //이번 턴에 공격하거나 피해를 받았는지
        public Turret(int power, int recent, int y, int x, boolean yes){
            this.power = power;
            this.recent = recent;
            this.y = y;
            this.x = x;
            this.yes = yes;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Turret{");
            sb.append("power=").append(power);
            sb.append(", recent=").append(recent);
            sb.append(", y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", yes=").append(yes);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new Turret[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = new Turret(Integer.parseInt(st.nextToken()), 0, i, j, false);
            }
        }

        for (int i = 0; i < K; i++) {
            //공격자와 타겟을 먼저 찾습니다.
            findMin();
            findMax();

            //
        }
    }

    static void findMin(){
        ArrayList<Turret> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j].power == min){
                    list.add(board[i][j]);
                }
            }
        }

        //가장 낮은 포탑이 하나 이상이라면
        if(list.size()>1){
            list.sort(new Comparator<Turret>() {
                @Override
                public int compare(Turret o1, Turret o2) {

                    //가장 최근에 공격한 포탑이 두개 이상이라면
                    if(o1.recent == o2.recent){
                        //각 포탑의 위치의 행과 열의 합이 같다면
                        if((o1.y+o1.x) == (o2.y+o2.x)){
                            return o2.x-o1.x;
                        } else {
                            return (o2.y+o2.x) - (o1.y+o1.x);
                        }
                    } else {
                        return o2.recent-o1.recent;
                    }
                }
            });
        }

        attacker = list.get(0);
    }

    static void findMax(){
        ArrayList<Turret> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j].power == max){
                    list.add(board[i][j]);
                }
            }
        }

        //가장 낮은 포탑이 하나 이상이라면
        if(list.size()>1){
            list.sort(new Comparator<Turret>() {
                @Override
                public int compare(Turret o1, Turret o2) {

                    //가장 최근에 공격한 포탑이 두개 이상이라면
                    if(o1.recent == o2.recent){
                        //각 포탑의 위치의 행과 열의 합이 같다면
                        if((o1.y+o1.x) == (o2.y+o2.x)){
                            return o1.x-o2.x;
                        } else {
                            return (o1.y+o1.x) - (o2.y+o2.x);
                        }
                    } else {
                        return o1.recent-o2.recent;
                    }
                }
            });
        }

        target = list.get(0);
    }

    static void attack(){
        Turret t = attacker;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Node("", t.y, t.x));
        boolean laser = false;
        while(!q.isEmpty()){
            Node now = q.poll();

            //목적지를 찾았다면!!
            if(now.y == target.y && now.x == target.x){
                laserAttack(t.power+N+M, now.root);
                laser = true;
            } else {
                for (int i = 0; i < 4; i++) {
                    int ny = (now.y + dy[i])%N;
                    int nx = (now.x + dx[i])%M;

                    //방문하지 않았고, 파워가 0 이상일 경우만 방문할 수 있다.
                    if(board[ny][nx].power != 0 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new Node(now.root+"/"+now.y+","+now.x, ny, nx));
                    }
                }
            }
        }

        //레이저를 쏘지 못했다면
        if(!laser){

        }
    }

    //레이저 어택!
    static void laserAttack(int power, String root){

    }
}
