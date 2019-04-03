package edu.ycp.cs320.independent_study_hub.model;

public class ChemicalInventory {
	
	private int chemicalID;
	private String chemical;
	private String use;
	private int dom;
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
	public int getDom() {
		return dom;
	}
	public void setDom(int dom) {
		this.dom = dom;
	}
	
	
	
}
