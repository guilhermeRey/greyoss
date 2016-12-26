package org.rarpg.samples;

import java.util.HashMap;
import java.util.Map;

import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;
import org.rarpg.screen.RScreen;
import org.rarpg.text.RText;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class RTextSample extends RScreen {
	Map<String, RText> fonts;
	
	@Override
	public void setup() {
		size(800, 600);
		
		this.fonts = new HashMap<String, RText>();
		this.fonts.put("calibri", new RText(this, 24f, "calibri"));
	}

	@Override
	public void draw() {
		background(0);
		this.fonts.get("calibri").show("Feliz Anivers‡rio, Lucas!", new RPoint(0f, 20f), RColor.rYellow);
	}
	
	public static void main(String[] args)
	{
		PApplet.main(new String[] { "--present", "org.rarpg.samples.RTextTest" });
	}
}
