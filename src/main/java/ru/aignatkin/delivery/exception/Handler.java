package ru.aignatkin.delivery.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class Handler {
    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(Handler.class);

    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.info("Unhandled exception caught!");
    }
}
