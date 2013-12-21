package com.google.appengine.codelab;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Room {
	private Set<String> members;
	private String roomName;
	
	public Room(String name) {
		members = new HashSet<String>();
		roomName = name;
	}
	
	public void addMembers(String user){
		members.add(user);
	}
	
	public void removeMembers(String user){
		members.remove(user);
	}
}
