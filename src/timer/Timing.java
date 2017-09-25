package timer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import daoI.IStationDao;
import model.BeanGas;
import model.BeanStandard;
import model.BeanStation;
import model.BeanWater;
import serviceI.IDataService;
import serviceI.IStandardService;
import util.BaseException;
import util.DbException; 



@Component("MonitorData") 
public class Timing { 
	@Autowired
	private IDataService ids;
	@Autowired
	private IStandardService iss;
	@Autowired
	private  IStationDao isd;
	@Scheduled(cron = "0 * * * * ?") 
	public void job1() { 
		SimpleDateFormat  formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		long startTime = System.currentTimeMillis(); 
		company();
		detection();
		long endTime = System.currentTimeMillis();  

		System.out.println("程序运行时间：" + (endTime - startTime) + "ms" +formatter.format(new Date()));
	} 
	

	public  void company(){
		boolean flag=false;
		List<BeanStation> local=new ArrayList<BeanStation>();
		List<BeanStation> other=new ArrayList<BeanStation>();
		try {
			other=isd.loadbasestation();
			local=isd.loadAllStation();
			Map<String,Integer> map=new HashMap<String,Integer>(other.size()+local.size());
			for(int i=0;i<other.size();i++){
				map.put(other.get(i).getMN(), 1);
			}
			for(int i=0;i<local.size();i++){
				Integer key =map.get(local.get(i).getMN());
				if(key!=null){
					map.put(local.get(i).getMN(), 0);

				}
				else{
					map.put(local.get(i).getMN(), -1);
				}
			}
			for(Map.Entry<String, Integer> entry:map.entrySet()){
				if(entry.getValue()==1){

					for(int i=0;i<other.size();i++){
						if(other.get(i).getMN()==entry.getKey()){
							System.out.println(entry.getKey()+"新数据"+other.get(i).getStationname());

							isd.addStation(other.get(i));

							break;
						}

					}			
				}
				if(entry.getValue()==-1){
					for(int i=0;i<local.size();i++){
						if(local.get(i).getMN()==entry.getKey()){
							System.out.println(entry.getKey()+"旧数据"+local.get(i).getStationname());
							isd.DelStation(local.get(i));
							break;
						}
					}				
					flag=true;
				}
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void detection(){


		List<BeanWater> water =new ArrayList<BeanWater>();
		List<BeanGas> gas =new ArrayList<BeanGas>();
		List<BeanStandard>  waterStandard=new ArrayList<BeanStandard>();
		List<BeanStandard>  gasStandard=new ArrayList<BeanStandard>();

		try {
			water=ids.loadnewwaterdata();
			gas=ids.loadnewgasdata();
			for(int i=0;i<water.size();i++){
				waterStandard=iss.loadStandard(water.get(i).getStationId());
				if(waterStandard.size()==0){
					continue;
				}

				for(int j=0;j<waterStandard.size();j++){
					//出错未填写
					switch(waterStandard.get(j).getInfectid()) {  
					case "011":  
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getW011()||
								waterStandard.get(j).getMinvaule()>water.get(i).getW011()){

						}
						break;  
					case "001": 
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getW001()||
								waterStandard.get(j).getMinvaule()>water.get(i).getW001()){
						}
						break;
					case "B01":  
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getwB01()||
								waterStandard.get(j).getMinvaule()>water.get(i).getwB01()){
						}
						break;
					case "060":  
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getW060()||
								waterStandard.get(j).getMinvaule()>water.get(i).getW060()){
						}
						break;
					case "065":  
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getW065()||
								waterStandard.get(j).getMinvaule()>water.get(i).getW065()){
						}
						break;
					case "42":  
						if(waterStandard.get(j).getMaxvaule()<water.get(i).getW42()||
								waterStandard.get(j).getMinvaule()>water.get(i).getW42()){
						}
						break;

					default:  
					}  
				}
			}
			//水质数据判断完成
			for(int i=0;i<gas.size();i++){
				gasStandard=iss.loadStandard(gas.get(i).getStationId());
				if(gasStandard.size()==0){
					continue;
				}

				for(int j=0;j<gasStandard.size();j++){
					//出错未填写
					switch(gasStandard.get(j).getInfectid()) {  
					case "02":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG02()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG02()){
						}
						break;
					case "01":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG01()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG01()){
						}
						break;						
					case "03":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG03()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG03()){
						}
						break;
					case "01-Zs":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG01Zs()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG01Zs()){
						}
						break;
					case "02-Zs":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG02Zs()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG02Zs()){
						}
						break;
					case "03-Zs":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getG03Zs()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getG03Zs()){
						}
						break;
					case "S01":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getgS01()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getgS01()){
						}
						break;
					case "S02":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getgS02()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getgS02()){
						}
						break;
					case "S03":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getgS03()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getgS03()){
						}
						break;
					case "S08":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getgS08()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getgS08()){
						}
						break;
					case "B02":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getgB02()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getgB02()){
						}
						break;
					case "S05":
						if(gasStandard.get(j).getMaxvaule()<gas.get(i).getSg05()||
								gasStandard.get(j).getMinvaule()>gas.get(i).getSg05()){
						}
						break;
					}  
				}
			}


		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
