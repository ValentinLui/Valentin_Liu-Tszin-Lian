package Exceptions;

import java.util.logging.Logger;

public class NotValidInformation extends  Exception{
    private static final Logger log = Logger.getLogger(String.valueOf(NotValidInformation.class));
    public NotValidInformation (String message) {
        super(message);
        log.info("Ошибка!");
    }
}
