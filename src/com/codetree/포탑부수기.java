package com.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 포탑부수기 {

    static int N, M, K, min, max, cnt;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", root='").append(root).append('\'');
            sb.append('}');
            return sb.toString();
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

        min = Integer.MAX_VALUE;
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int power = Integer.parseInt(st.nextToken());
                if(power>0) min = Math.min(min, power);
                max = Math.max(max, power);
                board[i][j] = new Turret(power, 0, i, j, false);
            }
        }

        for (int i = 1; i <= K; i++) {
            findMin(i);
            findMax();
            attacker.power += N+M;
            attack();
            repair();
            if(cnt == 1) break;
        }

        System.out.println(max);
    }
    static void printPower(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j].power+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void repair(){
        min = Integer.MAX_VALUE;
        max = 0;
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Turret now = board[i][j];
                //파괴되지 않은 터렛에 대해서만 판단합니다.
                if(now.power>0){
                    cnt++;
                    if(now.yes) now.yes = false;
                    else {
                        now.power++;
                    }
                    min = Math.min(min, now.power);
                    max = Math.max(max, now.power);
                }
            }
        }
    }

    static void findMin(int idx){
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

        list.get(0).recent = idx;
        attacker = list.get(0);
        attacker.yes = true;
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
            list.sort( new Comparator<Turret>() {
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
        target.yes = true;
    }

    static void attack(){
        Turret at = attacker;
        Turret t = target;

        int power = at.power;
        int hPower = power/2;

        //이제 표적까지의 최단 경로를 찾아봅니다.
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Node("", at.y, at.x));
        boolean laser = false;

        while(!q.isEmpty()){
            Node now = q.poll();
            //목적지를 찾았다면!!
            if(now.y == t.y && now.x == t.x){
                laserAttack(power, hPower, now.root);
                laser = true;
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    int ny = (now.y + dy[i])%N;
                    int nx = (now.x + dx[i])%M;

                    if(ny<0) ny = N-1;
                    if(nx<0) nx = M-1;

                    //방문하지 않았고, 파워가 0 이상일 경우만 방문할 수 있다.
                    if(board[ny][nx].power != 0 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new Node(now.root+"/"+now.y+","+now.x, ny, nx));
                    }
                }
            }
        }

        //레이저를 쏘지 못했다면
        //타겟과 타겟에 인접한 8방향에 공격을 합니다.
        if(!laser){
            for (int i = 0; i < 8; i++) {
                int ny = (t.y + ady[i])%N;
                int nx = (t.x + adx[i])%M;

                if(ny<0) ny = N-1;
                if(nx<0) nx = M-1;

                if(ny==at.y && nx==at.x) continue;

                if(board[ny][nx].power != 0){
                    if(board[ny][nx].power - hPower >= 0) board[ny][nx].power -= hPower;
                    else board[ny][nx].power = 0;

                    board[ny][nx].yes = true;
                }
            }
        }

        //표적은 레이저, 포탄 상관 없이 마지막에 공격해줍니다.
        if(board[t.y][t.x].power - power >= 0) board[t.y][t.x].power -= power;
        else board[t.y][t.x].power = 0;

        board[t.y][t.x].yes = true;
    }

    //레이저 어택!
    static void laserAttack(int power, int hPower, String root){
        String[] roots = root.split("/");

        //0번 index는 공백, 1번 index는 attack 위치이기 때문에 건너뜁니다.
        for (int i = 2; i < roots.length; i++) {
            String[] point = roots[i].split(",");

            int ny = Integer.parseInt(point[0]);
            int nx = Integer.parseInt(point[1]);

            if(board[ny][nx].power - hPower >= 0) board[ny][nx].power -= hPower;
            else board[ny][nx].power = 0;

            board[ny][nx].yes = true;
        }
    }
}
