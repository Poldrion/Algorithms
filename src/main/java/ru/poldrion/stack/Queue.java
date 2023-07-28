package ru.poldrion.stack;

public interface Queue<T> {
    void add(T item);   // добавить элемент в конец очереди

    T remove();         // извлечение элемента из начала очереди

    boolean isEmpty();

    boolean contains(T node);
}
