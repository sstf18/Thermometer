package Thermometer;

import java.util.Random;
import javax.swing.*;

//just a model/proof of concept right now
//TODO change this to our actual temperature class
public class Temperature {
    private final double[] measuredTemperatures;
    private final double averageTemperature;
    private final boolean isFever;
    private String toDisplay;

    public Temperature(double[] temps){
        this.measuredTemperatures = temps;
        this.averageTemperature = calcaulateAverage();
        //this.isFever =
    }

    private double calcaulateAverage(){
        double total = 0;
        for (double d : measuredTemperatures){
            total = d + total;
        }
        return total/measuredTemperatures.length;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    private boolean calculateFever(){

    }



    public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] temperature = new double[10];
        double feverLimit = 98.6;
        Random rand = new Random();
        double upperbound = 111.0;
        double lowerbound = 94.0;
        double randomValue = lowerbound + (upperbound - lowerbound) * rand.nextDouble();
        double tempRounded = Math.round(randomValue * 100.00)/100.00;
        String toDisplay = "";
        if (tempRounded > feverLimit) {
        	System.out.print("Fever!!! " + tempRounded+"");
        	toDisplay = ("Fever!!! " + tempRounded);
        } else {
        	System.out.print(tempRounded);
        	toDisplay = ("Thermometer.Temperature: " + tempRounded);
        }
        
        JOptionPane.showMessageDialog(null, toDisplay);
	}

}
