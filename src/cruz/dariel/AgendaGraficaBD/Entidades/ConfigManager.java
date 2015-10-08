package cruz.dariel.AgendaGraficaBD.Entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	
	private static ConfigManager instance;
	private InputStream input;
	private Properties property;
	
	private ConfigManager(){
		property = new Properties();
		try {
			input = new FileInputStream("config.cfg");
			property.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance(){
		return instance == null ? instance = new ConfigManager() : instance;
	}
	
	public String getDBName(){
		return property.getProperty("DB_Name");
	}
	
	public String getUser(){
		return property.getProperty("User");
	}
	
	public String getPassword(){
		return property.getProperty("Password");
	}
}
