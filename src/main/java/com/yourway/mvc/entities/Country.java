package com.yourway.mvc.entities;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Country {
	private static final String COUNTRYID = "CountryId";
	private static final String LINK = "link";
	private static final String NAME = "name";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	int CountryId;
	
	@Column(name="COUNTRY_NAME",nullable=false,updatable=true,unique=true)
	private String name;
	
	@Column(name="URL",nullable=true,updatable=true)
	private String link;
	
	public Country(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}

	public Country() {}

	public void setProperties(Map<String, String> properties) throws NumberFormatException{
		{
			String property=null;
			property=properties.get(NAME);
			if(property != null && property!="")
				name=property;
			property=properties.get(LINK);
			if(property != null && property!="")
				link=property;
			property=properties.get(COUNTRYID);
			if(property != null && property!="")
				CountryId=Integer.parseInt(property);
		}
	}	
	
	@JsonIgnore
	public Map<String, Object> getProperties(){
		Map<String, Object> res=new HashMap<String, Object>();
		res.put(NAME, name);
		res.put(LINK, link);
		res.put(COUNTRYID, CountryId);
		return res;
	}
	
	
	public void setCountryId(int CountryId) {
		this.CountryId = CountryId;
	}
	
	@Override
	public String toString() {
		String json=String.format("{\"name\":\"%s\",\"link\":\"%s\",\"CountryId\":\"%d\"}", 
				name,link,CountryId);
		return json;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCountryId() {
		return CountryId;
	}
}