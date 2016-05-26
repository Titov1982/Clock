package ru.tai.clock;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

/**
 * Created by titov on 23.05.16.
 */
public class DigitalClock_2 implements Clock {

    private JPanel jpanelDigitalClock = new JPanel();
    private BorderLayout bl = new BorderLayout();
    private JTextField jtf = new JTextField();

    final private java.util.Timer timer = new java.util.Timer();
    private Date time;

    public DigitalClock_2(){
        jpanelDigitalClock.setLayout(bl);
        jpanelDigitalClock.add(jtf, bl.CENTER);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("DigitalClock_2: Прошло 1 секунды");
                time = new Date();
                jtf.setText(time.toString());
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
