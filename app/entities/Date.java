package entities;

import java.io.Serializable;

public class Date implements Serializable {
    private int month;
    private int day;
    private int year;


    public Date(int year,int month,int day) {
        this.setMonth(month,day);
        this.setYear(year);
    }

    public int getMonth() {
        return month;
    }

    private void setMonth(int month,int day) {
        //Validating Month
        if (month>0 && month<=12) {
            this.month=month;
        }else {
            System.out.println("Invalid Month");
        }

        int[] dayInMonth=new int[]{0,31,28,31,30,31,31,30,31,30,31,30,31};
        //check if day in range for month
        if(day>0 && day<=dayInMonth[month]){
            this.day=day;
        }

//        //check for leap year
        if (year ==2 && day==29 && (year %400==0 || (year % 4==0 && year %100!=0))) {

            this.day=day;
        }
    }

    public int getDay() {
        return day;
    }



    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {

        String date=null;
        String month_s=null;
        if (day<10){
            date= String.format("%02d",day);
        }else {
            date=String.valueOf(day);
        }

        if (month<10){
            month_s = String.format("%02d", month);
        }else{
            month_s=String.valueOf(month);
        }

        return year+"-"+month_s+"-"+date;
    }
}
