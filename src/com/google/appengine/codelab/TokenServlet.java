package com.google.appengine.codelab;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelFailureException;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class TokenServlet extends HttpServlet{
	private static ChannelService channelService = ChannelServiceFactory.getChannelService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userid");
		if(userId != null && !userId.equals("")){
			String token = createChannel(userId);
			writeIntoChannel(response, token);
		}
	}
	
	private String createChannel(String userId){
		return channelService.createChannel(userId);
	}
	
	private void writeIntoChannel(HttpServletResponse response, String token){
		try {
			response.getWriter().print(token);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	  
}
