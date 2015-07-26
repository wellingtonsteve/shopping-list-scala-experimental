package testapp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyScalaClassTest {

	@Test public void
	can_double_a_number() {
		MyScalaClass myScalaClass = new MyScalaClass();
		int doubleNumber = myScalaClass.doubleNumber(3);
		System.err.println("Got an answer from scala of " + doubleNumber);
		assertThat(doubleNumber, is(6));
	}
}