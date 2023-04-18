package com.gosystem.appdatamanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gosystem.appdatamanager.algoritmos.CentrosCompareAlgoritmo;
import com.gosystem.appdatamanager.business.CentrosBusinessImpl;
import com.gosystem.appdatamanager.conexions.ConexionJavaOracle;
import com.gosystem.appdatamanager.conexions.ConexionJavaSqlServer;
import com.gosystem.appdatamanager.entitys.CentroAquaSities;
import com.gosystem.appdatamanager.entitys.CentroGestorTrabajo;
import com.gosystem.appdatamanager.filereports.FileReportCentros;
import com.gosystem.appdatamanager.utils.PropertiesUtils;

public class Main {
	
	public static CentrosBusinessImpl centrosBusinessImpl;
	
	private  static ConexionJavaSqlServer conexionJavaSqlServer;
	private  static ConexionJavaOracle conexionJavaOracle;
	
	
	private static CentrosCompareAlgoritmo centrosCompareAlgoritmo;
	
	private static Properties properties;
	
	private static FileReportCentros fileReportCentros;
	
	
	public static void main(String[] args) {
		
		try {
			properties = PropertiesUtils.getP();
			fileReportCentros = new FileReportCentros(properties);
			conexionJavaSqlServer = new ConexionJavaSqlServer();
			conexionJavaOracle = new ConexionJavaOracle();
			centrosBusinessImpl  = new CentrosBusinessImpl(conexionJavaSqlServer,conexionJavaOracle);
			
			
			
			
			
			  System.out.println("RECUPERANDO CENTROS DE AQUA SITES :" );
			 List<CentroAquaSities> listCentrosAquaSites =centrosBusinessImpl.getAllCentrosAquaSites();
			 fileReportCentros.createFileJSONData(CentroAquaSities.class.getSimpleName(),listCentrosAquaSites);
			  System.out.println("FINALIZA  RECUPERACION DE AQUA SITES :" );
			 
			
			
			  java.math.BigDecimal cantidadCetrosGestorTrabajo = centrosBusinessImpl.getCountCentrosGestorTrabajos();	
			System.out.println("RECUPERANDO CENTROS DE GESTOR TRABAJOS :" + cantidadCetrosGestorTrabajo);
			System.out.println(" CANTIDAD DE CENTROS : " );
			List<CentroGestorTrabajo> listCentrosGestorTrabajo = centrosBusinessImpl.getAllCentrosGestorTrabajos();	
			fileReportCentros.createFileJSONData(CentroGestorTrabajo.class.getSimpleName(), listCentrosGestorTrabajo);
			System.out.println("FINALIZA  RECUPERACION DE GESTOR TRABAJOS :" );
			
			
			System.out.println("EJECUTANDO COMPARACION :" );
			centrosCompareAlgoritmo = new CentrosCompareAlgoritmo(listCentrosAquaSites, listCentrosGestorTrabajo);
			centrosCompareAlgoritmo.CompareAquaSitesVsGestorTrabajo();
			System.out.println("FINALIZA CON EXITO :" );
			
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conexionJavaSqlServer.close();
			conexionJavaOracle.close();
		}
		
		

	}
	
	

}
