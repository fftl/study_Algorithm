package com.swexpertacademy_pro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_230819_박테리아 {

    //박테리아 정보를 담은 클래스
    static class Bac{
        int bId; //박테리아 아이디
        int y, x; //박테리아 중심
        int size; //박테리아 크기
        int time; //박테리아 수명
        int endTime; //박테리아 수명 만료 시간
    }

    //bId 박테리아의 모든 좌표를 구합니다.
    static class DelBac{
        int bId;
        int endTime;
        ArrayList<int[]> list = new ArrayList<>();
    }

    static PriorityQueue<DelBac> delBacs;
    static int[][] map;
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
    static void put(int mTime, int mY, int mX, int size, int time){
        remove(mTime);
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
                //다르다면 kill 당한 이후 다른 박테리아가 해당 위치에 새로 생성된 것!
                if(map[delBac.list.get(i)[0]][delBac.list.get(i)[1]] == delBac.bId) map[delBac.list.get(i)[0]][delBac.list.get(i)[1]] = 0;
            }
        }
    }
}
