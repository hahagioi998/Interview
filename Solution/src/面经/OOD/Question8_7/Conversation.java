package 面经.OOD.Question8_7;

import java.util.ArrayList;

public abstract class Conversation {
	protected ArrayList<User> participants = new ArrayList<User>();
	protected int id;
	protected ArrayList<Message> messages = new ArrayList<Message>();
	
	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public int getId() {
		return id;
	}

	//如果是list的话很好想到要加这个方法，返回的是boolean
	public boolean addMessage(Message m) {
		messages.add(m);
		return true;
	}
}
