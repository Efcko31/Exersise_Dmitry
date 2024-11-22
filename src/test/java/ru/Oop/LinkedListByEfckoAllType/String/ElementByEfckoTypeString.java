package ru.Oop.LinkedListByEfckoAllType.String;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoTypeString<E> {
    protected String data;
    protected ElementByEfckoTypeString<E> next;

    public ElementByEfckoTypeString(String data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return data;
    }
}
