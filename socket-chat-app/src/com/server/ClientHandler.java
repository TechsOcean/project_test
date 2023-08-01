package com.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

	public static ArrayList<ClientHandler> clientHandler = new ArrayList<>();
	private Socket socket;
	private BufferedReader bufferReader;
	private BufferedWriter bufferWriter;
	private String clientUserName;
	
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.clientUserName = bufferReader.readLine();
			clientHandler.add(this);
			broadCastMessge("SERVER: "+ clientUserName + " has entered into chat");
		}
		catch(IOException e) {
			closeEverything(socket, bufferReader, bufferWriter);
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String messageFromClient;
		while(socket.isConnected()) {
			try {
				messageFromClient = bufferReader.readLine();
				broadCastMessge(messageFromClient);
			}
			catch(IOException e) {
				closeEverything(socket, bufferReader, bufferWriter);
				break;
			}
		}
	}
	
	public void broadCastMessge(String message) {
		for(ClientHandler client : clientHandler) {
			try {
				if(!client.clientUserName.equals(clientUserName)) {
					client.bufferWriter.write(message);
					client.bufferWriter.newLine();
					client.bufferWriter.flush();
				}
			}
			catch(IOException e) {
				closeEverything(socket, bufferReader, bufferWriter);
			}
		}
	}
	
	public void removeClientHandler() {
		clientHandler.remove(this);	
		broadCastMessge("SERVER: "+ clientUserName + " has left the chat!!");
	}
	
	public void closeEverything(Socket soc, BufferedReader br, BufferedWriter bw) {
		removeClientHandler();
		try {
			if(br != null) {
				br.close();
			}
			if(bw != null) {
				bw.close();
			}
			if(soc != null) {
				soc.close();
			}
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
