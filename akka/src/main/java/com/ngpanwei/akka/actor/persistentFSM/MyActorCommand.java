package com.ngpanwei.akka.actor.persistentFSM;

import java.io.Serializable;

public class MyActorCommand {
	
	public interface Command extends Serializable {
	}

	public static final class Connect implements Command {
		private static final long serialVersionUID = 4156396612910410432L;
		String address;
		String port;

		public Connect(String address, String port) {
			this.address = address;
			this.port = port;
		}

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
	}

}
