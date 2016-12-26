package org.rarpg.info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class CharacterSheet
 * Represents the user's character with the attributes
 * @author guirey
 *
 */
public class CharacterSheet 
{
	private String name; 
	private String race;
	private String sClass; 
	private Map<String, Integer> attributes; 
	private List<Weapon> weapons;
	private List<Item> inventory; 
	private List<Spell> spells; 
	private String avatar;  
	
	public CharacterSheet(String name, String race, String sClass, int iq, int dx, 
			int st, int ht, int pv, int es, List<Weapon> weapons, List<Item> inventory,
			List<Spell> spells, String avatar){
		this.name = name; 
		this.race = race; 
		this.sClass = sClass; 
		this.avatar = avatar; 
		
		this.attributes = new HashMap<String, Integer>(); 
		this.attributes.put("IQ", iq); 
		this.attributes.put("DX", dx); 
		this.attributes.put("ST", st); 
		this.attributes.put("HT", ht); 
		this.attributes.put("PV", pv); 
		this.attributes.put("ES", es); 
		
		this.weapons = weapons; 
		this.inventory = inventory; 
		this.spells = spells; 
		
	}
	
	
	public CharacterSheet(String name, String race, String sClass, Map<String, Integer> attributes, List<Weapon> weapons, List<Item> inventory,
			List<Spell> spells, String avatar){
		this.name = name; 
		this.race = race; 
		this.sClass = sClass; 
		this.avatar = avatar; 
		
		this.attributes = attributes; 
		
		this.weapons = weapons; 
		this.inventory = inventory; 
		this.spells = spells;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getRace() {
		return race;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public String getsClass() {
		return sClass;
	}
	public void setAttributes(Map<String, Integer> attributes) {
		this.attributes = attributes;
	}
	public Map<String, Integer> getAttributes() {
		return attributes;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setItens(List<Item> inventory) {
		this.inventory = inventory;
	}
	public List<Item> getItens() {
		return inventory;
	}
	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}
	public List<Spell> getSpells() {
		return spells;
	}
	public void setAvatar(String avatar){
		this.avatar = avatar; 
	}
	public String getAvatar(){
		return this.avatar; 
	}
	
}
