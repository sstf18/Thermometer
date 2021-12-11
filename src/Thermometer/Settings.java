package Thermometer;

public class Settings{
    private static final char fahrenheit = 'F';
    private static final char celsius = 'C';
    
    private double upperFeverLimit;
    private double lowerFeverLimit;
    private char tempUnit;

    //has a boolean parameter which returns true if the fever limit and temperature unit should be set to its default values. would only return false if there are saved default values
    public Settings(boolean setToDefault){
        if(setToDefault){
            toDefault();
        }
        else{
            //TODO have user manually set the defaults
        }
    }

    private void toDefault(){
        this.tempUnit=fahrenheit;
        //TODO may want to change these default fever limit values
        this.upperFeverLimit=100.4;
        this.lowerFeverLimit = 94.0;
    }

    public double getUpperFeverLimit() {
        return upperFeverLimit;
    }

    public double getLowerFeverLimit() {
        return lowerFeverLimit;
    }

    public char getTempUnit() {
        return tempUnit;
    }

    public void setLowerFeverLimit(double lowerFeverLimit) {
        this.lowerFeverLimit = lowerFeverLimit;
    }

    public void setUpperFeverLimit(double upperFeverLimit) {
        this.upperFeverLimit = upperFeverLimit;
    }

    public void setTempUnit(char tempUnit) {
        this.tempUnit = tempUnit;
    }

    public static char getCelsius() {
        return celsius;
    }

    public static char getFahrenheit() {
        return fahrenheit;
    }
}
