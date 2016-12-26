package org.rarpg.samples;

import org.rarpg.image.RImage;
import org.rarpg.screen.RScreen;
import org.rarpg.screen.Resolutions;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class TabTest extends RScreen {
	RImage tab;
	
	public void setup() 
	{
		tab = new RImage(this, "teste_tab.png");
		
		this.enterFullScreen(Resolutions.r800_600);
	}

	public void draw()
	{
		background(0);
		
		tab.display(400, 300);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "org.rarpg.samples.TabTest" });
	}

}
