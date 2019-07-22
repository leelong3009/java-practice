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
		node.addWord("HOME");
		Assert.assertNotNull(node.getChildren());
		Assert.assertNotNull(node.getChild('H'));
		Assert.assertNotNull(node.getChild('H').getChild('O'));
		Assert.assertNotNull(node.getChild('H').getChild('O').getChild('M'));
		Assert.assertNotNull(node.getChild('H').getChild('O').getChild('M'));
		Assert.assertNotNull(node.getChild('H').getChild('O').getChild('M').getChild('E'));
	}
	
	@Test
	public void testEndOfWord_1() {
		node.addWord("HELLO");
		Assert.assertFalse(node.getChild('H').isEndOfWord());
	}
	
	@Test
	public void testEndOfWord_2() {
		node.addWord("HOME");
		Assert.assertTrue(node.getChild('H').getChild('O').getChild('M').getChild('E').isEndOfWord());
	}
}
