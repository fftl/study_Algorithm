package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_04991_G1_로봇청소기_other {
	public static int n,m;
    public static int dy[] = {0, 0, -1, 1}; //, 1, 1, -1, -1
    public static int dx[] = {1, -1, 0, 0}; //, 1, -1, 1, -1
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int answer = 0;
    public static List<int[]> dirties;
    public static char[][] board;
    public static int[][] startToDirtiesDist;
    public static int[][][] distBetweenDirties;
    public static int[] order;
    public static boolean[] visited;

    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //11:59
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            if(n==0 && m==0) break;

            board = new char[n][m];
            dirties = new ArrayList<>();
            startToDirtiesDist=new int[n][m];
            int[] start=null;

            //시작위치 찾기
            for(int i=0; i<n;i++){
                String row = br.readLine();
                for(int j=0; j<m;j++){
                    board[i][j] = row.charAt(j);
                    if (board[i][j] == 'o') {
                        start = new int[]{i, j};
                    }
                    if (board[i][j] == '*') {
                        dirties.add(new int[]{i, j});
                    }
                }
            }
            
            //각각 배열 초기화?
            order = new int[dirties.size()];
            visited = new boolean[dirties.size()];
            Arrays.fill(order, -1);
            distBetweenDirties = new int[dirties.size()][n][m];

            calculateDist(start);
            solve(start,0);
            if (answer == Integer.MAX_VALUE) {
                answer = -1;
            }
            System.out.println(answer);
        }
    }

    //여기서 순열을 통해서 순서대로 방문하는 작업을 진행합니다. 
    public static void solve(int[] start, int cnt) {
        if (cnt == dirties.size()) {
            int sum = sumDist();
            answer = Math.min(answer,sum);
            return;
        }

        for(int i=0; i<dirties.size();i++){
            if(visited[i]) continue;
            order[cnt]=i;
            visited[i]=true;
            solve(start, cnt+1);
            visited[i]=false;
        }
    }

    //순서가 모두 정해지면 해당 순서대로 방문했을 때 얼마의 시간?이 걸리는지 계산합니다.
    private static int sumDist() {
        int sum =0;
        int[] nxt=null;
        int curMark= order[0];
        sum += startToDirtiesDist[dirties.get(order[0])[0]][dirties.get(order[0])[1]];
        for(int i=1; i<dirties.size();i++){
            nxt = dirties.get(order[i]);
            if (distBetweenDirties[curMark][nxt[0]][nxt[1]] == -1) {
                return Integer.MAX_VALUE;
            }
            sum+= distBetweenDirties[curMark][nxt[0]][nxt[1]];
            curMark= order[i];
        }
        return sum;
    }

    //각각의 거리를 계산합니다.
    public static void calculateDist(int[] startLoc) {
    	
    	//시작점과 더러운 위치까지의 거리를 각각 구합니다.
        bfs(startLoc, startToDirtiesDist);
        
        //더러운 위치끼리의 거리를 구합니다!
        for(int i=0; i<dirties.size();i++){
            bfs(dirties.get(i), distBetweenDirties[i]);
        }
    }

    //bfs를 이용해서 두 지점사이의 최단거리를 구합니다.
    public static void bfs(int[] start, int[][] distArr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        for(int i=0; i<distArr.length;i++){
            Arrays.fill(distArr[i], -1);
        }
        distArr[start[0]][start[1]]=0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0;dir<4;dir++){
                int ny = dy[dir]+cur[0];
                int nx = dx[dir]+cur[1];

                if(ny<0 || ny>=n ||nx<0 ||nx>=m) continue;
                if(distArr[ny][nx]!= -1|| board[ny][nx]=='x') continue;
                distArr[ny][nx]=distArr[cur[0]][cur[1]]+1;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
