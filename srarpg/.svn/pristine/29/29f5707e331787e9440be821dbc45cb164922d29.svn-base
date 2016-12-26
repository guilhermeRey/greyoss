package org.rarpg.samples;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.rarpg.elements.RColor;
import org.rarpg.elements.RPoint;
import org.rarpg.image.RImage;
import org.rarpg.info.CharacterSheet;
import org.rarpg.projection.RCharSheetDisplay;
import org.rarpg.projection.RDisplayObj;
import org.rarpg.projection.RProjection;
import org.rarpg.projection.RProjectionBuilder;
import org.rarpg.screen.RScreen;
import org.rarpg.screen.Resolutions;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class CharacterDisplay extends RScreen {
	RProjection objects;
	RProjectionBuilder builder;
	
	public void setup() 
	{
		// Ficha 1
		CharacterSheet yarquen = new CharacterSheet("Tata", 
													"Elf", 
													"Archer", 
													10, 20, 10, 15, 60, 10, 
													null, null, null, "legolas.jpg");
		
		// Ficha 2
		CharacterSheet ycaz = new CharacterSheet("Ycaz", 
				  							     "Elf", 
				  							     "Arcanist", 
				  							     10, 20, 10, 15, 60, 10, 
				  							     null, null, null, "legolas.jpg");
		
		// Ficha 3
		CharacterSheet bhors = new CharacterSheet("Bhors", 
				  								  "Elf", 
				  								  "Archer", 
				  								  10, 20, 10, 15, 60, 10, 
				  								  null, null, null, "legolas.jpg");
		
		// Ficha 3
		CharacterSheet legolas = new CharacterSheet("Legolas", 
				  								    "Elf", 
				  								    "Archer", 
				  								    10, 20, 10, 15, 60, 10, 
				  								    null, null, null, "legolas.jpg");
		
		
		// Criando ficha para mostrar 1
		Map<String, Object> yarquen_prop = RDisplayObj.getDefaultProperties();
		yarquen_prop.put("position", new RPoint(64f, 15f));
		yarquen_prop.put("rectColor", new Float[]{ 0f, 255f, 255f });
		yarquen_prop.put("rotation", 180f);
		yarquen_prop.put("avatar_position", new RPoint(157f, 118f));
		yarquen_prop.put("name_position", new RPoint(140f, 230f));
		
		RCharSheetDisplay yarquen_display = 
			new RCharSheetDisplay(yarquen
					,new RImage(this, yarquen.getAvatar())
					,yarquen_prop);
		
		// Criando ficha para mostrar 2
		Map<String, Object> ycaz_prop = RDisplayObj.getDefaultProperties();
		ycaz_prop.put("position", new RPoint(78 + 292 + 64, 15f));
		ycaz_prop.put("rectColor", RColor.yellow);
		ycaz_prop.put("avatar_position", new RPoint(157f, 118f));
		ycaz_prop.put("rotation", 180f);
		ycaz_prop.put("name_position", new RPoint(150f, 230f));
		
		RCharSheetDisplay ycaz_display = 
			new RCharSheetDisplay(ycaz
					,new RImage(this, ycaz.getAvatar())
					,ycaz_prop);
		
		// Criando ficha para mostrar 3
		Map<String, Object> bhors_prop = RDisplayObj.getDefaultProperties();
		bhors_prop.put("position", new RPoint(64f, 264 + 71));
		bhors_prop.put("rectColor", new Float[]{ 255f, 0f, 255f });
		bhors_prop.put("name_position", new RPoint(150f, 30f));
		
		RCharSheetDisplay bhors_display = 
			new RCharSheetDisplay(bhors
					,new RImage(this, bhors.getAvatar())
					,bhors_prop);
		
		// Criando ficha para mostrar 4
		Map<String, Object> legolas_prop = RDisplayObj.getDefaultProperties();
		legolas_prop.put("position", new RPoint(78 + 292 + 64, 264f + 71f));
		legolas_prop.put("rectColor", new Float[]{ 255f, 255f, 255f });
		legolas_prop.put("name_position", new RPoint(150f, 30f));
		
		RCharSheetDisplay legolas_display = 
			new RCharSheetDisplay(legolas
					,new RImage(this, legolas.getAvatar())
					,legolas_prop);
		
		
		
		
		
		List<RDisplayObj> display_objects = new LinkedList<RDisplayObj>();
		display_objects.add(yarquen_display);
		display_objects.add(ycaz_display);
		display_objects.add(bhors_display);
		display_objects.add(legolas_display);
		
		
		objects = new RProjection(display_objects);
		
		builder = new RProjectionBuilder(objects, this);
		
		this.enterFullScreen(Resolutions.r800_600);
	}

	public void draw()
	{
		background(0);
		builder.displayProjection();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "org.rarpg.samples.CharacterDisplay" });
	}

}
