package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class TEst {
	static final String path = "D:\\вш╨о_sql.txt";

	static String acfun = "http://www.acfun.tv/a/ac2789583";
	static BufferedReader bf;
	
	public static void main(String[] args) {
		File file = new File(path);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		try {
			URL url = new URL(acfun);
			try {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept-Charset", "utf-8");
				if(conn.getResponseCode() == 200){
					String ss;
					bf = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
					while((ss = bf.readLine()) != null){
						System.out.println(ss);
					}
					
					
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
