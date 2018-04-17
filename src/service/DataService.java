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
import util.DbException;
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
			if(station.get(i).getBase()==1){
				BeanGas bg=new BeanGas();
				bg=idd.loadnewgasdate(station.get(i).getMN());
				bg.setMN(station.get(i).getMN());
				bg.setStationId(station.get(i).getStationid());
				bg.setStationname(station.get(i).getStationname());
				result.add(bg);
			}

		}
		return result;
	}

	@Override
	public List<BeanWater> loadnewwaterdata() throws BaseException {
		List<BeanStation> station =new ArrayList<BeanStation>();
		station=isd.loadwaterStation();
		List<BeanWater> result=new ArrayList<BeanWater>();
		for(int i=0;i<station.size();i++){
			if(station.get(i).getBase()==1){
			BeanWater bg=new BeanWater();
			bg=idd.loadnewawterdate(station.get(i).getMN());
			bg.setMN(station.get(i).getMN());
			bg.setStationId(station.get(i).getStationid());
			bg.setStationname(station.get(i).getStationname());
			result.add(bg);
			}
		}
		return result;
	}
	public void addwaterdata(BeanWater BeanWater) {
		
		try {
			idd.adddata(BeanWater.getMN(),"001",BeanWater.getW001());
			idd.adddata(BeanWater.getMN(),"011",BeanWater.getW011());
			idd.adddata(BeanWater.getMN(),"060",BeanWater.getW060());
			idd.adddata(BeanWater.getMN(),"065",BeanWater.getW065());
			idd.adddata(BeanWater.getMN(),"042",BeanWater.getW42());
			idd.adddata(BeanWater.getMN(),"B01",BeanWater.getwB01());
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addgasdata(BeanGas BeanGas) {
		try {
			idd.adddata(BeanGas.getMN(),"01",BeanGas.getG01());
			idd.adddata(BeanGas.getMN(),"01-Zs",BeanGas.getG01Zs());
			idd.adddata(BeanGas.getMN(),"02",BeanGas.getG02());
			idd.adddata(BeanGas.getMN(),"02-Zs",BeanGas.getG02Zs());
			idd.adddata(BeanGas.getMN(),"03",BeanGas.getG03());
			idd.adddata(BeanGas.getMN(),"03-Zs",BeanGas.getG03Zs());
			idd.adddata(BeanGas.getMN(),"B02",BeanGas.getgB02());
			idd.adddata(BeanGas.getMN(),"S01",BeanGas.getgS01());
			idd.adddata(BeanGas.getMN(),"S02",BeanGas.getgS02());
			idd.adddata(BeanGas.getMN(),"S03",BeanGas.getgS03());
			idd.adddata(BeanGas.getMN(),"S08",BeanGas.getgS08());
			idd.adddata(BeanGas.getMN(),"S05",BeanGas.getSg05());
			
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BeanGas> loadgasdata(int StationId,Timestamp start,Timestamp end) throws BaseException {
		return idd.loadgas(isd.SearchStation(StationId), start, end);
	}

	@Override
	public List<BeanWater> loadwaterdata(int StationId,Timestamp start,Timestamp end) throws BaseException {
		return idd.loadwater(isd.SearchStation(StationId), start, end);
	}

	@Override
	public List<BeanData> loaddate(int StationId, String InfectCode, Timestamp start, Timestamp end) throws DbException {
		// TODO Auto-generated method stub
		return idd.loaddate(isd.SearchStation(StationId).getMN(), InfectCode,start,end);
	}

	@Override
	public boolean checkdata(String MN, String InfectCode, float value) throws DbException {
		// TODO Auto-generated method stub
		return idd.checkdata(MN, InfectCode, value);
	}
}
