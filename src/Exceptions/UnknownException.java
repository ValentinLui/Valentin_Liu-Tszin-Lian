package Exceptions;

import java.util.logging.Logger;

public class UnknownException extends  Exception{
    private static final Logger log = Logger.getLogger(String.valueOf(UnknownException.class));
    public UnknownException (String message) {
        super(message);
        log.info("Ошибка!");
    }
}
