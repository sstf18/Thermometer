package Thermometer;


import java.util.Date;

public class Temperature {
    private final double[] measuredTemperatures;
    private double averageTemperature;
    private String toDisplay;
    private final Settings settings;
    private final Date timestamp;


    public Temperature(double[] temps, Settings settings){
        this.measuredTemperatures = temps;
        this.settings = settings;
        this.timestamp = new Date();
        this.averageTemperature = calculateAverage();
        System.out.println(averageTemperature);
        calculateFever();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    //TODO may want to have a method to convert the temperatures to different units?

    private double calculateAverage(){
        double total = 0;
        for (double d : measuredTemperatures){
            total = d + total;
        }
        return Math.round(total/measuredTemperatures.length*100.0)/100.0; //TODO change this to the correct number of decimal places

    }

    //converts the temperature to celsius if the settings call for celsius
    private void convert(){
        if(settings.getTempUnit() == Settings.getCelsius()){
            averageTemperature = Math.round((averageTemperature-32)*5/9 *100.00)/100.00;
        }
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    //a boolean which returns true if the average temperature measured is below the fever limit and false if it is above the fever limit
    private boolean calculateFever(){
        if(settings.getUpperFeverLimit() <= averageTemperature && settings.getTempUnit() == Settings.getFahrenheit()){
            toDisplay = "Fever Alert!! The measured temperature of " + averageTemperature + " is above the fever limit of " + settings.getUpperFeverLimit();
            return false;
        }
        else if(settings.getUpperFeverLimit() <= averageTemperature && settings.getTempUnit() == Settings.getCelsius()){
            convert();
            toDisplay = "Fever Alert!! The measured temperature of " + averageTemperature + " is above the fever limit of " + ((settings.getUpperFeverLimit()-32)*5/9);
            return false;
        }
        else if(settings.getLowerFeverLimit() >= averageTemperature && settings.getTempUnit() == Settings.getFahrenheit()){
            toDisplay = "Fever Alert!! The measured temperature of " + averageTemperature + " is below the fever limit of " + settings.getLowerFeverLimit();
            return false;
        }
        else if(settings.getLowerFeverLimit() >= averageTemperature && settings.getTempUnit() == Settings.getCelsius()){
            convert();
            toDisplay = "Fever Alert!! The measured temperature of " + averageTemperature + " is below the fever limit of " + ((settings.getLowerFeverLimit()-32)*5/9);
            return false;
        }
        else{
            toDisplay = "The measured temperature is within the fever limits";
            return true;
        }
    }

    public String getToDisplay() {
        return toDisplay;
    }

    //TODO log the temperature from the memory class
}
