package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Класс для генерации рандомных значений при заполнение значений новых документов

public class Randomizer {

    private List<Integer> idArray = new ArrayList<>();

    //Генерируем случайное значение в диапазоне размера листа, чтобы можно было взять случайный элемент из коллекции
    public int randomNum(int listSize){
        return (int) (Math.random() * listSize);
    }

    //Генерируем случайную дату
    public Date randomDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        int day = (int) ((Math.random() * (32 - 1)) + 1);
        int month = (int) ((Math.random() * (13 - 1)) + 1);
        int year = (int) ((Math.random() * (2022 - 2000)) + 2000);
        return new Date(year - 1900, month, day);
    }

    //Генерируем случайный id, при это заносим их в массив для того, чтобы исключить возможнсть повторения id
    public int randomId(){
        int randId = (int) (Math.random() * 1000);
        while(idArray.contains(randId)){
            randId = (int) (Math.random() * 1000);
        }
        idArray.add(randId);
        return randId;
    }

    //Генерируем номер телефона
    public String randomOutgoingNumber(){
        String number = "";
        for(int i = 0; i < 10; i++){
            int temp = (int) (Math.random() * 10);
            number += temp;
        }
        return number;
    }
}
