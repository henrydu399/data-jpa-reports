package com.gosystem.appdatamanager.business;

import java.util.List;

import com.gosystem.appdatamanager.conexions.ConexionJavaOracle;
import com.gosystem.appdatamanager.conexions.ConexionJavaSqlServer;
import com.gosystem.appdatamanager.dao.AquaSitesDao;
import com.gosystem.appdatamanager.dao.GestorTrabajosDao;
import com.gosystem.appdatamanager.entitys.CentroAquaSities;
import com.gosystem.appdatamanager.entitys.CentroGestorTrabajo;

public class CentrosBusinessImpl {
	
	private ConexionJavaSqlServer conexionJavaSqlServer;
	private ConexionJavaOracle conexionJavaOracle;
	
	private AquaSitesDao aquaSitesDao;
	private GestorTrabajosDao gestorTrabajosDao;
	
	
	public CentrosBusinessImpl(ConexionJavaSqlServer conexionJavaSqlServer, ConexionJavaOracle conexionJavaOracle) {
		super();
		this.conexionJavaSqlServer = conexionJavaSqlServer;
		this.conexionJavaOracle = conexionJavaOracle;	
		this.aquaSitesDao = new AquaSitesDao(conexionJavaSqlServer);
		this.gestorTrabajosDao = new GestorTrabajosDao(conexionJavaOracle);
	}
	
	
	
	public int  getCountCentrosAquaSites() {
		 return this.aquaSitesDao.getCountCentros();
	}
	
	public java.math.BigDecimal  getCountCentrosGestorTrabajos() {
		 return this.gestorTrabajosDao.getCountCentros();
	}
	
	
	public List<CentroAquaSities> getAllCentrosAquaSites(){
		return this.aquaSitesDao.getAllCentros();
	}
	
	
	
	public List<CentroGestorTrabajo> getAllCentrosGestorTrabajos(){
		return this.gestorTrabajosDao.getAllCentros();
	}
	
	
	
	
	
	

}
