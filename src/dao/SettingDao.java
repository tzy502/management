package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SettingDao {

	
	public Properties load() throws IOException {
		String path=this.getClass().getClassLoader().getResource("").getPath();	
		path=path.replace("/build", "");	
		path=path.replace("/classes/", "/");	
		
    	path+="setting.properties";
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(path);
		prop.load(fis);
		fis.close();
		return prop;
	}
	public boolean changsetting(String key,String value) {
		
		String path=this.getClass().getClassLoader().getResource("").getPath();
		path=path.replace("/build", "");	
		path=path.replace("/classes/", "");	
    	path+="setting.properties";
		
		
		 Properties prop = new Properties();
	     try {
	      InputStream fis = new FileInputStream(path);
	            prop.load(fis);
	            OutputStream fos = new FileOutputStream(path);
	            prop.setProperty(key, value);
	            prop.store(fos, "Update '" + key + "'+ '"+value);  
	            return true;
	        } catch (IOException e) {
	         return false;
	        }
		
	}
}
