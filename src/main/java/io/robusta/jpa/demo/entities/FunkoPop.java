package io.robusta.jpa.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FunkoPop
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

	private String name;
	
	@ManyToOne
	private Universe universe;
	
	private boolean waterproof;
	private double latitude;
	private double longitude;

	public FunkoPop()
	{
	}

	public FunkoPop(String name, Universe universe) {
		super();
		this.name = name;
		this.universe = universe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}



	public Universe getUniverse() {
		return universe;
	}


	public void setUniverse(Universe universe) {
		this.universe = universe;
	}


	public boolean isWaterproof() {
		return waterproof;
	}


	public void setWaterproof(boolean waterproof) {
		this.waterproof = waterproof;
	}

	@Override
	public String toString() {
		return this.name +" ("+this.universe.name+")";
	}

	
}
