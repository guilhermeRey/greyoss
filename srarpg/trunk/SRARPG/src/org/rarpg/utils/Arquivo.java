package org.rarpg.utils;

import java.io.*;

public class Arquivo {
	
	private String path;
	
	public Arquivo(String path)
	{
		this.path = path;
	}
	
	
	public String ler() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(this.path));
		StringBuilder sb = new StringBuilder();
		
		while(in.ready()) {
			sb.append(in.readLine());
			sb.append("\n");
		}
		
		return sb.toString();
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	
	
	
}
