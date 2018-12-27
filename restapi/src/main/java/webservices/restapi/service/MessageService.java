package webservices.restapi.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webservices.restapi.database.DatabaseClass;
import webservices.restapi.model.Message;

public class MessageService {

	private  Map<Long,Message> messages=DatabaseClass.getMessages();
	public MessageService(){
		messages.put(1L, new Message(1L,"HelloWorld","Ashok"));
		messages.put(2L, new Message(2L,"HelloWorld Restful","Jagad"));

	}
	public List<Message> getallMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public List<Message> getMessagesforyear(int year){
		List<Message> mpy=new ArrayList<Message>();
		Calendar c=Calendar.getInstance();
		for(Message m: messages.values()) {
			c.setTime(m.getCreated());
			if(c.get(Calendar.YEAR)==year) mpy.add(m);
		}
		return mpy;
	}
	public List<Message> getMessagePaginated(int start, int stop){
		List<Message> gmp=new ArrayList<>(messages.values());
		return gmp.subList(start, stop);
		
	}

	public Message getMessage(long i) {

		return messages.get(i);

	}
	public Message addMessage(Message mg) {
		mg.setId(messages.size()+1);
		messages.put(mg.getId(), mg);
		return mg;
	}
	public Message updateMessage(Message m) {
		if(m.getId()<=0) return null;
		else
			messages.put(m.getId(), m); 
		return m;
	}
	public void deleteMessage(long id) {
		messages.remove(id);

	}

}
