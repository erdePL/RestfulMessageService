package RestfulMessageService.database;

import RestfulMessageService.model.Message;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    public static Map<Long, Message> getMessages(){
        return messages;
    }
}
