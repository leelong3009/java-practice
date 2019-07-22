package com.bgl.challenge.PhoneWord;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PhoneWordTest {
	private Dictionary dict;
	private PhoneWord phoneword;
	
	@Before
	public void setup() {
		List<String> words = new ArrayList<String>();
		words.add("STAR");
		words.add("PLACES");
		words.add("HELLO");
		words.add("WORLD");
		words.add("WARS");
		words.add("KITTY");
//		dict = mock(Dictionary.class);
		dict = new Dictionary(words);
		phoneword = new PhoneWord(dict);
	}
	
	@Test
	public void testValidMatchPhoneNumber_1() {
		phoneword.findWordMatches("3548891");
		String[] expectedWords = {"3-KITTY-1"};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_2() {
		phoneword.findWordMatches("782792771");
		String[] expectedWords = {"STAR-WARS-1"};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_4() {
		phoneword.findWordMatches("7827292771");
		String[] expectedWords = {"STAR-2-WARS-1"};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testValidMatchPhoneNumber_5() {
		phoneword.findWordMatches("2");
		String[] expectedWords = {"2"};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testInvalidMatchPhoneNumber_1() {
		phoneword.findWordMatches("22222");
		String[] expectedWords = {};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testInvalidMatchPhoneNumber_2() {
		phoneword.findWordMatches("7827927711");
		String[] expectedWords = {};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
	
	@Test
	public void testInvalidMatchPhoneNumber_3() {
		phoneword.findWordMatches("");
		String[] expectedWords = {};
		Assert.assertArrayEquals(expectedWords, phoneword.getMatchedWords().toArray());
	}
}
