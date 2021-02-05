import {Component, OnInit, ViewChild} from '@angular/core';
import { NgForm } from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {ClubServices} from "../services/club-services.service";





export interface ClubData{
  clubId: string;
  clubName: string;
  clubPoints: string;
  goalsScored:string;
  goalDifference:string;
  playedMatchCount: string;
  wins:string;
  draws: string;
  losses: string;
}

let clubDataList: ClubData[] =[];


@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.css']
})

export class ClubsComponent implements OnInit{
  constructor(private clubServices:ClubServices){

  }

  ngOnInit(): void {
     this.getClubData();
    }

  //table column definitions
  displayedColumns: string[] = ['clubId', 'clubName',"clubPoints","goalsScored","goalDifference",'playedMatchCount', 'wins','draws','losses'];

  clubDataSource:any;

  //reciving data from backend and assign those data to clubDataList
  async getClubData(){
    try {
      const data: any = await this.clubServices.getClubData();
      clubDataList=[];
      for (var i in data){
        console.log(data)
        clubDataList.push({clubId:data[i]["clubId"],clubName:data[i]["clubName"],clubPoints:data[i]["clubPoints"],goalsScored:data[i]["goalsFor"],goalDifference:data[i]["goalDifference"],playedMatchCount:data[i]["playedMatchCount"],wins:data[i]["winCount"],draws:data[i]["drawCont"],losses:data[i]["lossCount"]})
      }
      this.clubPointsSort(0);
      this.clubDataSource=new MatTableDataSource(clubDataList);

    } catch (error) {
      console.log(`[ERROR] ==> AppComponent==>getData`, error);
      alert("Faild to get data!")
    }
  }

  //Performing search operation
  onSubmit(f:NgForm,){

    var findClub = f.value.search;
    for(var i in clubDataList){
      if(clubDataList[i].clubName== findClub){
        this.clubDataSource=new MatTableDataSource([clubDataList[i]])
        console.log(clubDataList[i].clubId)
        break;
      }else if(findClub==""){
        this.clubDataSource=new MatTableDataSource(clubDataList);
      }
    }
    console.log("done")
  }

  //sorting data accoding to club points
  clubPointsSort(sortMethod:Number){
    this.clubDataSource=new MatTableDataSource(clubDataList)
    var ftSwapped;
    do {
      ftSwapped = false;
      for (var ftClub=0; ftClub < clubDataList.length-1; ftClub++) {
        if (clubDataList[ftClub].clubPoints > clubDataList[ftClub+1].clubPoints) {
          var holdClub = clubDataList[ftClub];
          clubDataList[ftClub] = clubDataList[ftClub+1];
          clubDataList[ftClub+1] = holdClub;
          ftSwapped = true;
        }
      }
    } while (ftSwapped);

    if (sortMethod==1){
      this.clubDataSource=new MatTableDataSource(clubDataList);
    }else if (sortMethod==0){
      this.clubDataSource=new MatTableDataSource(clubDataList.reverse());
    }
  }


  winsSort(sortMethod:Number){

    this.clubDataSource=new MatTableDataSource(clubDataList)
    var ftSwapped;
    do {
      ftSwapped = false;
      for (var ftClub=0; ftClub < clubDataList.length-1; ftClub++) {
        if (clubDataList[ftClub].wins > clubDataList[ftClub+1].wins) {
          var temp = clubDataList[ftClub];
          clubDataList[ftClub] = clubDataList[ftClub+1];
          clubDataList[ftClub+1] = temp;
          ftSwapped = true;
        }
      }
    } while (ftSwapped);
    if (sortMethod==1){
      this.clubDataSource=new MatTableDataSource(clubDataList);
    }else if (sortMethod==0){
      this.clubDataSource=new MatTableDataSource(clubDataList.reverse());
    }
  }

  goalsScoredSort(sortMethod:Number){
    this.default();
    this.clubDataSource=new MatTableDataSource(clubDataList)
    var ftSwapped;
    do {
      ftSwapped = false;
      for (var ftClub=0; ftClub < clubDataList.length-1; ftClub++) {
        if (clubDataList[ftClub].goalsScored > clubDataList[ftClub+1].goalsScored) {
          var temp = clubDataList[ftClub];
          clubDataList[ftClub] = clubDataList[ftClub+1];
          clubDataList[ftClub+1] = temp;
          ftSwapped = true;
        }
      }
    } while (ftSwapped);
    if (sortMethod==1){
      this.clubDataSource=new MatTableDataSource(clubDataList);
    }else if (sortMethod==0){
      this.clubDataSource=new MatTableDataSource(clubDataList.reverse());
    }
  }



  default() {
    this.clubDataSource=new MatTableDataSource(clubDataList);
  }


  // sortingDecendingOrder(){
  //   this.dataSource=new MatTableDataSource(clubDataList)
  //   for(var i=1;i<clubDataList.length;i++){
  //     var itemValue=clubDataList[i].wins;
  //     var item=clubDataList[i];
  //     var j=i-1;
  //     while(j>=0 && clubDataList[j].wins>itemValue){
  //       clubDataList[j+1]=clubDataList[j];
  //       j--;
  //     }
  //     clubDataList[j+1]=item;
  //
  //   }
  // //
  // }
}
