package com.ngpanwei.akka;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ngpanwei.akka.actor.persistentFSM.MyActorCommand;
import com.ngpanwei.akka.actor.persistentFSM.MyPersistentFSMActor;
import com.ngpanwei.akka.util.AkkaUtil;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;

public class MyPersistentFSMActorTest {
	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		JavaTestKit.shutdownActorSystem(system);
		system = null;
	}

	@Test
	public void clearJournal() throws Exception {
		AkkaUtil.clearJournal(); 
	}

	@Test
	public void should_run() throws Exception {
		/*
	     * Wrap the whole test procedure within a testkit constructor 
	     * if you want to receive actor replies or use Within(), etc.
	     */
		new JavaTestKit(system) {{
            final ActorRef actor = system.actorOf(MyPersistentFSMActor.props("actorP"));
            actor.tell(new MyActorCommand.Connect("localhost","8080"), null);
            Thread.sleep(5000) ;
		}};
	}	
}
