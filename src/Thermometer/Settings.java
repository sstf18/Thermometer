package Thermometer;

class Settings{
    private static final char fahrenheit = 'F';
    private static final char celsius = 'C';
    
    private double feverLimit;
    private char tempUnit;
    private boolean setToDefault; //a boolean which returns true if the fever limit and temperature unit should be set to its default values

    public Settings(){
        if(setToDefault){

        }

        this.feverLimit = feverLimit;
        this.tempUnit = tempUnit;
    }

    private void toDefault(){
        this.tempUnit=fahrenheit;
        this.feverLimit=100.4;
    }




    public char getTempUnit() {
        return tempUnit;
    }

    public double getFeverLimit() {
        return feverLimit;
    }

    public void setTempUnit(char tempUnit) {
        this.tempUnit = tempUnit;
    }

    public void setFeverLimit(double feverLimit) {
        this.feverLimit = feverLimit;
    }
}
