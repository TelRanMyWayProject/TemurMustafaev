package com.yourway.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="WAY_STEPS")
public class WaySteps {
	boolean isDone;
	String information;//JSON
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WayStepsId")
	int WayStepsId;

	@ManyToOne
	ProgramStep ProgSteps;
	
	
	public WaySteps() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WaySteps(boolean isDone, String information) {
		super();
		this.isDone = isDone;
		this.information = information;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public int getWayStepsId() {
		return WayStepsId;
	}

	public ProgramStep getProgSteps() {
		return ProgSteps;
	}

	public void setProgSteps(ProgramStep progSteps) {
		ProgSteps = progSteps;
	}	
}