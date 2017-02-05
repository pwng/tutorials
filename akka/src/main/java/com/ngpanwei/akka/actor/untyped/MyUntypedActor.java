package com.ngpanwei.akka.actor.untyped;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class MyUntypedActor extends UntypedActor {
    ActorRef target = null;
    
	public void onReceive(Object o) throws Exception {
		if (o.equals("hello")) {
	        getSender().tell("world", getSelf());
	        if (target != null) target.forward(o, getContext());
		} else if(o.equals("say42")) {
			getSender().tell(42, getSelf());
	      } else if (o instanceof ActorRef) {
	          target = (ActorRef) o;
	          getSender().tell("done", getSelf());
	        
		} else if (o instanceof Exception) {
			throw (Exception) o;
		}
	}

	public boolean testMe() {
		return true;
	}
}