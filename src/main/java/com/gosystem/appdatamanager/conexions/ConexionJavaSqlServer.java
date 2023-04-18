package com.gosystem.appdatamanager.conexions;


import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJavaSqlServer implements IConexionJava {
	
	
	private  EntityManagerFactory emf ;
	private  EntityManager em ;
	
	public ConexionJavaSqlServer() throws Exception {
		connect();
	}

	private  void  connect() throws Exception {
		try {
			emf = Persistence.createEntityManagerFactory("SQL_SERVER_AQUA_SITES");
			em = emf.createEntityManager(); // Retrieve an application managed entity manager
			// Work with the EM
			//em.close();
			//emf.close(); // close at application end

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public  EntityManager getEm() throws Exception {
		if( Objects.isNull(this.em)) {
			this.connect();
		}
		return em;
	}

	
	public void close() {
		this.em.close();
		this.emf.close(); // close at application end
	}


	
	
	

}
