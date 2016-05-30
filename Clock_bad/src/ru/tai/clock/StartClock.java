package ru.tai.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartClock {

    public static void main(String[] args) {

        JFrame jframeClock = new JFrame();
        BorderLayout blFrame = new BorderLayout();
        JPanel jpanelFrame = new JPanel();

        final Clock[] clock = {new DigitalClock()};

        JButton jb_mode = new JButton("Mode");
        jb_mode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if (clock[0] instanceof DigitalClock ){
                    System.out.println("DigitalClock");

                    clock[0].stopTimer();
                    jpanelFrame.remove(clock[0].getWindowContent());
                    clock[0] = new DigitalClock_2();
                    jpanelFrame.add(clock[0].getWindowContent(), blFrame.CENTER);
                    jpanelFrame.revalidate();
                    jpanelFrame.repaint();
                }
                else if (clock[0] instanceof DigitalClock_2 ){
                    System.out.println("DigitalClock_2");

                    clock[0].stopTimer();
                    jpanelFrame.remove(clock[0].getWindowContent());
                    clock[0] = new DigitalClock();
                    jpanelFrame.add(clock[0].getWindowContent(), blFrame.CENTER);
                    jpanelFrame.revalidate();
                    jpanelFrame.repaint();
                }
                else {
                    System.out.println(clock[0].getClass().toString());
                }
            }
        });


        jpanelFrame.setLayout(blFrame);
        jpanelFrame.add(clock[0].getWindowContent(), blFrame.CENTER);

        jframeClock.setContentPane(jpanelFrame);
        jframeClock.add(jb_mode, blFrame.SOUTH);

        jframeClock.setSize(200, 200);
        jframeClock.setVisible(true);
        jframeClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
