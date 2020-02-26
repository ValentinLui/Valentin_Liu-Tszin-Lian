package Exceptions;

import java.util.logging.Logger;

public class ObjectAlreadyCreated extends Exception{
    private static final Logger log = Logger.getLogger(String.valueOf(ObjectAlreadyCreated.class));
    public ObjectAlreadyCreated (String message) {
        super(message);
        log.info("Ошибка!");
    }
}
