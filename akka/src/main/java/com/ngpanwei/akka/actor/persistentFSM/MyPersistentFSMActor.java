package com.ngpanwei.akka.actor.persistentFSM;

import com.ngpanwei.akka.actor.persistentFSM.MyActorEvent.DomainEvent;

import akka.actor.Props;
import akka.persistence.fsm.AbstractPersistentFSM;

public class MyPersistentFSMActor extends AbstractPersistentFSM<MyActorState, MyActorData, MyActorEvent.DomainEvent> {

	private final String persistenceId;

	public static Props props(String persistenceId) {
		return Props.create(MyPersistentFSMActor.class, persistenceId);
	}

	@SuppressWarnings("deprecation")
	public MyPersistentFSMActor(String persistenceId) {
		this.persistenceId = persistenceId;

		startWith(MyActorState.Waiting, new MyActorData());

		when(MyActorState.Waiting,
			matchEvent(MyActorCommand.Connect.class, 
				(event, data) -> 
					goTo(MyActorState.Connecting)));
		
		when(MyActorState.Connecting,
			matchEvent(MyActorCommand.Connect.class, 
				(event, data) -> 
					goTo(MyActorState.Connecting)));
		
		whenUnhandled(matchAnyEvent((event, data) -> {
			log().warning("received unhandled request {} in state {}/{}", event, stateName(), data);
			return stay();
		}));
		// Initialize
		initialize();
	}

	@Override
	public String persistenceId() {
		return persistenceId;
	}

	@Override
	public Class<DomainEvent> domainEventClass() {
		return MyActorEvent.DomainEvent.class;
	}

	@Override
	public MyActorData applyEvent(DomainEvent domainEvent, MyActorData currentData) {
		throw new RuntimeException("unhandled event: " + domainEvent);
	}

}
