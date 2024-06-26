package com.day27;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathOperationsTest {
	@Test
	public void testAdd() {
		MathOperations mathOps = new MathOperations();
		assertEquals(5, mathOps.add(2, 3));
		assertEquals(-1, mathOps.add(2, -3));
		assertEquals(0, mathOps.add(0, 0));
	}
	@Test
	public void testSubtract() {
		MathOperations mathOps = new MathOperations();
		assertEquals(-1, mathOps.subtract(2, 3));
		assertEquals(5, mathOps.subtract(2, -3));
		assertEquals(0, mathOps.subtract(0, 0));
	}
	@Test
	public void testMultiply() {
		MathOperations mathOps = new MathOperations();
		assertEquals(6, mathOps.multiply(2, 3));
		assertEquals(-6, mathOps.multiply(2, -3));
		assertEquals(0, mathOps.multiply(0, 3));
	}
	@Test
	public void testDivide() {
		MathOperations mathOps = new MathOperations();
		assertEquals(2, mathOps.divide(6, 3));
		assertEquals(-2, mathOps.divide(6, -3));
		assertEquals(0, mathOps.divide(0, 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() {
		MathOperations mathOps = new MathOperations();
		mathOps.divide(1,  0);
	}
	

}
