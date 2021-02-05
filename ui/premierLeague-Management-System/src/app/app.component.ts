import { Component } from '@angular/core';
import { ClubServices } from './services/club-services.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'premierLeague-Management-System';


 //  dataMening="";
 //
 //  constructor(private clubServices:ClubServices) {
 //  }
 //
 // async getData(){
 //   try {
 //    const data:any=await this.clubServices.getData();
 //    console.log(data);
 //    const dataValue=data.value;
 //    this.dataMening=dataValue;
 //   } catch (error) {
 //     console.log(`[ERROR] ==> AppComponent==>getData`,error);
 //     alert("Faild to get data!")
 //   }
 // }

}
