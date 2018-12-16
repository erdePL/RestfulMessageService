package RestfulMessageService.service;

import RestfulMessageService.database.DatabaseClass;
import RestfulMessageService.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    public MessageService(){

    }

    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }
    public Message getMessage(long id){
        return messages.get(id);
    }
    public Message addMessage(Message message){
        if(message.getAuthor()!=null && message.getMessageContent()!=null) {
            message.setId(messages.size() + 1);
            messages.put(message.getId(), message);
            return messages.get(message.getId());
        }
        else
            return null;
    }
    public Message updateMessage(Message message){
        if(message.getAuthor()!=null && message.getMessageContent()!=null && messages.get(message.getId())!=null) {
            messages.put(message.getId(), message);
            return messages.get(message.getId());
        }else
            return null;
    }
    public Message removeMessage(long id){
        return  messages.remove(id);
    }
    public String removeAllMessages(){
        messages.clear();
        if(messages.isEmpty())
            return "All messages have been succesfully removed";
        else
            return "Failed to remove alll messages";
    }
}
