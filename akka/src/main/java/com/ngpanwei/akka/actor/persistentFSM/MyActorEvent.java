package com.ngpanwei.akka.actor.persistentFSM;

import java.io.Serializable;

/**
 * Commands are "recorded" as a sequence of "domain events" which are persisted. 
 * Those events are replayed on actor's start in order to restore the latest actor 
 * state:
 * @author pwng
 *
 */
public class MyActorEvent {

    interface DomainEvent extends Serializable {}

    public static final class Connection implements DomainEvent {
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		private static final long serialVersionUID = -6986333152368506811L;
		String address ;
    	String port ;

    }
}
