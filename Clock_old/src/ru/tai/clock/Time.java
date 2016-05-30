package ru.tai.clock;

import java.util.Date;

/**
 * Created by titov on 24.05.16.
 * Интерфейс поставщика времени
 */
public interface Time {

    // Функция получения времени
    Date getTime();

    // Функция остановки таймера и завершения дочернего потока
    void stopTimer();
}
