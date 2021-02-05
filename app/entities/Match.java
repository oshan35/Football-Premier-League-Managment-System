package entities;

import java.io.Serializable;


public class Match implements Serializable {
    private FootballClub team01;
    private FootballClub team02;
    private String matchLocation;
    private Date matchDate;
    private int team01Goals;
    private int team02Goals;


    public Match(FootballClub team01, FootballClub team02, String matchLocation, Date matchDate, int team01Goals, int team02Goals) {
        this.setTeam01(team01);
        this.setTeam02(team02);
        this.setMatchLocation(matchLocation);
        this.setMatchDate(matchDate);
        this.setTeam01Goals(team01Goals);
        this.setTeam02Goals(team02Goals);
        //team.updateTeamStates(mainTeam,opponentTeam) ==> should follow this order while entering the teams
        team01.updateTeamStates(team01Goals,team02Goals);
        team02.updateTeamStates(team02Goals,team01Goals);
    }


    public String getTeam01() {
        return team01.getClubName();
    }

    public void setTeam01(FootballClub team01) {

        this.team01=team01;

    }

    public String getTeam02() {
        return team02.getClubName();
    }

    public void setTeam02(FootballClub team02) {
        this.team02 = team02;
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public void setMatchLocation(String matchLocation) {
        this.matchLocation = matchLocation;
    }

    public String getMatchDate() {
        return matchDate.toString();
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public int getTeam01Goals() {
        return team01Goals;
    }

    public void setTeam01Goals(int team01Goals) {
        this.team01Goals = team01Goals;
    }

    public int getTeam02Goals() {
        return team02Goals;
    }

    public void setTeam02Goals(int team02Goals) {
        this.team02Goals = team02Goals;
    }




    @Override
    public boolean equals(Object match) {
        return super.equals(match);
    }
    public void updateClubStat(){

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
