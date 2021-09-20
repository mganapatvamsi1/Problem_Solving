package algoexpert.arrays.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    //TODO: try this approach later
    public String tournamentWinner2(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> listOfMatches = competitions.get(i);
            if (results.get(i) == 0) {
                //TODO: note: everytime we are hardcoding and overriding the values of 0 and 3, which is wrong
                if (!map.isEmpty()) {
                    map.put(listOfMatches.get(1), map.get(listOfMatches.get(1)) + 3);
                    map.put(listOfMatches.get(0),  map.get(listOfMatches.get(0)) + 0);
                } else {
                    map.put(listOfMatches.get(1), 3);
                    map.put(listOfMatches.get(0), 0);
                }
                count  = 0;
            } else if (results.get(i) == 1) {
                if (!map.isEmpty()) {
                    map.put(listOfMatches.get(0), map.get(listOfMatches.get(0)) + 3);
                    map.put(listOfMatches.get(1),map.get(listOfMatches.get(1)) + 0);
                } else {
                    map.put(listOfMatches.get(0),  3);
                    map.put(listOfMatches.get(1), 0);
                }

                count = 0;
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue().equals( Collections.max(map.values()) )) {
                System.out.println("value of the result str: " + entry.getValue());
                return entry.getKey();
            }
        }
        return "";
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int teamWon = 1;
        String currentBestTeam = "";
        Map<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> listOfMatches = competitions.get(i);
            int result = results.get(i);
            String home = listOfMatches.get(0);
            String away = listOfMatches.get(1);

            String winningTeam = (result == teamWon ) ? home : away;

            updateScores(winningTeam, scores);

            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }

    public void updateScores(String team, Map<String, Integer> scores) {
        if (!scores.containsKey(team)) scores.put(team, 0);
        scores.put(team, scores.get(team) + 3);
    }

    public static void main(String[] args) {
        TournamentWinner twin = new TournamentWinner();
        ArrayList<ArrayList<String>> test1 = new ArrayList<>();
        ArrayList<Integer> results1 = new ArrayList<>();
        results1.add(1);
        results1.add(0);
        results1.add(0);
        results1.add(1);
        results1.add(0);
        results1.add(0);
        results1.add(1);
        results1.add(0);
        results1.add(0);
        results1.add(1);
        results1.add(0);
        results1.add(0);
        results1.add(1);
        results1.add(0);
        results1.add(0);
        ArrayList<String> innerStr1 = new ArrayList<>();
        innerStr1.add("AlgoMasters");
        innerStr1.add("FrontPage Freebirds");
        ArrayList<String> innerStr2 = new ArrayList<>();
        innerStr2.add("Runtime Terror");
        innerStr2.add("Static Startup");
        ArrayList<String> innerStr3 = new ArrayList<>();
        innerStr3.add("WeC#");
        innerStr3.add("Hypertext Assassins");
        ArrayList<String> innerStr4 = new ArrayList<>();
        innerStr4.add("AlgoMasters");
        innerStr4.add("WeC#");
        ArrayList<String> innerStr5 = new ArrayList<>();
        innerStr5.add("Static Startup");
        innerStr5.add("Hypertext Assassins");
        ArrayList<String> innerStr6 = new ArrayList<>();
        innerStr6.add("Runtime Terror");
        innerStr6.add("FrontPage Freebirds");
        ArrayList<String> innerStr7 = new ArrayList<>();
        innerStr7.add("AlgoMasters");
        innerStr7.add("Runtime Terror");
        ArrayList<String> innerStr8 = new ArrayList<>();
        innerStr8.add("Hypertext Assassins");
        innerStr8.add("FrontPage Freebirds");
        ArrayList<String> innerStr9 = new ArrayList<>();
        innerStr9.add("Static Startup");
        innerStr9.add("WeC#");
        ArrayList<String> innerStr10 = new ArrayList<>();
        innerStr10.add("AlgoMasters");
        innerStr10.add("Static Startup");
        ArrayList<String> innerStr11 = new ArrayList<>();
        innerStr11.add("FrontPage Freebirds");
        innerStr11.add("WeC#");
        ArrayList<String> innerStr12 = new ArrayList<>();
        innerStr12.add("Hypertext Assassins");
        innerStr12.add("Runtime Terror");
        ArrayList<String> innerStr13 = new ArrayList<>();
        innerStr13.add("AlgoMasters");
        innerStr13.add("Hypertext Assassins");
        ArrayList<String> innerStr14 = new ArrayList<>();
        innerStr14.add("WeC#");
        innerStr14.add("Runtime Terror");
        ArrayList<String> innerStr15 = new ArrayList<>();
        innerStr15.add("FrontPage Freebirds");
        innerStr15.add("Static Startup");

        test1.add(innerStr1);
        test1.add(innerStr2);
        test1.add(innerStr3);
        test1.add(innerStr4);
        test1.add(innerStr5);
        test1.add(innerStr6);
        test1.add(innerStr7);
        test1.add(innerStr8);
        test1.add(innerStr9);
        test1.add(innerStr10);
        test1.add(innerStr11);
        test1.add(innerStr12);
        test1.add(innerStr13);
        test1.add(innerStr14);
        test1.add(innerStr15);

        System.out.println("The tournament winner is: "+twin.tournamentWinner(test1, results1));
        //TODO: correct answer is "AlgoMasters" but i am getting "Runtime Terror"


    }
}
