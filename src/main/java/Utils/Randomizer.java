package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Randomizer {

    public int randomNum(int listSize){
        return (int) (Math.random() * listSize);
    }

    public Date randomDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        int day = (int) ((Math.random() * (31 - 1)) + 1);
        int month = (int) ((Math.random() * (12 - 1)) + 1);
        int year = (int) ((Math.random() * (2022 - 2000)) + 2000);
        return new Date(year - 1900, month, day);
    }
}
