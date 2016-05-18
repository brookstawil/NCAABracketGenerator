package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BracketMain {
    public static void main(String args[]){
        Division finalFour;

        Team[][] divisions = parseJSON();
        Team[] divisionChamps = getChamps(divisions);

        System.out.println(Division.bigUpsetCount);
        System.out.println(Division.upsetCount);

        finalFour = new Division(divisionChamps,"Final Four");
        System.out.println("FINAL FOUR: "+finalFour);
        Team champion = finalFour.divisionChamp();
        System.out.println(champion+" is the NCAA Champion!");
    }

    private static Team[][] parseJSON(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src\\teams.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject south = (JSONObject) jsonObject.get("south");
            JSONObject east = (JSONObject) jsonObject.get("east");
            JSONObject west = (JSONObject) jsonObject.get("west");
            JSONObject midwest = (JSONObject) jsonObject.get("midwest");

            Team[] southArray = new Team[16],eastArray = new Team[16],westArray= new Team[16],midwestArray = new Team[16];

            for(int i=1;i<17;i++){
                southArray[i-1] = new Team(i,(String)south.get(""+i));
                eastArray[i-1] = new Team(i,(String)east.get(""+i));
                westArray[i-1] = new Team(i,(String)west.get(""+i));
                midwestArray[i-1] = new Team(i,(String)midwest.get(""+i));
            }
            Team[][] result = {southArray,eastArray,westArray,midwestArray};
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Team[] getChamps(Team[][] teams){
        Team[] divisionChamps = new Team[4];

        Division southDiv = new Division(teams[0],"Southern Division");
        Division eastDiv = new Division(teams[1],"Eastern Division");
        Division westDiv = new Division(teams[2],"Western Division");
        Division midwestDiv = new Division(teams[3],"Midwestern Division");

        divisionChamps[0] = southDiv.divisionChamp();
        divisionChamps[1] = westDiv.divisionChamp();
        divisionChamps[2] = eastDiv.divisionChamp();
        divisionChamps[3] = midwestDiv.divisionChamp();
        return divisionChamps;
    }
}
