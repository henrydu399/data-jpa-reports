package com.gosystem.appdatamanager.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.annotations.QueryHints;

import com.gosystem.appdatamanager.conexions.ConexionJavaSqlServer;
import com.gosystem.appdatamanager.entitys.CentroAquaSities;
import com.gosystem.appdatamanager.querys.AquaSitesNativeQuerys;
import com.gosystem.appdatamanager.querys.AquaSitesQuerys;

public class AquaSitesDao {

	private ConexionJavaSqlServer conexionJavaSqlServer;

	public AquaSitesDao(ConexionJavaSqlServer conexionJavaSqlServer) {
		super();
		this.conexionJavaSqlServer = conexionJavaSqlServer;
	}

	
	public Integer getCountCentros() {

		Query q = null;
		int cant =0;
		try {
			q = this.conexionJavaSqlServer.getEm().createNativeQuery(AquaSitesNativeQuerys.COUNTL_CENTROS);
			q.setHint(QueryHints.READ_ONLY, true);
		    cant  =  (Integer) q.getSingleResult();
			
			this.conexionJavaSqlServer.getEm().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cant;

	}
	
	
	public List<CentroAquaSities> getAllCentros(){
		
		Query q = null;
		List<CentroAquaSities> list  = null;
		try {
			q = this.conexionJavaSqlServer.getEm().createQuery(AquaSitesQuerys.GET_ALL_CENTROS);
			//q.setMaxResults(1000);
			q.setHint(QueryHints.READ_ONLY, true);
		    list =   q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
