package ru.tai.clock;

import javax.swing.JPanel;
import java.util.Date;

/**
 * Created by titov on 23.05.16.
 * Интерфейс внешнего вида часов
 */
public interface Clock {

    // Возвратить ссылку на нашу панель с конкретными часами для панели JPanel окна JFrame
    JPanel getWindowContent();

    // Метод подписчика, который вызывает поставщик времени для передачи времени
    void update (Date date);
}
