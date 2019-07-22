package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private Dictionary dict;
	
	@Before
	public void setUp() {
		List<String> words = new ArrayList<String>();
		words.add("HELLO");
		dict = new Dictionary(words);
	}
	
	@Test
	public void testContain() {
		Assert.assertNotNull(dict.contains("HE"));
		Assert.assertNotNull(dict.contains("HELLO"));
		Assert.assertTrue(dict.contains("HELLO").isEndOfWord());
	}
}
