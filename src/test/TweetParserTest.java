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
		String tweetMsg1 = "@franky goes to #hollywood. See http://cnn.com";
		String tweetMsg2 = "@franky @rohan @david goes to #hollywood. See http://cnn.com";
		TweetParser parser1 = new TweetParser(tweetMsg1);
		TweetParser parser2 = new TweetParser(tweetMsg2);
		assertEquals(parser1.numberOfMentions(), 1);
		assertEquals(parser2.numberOfMentions(), 3);
	}

	@Test
	public void isTopicTest() {
		String tweetMsg = "@franky goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.isTopic("hollywood"), true);
		assertEquals(parser.isTopic("bollywood"), false);
	}

	@Test
	public void numberOfTopicsTest() {
		String tweetMsg1 = "@franky goes to #hollywood. See http://cnn.com";
		String tweetMsg2 = "@rohan goes to #hollywood #universalstudios and #staplescenter. See http://cnn.com";
		TweetParser parser1 = new TweetParser(tweetMsg1);
		TweetParser parser2 = new TweetParser(tweetMsg2);
		assertEquals(parser1.numberOfTopics(), 1);
		assertEquals(parser2.numberOfTopics(), 3);
	}

	@Test
	public void isReferencedURLTest() {
		String tweetMsg = "@franky goes to #hollywood. See http://cnn.com";
		TweetParser parser = new TweetParser(tweetMsg);
		assertEquals(parser.isReferencedURL("http://cnn.com"), true);
		assertEquals(parser.isReferencedURL("http://www.cnn.com"), true);
		assertEquals(parser.isReferencedURL("http://nba.com"), false);
	}
	
	@Test
	public void numberOfReferencedURLTest() {
		String tweetMsg1 = "@franky goes to #hollywood. See http://cnn.com";
		String tweetMsg2 = "@franky goes to #hollywood. See http://cnn.com and http://www.abcnews.com";
		TweetParser parser1 = new TweetParser(tweetMsg1);
		TweetParser parser2 = new TweetParser(tweetMsg2);
		assertEquals(parser1.numberOfReferencedURL(), 1);
		assertEquals(parser2.numberOfReferencedURL(), 2);
	}
	
}
