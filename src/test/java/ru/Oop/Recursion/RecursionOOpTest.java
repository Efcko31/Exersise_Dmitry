package ru.Oop.Recursion;

import org.junit.jupiter.api.Test;

public class RecursionOOpTest {
    RecursionOop test1 = new RecursionOop(3, 10);
    RecursionOop test2 = new RecursionOop(10, 3);
    RecursionOop test3 = new RecursionOop(-5, 2);
    RecursionOop test4 = new RecursionOop(2, -5);


    @Test
    public void testRecursion() {
        test1.outputsNumbersFromAtoB(test1.getA());
        test2.outputsNumbersFromAtoB(test2.getA());
        test3.outputsNumbersFromAtoB(test3.getA());
        test4.outputsNumbersFromAtoB(test4.getA());

    }

    @Test
    public void testRecursionV2(){
        test1.printAToB();
        test2.printAToB();
        test3.printAToB();
        test4.printAToB();
    }
}
