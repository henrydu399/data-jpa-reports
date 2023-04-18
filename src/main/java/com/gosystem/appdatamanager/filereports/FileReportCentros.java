package com.gosystem.appdatamanager.filereports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gosystem.appdatamanager.enums.PropertiesEnum;
import com.gosystem.appdatamanager.utils.FileUtils;

public class FileReportCentros {

	private static Properties p;

	public FileReportCentros(Properties p) {
		super();
		this.p = p;
	}

	public static <T> void createFileJSONData(String nameEntity, List<T> list) {

	 
		
		FileUtils.createFile( p.getProperty(PropertiesEnum.path_file_table_export.name())+nameEntity + ".json");

		try {
			FileWriter myWriter = new FileWriter(p.getProperty(PropertiesEnum.path_file_table_export.name())+nameEntity + ".json");

			myWriter.write("["+ "\n");
			for (Object o : list) {
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(o);
				myWriter.write(jsonString);
			
				if( list.size() >1) {
					myWriter.write(","+ "\n");
				}
			}
			myWriter.write(""+ "\n" + "]");
			myWriter.close();
			
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
