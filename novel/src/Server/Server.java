package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	static final int PORT = 25555; 
	ServerSocket serverSocket;
	public Server() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
			if(serverSocket != null)
				new Thread(new ServerThread()).start();
		}
	}
	private class ServerThread implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Socket socket= serverSocket.accept();
					new Thread(new SocketThread(socket)).start();;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	private class SocketThread implements Runnable{
		InputStream is;
		Socket socket;
		OutputStream os;
		BufferedReader br;
		public SocketThread(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			if(socket == null)
				return;
			try {
				is = socket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				String temp_string;
				temp_string = br.readLine();
				LI(temp_string);
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				if(br != null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		
		public void LI(String cmd){
			cmd = cmd.trim();
			switch (cmd) {
				case "get_list":
					
					break;
				case "down":
					
					break;
				case "serch":
					
					break;
				default:
					break;
			}
		}
	}
}
