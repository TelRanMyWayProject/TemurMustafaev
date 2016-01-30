package com.yourway.mvc.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PERSON")
@Access(AccessType.FIELD)
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	private int personId;
	@Column(name="USERNAME",unique=true)
	private String username;
	@Column(name="PASSWORD")
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name="REGISTRATION_DATE")
	private Date registrationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_LOGIN",updatable=true)
	private Date lastLogin;
	
	/*----ONE TO ONE---*/
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PERSON_DATA_ID",nullable=true)
	PersonData personData;
	
	/*----MANY TO ONE----*/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PERSON_ID",nullable=true)
	private Set<FamilyMember> familyMemebers = new HashSet<FamilyMember>();
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public PersonData getPersonData() {
		return personData;
	}
	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	
	public Set<FamilyMember> getFamilyMemebers() {
		return familyMemebers;
	}
	public void setFamilyMemebers(FamilyMember familyMemebers) {
		this.familyMemebers.add(familyMemebers);
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", username=" + username + ", password=" + password
				+ ", registrationDate=" + registrationDate + ", lastLogin=" + lastLogin + "]";
	}
}
