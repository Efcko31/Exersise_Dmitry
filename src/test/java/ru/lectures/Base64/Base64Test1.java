package ru.lectures.Base64;

import java.util.Base64;

public class Base64Test1 {

    public static void main(String[] args) {
        String str = "Hello Base64";

        Base64.Encoder enc = Base64.getEncoder();
        byte[] encbytes = enc.encode(str.getBytes());
        for(int i = 0; i < encbytes.length; i++ ) {
            System.out.printf("%c", (char) encbytes[i]);
            if (i != 0 && i % 4 ==0) {
                System.out.print(' ');
            }
        }
        System.out.println();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decbytes = decoder.decode(encbytes);
        System.out.println(new String(decbytes));
    }
}
