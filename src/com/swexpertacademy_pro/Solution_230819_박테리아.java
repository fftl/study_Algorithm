package com.swexpertacademy_pro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_230819_박테리아 {

    //박테리아 정보를 담은 클래스
    static class Bac{
        int bId; //박테리아 아이디
        int y, x; //박테리아 중심
        int ny, nx; //현재 박테리아 위치
        int size; //박테리아 크기
        int time; //박테리아 수명
        int endTime; //박테리아 수명 만료 시간

        public Bac(int bId, int y, int x, int ny, int nx, int size, int time, int endTime) {
            this.bId = bId;
            this.y = y;
            this.x = x;
            this.ny = ny;
            this.nx = nx;
            this.size = size;
            this.time = time;
            this.endTime = endTime;
        }
    }

    //bId 박테리아의 모든 좌표를 구합니다.
    static class DelBac{
        int bId; //박테리아 id
        int endTime; //소멸 시간
        ArrayList<int[]> list = new ArrayList<>(); //해당 박테리아의 좌표를 담아주어 바로 제거할 수 있도록 합니다.

        public DelBac(int bId, int endTime) {
            this.bId = bId;
            this.endTime = endTime;
        }
    }

    static PriorityQueue<DelBac> delBacs;
    static int[][] map; //박테리아id 를 이용하여 현 박테리아 현황을 표시.
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int Y, X;

    //초기화
    static void init(int Y, int X){

        //삭제 박테리아 리스트는 만료시간의 오름차순으로 우선순위 큐를 생성하였습니다.
        delBacs = new PriorityQueue<>(new Comparator<DelBac>() {
            @Override
            public int compare(DelBac o1, DelBac o2) {
                return o1.endTime-o2.endTime;
            }
        });
        map = new int[Y][X];

    }

    //박테리아 생성
    //가장 마지막에 생성된 박테리아의 위치를 반환합니다.
    //생성할 수 없을 경우 0,0을 반환합니다.
    static int[] put(int mTime, int bId, int mY, int mX, int mSize, int time){
        remove(mTime);

        //만약 중심위치가 0이 아닐 경우 바로 0,0으로 반환해주어 끝냅니다.
        if(map[mY][mX] != 0){
            return new int[]{0,0};
        }

        PriorityQueue<Bac> pq = new PriorityQueue<>( new Comparator<Bac>() {
            @Override
            public int compare(Bac o1, Bac o2) {
                if(Math.abs(o1.y-o1.ny)+Math.abs(o1.x-o1.nx) == Math.abs(o2.y-o2.ny)+Math.abs(o2.x-o2.nx)){ //맨허튼 거리가 같다면
                    if(o1.ny==o2.ny){ //Y축이 같다면
                        //x축 오름차순
                        return o1.x-o2.x;
                    } else {
                        //y축 오름차순
                        return o1.y-o2.y;
                    }
                } else {
                    //맨허튼 거리 오름차순
                    return Math.abs(o1.y-o1.ny)+Math.abs(o1.x-o1.nx) - Math.abs(o2.y-o2.ny)+Math.abs(o2.x-o2.nx);
                }
            }
        });

        Queue<int[]> q = new PriorityQueue<>(); //실제로 생성되는 박테리아만 담아줄 q입니다.
        pq.add(new Bac(bId, mY, mX, mY, mX, mSize, time, mTime+time));

        boolean[][] visited = new boolean[Y][X];
        visited[mY][mX] =  true;

        while(!pq.isEmpty()){
            Bac now = pq.poll(); //poll로 꺼낸다는 것 자체가 여기는 확실히 박테리아가 놓여질 수 있다는 것.
            q.add(new int[]{now.ny, now.nx});

            if(q.size() == mSize) break; //모든 박테리아를 퍼트렸음! while을 더 돌 필요가 없습니다.

            for (int i = 0; i < 4; i++) {
                int ny = now.ny + dy[i];
                int nx = now.nx + dx[i];
                if(0<=ny && ny<Y && 0<=nx && nx<X && !visited[ny][nx] && map[ny][nx] == 0){
                    pq.add(new Bac(bId, mY, mX, ny, nx, mSize, time, mTime+time));
                    visited[ny][nx] = true;
                }
            }
        }

        //위의 while 을 다 돌았지만 q의 크기가 채워지지 않았다면 박테리아
        //생성 불가!
        if(q.size()<mSize){
            return new int[]{0,0};
        }

        int lastY = -1;
        int lastX = -1;

        DelBac delBac = new DelBac(bId, mTime+time);

        //실제 놓을 수 있는 박테리아들을 map에 표시해주고,
        //삭제를 편하게 하기위한 delBac의 리스트에 좌표를 추가해줍니다.
        while(!q.isEmpty()){
            int[] now = q.poll();
            map[now[0]][now[1]] = bId;
            delBac.list.add(new int[]{now[0],now[1]});

            //q가 비었다면 현재 now 좌표가 가장 마지막에 생성된 박테리아 위치 라는 것
            //last에 담아줍니다.
            if(q.isEmpty()){
                lastY = now[0];
                lastX = now[1];
            }
        }

        //last 좌표를 반환!
        return new int[]{lastY, lastX};
    };

    //박테리아 확인
    //해당 좌표 확인 후 0이면 0반환 아니면 아닌 값 반환
    static int check(int mTime, int mY, int mX){
        remove(mTime);
        if(map[mY][mX] == 0){
            return 0;
        }

        return map[mY][mX];
    };

    //박테리아 제거
    //해당 좌표 확인 후 0이면 0반환 아니면 아닌 값 담아두고 0으로 변경 아닌 값 반환
    static int kill(int mTime, int mY, int mX){
        remove(mTime);
        if(map[mY][mX] == 0){
            return 0;
        }

        int res = map[mY][mX];
        map[mY][mX] = 0;

        return res;
    }

    static void remove(int nowTime){
        //시간이 초과한 모든 박테리아들의 좌표를 꺼내어 0으로 변경해줍니다.
        while(delBacs.peek().endTime<=nowTime){
            DelBac delBac = delBacs.poll();
            for (int i = 0; i < delBac.list.size(); i++) {

                //만약 map에 입력된 박테리아 아이디와 delBacs의 박테리아 아이디가 같다면 해당 박테리아를 삭제(0처리) 해줍니다.
                //다르다면 kill 당한 이후 다른 박테리아가 해당 위치에 새로 생성된 것! 걔는 지우면 안됩니다.
                if(map[delBac.list.get(i)[0]][delBac.list.get(i)[1]] == delBac.bId) map[delBac.list.get(i)[0]][delBac.list.get(i)[1]] = 0;
            }
        }
    }
}
