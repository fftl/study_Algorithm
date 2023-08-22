package com.swexpertacademy_pro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_병사관리_ys {
    HashMap<Integer, Soldier> soldierHashMap;
    Team[] teams;

    class Soldier {
        int mId;
        int mTeam;

        public Soldier(int mId, int mTeam) {
            this.mId = mId;
            this.mTeam = mTeam;
        }
    }

    class Team {
        Set<Integer>[] scores;

        public Team() {
            scores = new Set[6];
            for(int i = 1; i<=5; i++){
                scores[i] = new HashSet<>();
            }
        }

        public void updateTeamScore(int mChangeScore) {
            if(mChangeScore>0){
                for (int i = 5; i >= 1; i--) {
                    int updated = updateScore(i, mChangeScore);
                    if (i != updated) {
                        Set<Integer> merge = scores[i];
                        Set<Integer> target = scores[updated];
                        if (target.size() >= merge.size()) {
                            target.addAll(merge);
                            scores[updated] = target;
                            scores[i] = new HashSet<>();
                        } else {
                            merge.addAll(target);
                            scores[updated] = merge;
                            scores[i] = new HashSet<>();
                        }
                    }
                }
            } else if(mChangeScore<0) {
                for (int i = 1; i <= 5; i++) {
                    int updated = updateScore(i, mChangeScore);
                    if (i != updated) {
                        Set<Integer> merge = scores[i];
                        Set<Integer> target = scores[updated];
                        if (target.size() >= merge.size()) {
                            target.addAll(merge);
                            scores[updated] = target;
                            scores[i] = new HashSet<>();
                        } else {
                            merge.addAll(target);
                            scores[updated] = merge;
                            scores[i] = new HashSet<>();
                        }
                    }
                }
            }
        }
    }
    public void init()
    {
        soldierHashMap = new HashMap<>();
        teams = new Team[6];
        for(int i = 1; i<= 5; i++){
            teams[i] = new Team();
        }
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        Soldier soldier = new Soldier(mID, mTeam);
        soldierHashMap.put(mID, soldier);
        Team team = teams[mTeam];
        team.scores[mScore].add(mID);
    }

    public void fire(int mID)
    {
        Soldier removed = soldierHashMap.remove(mID);
        Team team = teams[removed.mTeam];
        Set<Integer>[] scores = team.scores;
        for(int i = 1; i<= 5; i++){
            if(scores[i].remove(removed.mId)){
                break;
            }
        }
    }

    public void updateSoldier(int mID, int mScore)
    {
        Soldier cur = soldierHashMap.get(mID);
        Team team = teams[cur.mTeam];
        Set<Integer>[] scores = team.scores;
        for(int i = 1; i <= 5; i++){
            if(scores[i].remove(cur.mId)){
                scores[mScore].add(cur.mId);
                break;
            }
        }
    }

    private int updateScore(int i, int mScore) {
        int updated = i + mScore;
        if(updated>=5){
            updated = 5;
        } else if(updated <= 1){
            updated = 1;
        }
        return updated;
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        Team team = teams[mTeam];
        team.updateTeamScore(mChangeScore);
    }

    public int bestSoldier(int mTeam)
    {
        Set<Integer>[] scores = teams[mTeam].scores;
        for(int i = 5; i >= 1; i--){
            if(scores[i].size()>0){
                Set<Integer> score = scores[i];
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (Integer integer : score) {
                    pq.offer(-integer);
                }
                Integer poll = -pq.poll();
                return poll;
            }
        }
        return 0;
    }
}
