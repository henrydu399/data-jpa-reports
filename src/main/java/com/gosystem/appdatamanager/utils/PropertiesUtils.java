package com.gosystem.appdatamanager.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class PropertiesUtils {

	public PropertiesUtils() {

	}

	public static Properties getP() {

		Properties prop = new Properties();
		 try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties")) {

			prop.load(input);
			return prop;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR CARGANDO LOS PROPERTIES");
			e.printStackTrace(System.out);
		} catch (IOException e) {
			System.out.println("ERROR CARGANDO LOS PROPERTIES");
			e.printStackTrace(System.out);
		}

		return null;

	}

}
