package com.yourway.mvc.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PERSON_DATA")
public class PersonData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_DATA_ID")
	private int personDataId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="FAMILY_STATUS")
	private String familyStatus;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="EDUCATION")
	private String education;
	
	@Column(name="HOME_PHONE")
	private String homePhone;
	
	@Column(name="WORK_PHONE")
	private String workPhone;
	
	@Column(name="MOBILE_PHONE")
	private String mobilePhone;
	
	/*----ONE TO ONE-----*/
	@OneToOne(mappedBy="personData")
	Person person;
	
	/*----ONE TO MANY-----*/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PERSON_DATA_ID",nullable=false)
	Set<Address> address = new HashSet<Address>();

	/*------MANY TO ONE-----*/
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COUNTRY_ID")
	private Country birthplace;

	/*------MANY TO MANY--------*/
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CITIZENSHIP", joinColumns=@JoinColumn(name="PERSON_DATA_ID"),
	inverseJoinColumns=@JoinColumn(name="COUNTRY_ID"))
	private Set<Country> citizenship = new HashSet<Country>();
	
	public PersonData(){/*NOP*/}

	public PersonData(String firstName, String lastName, Date birthday, String gender, String familyStatus,
			String occupation, String education, String homePhone, String workPhone, String mobilePhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.familyStatus = familyStatus;
		this.occupation = occupation;
		this.education = education;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.mobilePhone = mobilePhone;
	}

	public int getPersonDataId() {
		return personDataId;
	}

	public void setPersonDataId(int personDataId) {
		this.personDataId = personDataId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address.add(address);
	}

	public Country getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(Country birthplace) {
		this.birthplace = birthplace;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
	public Set<Country> getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country citizenship) {
		this.citizenship.add(citizenship);
	}

	@Override
	public String toString() {
		return "PersonData [personDataId=" + personDataId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", gender=" + gender + ", familyStatus=" + familyStatus + ", occupation="
				+ occupation + ", education=" + education + ", homePhone=" + homePhone + ", workPhone=" + workPhone
				+ ", mobilePhone=" + mobilePhone + "]";
	}
}
