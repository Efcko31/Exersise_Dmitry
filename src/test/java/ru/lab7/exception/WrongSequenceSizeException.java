package ru.lab7.exception;

public class WrongSequenceSizeException extends RuntimeException{
    public WrongSequenceSizeException(String message) {
        super(message);
    }

}
