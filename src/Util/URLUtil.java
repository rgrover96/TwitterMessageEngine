package Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLUtil {
	public static boolean isURLValid(String url) {
		Pattern p = Pattern.compile("^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
		Matcher m = p.matcher(url);
		return m.matches();
	}
	
	public static boolean compareURL(String url1, String url2) {
		try {
			URL checkUrl1 = new URL(url1);
			URL checkUrl2 = new URL(url2);
			String domainUrl1 = checkUrl1.getHost().startsWith("www.") ? checkUrl1.getHost().substring(4): checkUrl1.getHost();
			String domainUrl2 = checkUrl2.getHost().startsWith("www.") ? checkUrl2.getHost().substring(4): checkUrl2.getHost();
			if(domainUrl1.equals(domainUrl2)) {
				return true;
			}
		} catch (MalformedURLException e) {
			
		}
		return false;
	}
}
