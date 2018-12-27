package webservices.restapi.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import webservices.restapi.model.Message;
import webservices.restapi.resources.beans.MessageBeanResource;
import webservices.restapi.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageBeanResource mbr
			/* @QueryParam(value = "year") int year,
			 @QueryParam(value = "start") int start,
			 @QueryParam(value = "stop") int stop*/
			) {
		if(mbr.getYear()>0) 
		{
			return ms.getMessagesforyear( mbr.getYear());
		}
		if(mbr.getStart()>=0&&mbr.getStop()>0) return ms.getMessagePaginated(mbr.getStart(), mbr.getStop());
		return ms.getallMessages();
	}

	@Path("/{id}")
	@GET
	public Message getMessage(@PathParam(value = "id") Long id) {
		return ms.getMessage(id);
	}
	@POST
	public Message addMessage(Message m) {
		return ms.addMessage(m);
	}
	@PUT
	@Path("/{id}")
	public Message updateMessage(@PathParam(value="id") Long id,Message m) {
		m.setId(id);

		return ms.updateMessage(m);
	}
	@DELETE
	@Path("/{d}")
	public void deleteMessage(@PathParam(value="d") Long d) {
		ms.deleteMessage(d);
	}
}
