package entities;

public class SchoolFootballClub extends FootballClub {
    private String schoolName;

    public SchoolFootballClub(String clubId,String clubName,String clubLocation, Date startDate,
                              int winCount,int drawCont,int lossCount,
                              int goalsFor,int goalsAgainst,String schoolName) {
        super(clubId,clubName,clubLocation,startDate,winCount,drawCont,lossCount,goalsFor,goalsAgainst);
        this.schoolName=schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object schoolFootballClub) {
        return super.equals(schoolFootballClub);
    }
}
