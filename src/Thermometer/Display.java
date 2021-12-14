package Thermometer;

import javax.swing.*;
import java.awt.*;

/**
 * A class which represents the display of a thermometer
 */
public class Display extends JPanel {

    /**
     * A JButton object which represents the scan button
     */
    private JButton scanButton;
    /**
     * A JTextPane which shows the text that will be seen by the user
     */
    private JTextPane textDisplay;
    /**
     * A string that contains what will be shown on the textDisplay
     */
    private String toDisplay;
    /**
     * A JButton object which represents the powerButton
     */
    private JButton powerButton;
    /**
     * A boolean which returns true if the thermometer is 'scanning' temperatures
     */
    private boolean scanning;
    /**
     * A settings object which contains all the settings for the thermometer
     */
    private final Settings settings;

    public Display(String toDisplay, Settings settings){
        this.toDisplay = toDisplay;
        this.settings = settings;
        this.scanning = false;
        init();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        textDisplay.setText(toDisplay);
    }

    /**
     * A method that initializes the swing components
     */
    public void init(){
        //where the text will be displayed
        JPanel screen = new JPanel();
        scanButton = new JButton("Scan Button");
        powerButton = new JButton("Power Button");
        textDisplay = new JTextPane();
        textDisplay.setEditable(false);
        textDisplay.setText(toDisplay);
        screen.add(textDisplay);
        add(screen);
        add(scanButton);
        add(powerButton);
        initButtons();
    }

    /**
     * A method that initializes the action listeners for the swing buttons
     */
    void initButtons(){
        powerButton.addActionListener(this::powerButton);
        scanButton.addActionListener(this::scanButton);
    }

    void powerButton(java.awt.event.ActionEvent evt){
        Button.powerOn();
    }

    void scanButton(java.awt.event.ActionEvent evt){
        scanning = true;
    }

    /**
     * A method which simulates the thermometer scanning someone
     */
    Temperature scan(){
        Temperature temperature = Button.scanButton(settings);
        toDisplay = temperature.getToDisplay();
        return temperature;
    }

    public boolean isScanning() {
        return scanning;
    }

    public void setScanning(boolean scanning) {
        this.scanning = scanning;
    }

    public String getToDisplay() {
        return toDisplay;
    }

    public void setToDisplay(String toDisplay) {
        this.toDisplay = toDisplay;
    }

}