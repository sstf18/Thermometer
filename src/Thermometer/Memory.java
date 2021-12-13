package Thermometer;
import java.io.PrintStream;
import java.util.ArrayList;

public class memory {
    ArrayList<Temperature> measuredTemperatures;
    ArrayList<Integer> temps = new ArrayList<Temperature>();
    getTemp(ArrayList<Temperature> storedTemperatures);

    public ArrayList<Temperature> getMeasuredTemperatures() {
        return measuredTemperatures;
    }

    public memory (ArrayList<Temperature> storedTemperatures) { //Call temp array from temperature class (Constructors?)\
        ArrayList<Temperature> temps;
        this.measuredTemperatures = new ArrayList<Temperature>();
        for(Temperature t : temps) {
            storedTemperatures.add(t);
        }

    }

    public void writeToStorage(PrintStream p) {
        for (Temperature t : measuredTemperatures) {
            p.println(t.getAverageTemperature() + " " + t.getTimeStamp());
        }
    }


}
