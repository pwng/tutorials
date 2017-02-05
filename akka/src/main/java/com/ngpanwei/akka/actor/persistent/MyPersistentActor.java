package com.ngpanwei.akka.actor.persistent;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.persistence.AbstractPersistentActor;
import akka.persistence.SnapshotOffer;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class MyPersistentActor extends AbstractPersistentActor {
    private ExampleState state = new ExampleState();
	@Override
	public String persistenceId() { return "sample-id-1"; }

	@Override
	public PartialFunction<Object, BoxedUnit> receiveCommand() {
	      return ReceiveBuilder.
	    	        match(String.class, s -> s.equals("print"), s -> {
	    	        	System.out.println("current state = " + state) ;
	    	        }).
	    	        match(String.class, s -> s.equals("snap"), s ->
	    	          // IMPORTANT: create a copy of snapshot
	    	          // because ExampleState is mutable !!!
	    	          saveSnapshot(state.copy())).
	    	        match(String.class, s -> {
	    	          persist(s, evt -> {
	    	            state.update(evt);
	    	          });
	    	        }).
	    	        build();
	}
    @Override
    public PartialFunction<Object, BoxedUnit> receiveRecover() {
      return ReceiveBuilder.
        match(String.class, evt -> state.update(evt)).
        match(SnapshotOffer.class, ss -> {
          System.out.println("offered state = " + ss);
          state = (ExampleState) ss.snapshot();
        }).
        build();
    }

}
