package ru.tai.clock;

import javax.swing.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by titov on 24.05.16.
 */
public class TimeImp implements Time {

    final private Timer timer = new Timer();
    private Date time = new Date();

    public TimeImp() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Прошло 1 секунды");
                time = new Date();
            }
        }, 1000, 1000);
    }

    @Override
    public Date getTime() {
        return time;
    }
}
