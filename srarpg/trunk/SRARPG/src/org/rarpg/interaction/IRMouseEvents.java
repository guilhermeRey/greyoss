package org.rarpg.interaction;

import org.rarpg.elements.RPoint;


public interface IRMouseEvents {
	/**
	 * Checks if the user's mouse is over the object
	 * @param mousePos
	 * @return
	 */
	public boolean isMouseOver(RPoint mousePos);
	
	public void mousePressed();
	public void mouseOver();
}
