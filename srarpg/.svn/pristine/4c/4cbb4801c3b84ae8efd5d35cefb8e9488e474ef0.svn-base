package org.rarpg.projection;

import org.rarpg.core.PObject;

import processing.core.PApplet;

/**
 * Builds a projection. It takes an object with a list of objects to display,
 * and draws each one of it, based on its properties.
 * @author Guilherme Rey e Aline Miyazaki
 *
 */
public class RProjectionBuilder extends PObject {
	private RProjection 		 projection;
	private RProjectionDisplayer  displayer;
	
	public RProjectionBuilder(RProjection projection, PApplet p) {
		super(p);
		this.projection = projection;
		this.displayer  = new RProjectionDisplayer(this.getParent());
	}
	
	/**
	 * Displays all the objects in the RProjection object.
	 * For each object, it checks what instance it is of, and delegates
	 *  the display work to a proper function.
	 */
	public void displayProjection()
	{
		PApplet p = this.getParent();
		
		for (RDisplayObj obj : projection.getDisplayObjects())
			this.displayer.displayObject(obj);
	}
	
	public void setProjection(RProjection projection) {
		this.projection = projection;
	}

	public RProjection getProjection() {
		return projection;
	}
	
	
}
