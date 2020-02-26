package Exceptions;
import main.java.Main;
import java.util.logging.Logger;

public class NotEnoughInformation extends  Exception{
    private static final Logger log = Logger.getLogger(String.valueOf(NotEnoughInformation.class));
    public NotEnoughInformation (String message) {
        super(message);
        log.info("Ошибка!");
    }
}
