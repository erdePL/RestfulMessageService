package RestfulMessageService.resource;

import RestfulMessageService.model.Message;
import RestfulMessageService.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }
    @GET
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }
    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }
    @DELETE
    @Path("/{messageId}")
    public Message removeMessage(@PathParam("messageId") long id){
        return messageService.removeMessage(id);
    }
    @DELETE
    public String removeAllMessages(){
        return messageService.removeAllMessages();
    }
}

