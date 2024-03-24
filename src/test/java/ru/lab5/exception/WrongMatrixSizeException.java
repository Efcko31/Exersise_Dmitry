package ru.lab5.exception;

public class WrongMatrixSizeException extends RuntimeException {
    public WrongMatrixSizeException(String message) {
        super(message);
    }
}
