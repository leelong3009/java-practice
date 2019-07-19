package com.bgl.challenge.PhoneWord;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private Util util;
	private Dictionary dict;
	private PhoneWord phoneword;
	
	@Before
	public void setup() {
		util = new Util();
		List<String> words = new ArrayList<String>();
		words.add("STAR");
		words.add("PLACES");
		words.add("HELLO");
		words.add("WORLD");
		words.add("WARS");
		words.add("KITTY");
		dict = util.createDictionary(words);
		phoneword = new PhoneWord(dict);
	}
	
	@Test
	public void testValidMatchPhoneNumber_1() {
		List<String> matchedWords = phoneword.findAnyMatches("54889");
		String[] expectedWords = new String[] {"KITTY"};
		Assert.assertArrayEquals(expectedWords, matchedWords.toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_2() {
		List<String> matchedWords = phoneword.findAnyMatches("782792771");
		String[] expectedWords = new String[] {"STAR-WARS-1"};
		Assert.assertArrayEquals(expectedWords, matchedWords.toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_4() {
		List<String> matchedWords = phoneword.findAnyMatches("7827192771");
		String[] expectedWords = new String[] {"STAR-1-WARS-1"};
		Assert.assertArrayEquals(expectedWords, matchedWords.toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_3() {
		List<String> matchedWords = phoneword.findAnyMatches("7827927711");
		String[] expectedWords = new String[] {};
		Assert.assertArrayEquals(expectedWords, matchedWords.toArray());
	}
	
	@Test
	public void testInvalidMatchPhoneNumber_1() {
		List<String> matchedWords = phoneword.findAnyMatches("11111");
		String[] expectedWords = new String[] {};
		Assert.assertArrayEquals(expectedWords, matchedWords.toArray());
	}
}
