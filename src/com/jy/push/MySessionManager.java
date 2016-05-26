package com.jy.push;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.Session;
import nl.justobjects.pushlet.core.SessionManager;
import nl.justobjects.pushlet.util.PushletException;

/**
 * 自定义Session创建
 * @author sxq
 * @date 2016年4月27日 下午6:28:37
 */
public class MySessionManager extends SessionManager {

	@Override
	protected String createSessionId() {
		return super.createSessionId();
	}

	/**
	 * 获取自定义唯一标识，作为sessionID（此事例用request.getSession().getId()作为唯一标识）
	 */
	@Override
	public Session createSession(Event anEvent) throws PushletException {
		String uniqueId = anEvent.getField("uniqueId", "visitor");
		System.out.println("uniqueId>>" + uniqueId);
		return Session.create(uniqueId);
		//return super.createSession(anEvent);
	}

}
