package org.rarpg.projection;

import java.util.Map;

import org.rarpg.core.PObject;
import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;
import org.rarpg.image.RImage;
import org.rarpg.image.RImageRotated;
import org.rarpg.info.CharacterSheet;
import org.rarpg.text.RFonts;
import org.rarpg.text.RText;
import org.rarpg.text.RTextRotateDisplay;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

public class RProjectionDisplayer extends PObject {
	
	public RProjectionDisplayer(PApplet p)
	{
		super(p);
	}
	
	public void displayObject(RDisplayObj obj)
	{
		if (obj instanceof RCharSheetDisplay)
			displayCharacterSheetImage((RCharSheetDisplay) obj);
		else if (obj instanceof RMapDisplay)
			displayMap((RMapDisplay) obj);
	}
	
	public void displayCharacterSheetImage(RCharSheetDisplay sheet)
	{
		PApplet p = this.getParent();
		CharacterSheet c = sheet.getCharSheet();
		
		/* Getting properties */
		// Global properties
		Float  rotation = (Float) sheet.properties.get("rotation");
		Float padding_left = (Float) sheet.properties.get("padding_left");
		// Text Properties
		String font_family = (String) sheet.properties.get("font_family");
		RColor font_color = (RColor) sheet.properties.get("font_color");
		Float regular_size = (Float) sheet.properties.get("regular_size");
		Float title_size = (Float) sheet.properties.get("title_size");
		// Rectangle properties
		Float[] rectColor = (Float[]) sheet.properties.get("rectColor");
		RPoint position = (RPoint) sheet.properties.get("position");
		Integer width = (Integer) sheet.properties.get("width");
		Integer height = (Integer) sheet.properties.get("height");
		// Avatar properties
		RPoint avatar_position = (RPoint) sheet.properties.get("avatar_position");
		// Name properties
		Float  name_size = (Float) sheet.properties.get("name_size");
		RPoint name_position = (RPoint) sheet.properties.get("name_position");
		RColor name_color = (RColor) sheet.properties.get("name_color");
		// Attributes properties
		Float margin_top = (Float) sheet.properties.get("margin_top");
		/* --- */
		
		PGraphics g = p.createGraphics(width, height, PApplet.P2D);
		PFont name_font 	= RFonts.createNewFont(p, font_family, name_size);
		PFont regular_font 	= RFonts.createNewFont(p, font_family, regular_size);
		PFont title_font 	= RFonts.createNewFont(p, font_family, title_size);
		
		g.beginDraw();
		
		// Setting the background
		g.background(rectColor[0], rectColor[1], rectColor[2]);
		// Getting the avatar and showing it
		g.image(sheet.getAvatar().getImage(), avatar_position.X, avatar_position.Y);
		
		
		/* Writing the chars name */
		g.textFont(name_font, name_size);
		
		g.fill(name_color.R, name_color.G, name_color.B);
		g.text(sheet.getCharSheet().getName(), name_position.X, name_position.Y);
		/* -- */
		
		/* Writing the chars name */
		g.textFont(regular_font, regular_size);
		g.fill(font_color.R, font_color.G, font_color.B);
		String t = sheet.getCharSheet().getRace() + " " + sheet.getCharSheet().getsClass();
		g.text(t, name_position.X, name_position.Y + name_size - regular_size);
		/* -- */
		
		/* Writing the chars race + class */
		Float attr_pos = margin_top + 2f;
		for (Map.Entry<String, Integer> attr : c.getAttributes().entrySet()) {
			g.text(String.valueOf(attr.getKey()) + ": " + String.valueOf(attr.getValue())
					, padding_left, attr_pos);
			attr_pos += regular_size + 2f;
		}
		/* -- */
		
		
		g.endDraw();
		
		RImage img = new RImage(p, g);
		img.addDisplay("rotate", new RImageRotated(rotation));
		img.display("rotate", position.X + (width / 2), position.Y + (height / 2));
		
	}
	
	public void displayMap(RMapDisplay map) 
	{
		setBounds((Integer) map.properties.get("x"), (Integer) map.properties.get("y"));
		map.getMap().display((Integer) map.properties.get("x"), (Integer) map.properties.get("y"));
	}
	
	private void setBounds(int x, int y)
	{
		PApplet p = this.getParent();
		p.pushMatrix();
			p.translate(x, y);
		p.popMatrix();
	}
}
