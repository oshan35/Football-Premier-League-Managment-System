import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClubServices {

  constructor(private http:HttpClient) {

  }

  getClubData(){
    try {
      return this.http.get("http://localhost:4200/footballClubs").toPromise()
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }
  }

  getMatchData(){
    try {
      return this.http.get("http://localhost:4200/matchData").toPromise()
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }
  }

  getRandomMatch(){
    try {
      return this.http.get("http://localhost:4200/randomMatch").toPromise()
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }
  }


}
