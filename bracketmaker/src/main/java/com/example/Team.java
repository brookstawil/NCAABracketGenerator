package com.example;

/**
 * Created by Brooks on 4/17/2016
 * at 10:43 AM
 * under NCAARandomBracket
 */
//Team Class which holds the teams name and seed
//Allows for comparison of two teams, only based off of seed
//Possible future implementation to take into account offense and defense rankings.
public class Team implements Comparable<Team>{
    public int seed;
    public String team;

    public Team(int seed,String team){
        this.seed = seed;
        this.team = team;
    }

    public int compareTo(Team otherTeam){
        if(otherTeam.seed > this.seed) return -1;
        else if (otherTeam.seed < this.seed) return 1;
        else return 0;
    }
    public String toString(){
        return (team + "(" + seed + ") ");
    }
}
