package Thermometer;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    //TODO instantiate a settings class and memory class

    //a main method without a gui
    static void main2(){
        //TODO do power on and self test methods here
        Settings settings = new Settings(true);
        Scanner scan = new Scanner(System.in);

        //TODO may want to make this a swing gui later on
        while(true){
            System.out.print("What would you like to do? \n[1] Scan Temperature \n[2].. ");
            int input = 0;
            try{
                input = scan.nextInt();
            }catch (InputMismatchException e){
                System.out.print("You have to input a number from above");
            }
            if(input == 1){
                Button.scanButton(settings);
            }

        }

    }

    //a main method with a gui
    static void main3(){
        Settings settings = new Settings(true);
        Display display = new Display("Press the Power Button to power on the machine", settings);
        JFrame frame = new JFrame("Group Z Thermometer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,100);
        frame.setLocationRelativeTo(null);
        frame.add(display);
        frame.setVisible(true);
        StringBuilder scan;

        for(;;){
            try {
                Thread.sleep(100);
                scan = new StringBuilder("Please wait while the temperature is being measured");

                if(display.isScanning()){
                    for (int i = 0; i < 5; i++) {

                        Thread.sleep(1000);
                        display.setToDisplay(scan.toString());
                        frame.repaint();
                        scan.append(".");
                    }
                    display.setScanning(false);
                    display.scan();
                }
                frame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        main3();
    }

}
