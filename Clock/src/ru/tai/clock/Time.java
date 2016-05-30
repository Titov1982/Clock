package ru.tai.clock;

import java.util.Date;

/**
 * Created by titov on 24.05.16.
 * Интерфейс поставщика времени (используем паттерн Observer)
 */
public interface Time {

    void registerObserver(Clock clock);
    void removeObserver(Clock clock);
    void notifyObservers();
}
