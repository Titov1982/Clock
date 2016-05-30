package ru.tai.clock;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by titov on 23.05.16.
 * Конкретный класс часов основанный на JLable
 */
public class DigitalClock implements Clock {

    private JPanel jpanelDigitalClock = new JPanel();   // Создаем панель для конкретных часов
    private BorderLayout bl = new BorderLayout();       // Создаем лейаут для часов
    private JLabel jlableDigitalClock = new JLabel();   // Создаем сам объект, который будет показывать время

    private Date time;                      // Создаем объект - Дата и время
    private TimeImp timer = new TimeImp();  // Создаем объект - Поставщик времени

    public DigitalClock(){
        jpanelDigitalClock.setLayout(bl);                       // Устанавливаем для панели лейаут
        jpanelDigitalClock.add(jlableDigitalClock, bl.CENTER);  // Добавляем к панели объект, который будет показывать время

        time = timer.getTime(); // Получаем время из Поставщика времени
//        DateFormat dtfrm = DateFormat.getTimeInstance();
//        String dateTime = dtfrm.format(time);
//        jlableDigitalClock.setText(dateTime);

        jlableDigitalClock.setText(time.toString());    // Отображаем время в объект, который будет показывать время
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
