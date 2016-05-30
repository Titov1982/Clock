package ru.tai.clock;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by titov on 23.05.16.
 * Конкретный класс часов основанный на JFieldText
 */
public class DigitalClock_2 implements Clock {

    private JPanel jpanelDigitalClock = new JPanel();
    private BorderLayout bl = new BorderLayout();
    private JTextField jtf = new JTextField();

    private Date time;
    private TimeImp timer = new TimeImp();

    public DigitalClock_2(){
        jpanelDigitalClock.setLayout(bl);
        jpanelDigitalClock.add(jtf, bl.CENTER);

        time = timer.getTime();
//        DateFormat dtfrm = DateFormat.getTimeInstance();
//        String dateTime = dtfrm.format(time);
//        jtf.setText(dateTime);
        jtf.setText(time.toString());
    }

    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    @Override
    public JPanel getWindowContent() {
        return jpanelDigitalClock;
    }

    // Функция остановки таймера и завершения дочернего потока (по сути - функция декаратор)
    @Override
    public void stopTimer(){
        timer.stopTimer();
    }
}
