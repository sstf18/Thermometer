package Thermometer;

import java.util.Random;

class Button{



    public static void powerOn(){

    }

   public static Temperature scanButton(Settings settings){
       Random rand = new Random();
       double[] temps = rand.doubles(10, 90,110).toArray(); //TODO may want to change the random values later on
       Temperature temperature = new Temperature(temps, settings);
       //TODO add the measured temperature value to the memory list
       //memoryList.add(temperature);
       return temperature;

    }
}
