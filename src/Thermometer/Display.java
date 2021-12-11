package Thermometer;

import javax.swing.*;
import java.awt.*;


public class Display extends JPanel {

    private JButton scanButton;
    private JTextPane display; //the swing component that displays the text from the toDisplay string
    private String toDisplay; //the string that is displayed on the pane
    private JButton powerButton;
    private boolean scanning;
    private final Settings settings;

    public Display(String toDisplay, Settings settings){
        this.toDisplay = toDisplay;
        this.settings = settings;
        this.scanning = false;
        init();
    }

    public void paint(Graphics g) {
        super.paint(g);
        display.setText(toDisplay);
    }

    public void init(){
        //where the text will be displayed
        JPanel screen = new JPanel();
        scanButton = new JButton("Scan Button");
        powerButton = new JButton("Power Button");
        display = new JTextPane();
        display.setEditable(false);
        display.setText(toDisplay);
        screen.add(display);
        add(screen);
        add(scanButton);
        add(powerButton);
        initButtons();
    }

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

    void scan(){
        Temperature temperature = Button.scanButton(settings);
        toDisplay = temperature.getToDisplay();
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