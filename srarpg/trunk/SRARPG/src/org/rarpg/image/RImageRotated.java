package org.rarpg.image;

import processing.core.PApplet;
import processing.core.PConstants;

public class RImageRotated implements IRImageDisplay {
	float angle;

	public RImageRotated(float angle) {
		this.angle = angle;
	}

	public void setAngle(float value) {
		this.angle = value;
	}

	@Override
	public void display(RImage image, float x, float y) {
		PApplet p = image.getParent();
		p.pushMatrix();
			p.translate(x, y);
			p.rotate(PApplet.radians(this.angle));
			p.translate(-x, -y);
			p.imageMode(PConstants.CENTER);
			p.image(image._img, x, y);
		p.popMatrix();
	}

}
