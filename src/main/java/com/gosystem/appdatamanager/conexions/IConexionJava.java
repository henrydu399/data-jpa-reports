package com.gosystem.appdatamanager.conexions;



import javax.persistence.EntityManager;

public interface IConexionJava {
	
	EntityManager getEm() throws Exception;

}
