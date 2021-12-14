package Thermometer;
import java.io.PrintStream;
import java.util.ArrayList;

public class Memory {
    ArrayList<Temperature> measuredTemperatures;

    public ArrayList<Temperature> getMeasuredTemperatures() {
        return measuredTemperatures;
    }

    public Memory() { //Call temp array from temperature class (Constructors?)\
        this.measuredTemperatures = new ArrayList<Temperature>();

    }

    public void writeToStorage(PrintStream p) {
        for (Temperature t : measuredTemperatures) {
            p.println(t.getAverageTemperature() + " " + t.getTimestamp());
        }
    }


}
