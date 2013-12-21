package com.google.appengine.codelab;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelFailureException;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class MessageServlet extends HttpServlet{
	private static ChannelService channelService = ChannelServiceFactory.getChannelService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String message = request.getParameter("message");
		String user = request.getParameter("to");
		String from = request.getParameter("from");
		if(user != null && !user.equals("") && message != null && !message.equals("")){
			String outputMessage = "<data>" +
					  "<type>updateChatBox</type>" +
					  "<message>"+message+"</message>" +
					  "<from>"+from+"</from>" +
					  "</data>";
			channelService.sendMessage(new ChannelMessage(user, outputMessage));
		}
	}
}
