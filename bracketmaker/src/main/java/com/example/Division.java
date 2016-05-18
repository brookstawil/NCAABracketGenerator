package com.example;

import java.util.Arrays;
/**
 * Created by Brooks on 3/16/2016.
 */
public class Division {
    //Global vars
    public int roundNum;
    public Team[] teams;
    public String name;
    public static int bigUpsetCount,upsetCount;

    public Division(Team[] teams,String name){
        this.teams = teams;
        this.name = name;
        roundNum = 1;
        bigUpsetCount = 0;
        upsetCount = 0;
    }
    //By playing a game a probability equal to
    private Team playGame(Team team1, Team team2){
        Team lowSeed,highSeed; //lowSeed is the better team
        if(team1.seed < team2.seed) {
            lowSeed = team1;highSeed = team2;
        } else {
            highSeed = team1;lowSeed = team2;
        }
        double probUpset = lowSeed.seed/(double)(lowSeed.seed + highSeed.seed);
        double winningNumber = Math.random();

        if(winningNumber > probUpset){
            System.out.println(lowSeed+" defeats "+highSeed);
            return lowSeed;
        } else {
            System.out.println(highSeed+" defeats "+lowSeed);
            if(highSeed.seed - lowSeed.seed > 3){
                System.out.println("BIG UPSET");
                bigUpsetCount++;
            } else if (highSeed.seed - lowSeed.seed >= 1 && highSeed.seed - lowSeed.seed <= 3){
                System.out.println("UPSET");
                upsetCount++;
            }
            return highSeed;
        }
    }

    private void playRound(){
        Team temp[] = new Team[teams.length/2];
        //Round 1
        if(teams.length == 16){
            int i=0,j=15;
            temp[0] = playGame(teams[i],teams[j]);
            temp[1] = playGame(teams[i+7],teams[j-7]);
            temp[2] = playGame(teams[i+4],teams[j-4]);
            temp[3] = playGame(teams[i+3],teams[j-3]);
            temp[4] = playGame(teams[i+5],teams[j-5]);
            temp[5] = playGame(teams[i+2],teams[j-2]);
            temp[6] = playGame(teams[i+6],teams[j-6]);
            temp[7] = playGame(teams[i+1],teams[j-1]);
        //Subsequent rounds
        } else {
            int left = 0;
            int right = 1;
            int count = 0;
            while(right<teams.length){
                temp[count] = playGame(teams[left],teams[right]);
                count++;
                left += 2;
                right += 2;
            }
        }
        teams = temp;
        System.out.println("AFTER ROUND "+roundNum+": "+this);
    }

    public Team divisionChamp(){
        while(teams.length>1){
            System.out.println(this);
            playRound();
            roundNum++;
        }
        System.out.println(teams[0]+" is the "+this.name+" champion!");
        return teams[0];
    }

    public String toString(){
        String result = name + ": ";
        for(Team i:teams)
            result += i + "  ";

        return result;
    }

}
