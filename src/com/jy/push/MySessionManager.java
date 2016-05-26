package com.jy.push;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.Session;
import nl.justobjects.pushlet.core.SessionManager;
import nl.justobjects.pushlet.util.PushletException;

/**
 * �Զ���Session����
 * @author sxq
 * @date 2016��4��27�� ����6:28:37
 */
public class MySessionManager extends SessionManager {

	@Override
	protected String createSessionId() {
		return super.createSessionId();
	}

	/**
	 * ��ȡ�Զ���Ψһ��ʶ����ΪsessionID����������request.getSession().getId()��ΪΨһ��ʶ��
	 */
	@Override
	public Session createSession(Event anEvent) throws PushletException {
		String uniqueId = anEvent.getField("uniqueId", "visitor");
		System.out.println("uniqueId>>" + uniqueId);
		return Session.create(uniqueId);
		//return super.createSession(anEvent);
	}

}
