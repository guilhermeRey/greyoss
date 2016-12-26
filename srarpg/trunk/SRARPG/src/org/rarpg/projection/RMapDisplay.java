package org.rarpg.projection;

import java.util.Map;

import org.rarpg.image.RImage;

/***
 * Represents a map image to be shown by Processing
 * @author Guilherme Rey e Aline Miyazaki
 *
 */
public class RMapDisplay extends RDisplayObj {
	private RImage mapImg;
	
	public RMapDisplay(RImage map, Map<String, Object> properties) {
		super(properties);
		this.setMap(map);
	}

	public void setMap(RImage mapImg) {
		this.mapImg = mapImg;
	}

	public RImage getMap() {
		return mapImg;
	}
}
