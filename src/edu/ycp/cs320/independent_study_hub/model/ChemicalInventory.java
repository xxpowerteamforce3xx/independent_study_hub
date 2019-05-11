package edu.ycp.cs320.independent_study_hub.model;

public class ChemicalInventory {
	
	private int chemicalID;
	private String chemical;
	private String use;
	private String dom;
	private int amount;
	private String media;
	private String cas, room, loc, sup, cat;
	/**
	 * getter for the chemical
	 * @return a string chemical
	 */
	public ChemicalInventory() {
		
	}
	public int getChemicalID() {
		return chemicalID;
	}
	public void setChemicalID(int chemicalID) {
		this.chemicalID = chemicalID;
	}
	public String getChemical() {
		return chemical;
	}
	public void setChemical(String chemical) {
		this.chemical = chemical;
	}
	public String getUseOfChemical() {
		return use;
	}
	//use is 0 if class, 1 if research
	public void setUseOfChemcial(String use) {
		this.use = use;
	}
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	
	public String getCAS() {
		return cas;
	}
	public void setCAS(String cas) {
		this.cas = cas;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
}
