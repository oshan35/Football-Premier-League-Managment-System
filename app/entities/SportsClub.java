package entities;


import java.io.Serializable;



public abstract class SportsClub implements Serializable {
    private String clubId;
    private String clubName;
    private String clubLocation;
    private Date startDate;
    protected int clubPoints;


    public SportsClub(String clubId,String clubName, String clubLocation, Date startDate) {
        this.setClubName(clubName);
        this.setClubLocation(clubLocation);
        this.setStartDate(startDate);
        this.setClubId(clubId);
    }



    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {

        this.clubId =clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public abstract int getClubPoints();

    public abstract void setClubPoints();


    @Override
    public boolean equals(Object sportsClub) {
        return super.equals(sportsClub);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
