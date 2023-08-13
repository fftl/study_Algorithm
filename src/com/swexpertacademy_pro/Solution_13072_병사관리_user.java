package com.swexpertacademy_pro;

//각 팀 별로 스코어 5개의 맵을 전부 만든다!?
import java.util.HashMap;

public class Solution_13072_병사관리_user {

    static HashMap<Integer, Team> teams = new HashMap<>();
    public void init()
    {
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


    static class Team{
        int mTeam;

    }

    static class Member{
        int mId, mTeam, mScore;

        public Member(int mId, int mTeam, int mScore){
            this.mId = mId;
            this.mTeam = mTeam;
            this.mScore = mScore;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "mId=" + mId +
                    ", mTeam=" + mTeam +
                    ", mScore=" + mScore +
                    '}';
        }
    }
}
