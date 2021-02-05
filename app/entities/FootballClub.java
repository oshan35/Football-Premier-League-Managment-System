package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;


public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    private int winCount;
    private int drawCont;
    private int lossCount;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int playedMatchCount;



    public FootballClub(String clubId,String clubName, String clubLocation, Date startDate,
                        int winCount, int drawCont,
                        int lossCount, int goalsFor, int goalsAgainst) {
        super(clubId,clubName,clubLocation,startDate);
        this.setWinCount(winCount);
        this.setDrawCont(drawCont);
        this.setLossCount(lossCount);
        this.setPlayedMatchCount();
        this.setGoalsFor(goalsFor);
        this.setGoalsAgainst(goalsAgainst);
        this.setGoalDifference();
        this.setClubPoints();
    }

    public int getPlayedMatchCount() {
        return playedMatchCount;
    }

    public void setPlayedMatchCount() {
        this.playedMatchCount=winCount+drawCont+lossCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        //win count should be more than or equal to 0
        if (winCount>=0){
            this.winCount = winCount;
        }
    }

    public int getDrawCont() {
        return drawCont;
    }

    public void setDrawCont(int drawCont) {
        //draw coount should be more than or equal to 0
        if (drawCont>=0){
            this.drawCont = drawCont;
        }
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        //loss count should be more than or equal to 0
        if (lossCount>=0){
            this.lossCount = lossCount;
        }
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        if (goalsFor>=0){
            this.goalsFor = goalsFor;
        }else{
            System.out.println("Invalid GF count! GF count can not be less than zero");
        }

    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        if (goalsAgainst>=0){
            this.goalsAgainst = goalsAgainst;
        }else{
            System.out.println("Invalid GA count! GA count can not be less than zero");
        }
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference() {

        this.goalDifference = goalsFor - goalsAgainst;
    }


    @Override
    public int getClubPoints(){
        return clubPoints;
    }

    @Override
    public void setClubPoints() {
        this.clubPoints=winCount*3;
    }

    public void updateTeamStates(int mainClub,int opponent){
        playedMatchCount=playedMatchCount+1;
        goalsFor = goalsFor +mainClub;
        goalsAgainst = goalsAgainst +opponent;
        if (mainClub>opponent){
            winCount+=1;
        }else if (mainClub<opponent){
            lossCount+=1;
        }else{
            drawCont+=1;
        }

        goalDifference= goalsFor - goalsAgainst;
        setClubPoints();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object footballClub) {
        return super.equals(footballClub);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String date=formatter.format(getStartDate());
        return "FootballClub{" +
                "clubName="+getClubName()+
                ", clubPoints="+getClubPoints()+
                ", clubStart Date="+date+
                ", playedMtachCount="+playedMatchCount+
                ", winCount=" + winCount +
                ", drawCont=" + drawCont +
                ", lossCount=" + lossCount +
                ", totalGoals=" + goalsFor +
                ", GoalsRecived="+ goalsAgainst +
                ", GoalDifference="+goalDifference+
                '}';
    }


    @Override
    public int compareTo(FootballClub club) {
        if (this.getClubPoints()==club.getClubPoints()){
            if (this.getGoalDifference()>club.getGoalDifference()){
                return 1;
            }else if (this.getGoalDifference()<club.getGoalDifference()){
                return -1;
            }
            return 0;
        }else if (this.getClubPoints()<club.getClubPoints()){
            return -1;
        }else {
            return 1;
        }
    }
}
