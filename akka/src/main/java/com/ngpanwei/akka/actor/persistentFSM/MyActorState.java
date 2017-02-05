package com.ngpanwei.akka.actor.persistentFSM;

import akka.persistence.fsm.PersistentFSM.FSMState;

public enum MyActorState implements FSMState {
	Waiting, Connecting, Busy;
	
    @Override
    public String identifier() {
        return name();
    }
}
