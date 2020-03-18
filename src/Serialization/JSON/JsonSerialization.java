package Serialization.JSON;
import Control.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JsonSerialization {
    public static final Logger log = Logger.getLogger(String.valueOf(JsonSerialization.class));
    private static String jsonUser;
    private static ObjectMapper mapper;
    public static void   Serialization() throws IOException {
        mapper = new ObjectMapper();
        jsonUser = mapper.writeValueAsString(Manager.getContactList());
        mapper.writeValue(new File("ManagerSerialization.json"), Manager.getContactList());
    }
    public static void Deserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuffer json = new StringBuffer(readUsingScanner("ManagerSerialization.json"));
        log.info("Десириализую!");
        Manager.setContactList(mapper.readValue(json.toString(), ArrayList.class));
    }

    private static String readUsingScanner(String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("ManagerSerialization.json"));){
            log.info("Считываю с файла коллекцию!");
            return reader.readLine();
        }
    }
}
