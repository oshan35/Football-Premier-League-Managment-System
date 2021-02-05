package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    Date date=new Date(2020,4,6);
    FootballClub footballClub=new FootballClub("001","Kandy Tuskes","Kandy",date,4,5,2,15,14);
    @Test
    public void getPlayedMatchCount() {
        int expectedOutPut=6;
        int actualOutPut=footballClub.getPlayedMatchCount();
        assertEquals(expectedOutPut,actualOutPut);
    }

    @Test
    public void getWinCount() {
        int expectedOutput=4;
        int actualOutput=footballClub.getWinCount();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void getDrawCont() {
        int expectedOutPut=5;
        int actualOutPut=footballClub.getDrawCont();
        assertEquals(expectedOutPut,actualOutPut);
    }

    @Test
    public void getLossCount() {
        int expectedOutPut=2;
        int actualOutPut=footballClub.getLossCount();
        assertEquals(expectedOutPut,actualOutPut);
    }

    @Test
    public void getGoalsFor() {
        int expectedOutPut=15;
        int actualOutPut=footballClub.getGoalsFor();
        assertEquals(expectedOutPut,actualOutPut);
    }

    @Test
    public void getGoalsAgainst() {
        int expectedOutPut=14;
        int actualOutPut=footballClub.getGoalsAgainst();
        assertEquals(expectedOutPut,actualOutPut);
    }

    @Test
    public void getGoalDifference() {
        int expectedOutPut=1;
        int actualOutPut=footballClub.getGoalDifference();
        assertEquals(expectedOutPut,actualOutPut);
    }



    @Test
    public void getClubPoints() {
        int expectedOutPut=12;
        int actualOutPut=footballClub.getClubPoints();
        assertEquals(expectedOutPut,actualOutPut);
    }

}