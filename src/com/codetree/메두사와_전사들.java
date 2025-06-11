package com.codetree;

import java.util.*;
import java.io.*;
public class 메두사와_전사들 {

    //전사들을 관리하기 위한 Node입니다.
    static class Node{
        int y, x, idx;
        public Node(int y, int x, int idx){
            this.y = y;
            this.x = x;
            this.idx = idx;
        }
    }

    static int N, M, stoneCnt, moveCnt, attackCnt;
    static int[] dy = {-1,  1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board, bCnt, vision;
    static Queue<int[]> root;
    static int[] snk, park;
    static StringBuilder sb;

    static ArrayList<Node> war;
    static boolean[] warCheck;

    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //맵 정보 전사 정보
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //메두사, 공원 위치
        st = new StringTokenizer(br.readLine());

        snk = new int[2];
        park = new int[2];

        snk[0] = Integer.parseInt(st.nextToken());
        snk[1] = Integer.parseInt(st.nextToken());
        park[0] = Integer.parseInt(st.nextToken());
        park[1] = Integer.parseInt(st.nextToken());

        //전사 정보
        st = new StringTokenizer(br.readLine());

        war = new ArrayList<>();
        warCheck = new boolean[M];
        bCnt = new int[N][N];
        for(int i=0; i<M; i++){
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            bCnt[y][x]++;
            war.add(new Node(y, x, i));
        }

        //맵 정보
        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val==1) board[i][j] = -1;
                else board[i][j] = 0;
            }
        }

        //1 start
        root = new LinkedList<>();
        boolean search = rootSearch();
        if(!search){
            // System.out.println(Arrays.deepToString(board));
            // for(int[] a : root){
            //    System.out.println(Arrays.toString(a));
            // }
            System.out.println(-1);
            return;
        }

        //경로 확인
        // for(int[] n : root){
        //     System.out.println(n[0] +","+ n[1]);
        // }

        //1 end

        moveCnt = 0;
        stoneCnt = 0;
        attackCnt = 0;

        sb = new StringBuilder();
        while(true){
            snk = root.poll(); //메두사 다음 위치로 이동

            // System.out.println("현재 메두사 위치 >> " + Arrays.toString(snk));
            // for(Node n : war){
            //     System.out.println("현재 전사 위치 >> "+ n.y+" , "+n.x);
            // }

            snkRootKill();
            if(snk[0] == park[0] && snk[1] == park[1]){
                sb.append(0);
                break;
            }

            // System.out.println("현재 메두사 위치 >> " + Arrays.toString(snk));
            //2, 3, 4
            makeVision();
            warMove();

            sb.append(moveCnt+" "+stoneCnt+" "+attackCnt+"\n");
        }

        System.out.println(sb.toString());
    }

    //이차원 배열 출력
    static void print(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==snk[0] && j==snk[1]) sb.append(8+" ");
                else sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean distance(int ay, int ax, int by, int bx){
        int a = Math.abs(snk[0]-ay) + Math.abs(snk[1]-ax);
        int b = Math.abs(snk[0]-by) + Math.abs(snk[1]-bx);
        if(b<a) return true;
        else return false;
    }

    static void snkRootKill(){
        int size = war.size();
        for(int i=0; i<size; i++){
            if(warCheck[i]) continue;
            Node now = war.get(i);
            if(now.y == snk[0] && now.x == snk[1]){
                bCnt[now.y][now.x]--;
                warCheck[i] = true;
            }
        }
    }

    static void warMove(){
        int size = war.size();
        int mCnt = 0;
        int aCnt = 0;
        run : for(int i=0; i<size; i++){
            if(warCheck[i]) continue;
            Node now = war.get(i);

            //시야에 닿지 않는다면
            if(vision[now.y][now.x] != 1){

                for(int j=0; j<2; j++){
                    for(int k=0; k<4; k++){
                        int ny = j==0? dy[k]+now.y : dx[k]+now.y;
                        int nx = j==0? dx[k]+now.x : dy[k]+now.x;
                        if(0<=ny && ny<N && 0<=nx && nx<N){
                            //메두사에 가까이 이동할 수 있다면.
                            if(distance(now.y, now.x, ny, nx) && vision[ny][nx] != 1){
                                // System.out.println("이동!!");
                                bCnt[now.y][now.x]--;
                                now.y = ny;
                                now.x = nx;
                                mCnt++;
                                if(ny == snk[0] && nx == snk[1]) {
                                    aCnt++;
                                    // System.out.println("공격!!");
                                    warCheck[i] = true;
                                    continue run;
                                }
                                bCnt[now.y][now.x]++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        attackCnt = aCnt;
        moveCnt = mCnt;
    }


    //메두사의 시선 범위 만들기
    static void makeVision(){
        int[][] nVision = new int[N][N];
        // print(bCnt);
        int maxCnt = 0;
        for(int dir=0; dir<4; dir++){
            // System.out.println("------------------");
            int cnt = 0;
            int len = 1;
            while(true){
                int ny = (dy[dir]*len)+snk[0];
                int nx = (dx[dir]*len)+snk[1];

                if(0<=ny && ny<N && 0<=nx && nx<N){
                    if(dir<2){
                        for(int i=nx-len; i<=nx+len; i++){
                            if(0<=i && i<N){
                                if(nVision[ny][i] == 0){
                                    if(bCnt[ny][i] == 0){
                                        nVision[ny][i] = 1;
                                    } else {
                                        cnt+=bCnt[ny][i];
                                        nVision[ny][i] = 1;
                                        subVision(nVision, ny, i, dir);
                                    }
                                }
                            }
                        }

                    } else {
                        for(int i=ny-len; i<=ny+len; i++){
                            if(0<=i && i<N){
                                if(nVision[i][nx] == 0){
                                    if(bCnt[i][nx] == 0){
                                        nVision[i][nx] = 1;
                                    } else {
                                        cnt+=bCnt[i][nx];
                                        nVision[i][nx] = 1;
                                        subVision(nVision, i, nx, dir);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    break;
                }
                len++;
            }
            // System.out.println(cnt);
            // print(nVision);

            if(cnt>maxCnt){
                maxCnt = cnt;
                vision = nVision;
                nVision = new int[N][N];
            }
        }

        stoneCnt = maxCnt;
    }

    //돌이 된 전사로인해 가려지는 시야를 판단합니다.
    static void subVision(int[][] nVision, int y, int x, int dir){
        //상하 시야 체크 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(dir<2){
            //직선상에 있다면
            if(snk[1]==x){
                int len = 1;
                while(true){
                    int ny = (dy[dir]*len)+y;
                    int nx = (dx[dir]*len)+x;
                    if(0<=ny && ny<N){
                        nVision[ny][nx] = -1;
                    } else {
                        break;
                    }
                    len++;
                }
            } else {
                int len = 1;
                if(snk[1]>x){
                    while(true){
                        int ny = (dy[dir]*len)+y;
                        int nx = (dx[dir]*len)+x;
                        if(0<=ny && ny<N){
                            for(int i=x-len; i<=x; i++){
                                if(0<=i) nVision[ny][i] = -1;
                            }
                        } else {
                            break;
                        }
                        len++;
                    }
                } else {
                    while(true){
                        int ny = (dy[dir]*len)+y;
                        int nx = (dx[dir]*len)+x;
                        if(0<=ny && ny<N){
                            for(int i=x; i<=x+len; i++){
                                if(i<N) nVision[ny][i] = -1;
                            }
                        } else {
                            break;
                        }
                        len++;
                    }

                }
            }
            //좌우의 시야 체크 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        } else {
            //직선상에 있다면
            if(snk[0]==y){
                int len = 1;
                while(true){
                    int ny = (dy[dir]*len)+y;
                    int nx = (dx[dir]*len)+x;
                    if(0<=nx && nx<N){
                        nVision[ny][nx] = -1;
                    } else {
                        break;
                    }
                    len++;
                }
            } else {
                int len = 1;
                if(snk[0]>y){
                    while(true){
                        int ny = (dy[dir]*len)+y;
                        int nx = (dx[dir]*len)+x;
                        if(0<=nx && nx<N){
                            for(int i=y-len; i<=y; i++){
                                if(0<=i) nVision[i][nx] = -1;
                            }
                        } else {
                            break;
                        }
                        len++;
                    }
                } else {
                    while(true){
                        int ny = (dy[dir]*len)+y;
                        int nx = (dx[dir]*len)+x;
                        if(0<=nx && nx<N){
                            for(int i=y; i<=y+len; i++){
                                if(i<N) nVision[i][nx] = -1;
                            }
                        } else {
                            break;
                        }
                        len++;
                    }

                }
            }
        }
    }

    //메두사의 이동 경로 구하기
    static boolean rootSearch(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{park[0], park[1]});

        boolean[][] visit = new boolean[N][N];
        visit[park[0]][park[1]] = true;
        int len = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0; i<size; i++){
                int[] now = que.poll();
                board[now[0]][now[1]] = len;

                for(int j=0; j<4; j++){
                    int ny = dy[j]+now[0];
                    int nx = dx[j]+now[1];
                    if(0<=ny && ny<N && 0<=nx && nx<N){
                        if(board[ny][nx] == 0 && !visit[ny][nx]){
                            que.add(new int[]{ny, nx});
                            visit[ny][nx] = true;
                        }
                    }
                }
            }
            len++;
        }

        if(board[snk[0]][snk[1]] == 0) return false;

        int val = board[snk[0]][snk[1]];
        int[] now = new int[]{snk[0], snk[1]};

        while(true){
            for(int i=0; i<4; i++){
                int ny = dy[i] + now[0];
                int nx = dx[i] + now[1];

                if(0<=ny && ny<N && 0<=nx && nx<N){
                    if(board[ny][nx] == val-1){
                        now[0] = ny;
                        now[1] = nx;
                        val = board[ny][nx];
                        break;
                    }
                }
            }

            if(now[0] == park[0] && now[1] == park[1]){
                root.add(new int[]{now[0], now[1]});
                break;
            }  else {
                root.add(new int[]{now[0], now[1]});
            }
        }

        return true;
    }
}
