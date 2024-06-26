package com.day27;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class MathOperationsTestExtend {
	private MathOperations mathOps;
	@BeforeClass
	public static void setupClass() {
		System.out.println("BeforeClass: Runs once before all tests");
	}
	@AfterClass
	public static void teardownClass() {
		System.out.println("AfterClass : Runs once after all tests");
	}
	@Before
	public void setup() {
		System.out.println("Before: Runs before each test");
		mathOps = new MathOperations();
	}
	@After
	public void teardown() {
		System.out.println("After: Runs after each test");
		mathOps = null;
	}
	@Test
	public void testAdd() {
		assertEquals(5, mathOps.add(2, 3));
		assertEquals(-1, mathOps.add(2, -3));
		assertEquals(0, mathOps.add(0, 0));
	}
	@Test
	public void testSubtract() {
		assertEquals(-1, mathOps.subtract(2, 3));
		assertEquals(5, mathOps.subtract(2, -3));
		assertEquals(0, mathOps.subtract(0, 0));
	}
	@Test
	public void testMultiply() {
		assertEquals(6, mathOps.multiply(2, 3));
		assertEquals(-6, mathOps.multiply(2, -3));
		assertEquals(0, mathOps.multiply(0, 3));
	}
	@Test
	public void testDivide() {
		assertEquals(2, mathOps.divide(6, 3));
		assertEquals(-2, mathOps.divide(6, -3));
		assertEquals(0, mathOps.divide(0, 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() {
		mathOps.divide(1,  0);
	}

}
