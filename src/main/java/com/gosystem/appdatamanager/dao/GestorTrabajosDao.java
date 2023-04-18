package com.gosystem.appdatamanager.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.annotations.QueryHints;

import com.gosystem.appdatamanager.conexions.ConexionJavaOracle;
import com.gosystem.appdatamanager.entitys.CentroGestorTrabajo;
import com.gosystem.appdatamanager.querys.AquaSitesNativeQuerys;
import com.gosystem.appdatamanager.querys.GestorTrabajosNativeQuerys;
import com.gosystem.appdatamanager.querys.GestorTrabajosQuerys;






public class GestorTrabajosDao {

	private ConexionJavaOracle conexionJavaOracle;

	public GestorTrabajosDao(ConexionJavaOracle conexionJavaOracle) {
		super();
		this.conexionJavaOracle = conexionJavaOracle;
	}
	
	
	public java.math.BigDecimal getCountCentros() {

		Query q = null;
		java.math.BigDecimal cant = new BigDecimal(0) ;
		try {
			q = this.conexionJavaOracle.getEm().createNativeQuery(GestorTrabajosNativeQuerys.COUNTL_CENTROS);
			q.setHint(QueryHints.READ_ONLY, true);
		    cant  =  (java.math.BigDecimal) q.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cant;

	}
	
	
	
	
	
	public List<CentroGestorTrabajo> getAllCentros(){
		
		Query q = null;
		List<CentroGestorTrabajo> list  = null;
		try {
			q = this.conexionJavaOracle.getEm().createQuery(GestorTrabajosQuerys.GET_ALL_CENTROS);
			//q.setMaxResults(1000);
			q.setHint(QueryHints.READ_ONLY, true);
		    list =   q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	
	
	
}
