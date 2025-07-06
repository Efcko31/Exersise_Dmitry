package ru.Base64Excersises;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.Base64;

public class ExLvl2 {
    //Реализуйте кодирование и декодирование массива целых чисел в/из Base64
    @Test
    void encodesAndDecodesAnArrayOfIntegersTest() {
        encodesAndDecodesAnArrayOfIntegers(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public void encodesAndDecodesAnArrayOfIntegers(Integer[] numbers) {
        String encoded = Base64.getEncoder().encodeToString(intToByteArray(numbers));
        System.out.println("Закодировано: " + encoded);

        byte[] decoded = Base64.getDecoder().decode(encoded);
        Integer[] decodedNumbers = byteToIntArray(decoded);
        System.out.print("Раскодировано: ");
        for (int n : decodedNumbers) {
            System.out.print(n + " ");
        }

    }

    public byte[] intToByteArray(Integer[] numbers) {
        ByteBuffer buffer = ByteBuffer.allocate(numbers.length * Integer.BYTES);
        for (int numb : numbers) {
            buffer.putInt(numb);
        }
        return buffer.array();
    }

    public Integer[] byteToIntArray(byte[] bytes) {
        Integer[] numbers = new Integer[bytes.length / 4];
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = buffer.getInt();
        }
        return numbers;
    }

    //
}
