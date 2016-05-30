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
    private TimeImp timer;

    public DigitalClock_2(TimeImp timer){
        this.timer = timer;             // Получаем ссылку на объект поставщика времени
        timer.registerObserver(this);   // Регистрируем подписку

        jpanelDigitalClock.setLayout(bl);
        jpanelDigitalClock.add(jtf, bl.CENTER);
    }

    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    @Override
    public JPanel getWindowContent() {
        return jpanelDigitalClock;
    }

    // Метод подписчика, который вызывает поставщик времени для передачи времени
    @Override
    public void update(Date date) {
        DateFormat dtfrm = DateFormat.getTimeInstance();
        String dateTime = dtfrm.format(date);
        jtf.setText(dateTime);
    }

}
