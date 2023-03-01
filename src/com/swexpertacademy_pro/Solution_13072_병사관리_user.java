package com.swexpertacademy_pro;

import java.util.HashMap;
import java.util.List;

public class Solution_13072_병사관리_user {

    static HashMap<Integer, Member> members;
    static HashMap<Integer, List<Member>> teams;

    public void init()
    {
        members = new HashMap<>();
        teams = new HashMap<>();
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        members.put(mID, new Member(mID, mTeam, mScore));
    }

    public void fire(int mID)
    {
        members.remove(mID);
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
