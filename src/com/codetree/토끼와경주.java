package com.codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 토끼와경주 {

    static class Rabbit{
        int jump, y, x, id, d, point;
        boolean turn;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Rabbit{");
            sb.append("jump=").append(jump);
            sb.append(", y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", id=").append(id);
            sb.append(", d=").append(d);
            sb.append(", point=").append(point);
            sb.append(", turn=").append(turn);
            sb.append('}');
            return sb.toString();
        }

        public Rabbit(int jump, int y, int x, int id, int d, int point, boolean turn) {
            this.jump = jump;
            this.y = y;
            this.x = x;
            this.id = id;
            this.d = d;
            this.point = point;
            this.turn = turn;
        }
    }

    //두개를 선언해 놓은 이유가 무엇일까?
    static PriorityQueue<Rabbit> set;
    static HashMap<Integer, Rabbit> all;
    static int N, M;
    static long sumPoint;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            String[] strs = br.readLine().split(" ");
            int key = Integer.parseInt(strs[0]);

            if(key == 100) init(strs);
            else if(key == 400) end(strs);
            else if(key == 300) plus(strs);
            else run(strs);
        }
//        System.out.println("마지막 정리!!");
//        System.out.println(sumPoint);
//        System.out.println(all.toString());
    }

    static void init(String[] strs){
        set = new PriorityQueue<>(new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                if (o1.jump == o2.jump) {
                    if ((o1.y + o1.x) == (o2.y + o2.x)) {
                        if (o1.y == o2.y) {
                            if(o1.x == o2.x){
                                return o1.id-o2.id;
                            } else {
                                return o1.x - o2.x;
                            }
                        } else {
                            return o1.y - o2.y;
                        }
                    } else {
                        return (o1.y + o1.x) - (o2.y + o2.x);
                    }
                } else {
                    return o1.jump - o2.jump;
                }
            }
        });
        all = new HashMap<>();

        N = Integer.parseInt(strs[1]);
        M = Integer.parseInt(strs[2]);
        sumPoint = 0;

        int t = Integer.parseInt(strs[3]);

        int idx = 4;
        while(idx<strs.length){
            int id = Integer.parseInt(strs[idx++]);
            int d = Integer.parseInt(strs[idx++]);
            all.put(id, new Rabbit(0, 1, 1, id, d,0,false));
        }

        for (int key : all.keySet()){
            set.add(all.get(key));
        }
    }
    static void end(String[] strs){
        long max = 0;
        for (int idx : all.keySet()) {
            max = Math.max(max, all.get(idx).point+sumPoint);
        }
        System.out.println(max);
    }

    static void run(String[] strs){
//        System.out.println("200 시작 ---------------------------------------------");
    	int round = Integer.parseInt(strs[1]); //라운드 수

    	//각 라운드를 진행합니다.
    	for (int i = 0; i < round; i++) {
            PriorityQueue<Rabbit> move = new PriorityQueue<>( new Comparator<Rabbit>() {
                @Override
                public int compare(Rabbit o1, Rabbit o2) {
                    if((o1.y+o1.x) == (o2.y+o2.x)){
                        if(o1.y==o2.y){
                            return o2.x-o1.x;
                        } else {
                            return o2.y-o1.y;
                        }
                    } else {
                        return (o2.y+o2.x) - (o1.y+o1.x);
                    }
                }
            });

            Rabbit rabbit = set.poll(); //우선순위에 따라 이번에 이동해야 할 토끼를 뽑습니다.
//            System.out.println("이번에 이동할 토끼는 >>"+rabbit);
            for (int j = 0; j < 4; j++) {
                // 세로방향 이동 할 때
                Rabbit nRabbit = new Rabbit(rabbit.jump, rabbit.y, rabbit.x, rabbit.id, rabbit.d, rabbit.point, rabbit.turn);
                if(j==0){
                    //꺾어 돌아올 필요가 없다면
                    if(N - nRabbit.y >= nRabbit.d){
                        nRabbit.y += nRabbit.d;
                        move.add(nRabbit);

                        //꺾어 돌아와야 한다면?
                    } else {
                        int len = nRabbit.d - (N-nRabbit.y);
                        int turn = len/(N-1);

                        //역방향으로 돌아오고 있다면
                        if(turn%2==0){
                            nRabbit.y = N-(len%(N-1));
                        } else {
                            nRabbit.y = len%(N-1)+1;
                        }
                        move.add(nRabbit);
                    }
                } else if(j==1) {

                    //꺾어 돌아올 필요가 없다면
                    if(nRabbit.y-nRabbit.d >= 1){
                        nRabbit.y -= nRabbit.d;
                        move.add(nRabbit);

                        //꺾어 돌아와야 한다면?
                    } else {
                        int len = nRabbit.d - (nRabbit.y-1);
                        int turn = len/(N-1);

                        //역방향으로 돌아오고 있다면
                        if(turn%2==0){
                            nRabbit.y = len%(N-1)+1;
                        } else {
                            nRabbit.y = N-(len%(N-1));
                        }
                        move.add(nRabbit);
                    }

                } else if(j==2) {
                    //꺾어 돌아올 필요가 없다면
                    if(M - nRabbit.x >= nRabbit.d){
                        nRabbit.x += nRabbit.d;
                        move.add(nRabbit);

                        //꺾어 돌아와야 한다면?
                    } else {
                        int len = nRabbit.d - (M-nRabbit.x);
                        int turn = len/(M-1);

                        //역방향으로 돌아오고 있다면
                        if(turn%2==0){
                            nRabbit.x = M-(len%(M-1));
                        } else {
                            nRabbit.x = len%(M-1)+1;
                        }
                        move.add(nRabbit);
                    }

                } else if(j==3) {

                    //꺾어 돌아올 필요가 없다면
                    if(nRabbit.x-nRabbit.d >= 1){
                        nRabbit.x -= nRabbit.d;
                        move.add(nRabbit);

                        //꺾어 돌아와야 한다면?
                    } else {
                        int len = nRabbit.d - (nRabbit.x-1);
                        int turn = len/(M-1);

                        //역방향으로 돌아오고 있다면
                        if(turn%2==0){
                            nRabbit.x = len%(M-1)+1;
                        } else {
                            nRabbit.x = M-(len%(M-1));
                        }
                        move.add(nRabbit);
                    }
                }
            }

            Rabbit first = move.poll();
//            System.out.println("이번에 이동한 위치 >> "+first.toString());
            first.jump++;
            first.turn = true;
            sumPoint += (first.y+ first.x);
            first.point -= (first.y+first.x);

            set.add(first);
            all.put(first.id, first);
		}



//        System.out.println("라스트팡 이전이야!!!!!!!!!!!!!!!");
//        System.out.println(all.toString());

        lastPang(Integer.parseInt(strs[2]));

//        System.out.println("라스트팡 했는데 반영되나????????????????");
//        System.out.println(all.toString());
//        System.out.println(set.toString());
//        System.out.println("라스트팡 했는데 반영되나????????????????");
    }

    static void lastPang(int S){
        PriorityQueue<Rabbit> target = new PriorityQueue<>( new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                if((o1.y+o1.x) == (o2.y+o2.x)){
                    if(o1.y==o2.y){
                        if(o1.x==o2.y){
                            return o2.id-o1.id;
                        } else {
                            return o2.x-o1.x;
                        }
                    } else {
                        return o2.y-o1.y;
                    }
                } else {
                    return (o2.y+o2.x) - (o1.y+o1.x);
                }
            }
        });

        for(int num : all.keySet()){
            if(all.get(num).turn){
                target.add(all.get(num));
                all.get(num).turn = false;
            }
        }

        Rabbit tRabbit = target.poll();
        tRabbit.point += S;
        all.put(tRabbit.id, tRabbit);
    }

    static void plus(String[] strs){
        Rabbit pRabbit = all.get(Integer.parseInt(strs[1]));
        pRabbit.d *= Integer.parseInt(strs[2]);
        all.put(Integer.parseInt(strs[1]), pRabbit);
    }
}
