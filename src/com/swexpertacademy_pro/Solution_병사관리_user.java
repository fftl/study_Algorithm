package com.swexpertacademy_pro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution_병사관리_user {
    static class Test{
        int val;

        public Test(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Test{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Team{
        int tId;
        HashMap<Integer, LinkedList<Test>> map;

        public Team(int tId, HashMap<Integer, LinkedList<Test>> map) {
            this.tId = tId;
            this.map = map;
        }

        void init(){
            for (int i = 1; i <= 5; i++) {
                map.put(i, new LinkedList<>());
            }
        }
    }

    public void init()
    {
        HashMap<Integer, Test> map = new HashMap<>();
        map.put(1, new Test(10));

        ArrayList<Test> arr = new ArrayList<>();
        arr.add(map.get(1));

        System.out.println("일단 입력 상황 확인 --------------------------");
        System.out.println(map);
        System.out.println(arr);

        //삭제!!
        map.remove(1);

        System.out.println("삭제 이후 --------------------------");
        System.out.println(map);
        System.out.println(arr);

    }

    public void hire(int mID, int mTeam, int mScore)
    {
    }

    public void fire(int mID)
    {
    }

    public void updateSoldier(int mID, int mScore)
    {
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
    }

    public int bestSoldier(int mTeam)
    {
        return 0;
    }

}
