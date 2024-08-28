package ru.Oop.Recursion;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecursionOop {
    private int a;
    private int b;
    private int number = a;

    public RecursionOop(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int outputsNumbersFromAtoB(int number) {
        if (number == b) {
            System.out.println(b + "\n");
            return 0;
        } else {
            System.out.print(number + " ");
            number = number + (((a - b) / Math.abs(a - b)) * -1);
        }
        return outputsNumbersFromAtoB(number);
    }

    public void printAToB() {
        if (a < b) {
            printStep(1, a, b);
        } else{
            printStep(-1, a, b);
        }
    }

    private void printStep(int step, int number, int stop) {
        System.out.print(number);
        number = number + step;
        if( number == stop) {
            System.out.println();
        } else {
            printStep(step, number, stop);
        }
    }
}
