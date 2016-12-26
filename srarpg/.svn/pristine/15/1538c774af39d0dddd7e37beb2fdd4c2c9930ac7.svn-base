package org.rarpg.dice;

import org.rarpg.core.PObject;
import org.rarpg.elements.RPoint;

import processing.core.PApplet;
import saito.objloader.OBJModel;

public class D6 extends PObject implements Dice {
	OBJModel shape;
	
	public D6(PApplet p) {
		super(p);
		shape = new OBJModel(p, "cube_sphere_test.obj", "relative");
		shape.scale(2f);
		shape.enableDebug();
	}

	@Override
	public void show(RPoint pos) {
		PApplet p = this.getParent();
		
		p.lights();
		p.pushMatrix();
			p.fill(255f, 255f, 255f);
			p.translate(pos.X, pos.Y);
			shape.draw();
		p.popMatrix();
	}
	
}
