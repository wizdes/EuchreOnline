package com.google.appengine.codelab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RoomStore {
	  private HashMap<String, Room> roomList = new HashMap<String, Room>();
	  private static RoomStore instance ;		
	  
		/**
		 * Dummy constructor for Singleton Class implementation
		 */
	  private RoomStore(){
	  }
		
		/**
		 * Gives the singleton object of FriendStore class 
		 * 
		 * @return FriendStore object
		 */
	  public static RoomStore getInstance(){
	    if(instance==null)
	      instance = new RoomStore();
	    return instance;
	  }
		
		/**
		 * Adds the new user
		 * 
		 * @param user The user to be added in the set 
		 */
	  public void addRoom(String roomName){
		  roomList.put(roomName, new Room(roomName));
	  }
		
		/**
		 * Removes a new user from the set 
		 * 
		 * @param user The user that needs to be removed from the set
		 */
	  public void removeRoom(String roomName){
		  Room toBeRemovedObject = roomList.get(roomName);
		  roomList.remove(toBeRemovedObject);
	  }
	  
	  public void addFriendToRoom(String friendName, String roomName){
		  if(roomList.containsKey(roomName)){
			  roomList.get(roomName).addMembers(friendName);
		  }
	  }

	  public void removeFriendFromRoom(String friendName, String roomName){
		  if(roomList.containsKey(roomName)){
			  roomList.get(roomName).removeMembers(friendName);
		  }
	  }
	  
	  
		/**
		 * Gives the complete set of users sorted  
		 * 
		 * @return The TreeSet object of users (String)
		 */
	  public Set<String> getFriends(){
	    return new TreeSet<String>(roomList.keySet());
	  }

}
