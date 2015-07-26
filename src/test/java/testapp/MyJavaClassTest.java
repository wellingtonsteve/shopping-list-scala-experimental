package testapp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyJavaClassTest {

	@Test public void
	can_double_a_number() {
		MyJavaClass myJavaClass = new MyJavaClass();
		int doubleNumber = myJavaClass.doubleNumber(3);
		System.err.println("Got an answer of " + doubleNumber);
		assertThat(doubleNumber, is(6));
	}
}