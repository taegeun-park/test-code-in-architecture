package org.example.sample;

public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException() {
        super("Invalid operator, you need to choose one of (+,-,*,/)");

    }
}
