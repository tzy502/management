package util;

import java.io.IOException;
import java.util.Properties;

import dao.MailDao;
import dao.SettingDao;

public class BaseException extends Exception {
	 SettingDao sd=new SettingDao();
	 MailDao md=new MailDao();
	public BaseException(String msg) {
		super(msg);
		Properties props = new Properties();              
		try {
			props = sd.load();
			int send=(int) props.get("snedmail");
			if(send==1) {
				md.sendsyserror(msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("错误测试");
	}
}
