package net.dvt32.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import net.dvt32.javabrains.messenger.database.DatabaseClass;
import net.dvt32.javabrains.messenger.exception.DataNotFoundException;
import net.dvt32.javabrains.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put( 1L, new Message(1, "Hello World", "dvt32") );
		messages.put( 2L, new Message(2, "Hello Jersey", "dvt32") );
	}
	
	// GET
	public List<Message> getAllMessages() {
		return new ArrayList<Message>( messages.values() );
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		else {
			return message;
		}
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		
		for (Message message : messages.values()) {
			cal.setTime( message.getCreated() );
			if ( cal.get(Calendar.YEAR) == year ) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		if (start + size > list.size()) {
			return new ArrayList<Message>();
		}
		
		return list.subList(start, start + size);
	}
	
	// POST / PUT / DELETE
	public Message addMessage(Message message) {
		message.setId( messages.size()+1 );
		messages.put( message.getId(), message );
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
