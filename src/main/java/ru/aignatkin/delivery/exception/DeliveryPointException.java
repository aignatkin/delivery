package ru.aignatkin.delivery.exception;

public class DeliveryPointException extends Exception{
    public DeliveryPointException() {
    }

    public DeliveryPointException(String message) {
        super(message);
    }

    public DeliveryPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryPointException(Throwable cause) {
        super(cause);
    }

    public DeliveryPointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
