package Thermometer;

import java.util.Random;

class Button{

    public static void powerOn(){

    }

   public static Temperature scanButton(Settings settings){
       Random rand = new Random();
       double[] temps = rand.doubles(10, 90,110).toArray();
       //TODO may want to change the random values later on
       Temperature temperature = new Temperature(temps, settings);
       return temperature;

    }
}
