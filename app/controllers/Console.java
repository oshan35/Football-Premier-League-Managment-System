package controllers;

import entities.Date;
import entities.FootballClub;
import entities.Match;
import services.PremierLeagueManager;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static PremierLeagueManager premierLeagueManager;

    static {
        try {
            premierLeagueManager = new PremierLeagueManager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static FootballClub createSportsClub(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the club ID: ");
        String clubId = input.next();
        System.out.print("Enter the club Name: ");
        Scanner clubNm = new Scanner(System.in);
        String clubName = clubNm.nextLine();
        System.out.print("Enter the club Location: ");
        Scanner clubLocationIn = new Scanner(System.in);
        String clubLocation = clubLocationIn.nextLine();
        System.out.print("Enter the club start date:(yyyy/MM/dd) ");
        Date clubStartDate =new Date(input.nextInt(),input.nextInt(),input.nextInt());

        System.out.print("Enter win count: ");
        int win = input.nextInt();
        System.out.print("Enter loss count: ");
        int loss = input.nextInt();
        System.out.print("Enter draw count: ");
        int draw = input.nextInt();
        System.out.print("Enter GoalsFor: ");
        int goals = input.nextInt();
        System.out.print("Enter GoalsAgainst: ");
        int goalsRecived = input.nextInt();

        FootballClub footballClub = new FootballClub(clubId,clubName, clubLocation,clubStartDate, win, draw, loss, goals, goalsRecived);
        return footballClub;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Welcome to Premierleag Manager");
                System.out.println("Add a new club - 1");
                System.out.println("delete club -2");
                System.out.println("show statistics -3");
                System.out.println("show Premier League Table -4");
                System.out.println("To save the club List - 5");
                System.out.println("To add a new Match - 6");
                System.out.println("To Open GUI - 7");
                int choiceOne = sc.nextInt();
                if (choiceOne == 1) {
                    //getting details about the club
                    Scanner input = new Scanner(System.in);
                    System.out.println("Add a Football club -1");
                    System.out.println("Add a SchoolFutball club -2");
                    System.out.println("Add a UniversityFootball club -3");
                    int choice01 = input.nextInt();

                    if (choice01 == 1) {
                       FootballClub newFootballClub=createSportsClub();
                        //adding football club to arrayList
                        premierLeagueManager.addNewClub(newFootballClub);
                    }
                } else if (choiceOne == 2) {
                    Scanner inputTwo = new Scanner(System.in);
                    System.out.print("Enter the club ID: ");
                    String clubID = inputTwo.next();
                    premierLeagueManager.deleteClub(clubID);
                } else if (choiceOne == 3) {
                    premierLeagueManager.showStatistic();
                } else if (choiceOne == 4) {
                    premierLeagueManager.showPremierLeagTable();
                } else if (choiceOne == 5) {
                    premierLeagueManager.saveClubList();
                } else if (choiceOne == 6) {
                    Match newMatch=Console.createNewMatch();
                    premierLeagueManager.addMatch(newMatch);
                    premierLeagueManager.saveMatchList();
                } else if (choiceOne == 7) {
                    String connectToGUI = "http://localhost:4200/";
                    try {
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create(connectToGUI));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Try Again!");
            }

            System.out.print("Quit (y/n): ");
            String choiceTwo = sc.next();
            if (choiceTwo.equalsIgnoreCase("y")) {
                break;
            }

        }

    }

    public static Match createNewMatch(){
        Scanner matchScanner=new Scanner(System.in);

        System.out.print("Enter team01 Id: ");
        String club01ID = matchScanner.next();
        System.out.print("Enter team02 Id: ");
        String club02ID = matchScanner.next();
        System.out.print("Enter Club Location: ");
        String location = matchScanner.next();

        System.out.print("Enter match date:(yyyy/MM/dd) ");
        Date matchDate =new Date(matchScanner.nextInt(),matchScanner.nextInt(),matchScanner.nextInt());
        System.out.print("Team one goals: ");
        int team01 = matchScanner.nextInt();
        System.out.print("Team two goals: ");
        int team02 = matchScanner.nextInt();
        Match match = new Match(premierLeagueManager.search(club01ID), premierLeagueManager.search(club02ID), location, matchDate, team01, team02);
        return match;

    }
}
