package aufgabe01;

import static org.junit.Assert.*;
import org.junit.Test;

/** 
 * Project: Aufgabe 01 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose:    Unit Test Circle.java
 * Dependence: jUnit 4
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 * 
 */
public class TestCircleV4 {

	@Test
	public void testRadius() {
		//A public void method annotated with @Test will be executed as a test.
		// fail("Not yet implemented");
		Circle k = new Circle(1);
		double expected = 1.0;
		double actual = k.Get_Radius();
		double delta = 0.01;
		assertEquals(expected, actual, delta);
		//assertTrue(expected == actual);
	}

}
