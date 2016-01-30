package com.yourway.mvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Documents {
	
	String type;
	String image;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int DocId;
	
	@ManyToOne
	Programs prog;
	
	public Documents(String type, String image) {
		super();
		this.type = type;
		this.image = image;
	}

	public Documents() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Documents [type=" + type + ", image=" + image + ", DocId="
				+ DocId + "]";
	}	
}