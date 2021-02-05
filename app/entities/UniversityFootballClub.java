package entities;

public class UniversityFootballClub extends FootballClub{
    private String universityName;

    public UniversityFootballClub(String clubId,String clubName, String clubLocation, Date startDate,
                                  int winCount, int drawCont,
                                  int lossCount, int goalsFor, int goalsAgainst,String universityName){
        super(clubId,clubName,clubLocation,startDate,winCount,drawCont,lossCount,goalsFor,goalsAgainst);
        this.setUniversityName(universityName);

    }

    public String getUniversityName(){
        return universityName;
    }

    public void setUniversityName(String universityName){
        this.universityName=universityName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object universityFootballClub) {
        return super.equals(universityFootballClub);
    }
}
