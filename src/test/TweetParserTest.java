package test;

import org.junit.Test;

import parser.TweetParser;


import static org.junit.Assert.*;


public class TweetParserTest {
	
	@Test
	public void isMentionTest() {
		String tweetMsg = "@franky goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.isMention("franky"), true);
		assertEquals(parser.isMention("rohan"), false);
	}
	
	@Test
	public void numberOfMentions() {
		String tweetMsg = "@franky @rohan @naveen goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.numberOfMentions(), 3);
	}
	
	@Test
	public void isTopicTest() {
		String tweetMsg = "@franky goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.isTopic("hollywood"), true);
		assertEquals(parser.isTopic("bollywood"), false);
	}
	
	@Test
	public void isReferencedURLTest() {
		String tweetMsg = "@franky goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.isReferencedURL("http://cnn.com"), true);
		assertEquals(parser.isReferencedURL("http://www.cnn.com"), true);
		assertEquals(parser.isReferencedURL("http://nba.com"), false);
	}
}
