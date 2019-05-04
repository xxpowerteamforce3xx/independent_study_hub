package edu.ycp.cs320.independent_study_hub.model;

public class ChemicalInventory {
	
	private int chemicalID;
	private String chemical;
	private String use;
	private String dom;
	private int amount;
	private String media;
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
	
	
}
