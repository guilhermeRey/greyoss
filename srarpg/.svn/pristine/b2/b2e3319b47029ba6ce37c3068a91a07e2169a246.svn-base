package org.rarpg.image;

import processing.core.PApplet;

public class RImgDefaultDisplay implements IRImageDisplay {
	
	@Override
	public void display(RImage rimg, float x, float y) {
		PApplet p = rimg.getParent();
		
		p.imageMode(PApplet.CENTER);
		p.image(rimg._img, x, y);
	}
}
