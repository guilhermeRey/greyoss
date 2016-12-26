package org.rarpg.screen;

import processing.core.PApplet;
import fullscreen.FullScreen;

@SuppressWarnings("serial")
public abstract class RScreen extends PApplet {
	FullScreen fs;
	
	public abstract void setup();
	public abstract void draw();
	
	protected void enterFullScreen(int width, int height) {
		size(width, height, P3D);
		fs = new FullScreen(this);
		fs.enter();
	}
	
	protected void enterFullScreen(String resolution) {
		enterFullScreen(Integer.parseInt(resolution.trim().split("x")[0]), 
				Integer.parseInt(resolution.trim().split("x")[1]));
	}

}
