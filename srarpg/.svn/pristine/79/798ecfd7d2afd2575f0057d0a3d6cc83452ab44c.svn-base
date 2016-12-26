package org.rarpg.samples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import org.rarpg.image.RImage;
import org.rarpg.projection.RDisplayObj;
import org.rarpg.projection.RProjection;
import org.rarpg.projection.RProjectionBuilder;
import org.rarpg.screen.RScreen;
import org.rarpg.screen.Resolutions;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Communication extends RScreen {
	RProjection objects_to_display;
	RProjectionBuilder builder;
	RImage brand;
	
	/* Communication objects */
	Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	ObjectInputStream objectInput = null;
	
	int change = 0;
	
	public void socketClient()
	{
		try 
		{
			while (true)
			{
				socket = new Socket("localhost", 8088);
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				objectInput = new ObjectInputStream(in);
				change = in.readInt();
				
				if (change == 2){
					objectInput.close(); 
					out.close();
					in.close();
					socket.close();
				}
				
				if (change == 1) {
					@SuppressWarnings("unchecked")
					List<RDisplayObj> objects_from_server = (List<RDisplayObj>) objectInput.readObject();
					objects_to_display.setDisplayObjects(objects_from_server);
					out.writeInt(0);
				}
				
				out.close();
				in.close();
				socket.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void setup() {
		objects_to_display = new RProjection(new LinkedList<RDisplayObj>());
		builder = new RProjectionBuilder(objects_to_display, this);
		brand = new RImage(this, "logo.png");
		
		this.enterFullScreen(Resolutions.r800_600);
		
		socketClient();
	}

	@Override
	public void draw() {
		background(0);
		brand.display(400, 300);
		builder.displayProjection();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "org.rarpg.samples.Communication" });
	}

}
