package com.bgl.challenge.PhoneWord;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LetterNodeTest {

	private LetterNode node;
	
	@Before
	public void setup() {
		node = new LetterNode();
	}
	
	@Test
	public void testAddWord_1() {
		node.addWord("HELLO");
		Assert.assertNotNull(node.getChildren());
		Assert.assertNotNull(node.getChild('H'));
	}
	
	@Test
	public void testEndOfWord_1() {
		node.addWord("HELLO");
		Assert.assertFalse(node.getChild('H').isEndOfWord());
	}
	
	@Test
	public void testEndOfWord_2() {
		node.addWord("H");
		Assert.assertTrue(node.getChild('H').isEndOfWord());
	}
}
