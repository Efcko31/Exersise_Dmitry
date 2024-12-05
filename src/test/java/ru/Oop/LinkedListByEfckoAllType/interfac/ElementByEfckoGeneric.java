package ru.Oop.LinkedListByEfckoAllType.interfac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoGeneric<T> {
    protected T data;
    protected ElementByEfckoGeneric<T> next;

    public ElementByEfckoGeneric(T data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
