package org.rarpg.projection;

import java.util.HashMap;
import java.util.Map;

import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;

/**
 * Represents an object that will be rendered by Processing
 * @author Guilherme Rey e Aline Miyazaki
 *
 */
public abstract class RDisplayObj {
	Map<String, Object> properties;
	
	public RDisplayObj(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	public RDisplayObj()
	{
		this.properties = RDisplayObj.getDefaultProperties();
	}
	
	public static Map<String, Object> getDefaultProperties()
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		
		// Rectangle properties
		properties.put("rectColor", RColor.white);
		properties.put("position", new RPoint(0f, 0f));
		properties.put("width", (Integer) 292);
		properties.put("height", (Integer) 264);
		// --- //
		
		// Avatar prop
		properties.put("avatar_position", new RPoint(5f, 5f));
		// --- //
		
		// Global prop
		properties.put("rotation", (Float) 0f);
		properties.put("padding_left", 150f);
		// --- //
		
		// Text prop
		properties.put("font_family", "Trebuchet MS");
		properties.put("font_color", RColor.rBlack);
		properties.put("regular_size", 15f);
		properties.put("title_size", 20f);
		// --- //
		
		// Name prop
		properties.put("name_size", (Float) 30f);
		properties.put("name_color", RColor.rBlack);
		properties.put("name_position", new RPoint(150, 30));
		// --- //
		
		// Attributes prop
		properties.put("margin_top", 65f);
		// --- //
		
		return properties;
	}
}
