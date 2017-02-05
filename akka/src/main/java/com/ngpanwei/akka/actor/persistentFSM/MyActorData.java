package com.ngpanwei.akka.actor.persistentFSM;

import java.io.Serializable;

public class MyActorData implements Serializable {
	private static final long serialVersionUID = 735018567077997704L;
	private String name ;
	
	@Override
	public String toString() {
		return "MyActorData [name=" + name + "]";
	}
}

