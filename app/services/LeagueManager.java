package services;

import entities.FootballClub;
import entities.Match;

public interface LeagueManager {
    void addNewClub(FootballClub club);
    void deleteClub(String clubID);
    void showStatistic();
    void showPremierLeagTable();
    void addMatch(Match match);
    FootballClub search(String clubId);
    void saveClubList();
    void saveMatchList();
}
