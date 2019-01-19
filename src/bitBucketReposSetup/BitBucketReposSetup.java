package bitBucketReposSetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.jsoniter.JsonIterator;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class BitBucketReposSetup {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Scanner in = new Scanner(System.in);
		String uid;
		String pwd;
		String LocalRepoDir;
		URL url;
		
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Please enter root url of bitBucket server:");		
			//ReadableByteChannel in= Channels.newChannel(System.in);
			String repoRootURL=in.next();
			System.out.println("Please enter name of bitBucket Project :");
			//String bitBucketProjName= Channels.newChannel(System.in).toString();
			String bitBucketProjName= in.next();
			 url = new URL(repoRootURL+"/rest/api/1.0/projects/"+bitBucketProjName+"/repos");

			 System.out.println("Please enter name of local dir to create/update the local copy(eg:C:\\Users\\reposTest\\):");
			 LocalRepoDir=in.next();
			 System.out.println("Please enter your bitBucket username:");
			 uid=in.next();
			 System.out.println("Please enter your bitBucket pwd:");
			 pwd=in.next();
		}

		
		String reqMthd="GET";
		String jsonRepoList="";		
		HttpURLConnection conn =null;
		ConnectionFactory connFact= new ConnectionFactory();
		conn = connFact.createHttpConnectionBitBucket(url, uid, pwd, reqMthd);
		
		
		

		
	String output;
			
				BufferedReader	br = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
			//Scanner sc = new Scanner(url.openStream());
//				JSONParser jParse = new JSONParser();
				
//				while(br.readLine()!=null){
//					
//				}
				
			while ((output=br.readLine())!=null) {
				//System.out.println("output:"+output);
//				jsonRepoList+=sc.nextLine();
				jsonRepoList+=output;
			}
			
	      
			
			//JSONObject jsonBitBucketReposListObj=null;
			
//				jsonBitBucketReposListObj = (JSONObject)jParse.parse(jsonRepoList);
				Values repo = JsonIterator.deserialize(jsonRepoList, Values.class);
				bitBucketProject proj = JsonIterator.deserialize(jsonRepoList, bitBucketProject.class);
				System.out.println("proj.getLimit() "+proj.getLimit());
				System.out.println("repo.getRepoDesc() "+repo.getRepoDesc());
				System.out.println("proj.getValues().get(1).getName() "+proj.getValues().toString());
				
				//System.out.println("jsonBitBucketReposListObj "+jsonBitBucketReposListObj);
			
			
			//System.out.println("ouside ty catch jsonBitBucketReposListObj "+jsonBitBucketReposListObj);
//			JSONArray reposListArray= (JSONArray)jsonBitBucketReposListObj.get("values");
//			
//	
//			JSONObject jRepoObj = (JSONObject) reposListArray.stream().collect(Collectors.toMap("",""))
//					//filter( jRepoObj -> ((JSONObject)jRepoObj).get("project").);
//			
			
			
			
			
			//pri
//			reposListArray.stream<JSONObject>().filter(jRepoObj -> jRepoObj.get("project")).
//			filter(jProjObj -> jProjObj.get("key")).forEach(jProjNameObj -> {
//				System.out.println(jProjNameObj);
//				
//			});
				Values r=new Values();
				bitBucketProject bBP= new bitBucketProject();
				
			Map<String, Values> repoMAp= new HashMap<String, Values>();
		//	reposListArray.get(1).
			//System.err.println(reposListArray.size());
/*			
			for(int i=0;i<reposListArray.size();i++) {
				Repos r=new Repos();
				bitBucketProject bBP= new bitBucketProject();
				JSONObject jRepoObj = (JSONObject)reposListArray.get(i);
				r.setRepoName(jRepoObj.get("name").toString());				
				//System.out.println(jRepoObj.get("name"));		
				
				JSONObject jProjObj = (JSONObject)jRepoObj.get("project");
				bBP.setProjectName(jProjObj.get("key").toString());
				//System.out.println(jProjObj.get("key"));
				JSONObject jLinksObj = (JSONObject)jRepoObj.get("links");
				
				JSONArray jCloneLinksArray = (JSONArray) jLinksObj.get("clone");
				
				//((JSONObject)jCloneLinksArray.get(0)).get("href");
				
				
				for(int j=0;j<jCloneLinksArray.size();j++) {
					JSONObject jCloneLinksObj= (JSONObject)jCloneLinksArray.get(j);
					r.setRepoCloneUrl(jCloneLinksObj.get("name").toString(), jCloneLinksObj.get("href").toString());					
					
				}
*/				
				System.out.println("Creating local repo:"+r.getRepoName());
//				CloneRepo cR=new CloneRepo();
//				cR.cloneFullRepo(r.getRepoName(), r.getRepoCloneUrl("http"), uid, pwd, LocalRepoDir+bBP.getProjectName()+"\\"+r.getRepoName());
				
				PullRepos pR= new PullRepos();
				pR.pullLatestRepoVer(r.getRepoName(), r.getRepoCloneUrl("http"), uid, pwd, LocalRepoDir+"\\"+bBP.getProjectName()+"\\"+r.getRepoName()+"\\"+".git");
				//System.out.println(System.getProperty("user.dir"));
				System.out.println("Finished creating local repo:"+r.getRepoName());

				
					
				
					
	//		}
			
		
			connFact.closeConnections(conn);
	
	}

}
