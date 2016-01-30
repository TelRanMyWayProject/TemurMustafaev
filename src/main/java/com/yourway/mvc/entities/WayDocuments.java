package com.yourway.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="WAY_DOCUMENTS")
public class WayDocuments {

	private boolean isReady;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WayDocumentsId")
	private int WayDocumentsId;

	@ManyToOne
	private PersonDocuments personDocument;

	@ManyToOne
	private Documents requiredDocument;

	public WayDocuments(boolean isReady) {
		super();
		this.isReady = isReady;
	}

public WayDocuments() {/*NOP*/}

@Override
public String toString() {
	return "WayDocuments [isReady=" + isReady + ", WayDocumentsId="
			+ WayDocumentsId + ", personDocument=" + personDocument
			+ ", requiredDocument=" + requiredDocument + "]";
}

public boolean isReady() {
	return isReady;
}

public void setReady(boolean isReady) {
	this.isReady = isReady;
}

public PersonDocuments getPersonDocument() {
	return personDocument;
}

public void setPersonDocument(PersonDocuments personDocument) {
	this.personDocument = personDocument;
}

public Documents getRequiredDocument() {
	return requiredDocument;
}

public void setRequiredDocument(Documents requiredDocument) {
	this.requiredDocument = requiredDocument;
}

public int getWayDocumentsId() {
	return WayDocumentsId;
}
}