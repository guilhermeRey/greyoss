package org.rarpg.samples;

import java.util.ArrayList;
import java.util.List;

import org.rarpg.dice.D6;
import org.rarpg.dice.Dice;
import org.rarpg.elements.RPoint;
import org.rarpg.screen.RScreen;
import org.rarpg.screen.Resolutions;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class ShowingDice extends RScreen {
	List<Dice> dices;
	
	@Override
	public void setup() {
		dices = new ArrayList<Dice>();
		dices.add(new D6(this));
		
		this.enterFullScreen(Resolutions.r800_600);
	}

	@Override
	public void draw() {
		background(0f, 0f, 0f);
		
		for (Dice dice : dices)
			dice.show(new RPoint(400, 300));
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "org.rarpg.samples.ShowingDice" });
	}

}
