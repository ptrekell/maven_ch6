package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		log.info( "Retrieving Weather Data" );
		String url = "https://query.yahooapis.com/v1/public/yql?q=";
		String toEncode = "select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='chicago, il')";

        // Use this if you need to connect via a corporate proxy
//      String proxyHost = "[proxy server]";
//      int proxyPort = [proxy server port];
//      SocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
//      Proxy httpProxy = new Proxy(Proxy.Type.HTTP, addr);
//      URLConnection conn = new URL(url).openConnection(httpProxy);
		URLConnection conn = new URL(url + URLEncoder.encode(toEncode,"UTF-8")).openConnection();
		return conn.getInputStream();
	}

}
