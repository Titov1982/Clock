package ru.tai.clock;

import javax.swing.JPanel;

/**
 * Created by titov on 23.05.16.
 * Интерфейс внешнего вида часов
 */
public interface Clock {

    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    JPanel getWindowContent();

    // Функция остановки таймера и завершения дочернего потока (по сути - функция декаратор)
    void stopTimer();
}
