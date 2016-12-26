package org.rarpg.text;

import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;

public interface IRTextDisplay 
{	
	public void show(RText text, String message, RPoint position, RColor color);
}
