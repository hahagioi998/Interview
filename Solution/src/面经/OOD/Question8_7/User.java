package 面经.OOD.Question8_7;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {
	private int id;
	private UserStatus status = null;
	//map of privateChats
	private HashMap<Integer, PrivateChat> privateChats = new HashMap<Integer, PrivateChat>();
	private ArrayList<GroupChat> groupChats = new ArrayList<GroupChat>();

	//request也是hashmap
	private HashMap<Integer, AddRequest> receivedAddRequests = new HashMap<Integer, AddRequest>();
	private HashMap<Integer, AddRequest> sentAddRequests = new HashMap<Integer, AddRequest>();

	//这个很重要
	private HashMap<Integer, User> contacts = new HashMap<Integer, User>();
	private String accountName;
	private String fullName;
	
	public User(int id, String accountName, String fullName) {
		this.accountName = accountName;
		this.fullName = fullName;
		this.id = id;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public UserStatus getStatus() {
		return status;
	}

	//返回boolean
	public boolean sendMessageToUser(User toUser, String content) {
		//每个private chat都有id，用user的id找
		PrivateChat chat = privateChats.get(toUser.getId());
		//如果没有找到，那么久创建一个private chat
		if (chat == null) {
			chat = new PrivateChat(this, toUser);
			privateChats.put(toUser.getId(), chat);
		}
		//用得到的string content创建一个message
		Message message = new Message(content, new Date());
		return chat.addMessage(message);
	}
	
	public boolean sendMessageToGroupChat(int groupId, String content) {
		//如果没有找到，那么久创建一个group chat，直接用id找
		GroupChat chat = groupChats.get(groupId);
		if (chat != null) {
			Message message = new Message(content, new Date());
			return chat.addMessage(message);
		}
		return false;
	}
	


	public boolean addContact(User user) {
		//要先看有没有这个user，用userid找
		if (contacts.containsKey(user.getId())) {
			return false;
		} else {
			contacts.put(user.getId(), user);
			return true;
		}
	}
	
	public void receivedAddRequest(AddRequest req) {
		int senderId = req.getFromUser().getId();
		if (!receivedAddRequests.containsKey(senderId)) {
			receivedAddRequests.put(senderId, req);
		}		
	}
	
	public void sentAddRequest(AddRequest req) {
		int receiverId = req.getFromUser().getId();
		if (!sentAddRequests.containsKey(receiverId)) {
			sentAddRequests.put(receiverId, req);
		}		
	}
	
	public void removeAddRequest(AddRequest req) {
		if (req.getToUser() == this) {
			receivedAddRequests.remove(req);
		} else if (req.getFromUser() == this) {
			sentAddRequests.remove(req);
		}
	}
	
	public void requestAddUser(String accountName) {
		UserManager.getInstance().addUser(this, accountName);
	}
	
	public void addConversation(PrivateChat conversation) {
		User otherUser = conversation.getOtherParticipant(this);
		privateChats.put(otherUser.getId(), conversation);
	}

	public void addConversation(GroupChat conversation) {
		groupChats.add(conversation);
	}	
	
	public int getId() {
		return id;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public String getFullName() {
		return fullName;
	}
}
