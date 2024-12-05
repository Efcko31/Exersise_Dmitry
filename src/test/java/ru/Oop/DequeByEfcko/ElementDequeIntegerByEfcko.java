package ru.Oop.DequeByEfcko;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementDequeIntegerByEfcko<E> {
    protected Integer data;
    protected ElementDequeIntegerByEfcko<E> next;
    protected ElementDequeIntegerByEfcko<E> prev;

    public ElementDequeIntegerByEfcko(Integer data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return prev != null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
