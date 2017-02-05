package com.ngpanwei.akka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.ngpanwei.akka.actor.persistent.MyPersistentActor;
import com.ngpanwei.akka.util.AkkaUtil;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AkkaSampleApplicationTests {

	@Test
	public void clearFolder() throws Exception {
		AkkaUtil.clearJournal(); 
	}

	@Test
	public void actor() throws Exception {
		final ActorSystem system = ActorSystem.create("example");
		
		final ActorRef actor = system.actorOf(Props.create(MyPersistentActor.class), "actor1");
		final Props props = Props.create(MyPersistentActor.class);
		final TestActorRef<MyPersistentActor> actorRef= TestActorRef.create(system, props, "testA");
		  
		actor.tell("Hello", null);
		actor.tell("World", null);
		actor.tell("snap", null);

		actor.tell("Working", null);
		actor.tell("Software", null);
		actor.tell("print", null);

		Thread.sleep(3000);
		system.terminate();
	}

}
