package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    private Date date=new Date(2020,5,8);

    @Test
    public void getMonth() {

        int expectedOutPut=5;
        int actualOutPut=date.getMonth();
        assertEquals(expectedOutPut,actualOutPut);


    }

    @Test
    public void getDay() {
        int expectedOutput=8;
        int actualOutput=date.getDay();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void getYear() {
        int expectedOutput=2020;
        int actualOutput=date.getYear();
        assertEquals(expectedOutput,actualOutput);
    }
}