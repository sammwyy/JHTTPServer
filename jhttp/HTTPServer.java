package jhttp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
	
	private int port;
	private String rootdir;
	
	private ServerSocket server;
	
	public HTTPServer () {
		this.port = 8080;
		this.rootdir = "./";
	}
	
	public HTTPServer (int port) {
		this.port = port;
	}
	
	public HTTPServer (int port, String rootdir) {
		this.rootdir = rootdir;
	}
	
	public void init () {

		try {
			server = new ServerSocket(this.port);
			System.out.println("[JHTTP] Listening server on port: " + this.port);
			
			while (true) {
				try (Socket socket = server.accept()) {
					String response = "200OK";
					socket.getOutputStream().write(response.getBytes("UTF-8"));
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
