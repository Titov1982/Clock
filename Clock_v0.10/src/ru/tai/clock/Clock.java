package ru.tai.clock;

import javax.swing.*;

/**
 * Created by titov on 23.05.16.
 */
public interface Clock {
    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    JPanel getWindowContent();

    // Останавливаем таймер
    void stopTimer();
}
