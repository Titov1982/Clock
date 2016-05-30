package ru.tai.clock;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by titov on 24.05.16.
 * Конкретный класс поставщика времени
 */
public class TimeImp implements Time {

    final private Timer timer = new Timer();    // Создаем объект - таймер
    private Date time = new Date();             // Создаем объект - Дата и время

    public TimeImp() {
        timer.schedule(new TimerTask() {        // В конструкторе создаем ананимный класс и его объект и перегрузаем метод Run()
            @Override
            public void run() {
                System.out.println("Прошло 1 секунды");
                time = new Date();  // Получаем новую дату и время путем создания нового объекта
            }
        }, 1000, 1000); // вызываем таймер каждую секунду
    }

    // Функция возвращает ссылку на объект Date, который содержит текущее время
    @Override
    public Date getTime() {
        return time;
    }

    // Функция завершения работы таймера посредствам завершения дочернего потока
    // Функция необходима при переключении вида часов? Так как для каждого вида часов создается свой таймер
    @Override
    public void stopTimer() {
        timer.cancel();
    }
}
