package org.exceptions;

public final class GameIsOverException extends RuntimeException {
    public GameIsOverException(String message) {
        super(message);
    }
}

