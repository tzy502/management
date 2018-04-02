package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import daoI.IStationDao;
import model.BeanStation;
import model.BeanWarning;

public class MailDao {
	public static String myEmailAccount = "270081484@qq.com";
	public static String myEmailPassword = "lknpskrziwmqbiac";
	public static String myEmailSMTPHost = "smtp.qq.com";
	public static String receiveMailAccount = "31401376@stu.zucc.edu.cn";
	 SettingDao sd=new SettingDao();
	 Map<String, String>  Infect =new HashMap<String, String>();
	@Resource
	private IStationDao isd;

	public MimeMessage createMimeMessage(BeanWarning Warning) throws Exception {
		// 1. 创建一封邮件
		System.out.print("123123");
		Properties props = new Properties();              
		props = sd.load();
		Session session = Session.getInstance(props);
		session.setDebug(true); 
		
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
		message.setFrom(new InternetAddress(myEmailAccount, "数据监测系统", "UTF-8"));
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "XX用户", "UTF-8"));

		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		Date date=new Date();
		String type=null;
		if(Warning.getType()==1){
			 type="达到报警";
		}
		else if(Warning.getType()==2){		
			 type="达到预警";
		}else if(Warning.getType()==3){		
			 type="长时间数据未波动";
		}
		BeanStation bs=new BeanStation();
		bs=isd.SearchStation(Warning.getStationId());	
		String missionname=bs.getStationname()+Infect.get(Warning.getInfectCode())+type+"（系统自动报警）";
		
		message.setSubject(missionname, "UTF-8");

		message.setContent(missionname, "text/html;charset=UTF-8");

		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();
		Transport transport = session.getTransport();
		transport.connect(myEmailAccount, myEmailPassword);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		return message;
	}
}
