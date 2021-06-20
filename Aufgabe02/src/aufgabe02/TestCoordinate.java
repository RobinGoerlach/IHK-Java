package aufgabe02;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Project: Aufgabe 02 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose:    Unit Test Circle.java
 * Dependence: jUnit 4
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 * 100% code coverage although not every method has been specially tested  
 */
class TestCoordinate {
	//A public void method annotated with @Test will be executed as a test.
	//assertTrue(expected == actual);

	@Test
	void testEmptyConstructor() {
		// fail("Not yet implemented");
		Coordinate k = new Coordinate();
		k.Set_x(1);
		k.Set_y(1);
		
		double expected = Math.sqrt(2);
		double actual = k.Pythagoras();
		double delta = 0.01;
		
		assertEquals(expected, actual, delta);
	}

	@Test
	void testConstructor() {
		// fail("Not yet implemented");
		Coordinate k = new Coordinate(1,1);
		
		double expected = Math.sqrt(2);
		double actual = k.Pythagoras();
		double delta = 0.01;
		
		assertEquals(expected, actual, delta);
	}

}
