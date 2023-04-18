package com.gosystem.appdatamanager.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "CentroGestorTrabajo")
@Table(name="PL_RE_CENTRO" , schema = "PLOWN01")
public class CentroGestorTrabajo {
	
	@Id
	private String id;
	
	private String nombre;
	
	@Column( name = "codigo_info")
	private String shortName;
	
	
	@Column( name = "PROPIETARIO_ID")
	private Integer company;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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
