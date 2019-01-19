package bitBucketReposSetup;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;

//import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class ConnectionFactory {
	
	HttpURLConnection conn=null;
	//URL bitBucketProjectRepoUrl=null;
	
	public HttpURLConnection createHttpConnectionBitBucket(URL bitBucketProjectRepoUrl, String uid, String pwd, String reqMthd) {
		try {
			
			//bitBucketProjectRepoUrl= url;
			conn= (HttpURLConnection)bitBucketProjectRepoUrl.openConnection();	
			conn.setRequestMethod(reqMthd);
			conn.setRequestProperty("Accept", "application/json");
			String authString=uid + ":" + pwd;
			//System.out.println(authString);
			//System.out.println(Base64.getEncoder().encode(authString.getBytes()).toString());
			conn.setRequestProperty("Authorization", "Basic "+Base64.getEncoder().encodeToString(authString.getBytes()) );
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			//conn.disconnect();
			
			
		}catch(ProtocolException e) {
			e.printStackTrace();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
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
