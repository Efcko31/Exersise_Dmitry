package ru.Oop.LinkedListByEfckoAllType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfcko<E> {
    protected E data;
    protected ElementByEfcko<?> next;

    public ElementByEfcko(E data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

