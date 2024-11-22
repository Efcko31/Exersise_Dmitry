package ru.Oop.LinkedListByEfckoAllType.Integer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoTypeInteger<E> {
    protected Integer data;
    protected ElementByEfckoTypeInteger<E> next;

    public ElementByEfckoTypeInteger(Integer data) {
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

