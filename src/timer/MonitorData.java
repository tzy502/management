package timer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import model.BeanGas;
import model.BeanWater;
import serviceI.IDataService;
import util.BaseException; 



@Component("MonitorData") 
public class MonitorData { 
	@Autowired
	private IDataService ids;
	
    @Scheduled(cron = "0 * * * * ?") 
    public void job1() { 
    	List<BeanWater> result =new ArrayList<BeanWater>();
//		try {
//			result=ids.loadnewwaterdata();
//		} catch (BaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	Date date=new Date();
        System.out.println(date+"     "+result.size()); 
    } 
}
