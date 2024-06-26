package com.day27;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class StringUtilsTest {
	private StringUtils stringUtils;
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
		stringUtils = new StringUtils();
	}
	@After
	public void teardown() {
		System.out.println("After: Runs after each test");
		stringUtils = null;
	}
	@Test
	public void testIsPalindrome() {
		assertTrue(stringUtils.isPalindrome("madam"));
		assertFalse(stringUtils.isPalindrome("hello"));
		assertFalse(stringUtils.isPalindrome(null));
	}
	@Test
	public void testReverse() {
		assertEquals("dcba", stringUtils.reverse("abcd"));
		assertEquals("", stringUtils.reverse(""));
		assertEquals(null, stringUtils.reverse(null));
	}
	@Test
	public void testContainsOnlyDigits() {
		assertTrue(stringUtils.containsOnlyDigits("123456"));
		assertFalse(stringUtils.containsOnlyDigits("123wer"));
		assertFalse(stringUtils.containsOnlyDigits(""));
		assertFalse(stringUtils.containsOnlyDigits(null));
	}

}
