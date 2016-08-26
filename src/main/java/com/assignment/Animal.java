package com.assignment;

public class Animal {
	
	public String animalid = null;
	public String species = null;
	public String name = null;
	public String enclosure = null;
	public double weight = 0.0;
	

	public Animal() {
		super();
	}


	public String getAnimalid() {
		return animalid;
	}


	public void setAnimalid(String animalid) {
		this.animalid = animalid;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEnclosure() {
		return enclosure;
	}


	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Animal Identification #: "+ animalid + "  Species: " + species + "   Name: " + name + "   Enclosure Type: "
				+ enclosure + "   Weight: " + weight + "  :D :D :D";
	}
	

}
