package org.rarpg.text;

import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;

import processing.core.PApplet;
import processing.core.PFont;

public class RTextRotateDisplay implements IRTextDisplay 
{
	Float angle;
	
	public RTextRotateDisplay(Float angle)
	{
		this.angle = angle;
	}
	
	@Override
	public void show(RText text, String message, RPoint position, RColor color) 
	{
		PApplet p = text.getParent();
		PFont font = p.createFont(text.font, text.size, true);
		
		p.fill(color.R, color.G, color.B);
		p.textFont(font);
		
		p.pushMatrix();		
			p.translate(position.X, position.Y);
			p.rotate(PApplet.radians(this.angle));
			p.translate(-position.X, -position.Y);
			p.text(message, position.X, position.Y);
		p.popMatrix();
	}

}
