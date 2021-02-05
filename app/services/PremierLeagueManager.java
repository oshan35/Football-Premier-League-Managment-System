package services;

import entities.Date;
import entities.FootballClub;
import entities.Match;
import entities.SportsClub;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class PremierLeagueManager implements LeagueManager {
    public ArrayList<FootballClub> sportsClubArrayList;
    public ArrayList<Match> footballMatchArrayList;

    private final String clubDataFilePath="clubdata.txt";
    private final String matchDataFilePath="matchData.txt";

    //Premier League Manager Constructor
    public PremierLeagueManager() throws IOException, ClassNotFoundException {
        sportsClubArrayList=new ArrayList<>();
        footballMatchArrayList =new ArrayList<>();
        readClubData();
        readMatchData();
    }

    //Adding a new club to arrayList
    @Override
    public void addNewClub(FootballClub club){
        if (sportsClubArrayList.contains(club)){
            System.out.println("Club already exsists");
        }else {
            sportsClubArrayList.add(club);
        }
    }

    //deleting clubs from arrayList
    @Override
    public void deleteClub(String clubID){
        for (SportsClub club:sportsClubArrayList){
            if (club.getClubId().equals(clubID)){
                System.out.println("Do you want to delete "+club.getClubName()+" ?(y/n)");
                Scanner deleteChoice=new Scanner(System.in);
                String choice=deleteChoice.next();
                if (choice.equalsIgnoreCase("y")){
                    sportsClubArrayList.remove(club);
                    saveClubList();
                    break;
                }
            }
        }
        System.out.println("Club does not exist in the list!");

    }


    //showing varies stat about clubs
    @Override
    public void showStatistic(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Search club -1 ");
        System.out.println("Print the List -2 ");
        int choiceOne=sc.nextInt();
        if (choiceOne==1){
            System.out.print("Enter the club ID: ");
            String clubID=sc.next();
            for (FootballClub club:sportsClubArrayList){
                if (club.getClubId().equals(clubID)){
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%20s %15s %20s %10s %10s %10s %20s %20s", "clubName", "Points", "PlayedMatchCount", "wins", "Losses","draws","Goals For","Goals Against");
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%20s %15d %20d %10d %10d %10d %20d %20d",club.getClubName(),club.getClubPoints(),club.getPlayedMatchCount(),
                            club.getWinCount(),club.getLossCount(),club.getDrawCont(),club.getGoalsFor(),club.getGoalsAgainst());
                    System.out.println();
                    break;
                }
            }
        }else if (choiceOne==2){
            statTable(sportsClubArrayList);
        }
    }

    //displaying premeierLeag table
    @Override
    public void showPremierLeagTable(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Assending Order- 1");
        System.out.println("Dicending Order- 2");
        int choice=sc.nextInt();
        if (choice==2){
            Collections.reverse(sportsClubArrayList);
        }else if (choice==1){
            Collections.sort(sportsClubArrayList);
        }else {
            System.out.println("Invalid command!");
        }
        statTable(sportsClubArrayList);

    }

    //statistic table
    private void statTable(ArrayList<FootballClub> arrayList){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %15s %20s %10s %10s %10s %20s %20s", "clubName", "Points", "PlayedMatchCount", "wins", "Losses","draws","Goals For","Goals Against");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (FootballClub club:arrayList){
            System.out.printf("%20s %15d %20d %10d %10d %10d %20d %20d",club.getClubName(),club.getClubPoints(),club.getPlayedMatchCount(),
                    club.getWinCount(),club.getLossCount(),club.getDrawCont(),club.getGoalsFor(),club.getGoalsAgainst());
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

    }

    //adding a football match to the list
    public void addMatch(Match match){
        if (footballMatchArrayList.contains(match)){
            System.out.println("Match has already added!");
        }else{
            footballMatchArrayList.add(match);
            saveMatchList();
        }
    }

    //searching a club for given club id
    public FootballClub search(String clubId){

        for (FootballClub club:sportsClubArrayList){
            if (clubId.equals(club.getClubId())){
                return club;
            }
        }
        return null;
    }

    //save club list to text file
    public void saveClubList(){
        try {
            FileOutputStream clubFile = new FileOutputStream(clubDataFilePath);
            ObjectOutputStream clubObj = new ObjectOutputStream(clubFile);
            for (FootballClub club:sportsClubArrayList){
                clubObj.writeObject(club);
            }
            clubObj.close();
            System.out.println("club is successfully added to the list");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //saveing match list to text file
    public void saveMatchList(){
        try {

            FileOutputStream fileOut = new FileOutputStream(matchDataFilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Match match: footballMatchArrayList){
                objectOut.writeObject(match);
            }
            objectOut.close();
            System.out.println("Match is succesfully added to the list");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //Loding club objects to the match array list
    private void readClubData() throws IOException, ClassNotFoundException {
        try{

            FileInputStream fileIn = new FileInputStream(clubDataFilePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while(true){
                FootballClub obj = (FootballClub) objectIn.readObject();
                sportsClubArrayList.add(obj);
            }


        }catch (Exception e){
            System.out.println("Club data didn't read!");
        }

    }

    //loding match objects to the match array list
    private void readMatchData(){
        try {
            FileInputStream matchFile=new FileInputStream(matchDataFilePath);
            ObjectInputStream matchObj=new ObjectInputStream(matchFile);
            while(true){
                Match match=(Match) matchObj.readObject();
                footballMatchArrayList.add(match);
            }

        }catch (Exception e){
            System.out.println("matches didn't read");
        }
    }

    //generating random match between two random clubs with random scored dates and locations.
    public Match randomMatch(){
        String[] matchLocations=new String[]{"Colombo","Gampaha","Jaffna","Westminister","Wallawatta","Galla"};
        FootballClub team01=getRandemClub();
        FootballClub team02=getRandemClub();
        while (true){
            if (team01.equals(team02)){
                team02=getRandemClub();
            }else{
                break;
            }
        }
        Random randNum=new Random();
        String ground=matchLocations[randNum.nextInt(7)];

        Date date=new Date(2021,randNum.nextInt(11)+1,randNum.nextInt(30)+1);
        int team01GoalCount=randNum.nextInt(30);
        int team02GoalCount=randNum.nextInt(30);
        Match randMatch=new Match(team01,team02,ground,date,team01GoalCount,team02GoalCount);
        addMatch(randMatch);
        return randMatch;
    }

    //picking up two random football clubs.
    private FootballClub getRandemClub(){
        Random randClub=new Random();
        return sportsClubArrayList.get(randClub.nextInt(sportsClubArrayList.size()));
    }
}
