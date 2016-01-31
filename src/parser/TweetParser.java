package parser;

public class TweetParser {

	private String tweetMessage = null;
	
	public TweetParser(String message) {
		tweetMessage = message;
	
	}
	
	public boolean isMention(String mention) {
		String[] words = tweetMessage.split(" ");
		for (String word : words) {
			if (word.startsWith("@")) {
				if(word.contains(mention))
					return true;
			}	
		}
		return false;
	}
	
	
}
