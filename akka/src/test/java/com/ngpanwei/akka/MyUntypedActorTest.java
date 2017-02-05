/**
 * see http://doc.akka.io/docs/akka/current/java/testing.html
 * 
 */
package com.ngpanwei.akka;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ngpanwei.akka.actor.untyped.MyUntypedActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import scala.concurrent.duration.Duration;
import static org.junit.Assert.*;

public class MyUntypedActorTest {
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
	public void actor() throws Exception {
		/*
	     * Wrap the whole test procedure within a testkit constructor 
	     * if you want to receive actor replies or use Within(), etc.
	     */
		new JavaTestKit(system) {{
			final Props props = Props.create(MyUntypedActor.class);
		    final ActorRef subject = system.actorOf(props);
		    // can also use JavaTestKit “from the outside”
		    final JavaTestKit probe = new JavaTestKit(system);
		    subject.tell(probe.getRef(), getRef());
		    expectMsgEquals(duration("1 second"), "done");
		    new Within(duration("3 seconds")) {
		        protected void run() {
		          subject.tell("hello", getRef());
		          // This is a demo: would normally use expectMsgEquals().
		          // Wait time is bounded by 3-second deadline above.
		          new AwaitCond() {
		            protected boolean cond() {
		              return probe.msgAvailable();
		            }
		          };
		 
		          // response must have been enqueued to us before probe
		          expectMsgEquals(Duration.Zero(), "world");
		          // check that the probe we injected earlier got the msg
		          probe.expectMsgEquals(Duration.Zero(), "hello");
		          assertEquals(getRef(), probe.getLastSender());
		 
		          // Will wait for the rest of the 3 seconds
		          expectNoMsg();
		        }
		      };
		    
		}};
	}
}
