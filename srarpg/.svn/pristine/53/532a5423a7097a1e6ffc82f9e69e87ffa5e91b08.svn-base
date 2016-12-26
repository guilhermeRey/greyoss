package org.rarpg.text;

import java.util.HashMap;
import java.util.Map;

import org.rarpg.core.PObject;
import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;

import processing.core.PApplet;

/**
 * Represents a text to be displayed 
 * @author guirey
 *
 */
public class RText extends PObject {
	Float size;
	String font;
	
	Map<String, IRTextDisplay> displays;
	
	public RText(PApplet p)
	{
		super(p);
	}
	
	public RText(PApplet p, Float size, String font) {
		super(p);
		this.size = size;
		this.font = font;
		
		displays = new HashMap<String, IRTextDisplay>();
		addDisplay("default", new RTextDefaultDisplay());
	}
	
	public void addDisplay(String key, IRTextDisplay display)
	{
		this.displays.put(key, display);
	}
	
	public void show(String key, String message, RPoint pos, RColor color)
	{
		this.displays.get(key).show(this, message, pos, color);
	}
	
	public void show(String message, RPoint pos, RColor color)
	{
		this.displays.get("default").show(this, message, pos, color);
	}
}
