package ru.tai.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by titov on 30.05.16.
 */
public class ClockView {

    JFrame jframeClock = new JFrame();
    BorderLayout blFrame = new BorderLayout();
    JPanel jpanelFrame = new JPanel();

    TimeImp timer = new TimeImp();  // Создаем объект - Поставщик времени

    public ClockView(){
        final Clock[] clock = {new DigitalClock(timer)};

        jpanelFrame.add(clock[0].getWindowContent(), blFrame.CENTER);
        jpanelFrame.revalidate();
        jpanelFrame.repaint();

        JButton jb_mode = new JButton("Mode");
        jb_mode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jpanelFrame.remove(clock[0].getWindowContent());
                timer.removeObserver(clock[0]);

                if (clock[0] instanceof DigitalClock ){
                    System.out.println("DigitalClock");
                    clock[0] = new DigitalClock_2(timer);
                }
                else if (clock[0] instanceof DigitalClock_2 ){
                    System.out.println("DigitalClock_2");
                    clock[0] = new DigitalClock(timer);
                }
                else {
                    System.out.println(clock[0].getClass().toString());
                }

                jpanelFrame.add(clock[0].getWindowContent(), blFrame.CENTER);
                jpanelFrame.revalidate();
                jpanelFrame.repaint();
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
