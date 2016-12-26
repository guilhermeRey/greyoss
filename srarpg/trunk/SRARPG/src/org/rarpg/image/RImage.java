package org.rarpg.image;

import java.util.HashMap;
import java.util.Map;

import org.rarpg.core.PObject;
import org.rarpg.elements.RPoint;
import org.rarpg.interaction.IRMouseEvents;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Class RImage
 * Represents an Image, with special attributes needed to the RARPG project
 * 
 * @author 	Guilherme Policicio Rey and Aline Kimy Miyazaki
 * @date 	26/05/2001
 */
public class RImage extends PObject implements IRMouseEvents {
	String path;
	PImage _img;
	RPoint[] corners;
	
	/* Modes to display (Rotated, Scaled, etc) */
	public Map<String, IRImageDisplay> displays;
	
	public RImage(PApplet p) {
		super(p);
	}
	
	public RImage(PApplet p, String path) {
		super(p);
		this.path = path;
		
		// Adding supported displays (for rotation, scaling, etc)
		displays = new HashMap<String, IRImageDisplay>();
		displays.put("default", new RImgDefaultDisplay());
		
		_img = parent.loadImage(this.path);
		
		corners = new RPoint[4];
	}
	
	public RImage(PApplet p, PGraphics g)
	{
		super(p);
		this.path = "";
		
		// Adding supported displays (for rotation, scaling, etc)
		displays = new HashMap<String, IRImageDisplay>();
		displays.put("default", new RImgDefaultDisplay());
		
		_img = (PImage) g;
		
		corners = new RPoint[4];
	}
	
	/**
	 * Adds a new display mode to the RImage object
	 * @param key
	 * @param display
	 */
	public void addDisplay(String key, IRImageDisplay display) {
		displays.put(key, display);
	}
	
	/**
	 * Displays the RImage object with the desired mode
	 * @param which
	 * @param x
	 * @param y
	 */
	public void display(String which, float x, float y) {
		displays.get(which).display(this, x, y);
		updateCorners(x, y);
	}
	
	/**
	 * Displays the RImage with the default mode
	 * @param x
	 * @param y
	 */
	public void display(float x, float y){
		display("default", x, y);
	}
	
	/**
	 * Change the size of the RImage
	 * @param width
	 * @param height
	 */
	public void size(int width, int height) {
		this._img.resize(width, height);
	}
	
	/**
	 * Update corners positions
	 * @param x
	 * @param y
	 */
	private void updateCorners(float x, float y) 
	{
		corners[0] = new RPoint(x - _img.width / 2, y - _img.width / 2);
		corners[1] = new RPoint(x + _img.width / 2, y - _img.width / 2);
		corners[2] = new RPoint(x + this._img.width / 2, y + this._img.height / 2);
		corners[3] = new RPoint(x - _img.width / 2, y + _img.width / 2);
	}
	
	public int getWidth(){
		return this._img.width; 
	}
	
	public int getHeight(){
		return this._img.height;
	}

	@Override
	public boolean isMouseOver(RPoint mousePos) {
		return (mousePos.X >= corners[0].X && mousePos.X <= corners[2].X) &&
			   (mousePos.Y >= corners[0].Y && mousePos.Y <= corners[2].Y);
	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseOver() {
		// TODO Auto-generated method stub
	}
	
	public PImage getImage()
	{
		return this._img;
	}
	
	
}
