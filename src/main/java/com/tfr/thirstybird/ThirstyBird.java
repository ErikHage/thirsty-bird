package com.tfr.thirstybird;

import java.awt.*;

/**
 *
 * Created by Erik on 10/19/2017.
 */
public class ThirstyBird {

    private Thread thread;
    private MouseMoveJob runnable;

    public void start() {
        if(runnable == null || !runnable.continueRunning) {
            runnable = new MouseMoveJob();
            thread = new Thread(runnable);
            thread.start();
        }
    }

    public void stop() {
        if(runnable != null && runnable.continueRunning) {
            System.out.println("Stopping");
            runnable.continueRunning = false;
        }
    }

    private void moveMouse() {
        System.out.println("Moving mouse");
        try {
            Point p = MouseInfo.getPointerInfo().getLocation();
            int x = (int) p.getX();
            int y = (int) p.getY();
            Robot robot = new Robot();
            robot.mouseMove(x+1, y+1);
        } catch(AWTException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private class MouseMoveJob implements Runnable {

        private boolean continueRunning = true;

        public void run() {
            System.out.println("Thirsty bird is thirsty");
            while(continueRunning) {
                moveMouse();
                try {
                    Thread.sleep(60000);
                } catch(InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
