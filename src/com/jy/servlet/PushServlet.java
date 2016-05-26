package com.jy.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

public class PushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PushServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sessionId = request.getParameter("sessionId");
		String pushmsg = request.getParameter("pushmsg");
		
		pushmsg = URLEncoder.encode(pushmsg, "utf-8");
		System.out.println("发送的消息》》》》" + pushmsg);
		
		Event event = Event.createDataEvent("/hello");
		event.setField("msg", pushmsg);
//		Dispatcher.getInstance().unicast(event, sessionId);//点对点推
		Dispatcher.getInstance().multicast(event);//批量推
		
		
//		Session[] sessions = SessionManager.getInstance().getSessions();
//		if (sessions != null && sessions.length > 0) {
//			for (int i = 0; i < sessions.length; i++) {
//				String id = sessions[i].getId();
//				sessions[i].start();
//				System.out.println(id);
//			}
//		}
		
		request.setAttribute("sessionId", sessionId);
		request.getRequestDispatcher("/pushsend.jsp").forward(request, response);
		
	}

}
