package ru.Oop.GameByEfcko.Backpack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Backpack {
    protected String name;
    protected ArrayList<Object> volume;
}
