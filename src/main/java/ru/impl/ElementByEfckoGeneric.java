package ru.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoGeneric<T> {
    private T data;
    private ElementByEfckoGeneric<T> next;

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
