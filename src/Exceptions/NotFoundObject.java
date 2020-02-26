package Exceptions;

import java.util.logging.Logger;

public class NotFoundObject extends Exception {
    private static final Logger log = Logger.getLogger(String.valueOf(NotFoundObject.class));
    public NotFoundObject (String message) {
        super(message);
        log.info("Ошибка!");
    }
}
