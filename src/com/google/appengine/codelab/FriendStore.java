package com.google.appengine.codelab;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FriendStore {
	  private Set<String> friendsList = new HashSet<String>();
	  private static FriendStore instance ;		
	  
		/**
		 * Dummy constructor for Singleton Class implementation
		 */
	  private FriendStore(){
	  }
		
		/**
		 * Gives the singleton object of FriendStore class 
		 * 
		 * @return FriendStore object
		 */
	  public static FriendStore getInstance(){
	    if(instance==null)
	      instance = new FriendStore();
	    return instance;
	  }
		
		/**
		 * Adds the new user
		 * 
		 * @param user The user to be added in the set 
		 */
	  public void addNewFriend(String user){
	    friendsList.add(user);
	  }
		
		/**
		 * Removes a new user from the set 
		 * 
		 * @param user The user that needs to be removed from the set
		 */
	  public void removeFriend(String user){
	    friendsList.remove(user);
	  }
		
		/**
		 * Gives the complete set of users sorted  
		 * 
		 * @return The TreeSet object of users (String)
		 */
	  public Set<String> getFriends(){
	    return new TreeSet<String>(friendsList);
	  }
	}
