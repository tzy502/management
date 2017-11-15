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
