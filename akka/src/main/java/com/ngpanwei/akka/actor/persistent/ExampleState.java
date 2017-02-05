package com.ngpanwei.akka.actor.persistent;

import java.io.Serializable;
import java.util.ArrayList;

public class ExampleState implements Serializable {
	private static final long serialVersionUID = 1L;
	private final ArrayList<String> received;

	public ExampleState() {
		this(new ArrayList<String>());
	}

	public ExampleState(ArrayList<String> received) {
		this.received = received;
	}

	public ExampleState copy() {
		return new ExampleState(new ArrayList<String>(received));
	}

	public void update(String s) {
		received.add(s);
	}

	@Override
	public String toString() {
		return received.toString();
	}
}
