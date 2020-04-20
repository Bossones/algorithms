package net.bossones.calc.lilist;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {}

    public EmptyListException(String message) {
        super(message);
    }
}
