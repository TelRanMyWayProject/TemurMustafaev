package com.yourway.mvc.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;



@Entity(name="WAY")
public class Way {
private Date startDate;
private Date endDate;
private boolean isFinished;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "WayId")
int WayId;

@OneToMany
@JoinTable(name="WayDocuments",joinColumns={@JoinColumn(name="WayId")},inverseJoinColumns={@JoinColumn(name="WayDocumentsId")})
List <WayDocuments> requiredDocuments;

@ManyToOne
Programs program;

@OneToMany
@JoinTable(name="WaySteps",joinColumns={@JoinColumn(name="WayId")},inverseJoinColumns={@JoinColumn(name="WayStepsId")})
List <WaySteps> stepsToDo;

public Way(Date startDate, Date endDate, boolean isFinished) {
	super();
	this.startDate = startDate;
	this.endDate = endDate;
	this.isFinished = isFinished;
}

public Way() {/*NOP*/}


@Override
public String toString() {
	return "Way [startDate=" + startDate + ", endDate=" + endDate
			+ ", isFinished=" + isFinished + ", WayId=" + WayId
			+ ", requiredDocuments=" + requiredDocuments + ", program="
			+ program + "]";
}

public List<WayDocuments> getRequiredDocuments() {
	return requiredDocuments;
}

public void setRequiredDocuments(List<WayDocuments> requiredDocuments) {
	this.requiredDocuments = requiredDocuments;
}

public Programs getProgram() {
	return program;
}

public void setProgram(Programs program) {
	this.program = program;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public boolean isFinished() {
	return isFinished;
}

public void setFinished(boolean isFinished) {
	this.isFinished = isFinished;
}

public int getWayId() {
	return WayId;
}

}