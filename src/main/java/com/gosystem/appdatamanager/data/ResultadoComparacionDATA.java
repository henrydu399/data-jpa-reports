package com.gosystem.appdatamanager.data;

import com.gosystem.appdatamanager.entitys.CentroAquaSities;
import com.gosystem.appdatamanager.entitys.CentroGestorTrabajo;

public class ResultadoComparacionDATA {
	
	private CentroAquaSities centroAquaSites;
	private CentroGestorTrabajo centroGestorTrabajo;
	
	private  boolean isCompanydiferent;
	private  boolean  existe;
	
	
	public CentroAquaSities getCentroAquaSites() {
		return centroAquaSites;
	}
	public void setCentroAquaSites(CentroAquaSities centroAquaSites) {
		this.centroAquaSites = centroAquaSites;
	}
	public CentroGestorTrabajo getCentroGestorTrabajo() {
		return centroGestorTrabajo;
	}
	public void setCentroGestorTrabajo(CentroGestorTrabajo centroGestorTrabajo) {
		this.centroGestorTrabajo = centroGestorTrabajo;
	}
	public boolean isCompanydiferent() {
		return isCompanydiferent;
	}
	public void setCompanydiferent(boolean isCompanydiferent) {
		this.isCompanydiferent = isCompanydiferent;
	}
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	

	
	
	

}
