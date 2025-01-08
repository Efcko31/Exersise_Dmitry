package ru.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoTypeInteger {
    private Integer data;
    private ElementByEfckoTypeInteger next;

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

