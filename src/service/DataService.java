package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IDataDao;
import daoI.IStationDao;
import model.BeanData;
import model.BeanGas;
import model.BeanStation;
import model.BeanWater;
import serviceI.IDataService;
import util.BaseException;
@Service
public class DataService implements IDataService {
	@Resource
	private IStationDao isd;
	@Resource
	private IDataDao idd;
	@Override
	public List<BeanGas> loadnewgasdata() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanData> bd =new ArrayList<BeanData>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		station=isd.loadgasStation();
		List<BeanGas> result=new ArrayList<BeanGas>();
		for(int i=0;i<station.size();i++){
			bd=idd.loadnewdate(station.get(i).getMN());

			BeanGas bg=new BeanGas();
			bg.setTime(bd.get(0).getmTime());
			bg.setStationId(station.get(i).getStationid());
			bg.setStationname(station.get(i).getStationname());
			for(int j=0;j<bd.size();j++){

				switch(bd.get(j).getInfectCode()) {  

				case "02":  
					bg.setG02(bd.get(j).getInfectValue());
					break;  
				case "01":  
					bg.setG01(bd.get(j).getInfectValue()); 
					break;
				case "03":  
					bg.setG03(bd.get(j).getInfectValue()); 
					break;
				case "01-Zs":  
					bg.setG01Zs(bd.get(j).getInfectValue()); 
					break;
				case "02-Zs":  
					bg.setG01Zs(bd.get(j).getInfectValue()); 
					break;
				case "03-Zs":  
					bg.setG01Zs(bd.get(j).getInfectValue());
					break;
				case "S01":  
					bg.setgS01(bd.get(j).getInfectValue());
					break;
				case "S02":  
					bg.setgS02(bd.get(j).getInfectValue()); 
					break;
				case "S03":  
					bg.setgS03(bd.get(j).getInfectValue());
					break;
				case "S08":  
					bg.setgS08(bd.get(j).getInfectValue());
					break;
				case "B02":  
					bg.setgB02(bd.get(j).getInfectValue());
					break;
				case "S05":  
					bg.setSg05(bd.get(j).getInfectValue());
					break;

				default:  
					System.out.println("去数据有问题 气");  
				}  
			}
			result.add(bg);
		}
		return result;
	}

	@Override
	public List<BeanWater> loadnewwaterdata() throws BaseException {
		List<BeanData> bd =new ArrayList<BeanData>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		station=isd.loadwaterStation();
		List<BeanWater> result=new ArrayList<BeanWater>();
		for(int i=0;i<station.size();i++){
			bd=idd.loadnewdate(station.get(i).getMN());

			BeanWater bg=new BeanWater();
			bg.setTime(bd.get(0).getmTime());
			bg.setStationId(station.get(i).getStationid());
			bg.setStationname(station.get(i).getStationname());
			for(int j=0;j<bd.size();j++){

				switch(bd.get(j).getInfectCode()) {  

				case "011":  
					bg.setW011(bd.get(j).getInfectValue());
					break;  
				case "001":  
					bg.setW001(bd.get(j).getInfectValue());
					break;
				case "B01":  
					bg.setwB01(bd.get(j).getInfectValue());
					break;
				case "060":  
					bg.setW060(bd.get(j).getInfectValue());
					break;
				case "065":  
					bg.setW065(bd.get(j).getInfectValue());
					break;
				case "42":  
					bg.setW42(bd.get(j).getInfectValue());
					break;

				default:  
					System.out.println("去数据有问题 水"+station.get(i).getStationid());  
				}  
			}
			result.add(bg);
		}
		return result;
	}

	@Override
	public List<BeanGas> loadgasdata(int StationId,Timestamp start,Timestamp end) throws BaseException {
		return idd.loadgas(isd.SearchStation(StationId), start, end);
	}

	@Override
	public List<BeanWater> loadwaterdata(int StationId,Timestamp start,Timestamp end) throws BaseException {
		return idd.loadwater(isd.SearchStation(StationId), start, end);
	}
}
