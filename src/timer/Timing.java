package timer;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import daoI.IInfectDao;
import daoI.IStationDao;

import model.BeanGas;
import model.BeanInfect;
import model.BeanMission;
import model.BeanStandard;
import model.BeanStation;
import model.BeanTimer;
import model.BeanWarning;
import model.BeanWater;
import serviceI.IDataService;
import serviceI.IMissionService;
import serviceI.IStandardService;
import serviceI.ITimerService;
import serviceI.IWarningService;
import util.BaseException;
import util.DbException; 



@Component("MonitorData") 
public class Timing { 
	@Resource
	private IInfectDao iid;
	@Autowired
	private IDataService ids;
	@Autowired
	private IStandardService iss;
	@Autowired
	private  IStationDao isd;
	@Autowired
	private  ITimerService its;
	@Autowired
	private  IMissionService ims;
	@Autowired
	private  IWarningService iws;
	@Scheduled(cron = "0 0 6 * * ?") 
	public void daymission() throws UnsupportedEncodingException { 

		List<BeanTimer> result=its.loadmission(1);
		Timestamp start = new Timestamp(System.currentTimeMillis()); 
		Timestamp end =start;
		end.setDate(start.getDate()+1);
		start = new Timestamp(System.currentTimeMillis()); 
		for(int i=0;i<result.size();i++){
			BeanMission bm=new BeanMission();
			String name=result.get(i).getTimername(); 
			bm.setMissionname(name+"（每日）");
			bm.setDescription(result.get(i).getTimerdescription());
			bm.setStationid(result.get(i).getStationId());
			bm.setUserid(isd.SearchStation(result.get(i).getStationId()).getPrincipal());
			bm.setStartdate(start);
			bm.setEnddate(end);
			bm.setStatus(1);
			bm.setType(2);
			try {
				ims.addMission(bm);
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} 
	@Scheduled(cron = "0 0 6 ? * 2") 
	public void weekendmission() throws UnsupportedEncodingException { 
		List<BeanTimer> result=its.loadmission(2);
		Timestamp start = new Timestamp(System.currentTimeMillis()); 
		Timestamp end =start;
		end.setDate(start.getDate()+7);
		start = new Timestamp(System.currentTimeMillis()); 
		for(int i=0;i<result.size();i++){
			BeanMission bm=new BeanMission();
			bm.setMissionname(result.get(i).getTimername()+"（每周）");
			bm.setDescription(result.get(i).getTimerdescription());
			bm.setStationid(result.get(i).getStationId());
			bm.setUserid(isd.SearchStation(result.get(i).getStationId()).getPrincipal());
			bm.setStartdate(start);
			bm.setEnddate(end);
			bm.setStatus(1);
			bm.setType(2);
			try {
				ims.addMission(bm);
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Scheduled(cron = "0 0 6 1 * ?") 
	public void monmission() { 
		List<BeanTimer> result=its.loadmission(3);
		Timestamp start = new Timestamp(System.currentTimeMillis()); 
		Timestamp end =start;
	
		end.setMonth(start.getMonth()+2);
		start = new Timestamp(System.currentTimeMillis()); 
		for(int i=0;i<result.size();i++){
			BeanMission bm=new BeanMission();
			bm.setMissionname(result.get(i).getTimername()+"（每月）");
			bm.setDescription(result.get(i).getTimerdescription());
			bm.setStationid(result.get(i).getStationId());
			bm.setUserid(isd.SearchStation(result.get(i).getStationId()).getPrincipal());
			bm.setStartdate(start);
			bm.setEnddate(end);
			bm.setStatus(1);
			bm.setType(2);
			try {
				ims.addMission(bm);
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Scheduled(cron = "0 * * * * ?") 
	public void job1() { 	
		System.out.print("1");
//		SimpleDateFormat  formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
//		long startTime = System.currentTimeMillis(); 
//		companyallsttion();//保证两遍数据库一样
//		companynobase();//确定监测数据
//		detection();//检测
//		ims.overtimeMission();//检测超时
//		long endTime = System.currentTimeMillis();  
//		System.out.println("检测超过数据程序运行时间：" + (endTime - startTime) + "ms" +formatter.format(new Date()));
	} 
	@Scheduled(cron = "30 15 * * * ?") 
	public void job2() { 	
		SimpleDateFormat  formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		long startTime = System.currentTimeMillis(); 
		List<BeanWater> water =new ArrayList<BeanWater>();
		try {
			water=ids.loadnewwaterdata();
			List<BeanInfect> bi =new ArrayList<BeanInfect>();
			bi=iid.loadAllWaterInfect();
			Map<String, Float> waterdate=new HashMap<String, Float>();
			for(int i=0;i<water.size();i++){
				waterdate.put("011", water.get(i).getW011());
				waterdate.put("001", water.get(i).getW001());
				waterdate.put("B01", water.get(i).getwB01());
				waterdate.put("060", water.get(i).getW060());
				waterdate.put("065", water.get(i).getW065());
				waterdate.put("42", water.get(i).getW42());
				for(int j=0;j<bi.size();j++){
					if(waterdate.get(bi.get(j).getInfectCode())!=0){
						boolean item= ids.checkdata(water.get(i).getMN(), bi.get(j).getInfectCode(), waterdate.get(bi.get(j).getInfectCode()));
						if(item){
							BeanWarning Warning =new BeanWarning();
							Warning.setInfectCode(bi.get(j).getInfectCode());
							Warning.setStationId(water.get(i).getStationId());
							Warning.setWarningtime(water.get(i).getTime());
							Warning.setType(3);
							iws.addWarning(Warning);

						}
					}
				}
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();  
		System.out.println("检测波动数据程序运行时间：" + (endTime - startTime) + "ms" +formatter.format(new Date()));

	} 
	public void companynobase(){
		List<BeanStation> local=new ArrayList<BeanStation>();
		List<BeanStation> other=new ArrayList<BeanStation>();
		try {
			other=isd.loadbasestation();
			local=isd.loadnobaseStation();
			Map<String,Integer> map=new HashMap<String,Integer>(other.size()+local.size());
			for(int i=0;i<other.size();i++){
				map.put(other.get(i).getMN(), 1);
			}
			for(int i=0;i<local.size();i++){
				map.put(local.get(i).getMN(), -1);

			}
			for(Map.Entry<String, Integer> entry:map.entrySet()){
				if(entry.getValue()==0){
					for(int i=0;i<local.size();i++){
						if(local.get(i).getMN()==entry.getKey()){
							BeanStation bs=local.get(i);
							bs.setBase(1);
							isd.modifryStation(bs);

							break;
						}
					}				

				}
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void companyallsttion(){

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
							BeanStation bs=other.get(i);
							bs.setBase(1);				
							isd.addStation(other.get(i));
							break;
						}

					}			
				}
				if(entry.getValue()==-1){
					for(int i=0;i<local.size();i++){
						if(local.get(i).getMN()==entry.getKey()){
							System.out.println(entry.getKey()+"旧数据"+local.get(i).getStationname());
							BeanStation bs=local.get(i);
							if(bs.getBase()!=0){
								bs.setBase(0);
								isd.modifryStation(bs);
							}

							break;
						}
					}				

				}
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void detection(){


		List<BeanWater> water =new ArrayList<BeanWater>();
		List<BeanStandard>  waterStandard=new ArrayList<BeanStandard>();
		List<BeanGas> gas =new ArrayList<BeanGas>();

		List<BeanStandard>  gasStandard=new ArrayList<BeanStandard>();

		try {
			water=ids.loadnewwaterdata();
			gas=ids.loadnewgasdata();
			for(int i=0;i<water.size();i++){

				Map<String, Float> waterdate=new HashMap<String, Float>();

				waterStandard=iss.loadStandard(water.get(i).getStationId());
				if(waterStandard.size()==0){
					continue;
				}
				else{
					waterdate.put("011", water.get(i).getW011());
					waterdate.put("001", water.get(i).getW001());
					waterdate.put("B01", water.get(i).getwB01());
					waterdate.put("060", water.get(i).getW060());
					waterdate.put("065", water.get(i).getW065());
					waterdate.put("42", water.get(i).getW42());

				}
				for(int j=0;j<waterStandard.size();j++){
					if(waterStandard.get(j).getMaxvaule()<waterdate.get(waterStandard.get(j).getInfectid())||
							waterStandard.get(j).getMinvaule()>waterdate.get(waterStandard.get(j).getInfectid())){
						BeanWarning Warning =new BeanWarning();
						Warning.setInfectCode(waterStandard.get(j).getInfectid());
						Warning.setStationId(water.get(i).getStationId());
						Warning.setWarningtime(water.get(i).getTime());
						if(waterStandard.get(j).getMaxalarm()<waterdate.get(waterStandard.get(j).getInfectid())||
								waterStandard.get(j).getMinalarm()>waterdate.get(waterStandard.get(j).getInfectid())){
							Warning.setType(1);
						}else{
							Warning.setType(2);
						}

						iws.addWarning(Warning);
					}
				}
			}
			//水质数据判断完成
			for(int i=0;i<gas.size();i++){

				gasStandard=iss.loadStandard(gas.get(i).getStationId());
				Map<String, Float> gasdate=new HashMap<String, Float>();
				if(gasStandard.size()==0){
					continue;
				}
				else{					
					gasdate.put("02", gas.get(i).getG02());
					gasdate.put("01", gas.get(i).getG01());
					gasdate.put("03", gas.get(i).getG03());
					gasdate.put("01-Zs", gas.get(i).getG01Zs());
					gasdate.put("02-Zs", gas.get(i).getG02Zs());
					gasdate.put("03-Zs", gas.get(i).getG03Zs());
					gasdate.put("S01", gas.get(i).getgS01());
					gasdate.put("S02", gas.get(i).getgS02());
					gasdate.put("S03", gas.get(i).getgS03());
					gasdate.put("S08", gas.get(i).getgS08());
					gasdate.put("B02", gas.get(i).getgB02());
					gasdate.put("S05", gas.get(i).getSg05());
				}

				for(int j=0;j<gasStandard.size();j++){
					//出错未填写

					if(gasStandard.get(j).getMaxvaule()<gasdate.get(gasStandard.get(j).getInfectid())||
							gasStandard.get(j).getMinvaule()>gasdate.get(gasStandard.get(j).getInfectid())){

						BeanWarning Warning =new BeanWarning();
						Warning.setInfectCode(gasStandard.get(j).getInfectid());
						Warning.setStationId(gas.get(i).getStationId());
						Warning.setWarningtime(gas.get(i).getTime());
						if(gasStandard.get(j).getMaxalarm()<gasdate.get(gasStandard.get(j).getInfectid())||
								gasStandard.get(j).getMinalarm()>gasdate.get(gasStandard.get(j).getInfectid())){
							Warning.setType(1);

						}else{
							Warning.setType(2);
						}
						iws.addWarning(Warning);
					}
				}
			}


		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
