package ru.tai.clock;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.util.Timer;

/**
 * Created by titov on 23.05.16.
 */
public class DigitalClock implements Clock {

    private JPanel jpanelDigitalClock = new JPanel();
    private BorderLayout bl = new BorderLayout();
    private JLabel jlableDigitalClock = new JLabel();

    final private Timer timer = new Timer();
    private Date time;
//    private TimeImp timer = new TimeImp();



    public DigitalClock(){
        jpanelDigitalClock.setLayout(bl);
        jpanelDigitalClock.add(jlableDigitalClock, bl.CENTER);

//        time = timer.getTime();

//        System.out.println(time.toString());

//        jlableDigitalClock.setText(time.toString());

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("DigitalClock: Прошло 1 секунды");
                time = new Date();
                jlableDigitalClock.setText(time.toString());
            }
        }, 1000, 1000);
    }

    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    @Override
    public JPanel getWindowContent() {
        return jpanelDigitalClock;
    }

    public void stopTimer(){
        timer.cancel();
    }
}
