package org.rarpg.samples;

import org.rarpg.elements.RPoint;
import org.rarpg.image.RImage;
import org.rarpg.image.RImageRotated;
import org.rarpg.screen.RScreen;
import org.rarpg.screen.Resolutions;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class RImageSample extends RScreen {
	RImage[] images;
	
	float val = 0f;
	float val2 = 0f;
	
	public void setup() 
	{
		images = new RImage[2];
		images[0]  = new RImage(this, "mapa.jpg");
		images[1]  = new RImage(this, "ficha.jpg");
		
		images[0].size(images[0].getWidth() / 2, images[0].getHeight() / 2);
		images[1].size(images[1].getWidth() / 4, images[1].getHeight() / 4);
		
		images[0].addDisplay("rotate", new RImageRotated(val));
		images[1].addDisplay("rotate", new RImageRotated(val2));
		
		this.enterFullScreen(Resolutions.r1200x800);
	}

	public void draw()
	{
		background(0);
		
		images[0].display("rotate", 250, 500);
		images[1].display("rotate", 750, 250);
		
		for (RImage img : images) {
			if (img.isMouseOver(new RPoint(mouseX, mouseY)))
				if (mousePressed) {
					if (img.equals(images[0]))
						val += 1f;
					else
						val2 += 0.5f;
					((RImageRotated) img.displays.get("rotate")).setAngle(img.equals(images[0]) ? val : val2);
				}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "org.rarpg.samples.RImageSample" });
	}

}
