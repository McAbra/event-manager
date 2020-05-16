package org.piotr.eventmanager.exception;

public class NotFoundEventException extends RuntimeException {

    public NotFoundEventException(String message) {
        super(message);
    }
}
