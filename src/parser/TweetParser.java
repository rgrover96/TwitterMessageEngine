package parser;

import Util.URLUtil;

public class TweetParser {

	private String tweetMessage = null;

	public TweetParser(String message) {
		tweetMessage = message;
	}

	public boolean isMention(String mention) {
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (word.startsWith("@")) {
				if (word.contains(mention))
					return true;
			}
		}
		return false;
	}

	public int numberOfMentions() {
		int count = 0;
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (word.startsWith("@")) {
				count++;
			}
		}
		return count;
	}

	public boolean isTopic(String topic) {
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (word.startsWith("#")) {
				if (word.contains(topic))
					return true;
			}
		}
		return false;
	}

	public int numberOfTopics() {
		int count = 0;
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (word.startsWith("#")) {
				count++;
			}
		}
		return count;
	}

	public boolean isReferencedURL(String url) {
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (URLUtil.isURLValid(word)) {
				if (URLUtil.compareURL(word, url)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int numberOfReferencedURL() {
		int count = 0;
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (URLUtil.isURLValid(word)) {
				count++;
			}
		}
		return count;
	}
}
