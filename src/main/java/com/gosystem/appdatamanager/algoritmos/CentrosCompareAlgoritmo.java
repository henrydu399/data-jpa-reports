package com.gosystem.appdatamanager.algoritmos;

import java.util.ArrayList;
import java.util.List;

import com.gosystem.appdatamanager.data.ResultadoComparacionDATA;
import com.gosystem.appdatamanager.entitys.CentroAquaSities;
import com.gosystem.appdatamanager.entitys.CentroGestorTrabajo;
import com.gosystem.appdatamanager.filereports.FileReportCentros;

public class CentrosCompareAlgoritmo {

	private List<CentroAquaSities> listAquaSites;
	private List<CentroGestorTrabajo> listGestorTrabajos;
	private List<ResultadoComparacionDATA> resultadosNoExistenGestorTrabajos ;
	private List<ResultadoComparacionDATA> resultadosDiferenciaCompany ;

	public CentrosCompareAlgoritmo(List<CentroAquaSities> listAquaSites, List<CentroGestorTrabajo> listGestorTrabajos) {
		this.listAquaSites = listAquaSites;
		this.listGestorTrabajos = listGestorTrabajos;
		resultadosNoExistenGestorTrabajos = new ArrayList<>();
		resultadosDiferenciaCompany = new ArrayList<>();
		
	}

	/**
	 * Metodo que compara la informacion de las tablas de centros en AQUA_SITES
	 * contra GESTOR DE TRABAJOS
	 * 
	 * @param listAquaSites
	 * @param listGestorTrabajos
	 */
	public void CompareAquaSitesVsGestorTrabajo() {

		 
		for (CentroAquaSities centroAquaSities : this.listAquaSites) {
			this.findCentroGestortrabajo(centroAquaSities);
		}
		FileReportCentros.createFileJSONData("CompareAquaSitesVsGestorTrabajoNoExisten", this.resultadosNoExistenGestorTrabajos);
		FileReportCentros.createFileJSONData("CompareAquaSitesVsGestorTrabajoDiferencias", this.resultadosDiferenciaCompany);

	}

	private void   findCentroGestortrabajo(CentroAquaSities centroAquaSites) {
		ResultadoComparacionDATA out = null;
		boolean exist = false;
		for( CentroGestorTrabajo centroGestorTrabajo : this.listGestorTrabajos) {
			//ENCONTRO EL CENTRO EN GESTOR DE TRABAJOS
			if(centroGestorTrabajo.getShortName().trim().equals(centroAquaSites.getShortName().trim()) ) {
				exist = true;
				//VERIFICAMOS SI ES LA MISMA COMPAÑIA
				if( centroGestorTrabajo.getCompany()!= centroAquaSites.getCompany()) {
					out = new ResultadoComparacionDATA();
					out.setCentroAquaSites(centroAquaSites);
					out.setCentroGestorTrabajo(centroGestorTrabajo);
					out.setExiste(true);
					out.setCompanydiferent(true);
					this.resultadosDiferenciaCompany.add(out);
				}
				break;
			}
		}
		//NO ENCONTRO EN EL GESTOR DE TRABAJOS
		if(exist==false) {
			out = new ResultadoComparacionDATA();
			out.setCentroAquaSites(centroAquaSites);
			out.setCentroGestorTrabajo(null);
			out.setExiste(false);
			this.resultadosNoExistenGestorTrabajos.add(out);
		}
	
		
	}

}
