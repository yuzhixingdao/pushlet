package com.jy.servlet;

import java.io.Serializable;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class HelloEventPullSource extends EventPullSource implements Serializable {

	public HelloEventPullSource() {
		super();
	}

	@Override
	protected long getSleepTime() {
		return 2000;
	}

	@Override
	protected Event pullEvent() {
		Event event = Event.createDataEvent("/hello");
        return event;
	}

}

