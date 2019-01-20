package main.java.bitBucketReposSetup;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class ConnectionFactory {

    private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
	HttpURLConnection conn=null;
	
	
	public HttpURLConnection createHttpConnectionBitBucket(URL bitBucketProjectRepoUrl, String uid, String pwd, String reqMthd) {
		try {
			
			
			conn= (HttpURLConnection)bitBucketProjectRepoUrl.openConnection();	
			conn.setRequestMethod(reqMthd);
			conn.setRequestProperty("Accept", "application/json");
			String authString=uid + ":" + pwd;

			conn.setRequestProperty("Authorization", "Basic "+Base64.getEncoder().encodeToString(authString.getBytes()) );
			if (conn.getResponseCode() != 200) {
				logger.error("Failed : HTTP error code : "
						+ conn.getResponseCode());
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
	
			
		}catch(ProtocolException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}catch(MalformedURLException e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			e.printStackTrace();
		}catch(IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			logger.error(e.getStackTrace());
		}
		
		return conn;
	}
	
	public HttpURLConnection authorization(HttpURLConnection conn) {
		return conn;
	}
	
	public void closeConnections(HttpURLConnection conn) {		
			conn.disconnect();		
	}
}
