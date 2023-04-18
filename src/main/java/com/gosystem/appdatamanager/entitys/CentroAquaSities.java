package com.gosystem.appdatamanager.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity (name = "CentroAquaSities")
@Table(name="AQS_TB_SITE" , schema = "dbo")
public class CentroAquaSities   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4596576209291543555L;
	
	@Id
	private String id;
	
	private String name;
	
	@Column( name = "SHORT_NAME")
	private String shortName;
	
	
	@Column( name = "ID_MANAGING_COMPANY")
	private Integer company;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public Integer getCompany() {
		return company;
	}


	public void setCompany(Integer company) {
		this.company = company;
	}
	
	
	
	
	
	
	
	
	

}
