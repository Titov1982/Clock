package ru.tai.clock;

import java.util.*;

/**
 * Created by titov on 24.05.16.
 * Конкретный класс поставщика времени
 */
public class TimeImp implements Time {


    private List<Clock> observers;
    final private Timer timer = new Timer();    // Создаем объект - таймер
    private Date time = new Date();             // Создаем объект - Дата и время

    public TimeImp() {

        observers = new ArrayList<Clock>();

        timer.schedule(new TimerTask() {        // В конструкторе создаем ананимный класс и его объект и перегрузаем метод Run()
            @Override
            public void run() {
                System.out.println("Прошло 1 секунды" + " " + Thread.currentThread() + " " + "Observers: " + observers.size());
                time = new Date();  // Получаем новую дату и время путем создания нового объекта

                notifyObservers();
            }
        }, 1000, 1000); // вызываем таймер каждую секунду
    }

    @Override
    public void registerObserver(Clock clock) {
        observers.add(clock);
    }

    @Override
    public void removeObserver(Clock clock) {
        observers.remove(clock);
    }

    @Override
    public void notifyObservers() {
        for (Clock observer : observers)
        {
            observer.update(time);
        }
    }
}
