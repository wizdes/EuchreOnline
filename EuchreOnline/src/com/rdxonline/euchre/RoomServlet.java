package com.rdxonline.euchre;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

@SuppressWarnings("serial")
public class RoomServlet extends HttpServlet{
	private static ChannelService channelService = ChannelServiceFactory.getChannelService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FriendStore friendstore = FriendStore.getInstance();
		
		String room = request.getParameter("roomid");
	  	String user = request.getParameter("userid"); 
	  	response.setContentType("text/xml");
	  	String outputTxt =	"<data>\n" ;
	  	
	  	if(!friendstore.getFriends().contains(user)){
	  		friendstore.addNewFriend(user);
	  	}

	    Iterator<String> friendList = friendstore.getFriends().iterator();
	    
	  	//Add all the users logged in already to the new user friends list
	    // and also update all of them about the new user
	    while(friendList.hasNext()){
	  	  String friend = friendList.next() ;
	      if(!friend.equals(user)){
	        outputTxt +="<friend><name>" + friend +"</name></friend>\n";
	        channelService.sendMessage(
	  		  new ChannelMessage(friend,"<data>" +
	  			"<type>updateFriendList</type>" +
	  			"<message>"+user+"</message>" +
	  			"<from>Server</from>" +	"</data>"));
	  	  }
	    }
	    
	    outputTxt += "</data>\n";
	    response.getWriter().print(outputTxt);
	  }	    	
}