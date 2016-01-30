package com.yourway.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programstep")
public class ProgramStep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_program", referencedColumnName = "ProgramId", nullable = false)
	private Programs program;

	@ManyToOne
	@JoinColumn(name = "id_step", referencedColumnName = "id", nullable = false)
	private Step step;

	private int stepOrder;

	private String description;

	public ProgramStep() {
	}

	public ProgramStep(Programs program, Step step) {
		this.program = program;
		this.step = step;
	}

	public ProgramStep(Programs program, Step step, int stepOrder, String description) {
		this.program = program;
		this.step = step;
		this.stepOrder = stepOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Programs getProgram() {
		return program;
	}

	public void setProgram(Programs program) {
		this.program = program;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public int getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProgramStep [id=" + id + ", program=" + program + ", step=" + step + ", stepOrder=" + stepOrder + ", description=" + description
				+ "]";
	}
}