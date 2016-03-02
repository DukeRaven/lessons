package com.lessons.n03;

/**
 * Created by Kirill on 29.02.2016.
 */
public class InvalidAgeException extends MyException {
    public InvalidAgeException() {
        super();
    }

    public InvalidAgeException(String message) {
        super(message);
    }
}
