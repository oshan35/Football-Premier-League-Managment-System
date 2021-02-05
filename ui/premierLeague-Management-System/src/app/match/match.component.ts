import {AfterViewInit, Component, OnInit} from '@angular/core';
import { ClubServices } from '../services/club-services.service';
import {MatTableDataSource} from "@angular/material/table";
import {NgForm} from "@angular/forms";


export interface MatchData{
  team01: string;
  team02: string;
  date: string;
  team01Goals:string;
  team02Goals: string;
}

let footballMatchDataList: MatchData[] =[];


@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})

export class MatchComponent implements OnInit{


  matchDataSource:any;
  constructor(private clubServices:ClubServices) {

  }


  ngOnInit(): void {
    this.getMatchData()
  }


  displayedColumns: string[] = ['team01', 'team02', 'matchDate', 'team01Goals','team02Goals'];

  //fetching match data from backend and assigning them to each column.
  async getMatchData(){

    try {
      const data: any = await this.clubServices.getMatchData();
      footballMatchDataList=[];
      for (var i in data){
        footballMatchDataList.push({team01:data[i]["team01"],team02:data[i]["team02"],date:data[i]["matchDate"],team01Goals:data[i]["team01Goals"],team02Goals:data[i]["team02Goals"]});
      }

      this.matchDataSource=new MatTableDataSource(footballMatchDataList);
      console.log("hello")

    } catch (error) {
      console.log(`[ERROR] ==> AppComponent==>getMatchData`, error);
      alert("Faild to get data!")
    }
  }

  //reciving random match from http request
  async getRandomMatch(){

    try {
      const data: any = await this.clubServices.getRandomMatch();
      console.log(data["team01"]);
      footballMatchDataList.push({team01:data["team01"],team02:data["team02"],date:data["matchDate"]
        ,team01Goals:data["team01Goals"],team02Goals:data["team02Goals"]});

      this.matchDataSource=new MatTableDataSource(footballMatchDataList);
      console.log("mat data source passed ");
    } catch (error) {
      console.log(`[ERROR] ==> AppComponent==>getMatchData`, error);
      alert("Faild to get data!");
    }
  }



  sort(type:Number){
    this.matchDataSource=new MatTableDataSource(footballMatchDataList);
    for(var i=1;i<footballMatchDataList.length;i++){
      var itemValue=footballMatchDataList[i].date;
      var item=footballMatchDataList[i];
      var j=i-1;
      while(j>=0 && footballMatchDataList[j].date>itemValue){
        footballMatchDataList[j+1]=footballMatchDataList[j];
        j--;
      }
      footballMatchDataList[j+1]=item;

    }
    if (type==1){
      this.matchDataSource=new MatTableDataSource(footballMatchDataList);
    }else if (type==0){
      this.matchDataSource=new MatTableDataSource(footballMatchDataList.reverse());
    }

  }


  onSubmit(f: NgForm) {
    let updatedMatchList=[];
    var findClub = f.value.search;
    for(var i in footballMatchDataList){
      if(footballMatchDataList[i].date== findClub){
        updatedMatchList.push(footballMatchDataList[i]);
        console.log(footballMatchDataList[i]);
      }
    }
    if (updatedMatchList.length==0){
      this.matchDataSource=new MatTableDataSource(footballMatchDataList);
    }else {
      this.matchDataSource=new MatTableDataSource(updatedMatchList);
    }

    console.log("done")

  }

  default() {
    this.matchDataSource=new MatTableDataSource(footballMatchDataList);
  }
}
